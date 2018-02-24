package com.hz.yk.fastjson;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wuzheng.yk on 2018/2/23.
 */
public class ReflectObject2MapUtil {

    /**
     * 基本类型以及Date,List,Map等不需要转换，直接调用
     */
    private static Map<String, Class> baseTypeMap = Maps.newHashMap();

    static {
        baseTypeMap.put(String.class.getName(), String.class);
        baseTypeMap.put(Date.class.getName(), Date.class);
        baseTypeMap.put(int.class.getName(), int.class);
        baseTypeMap.put(long.class.getName(), long.class);
        baseTypeMap.put(float.class.getName(), float.class);
        baseTypeMap.put(double.class.getName(), double.class);
        baseTypeMap.put(boolean.class.getName(), boolean.class);
        baseTypeMap.put(byte.class.getName(), byte.class);
        baseTypeMap.put(char.class.getName(), char.class);
        baseTypeMap.put(short.class.getName(), short.class);
        baseTypeMap.put(Integer.class.getName(), Integer.class);
        baseTypeMap.put(Long.class.getName(), Long.class);
        baseTypeMap.put(Float.class.getName(), Float.class);
        baseTypeMap.put(Double.class.getName(), Double.class);
        baseTypeMap.put(Boolean.class.getName(), Boolean.class);
        baseTypeMap.put(Byte.class.getName(), Byte.class);
        baseTypeMap.put(Character.class.getName(), Character.class);
        baseTypeMap.put(Short.class.getName(), Short.class);
    }

    public static Object convertToMap(Object object) {
        if (object == null) {
            return null;
        }
        if (isBaseTye(object)) {
            return object;
        }
        if (object instanceof Map) {
            return doConvertForMap((Map<Object, Object>) object);
        }
        if (object instanceof Collection) {
            return doCovertForCollection((Collection) object);
        }
        if (object.getClass().isArray()) {
            return doCovertForArray(object);
        }
        List<Field> fields = getDeclaredField(object);
        Map resultMap = new HashMap();
        try {
            for (Field field : fields) {
                if (Modifier.isStatic(field.getModifiers())) {
                    continue;
                }
                field.setAccessible(true);
                Object fieldValue = field.get(object);
                if (fieldValue == null) {
                    continue;
                }
                resultMap.put(field.getName(), convertToMap(fieldValue));

            }
        } catch (IllegalAccessException e) {
            //todo 日志记录
            e.printStackTrace();
        }
        return resultMap;
    }


    /**
     * 循环向上转型, 获取对象的 DeclaredField
     * @param object : 子类对象
     * @return 所有的字段
     */
    public static List<Field> getDeclaredField(Object object){
        Class<?> clazz = object.getClass() ;
        List<Field> fieldList = Lists.newArrayList();

        for(; clazz != Object.class ; clazz = clazz.getSuperclass()) {
            Field[] fields = clazz.getDeclaredFields();
            if (ArrayUtils.isEmpty(fields)) {
                continue;
            }
            fieldList.addAll(Arrays.asList(fields));
        }
        return fieldList;
    }

    /**
     * 是否基础类型,基础类型不需要继续解析
     *
     * @param obj
     * @return
     */
    private static boolean isBaseTye(Object obj) {
        if (obj == null) {
            return false;
        }
        return baseTypeMap.containsKey(obj.getClass().getName());
    }

    private static Object doCovertForArray(Object object) {
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

    private static Object doCovertForCollection(Collection object) {
        Collection objCol = object;
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

    private static Map<Object, Object> doConvertForMap(Map<Object, Object> originalMap) {
        Map<Object, Object> resultMap = new HashMap(originalMap.size());
        for (Map.Entry<Object, Object> entry : originalMap.entrySet()) {
            if (entry.getValue() == null) {
                continue;
            }
            if (isBaseTye(entry.getValue())) {
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

}
