package com.hz.yk.spring.beans.factory.xml;

import com.hz.yk.spring.core.io.Resource;
import com.hz.yk.spring.core.io.ResourceLoader;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * @author wuzheng.yk
 *         Date: 13-3-15
 *         Time: ÏÂÎç7:26
 */
public class ResourceEntityResolver extends DelegatingEntityResolver{
    private static final Log logger = LogFactory.getLog(ResourceEntityResolver.class);

    private final ResourceLoader resourceLoader;


    /**
     * Create a ResourceEntityResolver for the specified ResourceLoader
     * (usually, an ApplicationContext).
     * @param resourceLoader the ResourceLoader (or ApplicationContext)
     * to load XML entity includes with
     */
    public ResourceEntityResolver(ResourceLoader resourceLoader) {
        super(resourceLoader.getClassLoader());
        this.resourceLoader = resourceLoader;
    }


    public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
        InputSource source = super.resolveEntity(publicId, systemId);
        if (source == null && systemId != null) {
            String resourcePath = null;
            try {
                String decodedSystemId = URLDecoder.decode(systemId);
                String givenUrl = new URL(decodedSystemId).toString();
                String systemRootUrl = new File("").toURL().toString();
                // Try relative to resource base if currently in system root.
                if (givenUrl.startsWith(systemRootUrl)) {
                    resourcePath = givenUrl.substring(systemRootUrl.length());
                }
            }
            catch (Exception ex) {
                // Typically a MalformedURLException or AccessControlException.
                if (logger.isDebugEnabled()) {
                    logger.debug("Could not resolve XML entity [" + systemId + "] against system root URL", ex);
                }
                // No URL (or no resolvable URL) -> try relative to resource base.
                resourcePath = systemId;
            }
            if (resourcePath != null) {
                if (logger.isTraceEnabled()) {
                    logger.trace("Trying to locate XML entity [" + systemId + "] as resource [" + resourcePath + "]");
                }
                Resource resource = this.resourceLoader.getResource(resourcePath);
                source = new InputSource(resource.getInputStream());
                source.setPublicId(publicId);
                source.setSystemId(systemId);
                if (logger.isDebugEnabled()) {
                    logger.debug("Found XML entity [" + systemId + "]: " + resource);
                }
            }
        }
        return source;
    }







}
