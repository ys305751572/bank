package com.sixmac.utils;

import com.sixmac.utils.gson.DmsExclusionStrategy;
import com.google.gson.*;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Type;

/**
 * Created by wangbin on 14-10-17.
 */
public class JsonUtil {

    protected final static Log logger = LogFactory.getLog(JsonUtil.class);

    public static GsonBuilder createGsonBuilder(){
        return new GsonBuilder().serializeNulls().
                setDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * json�ַ���ת���ɶ���
     * @param str  json�ַ���
     * @param type ��������
     * @param <T>
     * @return
     */
    public static <T> T json2Obj(String str,Type type){
        Gson gson = createGsonBuilder().create();
        return gson.fromJson(str,type);
    }





    /**
     * java����ת����json�ַ���
     * @param obj  java����
     * @param excludes �����ֶ�
     * @return
     */
    public static String obj2Json(Object obj,String ... excludes ){
        ExclusionStrategy strategy = new DmsExclusionStrategy(excludes);
        Gson gson =createGsonBuilder()
                .setExclusionStrategies(strategy)
                .create();
        return  gson.toJson(obj);
    }




    /**
     * java����ת����json�ַ���
     * @param obj
     * @param classes �������
     * @param excludes  �ַ�������
     * @return
     */
    public static String obj2Json(Object obj,Class[] classes,String... excludes){
        ExclusionStrategy strategy = new DmsExclusionStrategy(excludes,classes);
        Gson gson =createGsonBuilder()
                  .setExclusionStrategies(strategy)
                .create();
        return  gson.toJson(obj);
    }

    public static Boolean isGoodJson(String json){
        if (StringUtils.isBlank(json)) {
            return false;
        }
        try {
            new JsonParser().parse(json);
            return true;
        } catch (JsonParseException e) {
            logger.error("bad json: " + json);
            return false;
        }
    }







}
