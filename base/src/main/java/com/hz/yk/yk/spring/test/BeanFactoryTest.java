package com.hz.yk.yk.spring.test;


import com.hz.yk.yk.spring.beans.factory.xml.XmlBeanFactory;
import com.hz.yk.yk.spring.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;

/**
 * @author wuzheng.yk
 *         Date: 13-3-13
 *         Time: ����9:24
 */
public class BeanFactoryTest {

    private String name;

    public static void main(String[] args) throws IOException {
        ClassPathResource res = new ClassPathResource("beans.xml");
        File resource=res.getFile();
        System.out.println(resource);
        XmlBeanFactory factory = new XmlBeanFactory(res);
//        Object obj = factory.getBean("beanFactory");
//        System.out.println(obj.getClass());
    }



    public void setName(String name) {
        this.name = name;
    }
}
