package com.hz.yk.spring.source.beanwrapper;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;

/**
 * BeanWrapper�ṩ�����úͻ�ȡ����ֵ�������Ļ����������ģ�����ȡ����������Ϣ����ѯֻ�����߿�д���Եȹ��ܡ�������ˣ�
 * BeanWrapper��֧��Ƕ�����ԣ�����Բ���Ƕ��������ƶ������Ե�ֵ��������
 * @author wuzheng.yk
 *         Date: 13-1-31
 *         Time: ����9:18
 */
public class Main {

    public static void main(String[] args) throws Exception{
        Object obj = Class.forName("Company").newInstance();
        BeanWrapper company=new BeanWrapperImpl(obj);
        company.setPropertyValue("name","some company inc.");
        System.out.println(company.getPropertyValue("name"));

        PropertyValue value=new PropertyValue("name","next company name");
        company.setPropertyValue(value);

        Object obj2 = Class.forName("Employee").newInstance();
        BeanWrapper jim = new BeanWrapperImpl(obj2);
        jim.setPropertyValue("salary", 4567.0);
        company.setPropertyValue("managingDirector", jim.getWrappedInstance());

        Float salary = (Float) company.getPropertyValue("managingDirector.salary");
        System.out.println(salary);
        System.out.println(company.getPropertyValue("name"));
    }
}
