package com.hz.yk.spring.source.core.io;

import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author yangke
 * Date: 13-8-16
 * Time: ����7:40
 */
public class ClassPathResource extends AbstractResource {

    private String path;
    private ClassLoader classLoader;
    private Class clazz;

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        String pathToUse = StringUtils.cleanPath(path);
        if (pathToUse.startsWith("/")) {
            pathToUse = pathToUse.substring(1);
        }
        this.path = pathToUse;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
    }

    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    @Override
    public String getDescription() {
        return "class path resource [" + this.path + "]";
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = null;
        if (this.clazz != null) {
            is = this.clazz.getResourceAsStream(this.path);
        } else {
            is = this.classLoader.getResourceAsStream(this.path);
        }
        if (is == null) {
            throw new FileNotFoundException(getDescription() + " cannot be opened because it does not exist");
        }
        return is;
    }

    public URL getURL() throws IOException {
        URL url = null;
        if (this.clazz != null) {
            url = this.clazz.getResource(this.path);
        } else {
            url = this.classLoader.getResource(this.path);
        }
        if (url == null) {
            throw new FileNotFoundException(getDescription() + " cannot be resolved to URL because it does not exist");
        }
        return url;
    }

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
        } else {
            return ResourceUtils.getFile(url, getDescription());
        }
    }

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
            return (this.path.equals(otherRes.path) && ObjectUtils
                    .nullSafeEquals(this.classLoader, otherRes.classLoader) && ObjectUtils
                            .nullSafeEquals(this.clazz, otherRes.clazz));
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
