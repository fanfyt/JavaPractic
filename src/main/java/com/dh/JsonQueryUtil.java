package com.dh;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 查询json指定属性值工具类
 */
public class JsonQueryUtil {

    public static Object queryJson(com.alibaba.fastjson.JSON data, QueryJsonParam params) {
        // 判断是否是检查存在性
        Boolean checkExist = params.getCheckExist();
        Map<String, String> orMap = params.getOr();
        Map<String, String> andMap = params.getAnd();
        List<Object> list = new ArrayList<>();
        // json数组
        if (data instanceof JSONArray) {
            JSONArray jsonArray = (JSONArray) data;
            for (Object obj : jsonArray) {
                Map<String, Object> query = query(obj, params.getTarget(), orMap, andMap);
                if (query == null) {
                    continue;
                }
                list.add(query(obj, params.getTarget(), orMap, orMap));
                if (checkExist) {
                    break;
                }
            }
        }
        // json对象
        if (data instanceof JSONObject) {
            JSONObject jsonObjData = (JSONObject) data;
            Object query = query(jsonObjData, params.getTarget(), orMap, orMap);
            if (query != null) {
                list.add(query(jsonObjData, params.getTarget(), orMap, orMap));
            }
        }
        if (checkExist) {
            boolean exist = !list.isEmpty();
            HashMap<String, Boolean> existOrNot = new HashMap<>();
            existOrNot.put("exist", exist);
            return existOrNot;
        }
        return list;
    }


    /**
     * 核心执行逻辑（过滤并返回一个对象的属性）
     *
     * @param obj           查询的obj对象
     * @param queryPathList 查询返回目标属性
     * @param orMap         获取满足所有此条件的数据
     * @param andMap        获取仅满足此条件的数据
     * @return Object
     */
    public static Map<String, Object> query(@NonNull Object obj, @NonNull List<String> queryPathList, Map<String, String> orMap, Map<String, String> andMap) {
        if (!(obj instanceof com.alibaba.fastjson.JSON)) {
            throw new RuntimeException("数据格式存在问题，无法转换为JSON格式");
        }
        boolean nullOr = orMap == null;
        boolean nullAnd = andMap == null;
        boolean getAllData = (nullOr || orMap.isEmpty()) && (nullAnd || andMap.isEmpty());
        com.alibaba.fastjson.JSON jsonObjData = (com.alibaba.fastjson.JSON) obj;
        Map<String, Object> rMap = new HashMap<>();
        // 遍历每个属性的路径
        for (String pathStr : queryPathList) {
            // 将每个路径下的数据保存到map中
            String[] splitPath = pathStr.split("\\.");
            SignalData pathValue = getPathValue(jsonObjData, splitPath, 0);
            if (pathValue.isResult && pathValue.getData() != null) {
                // 过滤数据逻辑处理
                if (getAllData) {
                    rMap.put(pathStr, pathValue.getData());
                } else {
                    // 先将符合and条件的数据保存;如果没有and条件，则判断or条件
                    if (!nullAnd) {
                        String andData = andMap.get(pathStr);
                        if (!andMap.isEmpty() && andData != null) {
                            boolean match = patternMatch(String.valueOf(pathValue.getData()), andData);
                            if (match) {
                                rMap.put(pathStr, pathValue.getData());
                            }
                        }
                    }
                    if (!nullOr) {
                        if (!orMap.isEmpty()) {
                            String orData = orMap.get(pathStr);
                            if (!orMap.isEmpty() && orData != null) {
                                boolean match = patternMatch(String.valueOf(pathValue.getData()), orData);
                                if (match) {
                                    rMap.put(pathStr, pathValue.getData());
                                }
                            }
                        }
                    }
                }
            }
        }
        return rMap.isEmpty() ? null : rMap;
    }


    public static boolean patternMatch(String data, String queryData) {

        String regexToEscape = "[.^$*+{}()\\[\\]|]";
        // 使用replaceAll方法替换这些元字符，加上反斜杠进行转义
        queryData = queryData.replaceAll(regexToEscape, "\\\\$0");
        queryData = queryData.replaceAll("\\?", ".");
        Pattern pattern = Pattern.compile(queryData);
        Matcher matcher = pattern.matcher(data);
        return matcher.find();
    }

    private static SignalData getPathValue(com.alibaba.fastjson.JSON jsonObjData, String[] splitPath, int j) {

        boolean end = j + 1 == splitPath.length;
        String section = splitPath[j];
        // 判断是否是数组类型，默认为非列表
        boolean isArray = false;
        int length = section.length();
        int arrayIndex = 0;
        String arrayKey = "";
        for (int i = 0; i < length; i++) {
            if (section.charAt(i) == '[') {
                isArray = true;
                arrayIndex = Integer.parseInt(section.substring(i + 1, length - 1));
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
                SignalData pathValue = getPathValue((com.alibaba.fastjson.JSON) objData, splitPath, j + 1);
                if (pathValue.isResult) {
                    return pathValue;
                }
                return getPathValue((com.alibaba.fastjson.JSON) objData, splitPath, j + 1);
            }
        } else {
            JSONObject tmpJson = (JSONObject) jsonObjData;
            Object objData = tmpJson.get(section);
            // 是最后一个节点，则保存数据
            if (end) {
                return new SignalData(true, objData);
            } else {
                // 不是最后一个节点，继续遍历; 如果数据已经为null，表示此对象不存在指定属性，直接返回 null
                if (!(objData instanceof com.alibaba.fastjson.JSON)) {
                    return new SignalData(false, null);
                }
                return getPathValue((JSON) objData, splitPath, j + 1);
            }
        }
    }


    @Data
    public static class SignalData {
        private boolean isResult;
        private Object data;

        public SignalData(boolean b, Object o) {
            this.isResult = b;
            this.data = o;
        }

    }


    @Data
    public static class QueryJsonParam {
        private Boolean checkExist;
        private List<String> target = new ArrayList<>();
        private Map<String, String> or;
        private Map<String, String> and;

        public void setOr(Map<String, String> or) {
            for (Map.Entry<String, String> entry : or.entrySet()) {
                target.add(entry.getKey());
            }
            this.or = or;
        }

        public void setAnd(Map<String, String> and) {
            for (Map.Entry<String, String> entry : and.entrySet()) {
                target.add(entry.getKey());
            }
            this.and = and;
        }
    }

}
