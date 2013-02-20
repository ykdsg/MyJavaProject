package com.hz.yk.spring.core.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

/**
 * @author wuzheng.yk
 *         Date: 13-2-17
 *         Time: ÏÂÎç9:55
 */
public class ClassPathResource extends AbstractResource{

    private final String path;

    private ClassLoader classLoader;

    private Class clazz;


    /**
     * Return the path for this resource (as resource path within the class path).
     */
    public final String getPath() {
        return this.path;
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    /**
     * Create a new ClassPathResource for ClassLoader usage.
     * A leading slash will be removed, as the ClassLoader
     * resource access methods will not accept it.
     * <p>The thread context class loader will be used for
     * loading the resource.
     * @param path the absolute path within the class path
     * @see java.lang.ClassLoader#getResourceAsStream(String)
     * @see org.springframework.util.ClassUtils#getDefaultClassLoader()
     */
    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    /**
     * Create a new ClassPathResource for ClassLoader usage.
     * A leading slash will be removed, as the ClassLoader
     * resource access methods will not accept it.
     * @param path the absolute path within the classpath
     * @param classLoader the class loader to load the resource with,
     * or <code>null</code> for the thread context class loader
     * @see java.lang.ClassLoader#getResourceAsStream(String)
     */
    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        String pathToUse = StringUtils.cleanPath(path);
        if (pathToUse.startsWith("/")) {
            pathToUse = pathToUse.substring(1);
        }
        this.path = pathToUse;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
    }

    /**
     * Create a new ClassPathResource for Class usage.
     * The path can be relative to the given class,
     * or absolute within the classpath via a leading slash.
     * @param path relative or absolute path within the class path
     * @param clazz the class to load resources with
     * @see java.lang.Class#getResourceAsStream
     */
    public ClassPathResource(String path, Class clazz) {
        Assert.notNull(path, "Path must not be null");
        this.path = StringUtils.cleanPath(path);
        this.clazz = clazz;
    }

    /**
     * Create a new ClassPathResource with optional ClassLoader and Class.
     * Only for internal usage.
     * @param path relative or absolute path within the classpath
     * @param classLoader the class loader to load the resource with, if any
     * @param clazz the class to load resources with, if any
     */
    protected ClassPathResource(String path, ClassLoader classLoader, Class clazz) {
        this.path = StringUtils.cleanPath(path);
        this.classLoader = classLoader;
        this.clazz = clazz;
    }
    @Override
    public String getDescription() {
        return "class path resource [" + this.path + "]";
    }

    /**
     * This implementation opens an InputStream for the given class path resource.
     * @see java.lang.ClassLoader#getResourceAsStream(String)
     * @see java.lang.Class#getResourceAsStream(String)
     */
    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = null;
        if (this.clazz != null) {
            is = this.clazz.getResourceAsStream(this.path);
        }
        else {
            is = this.classLoader.getResourceAsStream(this.path);
        }
        if (is == null) {
            throw new FileNotFoundException(
                    getDescription() + " cannot be opened because it does not exist");
        }
        return is;
    }



    /**
     * This implementation returns a URL for the underlying class path resource.
     * @see java.lang.ClassLoader#getResource(String)
     * @see java.lang.Class#getResource(String)
     */
    public URL getURL() throws IOException {
        URL url = null;
        if (this.clazz != null) {
            url = this.clazz.getResource(this.path);
        }
        else {
            url = this.classLoader.getResource(this.path);
        }
        if (url == null) {
            throw new FileNotFoundException(
                    getDescription() + " cannot be resolved to URL because it does not exist");
        }
        return url;
    }

    /**
     * This implementation returns a File reference for the underlying class path
     * resource, provided that it refers to a file in the file system.
     * @see org.springframework.util.ResourceUtils#getFile(java.net.URL, String)
     */
    public File getFile() throws IOException {
        return ResourceUtils.getFile(getURL(), getDescription());
    }

    /**
     * This implementation determines the underlying File
     * (or jar file, in case of a resource in a jar/zip).
     */
    protected File getFileForLastModifiedCheck() throws IOException {
        URL url = getURL();
        if (ResourceUtils.isJarURL(url)) {
            URL actualUrl = ResourceUtils.extractJarFileURL(url);
            return ResourceUtils.getFile(actualUrl);
        }
        else {
            return ResourceUtils.getFile(url, getDescription());
        }
    }

    /**
     * This implementation creates a ClassPathResource, applying the given path
     * relative to the path of the underlying resource of this descriptor.
     * @see org.springframework.util.StringUtils#applyRelativePath(String, String)
     */
    public Resource createRelative(String relativePath) {
        String pathToUse = StringUtils.applyRelativePath(this.path, relativePath);
        return new ClassPathResource(pathToUse, this.classLoader, this.clazz);
    }

    /**
     * This implementation returns the name of the file that this class path
     * resource refers to.
     * @see org.springframework.util.StringUtils#getFilename(String)
     */
    public String getFilename() {
        return StringUtils.getFilename(this.path);
    }



    /**
     * This implementation compares the underlying class path locations.
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ClassPathResource) {
            ClassPathResource otherRes = (ClassPathResource) obj;
            return (this.path.equals(otherRes.path) &&
                    ObjectUtils.nullSafeEquals(this.classLoader, otherRes.classLoader) &&
                    ObjectUtils.nullSafeEquals(this.clazz, otherRes.clazz));
        }
        return false;
    }

    /**
     * This implementation returns the hash code of the underlying
     * class path location.
     */
    public int hashCode() {
        return this.path.hashCode();
    }
}
