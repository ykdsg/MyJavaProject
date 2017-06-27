package com.yk.groovy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.JSONPathException;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by wuzheng.yk on 2017/6/27.
 */
public class DataObject extends LinkedHashMap<String,Object> {
    private static DecimalFormat decimalFormat = new DecimalFormat("#");
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private Set<String> xPathKeyCache = new LinkedHashSet<String>();

    public enum DataType{Object,String,Double,BigDecimal,Integer,Date,Boolean,UnKnow}

    public DataObject() {
        super();
    }

    @SuppressWarnings("unchecked")
    public DataObject(Object bean){
        if(bean instanceof Map){
            this.putAll((Map<String,Object>)bean);
        }else{
            Map<String,Object> map = bean2Map(bean);
            this.putAll((Map<String,Object>)map);
        }
    }

    public static final Map<String, Object> bean2Map(Object bean) {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        BeanInfo beanInfo;
        try {
            beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0; i< propertyDescriptors.length; i++) {
                PropertyDescriptor descriptor = propertyDescriptors[i];
                String propertyName = descriptor.getName();
                if (!propertyName.equals("class")) {
                    Method readMethod = descriptor.getReadMethod();
                    Object result = readMethod.invoke(bean, new Object[0]);
                    if (result != null) {
                        returnMap.put(propertyName, result);
                    } else {
                        returnMap.put(propertyName, "");
                    }
                }
            }
        } catch (IntrospectionException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return returnMap;
    }

    public static <T> T map2Bean(Map<String, Object> map, Class<T> clazz) {
        T bean = null;
        try {
            bean = clazz.newInstance();
            org.apache.commons.beanutils.BeanUtils.populate(bean, map);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public <T> T castToBean(Class<T> clazz) {
        return map2Bean(this, clazz);
    }

    /**
     * 名称是否为XPath表达式
     * @param name
     * @return
     */
    protected boolean isXPath(String name){
        return false;
    }

    public DataType getDataType(Object object){
        DataType dataType = DataType.UnKnow;
        if(object instanceof Double){
            dataType = DataType.Double;
        }else if(object instanceof Float){
            dataType = DataType.Double;
        }else if(object instanceof Integer){
            dataType = DataType.Integer;
        }else if(object instanceof BigDecimal){
            dataType = DataType.BigDecimal;
        }else if(object instanceof Number){
            dataType = DataType.Double;
        }else if(object instanceof Date){
            dataType = DataType.Date;
        }else if(object instanceof Boolean){
            dataType = DataType.Boolean;
        }else if(object instanceof String){
            dataType = DataType.String;
        }else if(object instanceof Object){
            dataType = DataType.Object;
        }
        return dataType;
    }
    public DataType getDataType(String name){
        Object object = getObject(name);
        if(object == null) return null;
        return getDataType(object);
    }

    @SuppressWarnings("unchecked")
    public Object getObject(String name){
        Object object = null;
        if(name.indexOf(".")>0){    //说明是xpath格式

            JSONPath xpath = new JSONPath(name);
            try{
                object = xpath.eval(this);
            }catch(NullPointerException e){
                object = null;
            }catch(JSONPathException e){
                //fastjson的xpath不太靠谱，有时候解不天，如果解不开，则硬解
                String[] names = name.split("\\.");
                Map<String,Object> curObject = this;
                String nPath = "";
                for(String n : names){
                    nPath += n+".";
                    if(curObject == null || !curObject.containsKey(n)){
                        throw new NullPointerException(MessageFormat.format("attribute [{0}] not exists in DataObject",nPath.substring(0, nPath.length()-1)));
                    }
                    object = curObject.get(n);
                    if(object instanceof Map){
                        curObject = (Map<String, Object>)object;
                        continue;
                    }
                    return object;
                }
            }
        }else{
            if(!containsKey(name)){
                throw new NullPointerException(MessageFormat.format("attribute [{0}] not exists in DataObject",name));
            }
            object = get(name);
        }
        return object;
    }

    public boolean attributeExists(String name){
        if(name.indexOf(".")>0){    //说明是xpath格式
            JSONPath xpath = new JSONPath(name);
            Object object = null;
            try{
                object = xpath.eval(this);
            }catch(NullPointerException e){
                object = null;
            }
            return object != null;
        }else{
            return this.containsKey(name);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T getObject(String name,Class<T> requiredType) {
        Object object = getObject(name);
        return (T)object;
    }
    @SuppressWarnings("unchecked")
    public <T> List<T> getObjectList(String name,Class<T> requiredType) {
        Object object = getObject(name);
        return (List<T>)object;
    }



    public void putAll(Map<? extends String, ? extends Object> m) {
        super.putAll(m);
    }

    @SuppressWarnings("unchecked")
    public Object put(String key, Object value) {
        if(value instanceof Map){
            return super.put(key,cascadeConvertMap((Map<Object, Object>)value));
        }else if(value instanceof List){
            List<Object> listValue = (List<Object>)value;
            for(int i=0;i<listValue.size();i++){
                Object v = listValue.get(i);
                if(v instanceof Map){
                    listValue.set(i, cascadeConvertMap((Map<Object,Object>)v));
                }
            }
            return super.put(key, listValue);
        }else{
            return super.put(key, value);
        }
    }

    /**
     * 递归转换所有的Map为ElasticDataObject
     * @param mapValue
     * @return
     */
    @SuppressWarnings("unchecked")
    protected DataObject cascadeConvertMap(Map<Object,Object> mapValue){
        Iterator<?> iterator = mapValue.keySet().iterator();
        while(iterator.hasNext()){
            Object k = iterator.next();
            Object v = mapValue.get(k);
            if(v instanceof Map){
                mapValue.put(k, cascadeConvertMap((Map<Object,Object>)v));
            }
        }
        return new DataObject(mapValue);
    }

    public Integer getInteger(String name){
        Object object = getObject(name);
        if(object == null) return null;
        DataType dataType = getDataType(object);
        if(dataType == DataType.Integer){
            return (Integer)object;
        }else if(dataType == DataType.Double){
            return ((Double)object).intValue();
        }else if(dataType == DataType.BigDecimal){
            return ((BigDecimal)object).intValue();
        }else if(dataType == DataType.String){
            return Integer.parseInt((String)object);
        }else{
            return null;
        }
    }
    public Double getDouble(String name){
        Object object = getObject(name);
        if(object == null) return null;
        DataType dataType = getDataType(object);
        if(dataType == DataType.Integer){
            return ((Integer)object).doubleValue();
        }else if(dataType == DataType.Double){
            return ((Double)object);
        }else if(dataType == DataType.BigDecimal){
            return ((BigDecimal)object).doubleValue();
        }else if(dataType == DataType.String){
            return Double.parseDouble((String)object);
        }else{
            return null;
        }
    }

    /**
     * 取出数据，直接转为String
     * @param name
     * @return
     */
    public String getString(String name){
        Object object = getObject(name);
        if(object == null) return null;
        DataType dataType = getDataType(object);
        if(dataType == DataType.Integer){
            return decimalFormat.format((Integer)object);
        }else if(dataType == DataType.Double){
            return decimalFormat.format((Double)object);
        }else if(dataType == DataType.String){
            return (String)object;
        }else if(dataType == DataType.Boolean){
            return ((Boolean)object).toString();
        }else if(dataType == DataType.Date){
            return dateFormat.format((Date)object);
        }else{
            return object.toString();
        }
    }

    public Boolean getBoolean(String name){
        Object object = getObject(name);
        if(object == null) return null;
        DataType dataType = getDataType(object);
        if(dataType == DataType.Boolean){
            return ((Boolean)object);
        }else if(dataType == DataType.String){
            return Boolean.parseBoolean((String)object);
        }else{
            return null;
        }
    }

    public String getJSONString() {
        SerializeConfig slizeCfg = new SerializeConfig();
        slizeCfg.put(Date.class, new SimpleDateFormatSerializer("yyyy/MM/dd HH:mm:ss.SSS"));
        return JSON.toJSONString(this,
                slizeCfg,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteNonStringKeyAsString,
                SerializerFeature.SortField);
    }

    /**
     * 取出数据，如果是日期类型或日期字串，都可以直接转成日期类型
     * @param name
     * @return
     */
    public Date getDate(String name){
        Object object = getObject(name);
        if(object == null) return null;
        DataType dataType = getDataType(object);
        if(dataType == DataType.Date){
            return (Date)object;
        }else if(dataType == DataType.String){
            return toDate((String)object);
        }else{
            return null;
        }
    }


    private Date toDate(String _date){
        Date date = new Date();

        DateFormat df = dateFormat;
        try {
            date = df.parse(_date);
        } catch (ParseException e) {
            df = new SimpleDateFormat("yyyy/MM/dd");
            try {
                date = df.parse(_date);
            } catch (ParseException e1) {
                throw new RuntimeException("",e);
            }
        }

        return date;
    }

    /**
     * 支持xpath形式的设置值
     * @param name
     * @param value
     */
    public void xput(String name,Object value){
        if(name.indexOf(".")<0)put(name,value);
        String[] names = name.split("\\.");
        DataObject cursor = this;
        for(int i=0;i<names.length;i++){
            String n = names[i];
            boolean isLast = (i == names.length -1);
            if(!isLast){
                //根据xpath路径，不存在，则创建一个相应的对象
                if(!cursor.containsKey(n)){
                    cursor.put(n, new DataObject());
                }
                cursor = cursor.getObject(n, DataObject.class);
            }else{
                cursor.put(n, value);
            }
        }
        xPathKeyCache.add(name);
    }

    public Iterator<String> xpathKeyIterator(){
        return xPathKeyCache.iterator();
    }

    /**
     * 把层次结构深的对象使用xpath方式拉平
     * @return
     */
    public Map<String,Object> flatMap(){
        Map<String,Object> mapResult = new LinkedHashMap<String, Object>();
        Iterator<String> iterator = xpathKeyIterator();
        while(iterator.hasNext()){
            String xpath = iterator.next();
            mapResult.put(xpath, this.getObject(xpath));
        }
        return mapResult;
    }

    public void set(String text){
        this.putAll(JSON.parseObject(text, new TypeReference<Map<String,Object>>(){}));
    }
    public static DataObject createNew(String text){
        DataObject edo = new DataObject();
        edo.set(text);
        return edo;
    }
}
