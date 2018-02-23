package com.hz.yk.fastjson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wuzheng.yk on 2018/2/23.
 */
public class JacksonObject2MapUtil {

    private static final List<Class>  PRIMITIVE_CLASS_LIST = Lists.newArrayList();

    static {
        PRIMITIVE_CLASS_LIST.add(Integer.class);
        PRIMITIVE_CLASS_LIST.add(Long.class);
        PRIMITIVE_CLASS_LIST.add(Short.class);
        PRIMITIVE_CLASS_LIST.add(Float.class);
        PRIMITIVE_CLASS_LIST.add(Double.class);
        PRIMITIVE_CLASS_LIST.add(Byte.class);
        PRIMITIVE_CLASS_LIST.add(Character.class);
        PRIMITIVE_CLASS_LIST.add(Boolean.class);
    }


    public static Object convertToMap(Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof Map) {
            return doConvertForMap((Map<Object, Object>) object);
        }
        if (object instanceof Collection) {
            Collection objCol = (Collection) object;
            List tempList = new ArrayList(objCol.size());
            for (Object innerObj : objCol) {
                Object convertObj = convertToMap(innerObj);
                if (convertObj == null) {
                    continue;
                }
                tempList.add(convertObj);
            }
            return tempList;
        }
        if (object.getClass().isArray()) {
            int lengh = Array.getLength(object);
            List tempList = new ArrayList(lengh);
            for (int i = 0; i < lengh; ++i) {
                Object obj = Array.get(object, i);
                if (obj == null) {
                    continue;
                }
                Object convertObj = convertToMap(obj);
                if (convertObj == null) {
                    continue;
                }
                tempList.add(convertObj);
            }
            return tempList;
        }
        if (isBasicObject(object)) {
            return object;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper.convertValue(object, Map.class);
    }

    private static Map<Object, Object> doConvertForMap(Map<Object, Object> originalMap) {
        Map<Object, Object> resultMap = new HashMap(originalMap.size());
        for (Map.Entry<Object, Object> entry : originalMap.entrySet()) {
            if (entry.getValue() == null) {
                continue;
            }
            if (isBasicObject(entry.getValue())) {
                resultMap.put(entry.getKey(), entry.getValue());
                continue;
            }
            Object object1 = convertToMap(entry.getValue());
            if (object1 == null) {
                continue;
            }
            resultMap.put(entry.getKey(), object1);
        }
        return resultMap;
    }

    private static boolean isBasicObject(Object object) {
        if (object == null) {
            return false;
        }
        return (PRIMITIVE_CLASS_LIST.contains(object.getClass()) || object.getClass().getName().startsWith("java.lang")
                || object.getClass().getName().startsWith("java.util"))
               && !Collection.class.isAssignableFrom(object.getClass())
               && !Map.class.isAssignableFrom(object.getClass());
    }
}
