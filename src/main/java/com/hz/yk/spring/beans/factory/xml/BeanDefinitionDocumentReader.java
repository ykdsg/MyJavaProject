package com.hz.yk.spring.beans.factory.xml;

import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.xml.XmlReaderContext;
import org.w3c.dom.Document;

/**
 * @author yangke
 *         Date: 13-8-4
 *         Time: ÏÂÎç4:26
 */
public interface BeanDefinitionDocumentReader {

    /**
     * Read bean definitions from the given DOM document,
     * and register them with the given bean factory.
     * @param doc the DOM document
     * @param readerContext the current context of the reader. Includes the resource being parsed
     * @throws BeanDefinitionStoreException in case of parsing errors
     */
    void registerBeanDefinitions(Document doc, XmlReaderContext readerContext)
            throws BeanDefinitionStoreException;
}
