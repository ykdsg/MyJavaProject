package com.hz.yk.spring.source.beans.factory.xml;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * @author wuzheng.yk
 * Date: 13-2-16
 * Time: ����8:36
 */
public class DefaultDocumentLoader implements DocumentLoader {

    private static final Log logger = LogFactory.getLog(DefaultDocumentLoader.class);

    @Override
    public Document loadDocument(InputSource inputSource, EntityResolver entityResolver, ErrorHandler errorHandler,
                                 int validationMode, boolean namespaceAware) throws Exception {
        DocumentBuilderFactory factory = createDocumentBuilderFactory(validationMode, namespaceAware);
        if (logger.isDebugEnabled()) {
            logger.debug("Using JAXP provider [" + factory.getClass().getName() + "]");
        }
        DocumentBuilder builder = createDocumentBuilder(factory, entityResolver, errorHandler);
        return builder.parse(inputSource);
    }

    private DocumentBuilder createDocumentBuilder(DocumentBuilderFactory factory, EntityResolver entityResolver,
                                                  ErrorHandler errorHandler) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    private DocumentBuilderFactory createDocumentBuilderFactory(int validationMode, boolean namespaceAware) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

}
