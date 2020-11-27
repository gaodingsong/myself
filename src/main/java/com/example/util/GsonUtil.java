package com.example.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.lang.reflect.Type;

/**
 * @description:谷歌json和对象转换
 * @author:dingsong.gao
 * @createTime:2020/10/13 18:44
 * @version:1.0
 */
public class GsonUtil {

    private GsonUtil(){}

    /**
     * 对象转换成json字符串  字段为null时  不过滤
     * @param obj
     * @return
     */
    public static String toJsonContainNull(Object obj) {
        GsonBuilder gsonbuilder = new GsonBuilder();
        gsonbuilder.serializeNulls();
        Gson gson = gsonbuilder.create();
        return gson.toJson(obj);
    }

    /**
     * 对象转换成json字符串  字段为null时  过滤为null值的字段
     * @param obj
     * @return
     */
    public static String toJsonNotContainNull(Object obj) {

        Gson gson = new Gson();
        return gson.toJson(obj);
    }
    /**
     * json字符串转成对象集合
     * @param str
     * @param type
     * @return
     */
    public static <T> T fromJson(String str, Type type) {
        Gson gson = new Gson();
        return gson.fromJson(str, type);
    }

    /**
     * json字符串转成对象
     * @param str
     * @param type
     * @return
     */
    public static <T> T toJavaObjectFromJson(String str, Class<T> type) {
        Gson gson = new Gson();
        return gson.fromJson(str, type);
    }


    /**
     * 根据key获取value值
     * @param originStr  获取到的原始的字符串
     * @param key
     * @return
     */
    public static String getValueByKey(String originStr,String key){
        JsonObject root  = new JsonParser().parse(originStr).getAsJsonObject();
        String value = root.get(key).toString();
        return value;
    }


//       *  import com.google.gson.reflect.TypeToken;
//     * List<Person> rtn = GsonUtil.fromJson(jsonStr, new TypeToken<List<Person>>(){}.getType());jsonstr转对象集合

}
