package com.dh;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.NonNull;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryJsonUtil {
    public static void main(String[] args) throws IOException {
        String url = "http://106.63.4.5:8082/tag?data=%E6%96%B0%E5%86%A0%E8%82%BA%E7%82%8E%E6%B5%81%E8%A1%8C%E7%97%85%E5%AD%A6%E5%8F%B2%EF%BC%9A14%E5%A4%A9%E5%86%85%E4%B8%AD%E6%96%B0%E5%86%A0%E8%82%BA%E7%82%8E%E4%B8%AD%E9%AB%98%E9%A3%8E%E9%99%A9%E5%9C%B0%E5%8C%BA%E6%97%85%E5%B1%85%E5%8F%B2%EF%BC%8C14%E5%A4%A9%E5%86%85%E6%8E%A5%E8%A7%A6%E6%96%B0%E5%86%A0%E7%97%85%E6%AF%92%E6%A3%80%E6%B5%8B%E9%98%B3%E6%80%A7%E8%80%85%EF%BC%8C14%E5%A4%A9%E5%86%85%E6%8E%A5%E8%A7%A6%E6%96%B0%E5%86%A0%E8%82%BA%E7%82%8E%E9%98%B3%E6%80%A7%E6%8A%A5%E5%91%8A%E7%A4%BE%E5%8C%BA%E7%9A%84%E5%8F%91%E7%83%AD%E6%82%A3%E8%80%85%E6%88%96%E6%9C%89%E5%91%BC%E5%90%B8%E9%81%93%E7%97%87%E7%8A%B6%E6%82%A3%E8%80%85%EF%BC%8C14%E5%A4%A9%E5%86%85%E6%89%80%E5%88%B0%E4%B9%8B%E5%A4%84%E8%81%9A%E9%9B%86%E6%80%A7%E5%8F%91%E7%83%AD%E6%88%96%E5%91%BC%E5%90%B8%E9%81%93%E7%97%87%E7%8A%B6%E3%80%82n%E5%85%B6%E4%BB%96%E4%B8%AA%E4%BA%BA%E5%8F%B2%E6%83%85%E5%86%B5%EF%BC%9A";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse execute = httpClient.execute(new HttpGet(url));
        String resultJson = EntityUtils.toString(execute.getEntity());
//        System.out.println(resultJson);
        QueryJsonParam queryJson = new QueryJsonParam();
        HashMap<String, String> paramAnd = new HashMap<>();
//        paramAnd.put("type", "+disease");
//        paramAnd.put("name", "新冠肺炎");
        queryJson.setAnd(paramAnd);
        ArrayList<String> targetList = new ArrayList<>();
//        targetList.add("name");
//        targetList.add("section_type");
//        targetList.add("graph.parents[0].children[0].parents[0].name");
//        targetList.add("graph.parents[0].children[0].parents[0]");
        targetList.add("graph.parents[0].children[0]");
//        targetList.add("position.name");
//        targetList.add("section_type");
//        targetList.add("graph.name");
        queryJson.setTarget(targetList);
        Object o = queryJson(JSON.parseArray(resultJson), queryJson);
        System.out.println("=结果=");
        System.out.print(JSONArray.toJSONString(o));
    }

    /**
     * 先判断是列表还是对象json
     * 1.是列表，则遍历列表，拿到对象更具条件遍历json对象
     * 2.是json对象，则直接根据条件遍历json对象
     * *****************************************************
     * 查询json对象属性：
     * 1. 获取or集合中属性值匹配的对象，满足的留下（根据条件参数遍历，判断是否留下）
     * 1.2 除了or还有and条件，则将满足or条件的再去判断满足and条件，满足的留下（根据条件参数遍历，判断是否留下）
     */


    public static Object queryJson(JSON data, QueryJsonParam params) {
        // 判断是否是检查存在性
        Boolean checkExist = params.getCheckExist();
        List<Object> list = new ArrayList<>();
        // json数组
        if (data instanceof JSONArray) {
            JSONArray jsonArray = (JSONArray) data;
            for (Object obj : jsonArray) {
                Object query = query(obj, params.getTarget());
                if (query == null) {
                    continue;
                }
                list.add(query(obj, params.getTarget()));
            }
        }
        // json对象
        if (data instanceof JSONObject) {
            JSONObject jsonObjData = (JSONObject) data;
            Object query = query(jsonObjData, params.getTarget());
            if (query == null) {
                return list;
            }
            list.add(query(jsonObjData, params.getTarget()));
        }
        return list;
    }


    /**
     * 核心执行逻辑（过滤并返回一个对象的属性）
     *
     * @param obj           查询的obj对象
     * @param queryPathList 查询返回目标属性
     * @return Object
     */
    public static Object query(@NonNull Object obj, @NonNull List<String> queryPathList) {
        if (!(obj instanceof JSON)) {
            throw new RuntimeException("数据格式存在问题，无法转换为JSON格式");
        }
        JSON jsonObjData = (JSON) obj;
        Map<String, Object> rMap = new HashMap<>();
        // 遍历每个属性的路径
        for (String pathStr : queryPathList) {
            // 将每个路径下的数据保存到map中
            String[] splitPath = pathStr.split("\\.");
            SignalData pathValue = getPathValue(jsonObjData, splitPath, 0);
            if (pathValue.isResult) {
                rMap.put(pathStr, pathValue.getData());
            }
        }
        return rMap.isEmpty() ? null : rMap;
    }

    private static SignalData getPathValue(JSON jsonObjData, String[] splitPath, int j) {

        boolean end = j + 1 == splitPath.length;
        String section = splitPath[j];
        // 判断是否是数组类型，默认为非列表
        boolean isArray = false;
        int length = section.length();
        Integer arrayIndex = 0;
        String arrayKey = "";
        for (int i = 0; i < length; i++) {
            if (section.charAt(i) == '[') {
                isArray = true;
                arrayIndex = Integer.valueOf(section.substring(i + 1, length - 1));
                arrayKey = section.substring(0, i);
            }
        }
        // 是数组类型
        if (isArray) {
            JSONObject jsonObject = (JSONObject) jsonObjData;
            JSONArray jsonArray = (JSONArray) jsonObject.get(arrayKey);
            if (jsonArray == null || jsonArray.isEmpty()) {
                return new SignalData(false, null);
            }
            Object objData = jsonArray.get(arrayIndex);
            // 是最后一个节点，则保存数据
            if (end) {
                return new SignalData(true, objData);
            } else {
                // 不是最后一个节点，继续遍历
                SignalData pathValue = getPathValue((JSON) objData, splitPath, j + 1);
                if (pathValue.isResult) {
                    return pathValue;
                }
                return getPathValue((JSON) objData, splitPath, j + 1);
            }
        } else {
            JSONObject tmpJson = (JSONObject) jsonObjData;
            Object objData = tmpJson.get(section);
            // 是最后一个节点，则保存数据
            if (end) {
                return new SignalData(true, objData);
            } else {
                // 不是最后一个节点，继续遍历; 如果数据已经为null，表示此对象不存在指定属性，直接返回 null
                if (!(objData instanceof JSON)) {
                    return new SignalData(false, null);
                }
                return objData == null ? new SignalData(true, null) : (getPathValue((JSON) objData, splitPath, j + 1));
            }
        }
    }


    public static class SignalData {
        private boolean isResult;
        private Object data;

        public SignalData(boolean b, Object o) {
            this.isResult = b;
            this.data = o;
        }

        public boolean isResult() {
            return isResult;
        }

        public Object getData() {
            return data;
        }
    }


    @Data
    public static class QueryJsonParam {
        private Boolean checkExist;
        private List<String> target;
        private Map<String, String> or;
        private Map<String, String> and;
    }
}
