package com.hz.yk.my.spring.source.beans.factory.xml;

import com.hz.yk.my.spring.source.core.io.ClassPathResource;
import com.hz.yk.my.spring.source.core.io.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.FatalBeanException;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.Properties;

/**
 * @author yangke
 * Date: 13-8-16
 * Time: ����10:01
 */
public class PluggableSchemaResolver implements EntityResolver {

    /**
     * The location of the file that defines schema mappings.
     * Can be present in multiple JAR files.
     */
    public static final String DEFAULT_SCHEMA_MAPPINGS_LOCATION = "META-INF/spring.schemas";

    private static final Log logger = LogFactory.getLog(PluggableSchemaResolver.class);
    private final ClassLoader classLoader;
    private final String schemaMappingsLocation;
    /**
     * Stores the mapping of schema URL -> local schema path
     */
    private Properties schemaMappings;

    public PluggableSchemaResolver(ClassLoader classLoader) {
        this.classLoader = classLoader;
        this.schemaMappingsLocation = DEFAULT_SCHEMA_MAPPINGS_LOCATION;
    }

    @Override
    public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
        if (logger.isTraceEnabled()) {
            logger.trace(
                    "Trying to resolve XML entity with public id [" + publicId + "] and system id [" + systemId + "]");
        }
        if (systemId != null) {
            String resourceLocation = getSchemaMapping(systemId);
            if (resourceLocation != null) {
                Resource resource = new ClassPathResource(resourceLocation, this.classLoader);
                InputSource source = new InputSource(resource.getInputStream());
                source.setPublicId(publicId);
                source.setSystemId(systemId);
                if (logger.isDebugEnabled()) {
                    logger.debug("Found XML schema [" + systemId + "] in classpath: " + resourceLocation);
                }
                return source;
            }
        }
        return null;
    }

    protected String getSchemaMapping(String systemId) {
        if (this.schemaMappings == null) {
            if (logger.isDebugEnabled()) {
                logger.debug("Loading schema mappings from [" + this.schemaMappingsLocation + "]");
            }
            try {
                this.schemaMappings = PropertiesLoaderUtils
                        .loadAllProperties(this.schemaMappingsLocation, this.classLoader);
                if (logger.isDebugEnabled()) {
                    logger.debug("Loaded schema mappings: " + this.schemaMappings);
                }
            } catch (IOException ex) {
                throw new FatalBeanException(
                        "Unable to load schema mappings from location [" + this.schemaMappingsLocation + "]", ex);
            }
        }
        return this.schemaMappings.getProperty(systemId);
    }
}
