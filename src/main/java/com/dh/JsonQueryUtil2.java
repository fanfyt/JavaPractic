package com.dh;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 查询json指定属性值工具类
 */
public class JsonQueryUtil2 {

    public static Object queryJson(JSON data, QueryJsonParam params) {
        QueryJsonFilter filter = params.getFilter();
        // 判断是否是检查存在性
        List<Map<String, String>> orMap = filter.getOr();
        List<Map<String, String>> andMap = filter.getAnd();
        List<Map<String, String>> notMap = filter.getNot();

        List<Object> list = new ArrayList<>();

        // json数组
        if (data instanceof JSONArray) {
            JSONArray jsonArray = (JSONArray) data;
            for (Object obj : jsonArray) {
                Map<String, Object> query = query(obj, params.getTarget(), orMap, andMap, notMap);
                if (query == null || query.isEmpty()) {
                    continue;
                }
                list.add(query);
            }
        }

        // json对象
        if (data instanceof JSONObject) {
            JSONObject jsonObjData = (JSONObject) data;
            Object query = query(jsonObjData, params.getTarget(), orMap, orMap, notMap);
            if (query != null) {
                list.add(query(jsonObjData, params.getTarget(), orMap, orMap, notMap));
            }
        }

        JsonQueryResult result = new JsonQueryResult();
        result.setIsExist(!list.isEmpty());
        result.setResult(list);
        return result;
    }


    /**
     * 核心执行逻辑（过滤并返回一个对象的属性）
     *
     * @param obj           查询的obj对象
     * @param queryPathList 查询返回目标属性
     * @param orMapList     获取满足所有此条件的数据
     * @param andMapList    获取仅满足此条件的数据
     * @param notMapList    获取仅不满足此条件的数据
     * @return Object
     */
    public static Map<String, Object> query(@NonNull Object obj, @NonNull Set<String> queryPathList, List<Map<String, String>> orMapList, List<Map<String, String>> andMapList, List<Map<String, String>> notMapList) {
        if (!(obj instanceof JSON)) {
            throw new RuntimeException("数据格式存在问题，无法转换为JSON格式");
        }
        boolean nullOr = orMapList == null;
        boolean nullAnd = andMapList == null;
        boolean nullNot = notMapList == null;
        boolean noFilterOr = nullOr || orMapList.isEmpty();
        boolean noFilterAnd = nullAnd || andMapList.isEmpty();
        boolean noFilterNot = nullNot || notMapList.isEmpty();
        // 是否未设置任何过滤条件
        boolean getAllData = noFilterAnd && noFilterOr && noFilterNot;
        JSON jsonObjData = (JSON) obj;
        Map<String, Object> rMap = new HashMap<>();
        Map<String, Object> tmpMap = new HashMap<>();
        boolean isMatch;
        boolean noMatchOr = true;

        // 获取满足and条件的数据
        Map<String, String> andParamMap = andMapList.get(0);
        noFilterAnd = andParamMap.isEmpty();

        // 获取满足not条件的数据
        Map<String, Set<String>> notMapParam = new HashMap<>();
        if (!noFilterNot) {
            for (Map<String, String> notMap : notMapList) {
                for (Map.Entry<String, String> entry : notMap.entrySet()) {
                    Set<String> set = notMapParam.get(entry.getKey());
                    if (set == null) {
                        set = new HashSet<>();
                        set.add(entry.getValue());
                        notMapParam.put(entry.getKey(), set);
                    } else {
                        set.add(entry.getValue());
                    }
                }
            }
        }
        // 获取满足or条件的数据
        Map<String, Set<String>> orMapParam = new HashMap<>();
        if (!noFilterOr) {
            for (Map<String, String> orMap : orMapList) {
                for (Map.Entry<String, String> entry : orMap.entrySet()) {
                    String value = entry.getValue();
                    Set<String> set = orMapParam.get(entry.getKey());
                    if (set == null) {
                        set = new HashSet<>();
                        set.add(value);
                        orMapParam.put(entry.getKey(), set);
                    } else {
                        set.add(value);
                    }
                }
            }
        }

        Map<String, String> andMap = new HashMap<>();
        Map<String, String> notMap = new HashMap<>();
        Map<String, String> orMap = new HashMap<>();

        int matchAndSize = 0;
        // 遍历每个属性的路径
        for (String pathStr : queryPathList) {
            // 将每个路径下的数据保存到map中
            String[] splitPath = pathStr.split("\\.");
            SignalData pathValue = getPathValue(jsonObjData, splitPath, 0);
            if (pathValue.isResult && pathValue.getData() != null) {
                boolean judgeAndExistPath = (!nullAnd) && andParamMap.containsKey(pathStr);
                boolean judgeOrExistPath = (!nullOr) && orMapParam.containsKey(pathStr);
                boolean judgeNotExistPath = (!nullNot) && notMapParam.containsKey(pathStr);
                boolean noFilterCurrentPath = !judgeAndExistPath && !judgeOrExistPath && !judgeNotExistPath;
                // === 过滤数据逻辑处理 ===
                if (getAllData) {
                    // 获取所有数据
                    rMap.put(pathStr, pathValue.getData());
                } else {
                    String andData = andParamMap.get(pathStr);
                    Set<String> notDataSet = notMapParam.get(pathStr);
                    boolean doAnd = false;
                    boolean doNot = false;
                    /*
                     先将符合and条件的数据保存,如果存在not条件,那么还要通过not与and保存下来的数据进行匹配，如果匹配上了就要去掉;
                     如果不存在and条件，则直接用not数据进行匹配，然后保存符合的结果；
                     如果没有and条件且没有not条件，才去判断or条件
                    */
                    // -------- 路径存在且条件存在,获取到and条件数据
                    if (judgeAndExistPath && andData != null) {
                        if (andData.isEmpty()) {
                            // 未获取到匹配的数据，停止此对象属性遍历，直接退出
                            tmpMap.clear();
                            break;
                        }
                        doAnd = true;
                        // 获取到了数据，判断是否匹配
                        isMatch = patternMatch(String.valueOf(pathValue.getData()), andData);
                        if (isMatch) {
                            tmpMap.put(pathStr, pathValue.getData());
                            andMap.put(pathStr, String.valueOf(pathValue.getData()));
                            noMatchOr = false;
                            matchAndSize = matchAndSize + 1;
                        } else {
                            // 匹配失败，停止此对象属性遍历，直接退出
                            tmpMap.clear();
                            break;
                        }

                    }

                    if (andData == null || andData.isEmpty()) {
                        andMap.put(pathStr, String.valueOf(pathValue.getData()));
                    }

                    // -------- 获取到not条件数据
                    if (judgeNotExistPath && notDataSet != null) {
                        boolean notNotEmpty = false;
                        String sourceValue = String.valueOf(pathValue.getData());
                        // 未获取到已匹配上的数据；则对比源Json数据对应路径值
                        for (String notData : notDataSet) {
                            notNotEmpty = true;
                            // 获取到了数据，判断是否匹配
                            isMatch = patternMatch(sourceValue, notData);
                            if (isMatch) {
                                // 匹配成功，记录此待移除属性与数据
                                rMap.clear();
                                return rMap;
                            }
                        }
                    }

                    // -------- 如果已经存在精确匹配条件，则忽略or条件
                    if (!doAnd && !doNot && judgeOrExistPath) {
                        Set<String> orDataSet = orMapParam.get(pathStr);
                        if (!orMapList.isEmpty() && orDataSet != null && !orDataSet.isEmpty()) {
                            for (String orData : orDataSet) {
                                boolean match = patternMatch(String.valueOf(pathValue.getData()), orData);
                                if (match) {
                                    noMatchOr = false;
                                    tmpMap.put(pathStr, pathValue.getData());
                                }
                            }
                        }
                    }

                }
            }
        }

        // 如果and条件没有全部匹配上，则清空and数据
        if (!noFilterAnd && (matchAndSize != andParamMap.size())) {
            andMap.clear();
        }

        if (noFilterAnd && noMatchOr) {
            rMap.clear();
        } else {
            rMap.putAll(andMap);
            rMap.putAll(notMap);
            rMap = rMap.isEmpty() ? null : rMap;
        }
        return rMap;
    }

    public static boolean patternMatch(String data, String queryData) {

        String regexToEscape = "[.^$*+{}()\\[\\]|]";
        // 使用replaceAll方法替换这些元字符，加上反斜杠进行转义
        queryData = queryData.replaceAll(regexToEscape, "\\\\$0");
        queryData = queryData.replaceAll("\\?", ".*");
        Pattern pattern = Pattern.compile(queryData);
        Matcher matcher = pattern.matcher(data);
        boolean b = matcher.find();
        return b;
    }

    private static SignalData getPathValue(JSON jsonObjData, String[] splitPath, int j) {

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
            if (arrayIndex >= jsonArray.size()) {
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
        private String id;
        private String name;
        private String desc;
        private String mode;
        private String table;
        @Getter
        private Set<String> target = new HashSet<>();
        private QueryJsonFilter filter = new QueryJsonFilter();

        public void setOr(List<Map<String, String>> or) {
            for (Map<String, String> orMap : or) {
                for (Map.Entry<String, String> entry : orMap.entrySet()) {
                    target.add(entry.getKey());
                }
            }
            this.filter.or = or;
        }

        public void setAnd(List<Map<String, String>> and) {
            for (Map<String, String> andMap : and) {
                for (Map.Entry<String, String> entry : andMap.entrySet()) {
                    target.add(entry.getKey());
                }
            }
            this.filter.and = and;
        }

        public void setNot(List<Map<String, String>> not) {
            for (Map<String, String> notMap : not) {
                for (Map.Entry<String, String> entry : notMap.entrySet()) {
                    target.add(entry.getKey());
                }
            }
            this.filter.not = not;
        }
    }

    @Data
    public static class QueryJsonFilter {
        private List<Map<String, String>> or;
        private List<Map<String, String>> and;
        private List<Map<String, String>> not;
    }

    @Data
    public static class JsonQueryResult {
        Boolean isExist;
        List<Object> result;
    }
}
