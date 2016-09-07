package com.hz.yk.spring.beans.factory.xml;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;

/**
 * @author yangke
 *         Date: 13-8-16
 *         Time: ����9:41
 */
public class DelegatingEntityResolver implements EntityResolver {
    /** Suffix for DTD files */
    public static final String DTD_SUFFIX = ".dtd";

    public static final String XSD_SUFFIX = ".xsd";

    private final EntityResolver schemaResolver;

    public DelegatingEntityResolver(ClassLoader classLoader) {
        this.schemaResolver = new PluggableSchemaResolver(classLoader);
    }

    @Override
    public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
        if (systemId != null) {
            if (systemId.endsWith(XSD_SUFFIX)) {
                return this.schemaResolver.resolveEntity(publicId, systemId);
            }
        }
        return null;
    }
}
