package com.hz.yk.spring.core.io;

import java.net.MalformedURLException;
import java.net.URL;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

/**
 * @author wuzheng.yk
 *         Date: 13-2-17
 *         Time: ÏÂÎç9:47
 */
public class DefaultResourceLoader implements ResourceLoader {
    private ClassLoader classLoader;

    /**
     * Create a new DefaultResourceLoader.
     * <p>ClassLoader access will happen using the thread context class loader
     * at the time of this ResourceLoader's initialization.
     * @see java.lang.Thread#getContextClassLoader()
     */
    public DefaultResourceLoader() {
        this.classLoader = ClassUtils.getDefaultClassLoader();
    }

    /**
     * Create a new DefaultResourceLoader.
     * @param classLoader the ClassLoader to load class path resources with, or <code>null</code>
     * for using the thread context class loader at the time of actual resource access
     */
    public DefaultResourceLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }


    /**
     * Specify the ClassLoader to load class path resources with, or <code>null</code>
     * for using the thread context class loader at the time of actual resource access.
     * <p>The default is that ClassLoader access will happen using the thread context
     * class loader at the time of this ResourceLoader's initialization.
     */
    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }


    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null");
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()), getClassLoader());
        }
        else {
            try {
                // Try to parse the location as a URL...
                URL url = new URL(location);
                return new UrlResource(url);
            }
            catch (MalformedURLException ex) {
                // No URL -> resolve as resource path.
                return getResourceByPath(location);
            }
        }
    }

    @Override
    public ClassLoader getClassLoader() {
        return classLoader;
    }
    /**
     * Return a Resource handle for the resource at the given path.
     * <p>The default implementation supports class path locations. This should
     * be appropriate for standalone implementations but can be overridden,
     * e.g. for implementations targeted at a Servlet container.
     * @param path the path to the resource
     * @return the corresponding Resource handle
     * @see ClassPathResource
     * @see org.springframework.context.support.FileSystemXmlApplicationContext#getResourceByPath
     * @see org.springframework.web.context.support.XmlWebApplicationContext#getResourceByPath
     */
    protected Resource getResourceByPath(String path) {
        return new ClassPathContextResource(path, getClassLoader());
    }

    /**
     * ClassPathResource that explicitly expresses a context-relative path
     * through implementing the ContextResource interface.
     */
    private static class ClassPathContextResource extends ClassPathResource implements ContextResource {

        public ClassPathContextResource(String path, ClassLoader classLoader) {
            super(path, classLoader);
        }

        public String getPathWithinContext() {
            return getPath();
        }

        public Resource createRelative(String relativePath) {
            String pathToUse = StringUtils.applyRelativePath(getPath(), relativePath);
            return new ClassPathContextResource(pathToUse, getClassLoader());
        }
    }
}
