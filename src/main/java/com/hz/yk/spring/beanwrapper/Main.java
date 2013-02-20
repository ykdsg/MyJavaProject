package com.hz.yk.spring.beanwrapper;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;

/**
 * BeanWrapper提供了设置和获取属性值（单个的或者是批量的），获取属性描述信息、查询只读或者可写属性等功能。不仅如此，
 * BeanWrapper还支持嵌套属性，你可以不受嵌套深度限制对子属性的值进行设置
 * @author wuzheng.yk
 *         Date: 13-1-31
 *         Time: 下午9:18
 */
public class Main {

    public static void main(String[] args) throws Exception{
        Object obj = Class.forName("com.hz.yk.spring.beanwrapper.Company").newInstance();
        BeanWrapper company=new BeanWrapperImpl(obj);
        company.setPropertyValue("name","some company inc.");
        System.out.println(company.getPropertyValue("name"));

        PropertyValue value=new PropertyValue("name","next company name");
        company.setPropertyValue(value);

        Object obj2 = Class.forName("com.hz.yk.spring.beanwrapper.Employee").newInstance();
        BeanWrapper jim = new BeanWrapperImpl(obj2);
        jim.setPropertyValue("salary", 4567.0);
        company.setPropertyValue("managingDirector", jim.getWrappedInstance());

        Float salary = (Float) company.getPropertyValue("managingDirector.salary");
        System.out.println(salary);
        System.out.println(company.getPropertyValue("name"));
    }
}
