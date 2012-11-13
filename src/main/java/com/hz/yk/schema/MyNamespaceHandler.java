package com.hz.yk.schema;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author ykdsg
 *         Date: 12-1-29
 *         Time: обнГ10:50
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {
    public void init() {
        registerBeanDefinitionParser("people", new PeopleBeanDefinitionParser());
    }
}
