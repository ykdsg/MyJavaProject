package com.hz.yk.spring.test;

import java.io.File;
import java.io.IOException;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author wuzheng.yk
 *         Date: 13-3-13
 *         Time: ÉÏÎç9:24
 */
public class BeanFactoryTest {
    public static void main(String[] args) throws IOException {
        ClassPathResource res = new ClassPathResource("beans.xml");
        File resource=res.getFile();
        System.out.println(resource);
        XmlBeanFactory factory = new XmlBeanFactory(res);
        Object obj = factory.getBean("beanFactory");
        System.out.println(obj.getClass());
    }
}
