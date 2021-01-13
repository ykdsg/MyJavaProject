package com.hz.yk.spring.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * @author wuzheng.yk
 * Date: 13-3-7
 * Time: 下午4:43
 */
public class DefaultListableBeanFactoryTest {

    public static void main(String[] args) {
        ClassPathResource res = new ClassPathResource("application.xml");

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(res);

    }
}
