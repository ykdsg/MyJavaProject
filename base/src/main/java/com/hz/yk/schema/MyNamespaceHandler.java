package com.hz.yk.schema;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author wuzheng.yk
 * @date 2018/7/5
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("people", new PeopleBeanDefinitionParser());
    }

}
