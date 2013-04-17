package com.hz.yk.spring.beans.factory.xml;

import java.io.IOException;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * @author wuzheng.yk
 *         Date: 13-3-15
 *         Time: обнГ7:20
 */
public class BeansDtdResolver implements EntityResolver {
    @Override
    public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
        return null;  //TODO
    }
}
