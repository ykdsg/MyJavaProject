package com.hz.yk.spring.beans.factory.xml;

import com.hz.yk.spring.core.io.ClassPathResource;
import com.hz.yk.spring.core.io.Resource;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.FatalBeanException;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.Assert;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

/**
 * @author wuzheng.yk
 *         Date: 13-3-15
 *         Time: ÏÂÎç7:21
 */
public class PluggableSchemaResolver  implements EntityResolver {

    /**
     * The location of the file that defines schema mappings.
     * Can be present in multiple JAR files.
     */
    public static final String DEFAULT_SCHEMA_MAPPINGS_LOCATION = "META-INF/spring.schemas";


    private static final Log logger = LogFactory.getLog(PluggableSchemaResolver.class);

    private final ClassLoader classLoader;

    private final String schemaMappingsLocation;

    /** Stores the mapping of schema URL -> local schema path */
    private Properties schemaMappings;


    /**
     * Loads the schema URL -> schema file location mappings using the default
     * mapping file pattern "META-INF/spring.schemas".
     * @param classLoader the ClassLoader to use for loading
     * (can be <code>null</code>) to use the default ClassLoader)
     * @see org.springframework.core.io.support.PropertiesLoaderUtils#loadAllProperties(String, ClassLoader)
     */
    public PluggableSchemaResolver(ClassLoader classLoader) {
        this.classLoader = classLoader;
        this.schemaMappingsLocation = DEFAULT_SCHEMA_MAPPINGS_LOCATION;
    }

    /**
     * Loads the schema URL -> schema file location mappings using the given
     * mapping file pattern.
     * @param classLoader the ClassLoader to use for loading
     * (can be <code>null</code>) to use the default ClassLoader)
     * @param schemaMappingsLocation the location of the file that defines schema mappings
     * (must not be empty)
     * @see org.springframework.core.io.support.PropertiesLoaderUtils#loadAllProperties(String, ClassLoader)
     */
    public PluggableSchemaResolver(ClassLoader classLoader, String schemaMappingsLocation) {
        Assert.hasText(schemaMappingsLocation, "'schemaMappingsLocation' must not be empty");
        this.classLoader = classLoader;
        this.schemaMappingsLocation = schemaMappingsLocation;
    }


    public InputSource resolveEntity(String publicId, String systemId) throws IOException {
        if (logger.isTraceEnabled()) {
            logger.trace("Trying to resolve XML entity with public id [" + publicId +
                    "] and system id [" + systemId + "]");
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
                this.schemaMappings =
                        PropertiesLoaderUtils.loadAllProperties(this.schemaMappingsLocation, this.classLoader);
                if (logger.isDebugEnabled()) {
                    logger.debug("Loaded schema mappings: " + this.schemaMappings);
                }
            }
            catch (IOException ex) {
                throw new FatalBeanException(
                        "Unable to load schema mappings from location [" + this.schemaMappingsLocation + "]", ex);
            }
        }
        return this.schemaMappings.getProperty(systemId);
    }
}
