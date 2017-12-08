package com.hz.yk.jmx.dynamic;

import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.AttributeNotFoundException;
import javax.management.DynamicMBean;
import javax.management.InvalidAttributeValueException;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanConstructorInfo;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.MBeanNotificationInfo;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanParameterInfo;
import javax.management.ReflectionException;
import java.lang.reflect.Constructor;
import java.util.Iterator;

/**
 * Created by wuzheng.yk on 2017/12/8.
 */
public class HelloDynamic implements DynamicMBean {

    private String name;
    private MBeanInfo mBeanInfo = null;
    private String                 className;
    private String                 description;
    private MBeanAttributeInfo[]   attributes;
    private MBeanConstructorInfo[] constructors;
    private MBeanOperationInfo[]   operations;
    MBeanNotificationInfo[] mBeanNotificationInfoArray;

    private void init(){
        className = this.getClass().getName();
        description = "Simple implementation of a dynamic MBean.";
        attributes = new MBeanAttributeInfo[1];
        constructors = new MBeanConstructorInfo[1];
        operations = new MBeanOperationInfo[1];
        mBeanNotificationInfoArray = new MBeanNotificationInfo[0];
    }

    private void buildDynamicMBean(){
        Constructor[] thisConstructors = this.getClass().getConstructors();
        constructors[0] = new MBeanConstructorInfo("HelloDynamic(): Constructs a HelloDynamic Object",thisConstructors[0]);

        attributes[0] = new MBeanAttributeInfo("name","java.lang.String","Name:name string.",true,true,false);

        MBeanParameterInfo[] params = null;
        operations[0] = new MBeanOperationInfo("print","print():print the name",params,"void",MBeanOperationInfo.INFO);
        mBeanInfo = new MBeanInfo(className,description,attributes,constructors,operations,mBeanNotificationInfoArray);
    }

    public HelloDynamic(){
        init();
        buildDynamicMBean();
    }

    private void dynamicAddOperation(){
        init();
        operations = new MBeanOperationInfo[2];
        buildDynamicMBean();
        operations[1] = new MBeanOperationInfo("print1","print1():print the name",null,"void",MBeanOperationInfo.INFO);
        mBeanInfo = new MBeanInfo(className,description,attributes,constructors,operations,mBeanNotificationInfoArray);
    }

    @Override
    public Object getAttribute(String attribute) throws AttributeNotFoundException, MBeanException, ReflectionException {
        if (attribute == null) {
            return null;
        }
        if (attribute.equals("Name")) {
            return name;
        }

        return null;
    }

    @Override
    public void setAttribute(Attribute attribute) throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {
        if (attribute == null) {
            return;
        }

        String Name = attribute.getName();
        Object value = attribute.getValue();

        try {
            if (Name.equals("Name")) {
                if (value == null) {
                    name=null;
                } else if (Class.forName("java.lang.String").isAssignableFrom(value.getClass())) {
                    name = (String) name;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public AttributeList getAttributes(String[] attributes) {
        if (attributes == null) {
            return null;
        }
        AttributeList resultList = new AttributeList();
        //        if (attributes.length == 0) {
        //            return resultList;
        //        }
        for(int i=0;i<attributes.length;i++){
            try {
                Object value = getAttribute(attributes[i]);
                resultList.add(new Attribute(attributes[i],value));
            } catch (AttributeNotFoundException e) {
                e.printStackTrace();
            } catch (MBeanException e) {
                e.printStackTrace();
            } catch (ReflectionException e) {
                e.printStackTrace();
            }
        }

        return resultList;
    }

    @Override
    public AttributeList setAttributes(AttributeList attributes) {
        if (attributes == null) {
            return null;
        }
        AttributeList resultList = new AttributeList();
        if(attributes.isEmpty()){
            return resultList;
        }
        for(Iterator i = attributes.iterator(); i.hasNext();){
            Attribute attr = (Attribute) i.next();
            try {
                setAttribute(attr);
                String name = attr.getName();
                Object value = getAttribute(name);
                resultList.add(new Attribute(name,value));
            } catch (AttributeNotFoundException e) {
                e.printStackTrace();
            } catch (InvalidAttributeValueException e) {
                e.printStackTrace();
            } catch (MBeanException e) {
                e.printStackTrace();
            } catch (ReflectionException e) {
                e.printStackTrace();
            }

        }

        return resultList;
    }

    @Override
    public Object invoke(String actionName, Object[] params, String[] signature) throws MBeanException, ReflectionException {
        if(actionName.equals("print")){
            System.out.println("Hello, "+name+",this is HelloDynamic!");
            dynamicAddOperation();
            return null;
        }else if(actionName.equals("print1")){
            System.out.println("这是动态增加的一个方法print1");
            return null;
        }else {
            throw new ReflectionException(new NoSuchMethodException(actionName),"Cannot find the operation "+actionName+" in "+className);
        }
    }

    @Override
    public MBeanInfo getMBeanInfo() {
        return mBeanInfo;
    }
}
