package com.hz.yk.yk.spring.core.io;

import org.springframework.core.io.InputStreamSource;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

/**
 * @author wuzheng.yk
 *         Date: 13-2-8
 *         Time: ÏÂÎç10:35
 */
public interface Resource extends InputStreamSource {
    /**
     * Return whether this resource actually exists in physical form.
     * <p>This method performs a definitive existence check, whereas the
     * existence of a <code>Resource</code> handle only guarantees a
     * valid descriptor handle.
     */
    boolean exists();


    /**
     * Return a URL handle for this resource.
     *
     * @throws java.io.IOException if the resource cannot be resolved as URL,
     *                             i.e. if the resource is not available as descriptor
     */
    URL getURL() throws IOException;

    /**
     * Return a URI handle for this resource.
     *
     * @throws IOException if the resource cannot be resolved as URI,
     *                     i.e. if the resource is not available as descriptor
     */
    URI getURI() throws IOException;

    /**
     * Return a File handle for this resource.
     *
     * @throws IOException if the resource cannot be resolved as absolute
     *                     file path, i.e. if the resource is not available in a file system
     */
    File getFile() throws IOException;


    /**
     * Return a description for this resource,
     * to be used for error output when working with the resource.
     * <p>Implementations are also encouraged to return this value
     * from their <code>toString</code> method.
     *
     * @see java.lang.Object#toString()
     */
    String getDescription();

    /**
     * Return whether this resource represents a handle with an open
     * stream. If true, the InputStream cannot be read multiple times,
     * and must be read and closed to avoid resource leaks.
     * <p>Will be <code>false</code> for typical resource descriptors.
     */
    boolean isOpen();

}
