package com.hz.yk.yk.spring.core.io;

/**
 * @author wuzheng.yk
 *         Date: 13-2-18
 *         Time: обнГ4:21
 */
public interface ContextResource extends Resource{

    /**
     * Return the path within the enclosing 'context'.
     * <p>This is typically path relative to a context-specific root directory,
     * e.g. a ServletContext root or a PortletContext root.
     */
    String getPathWithinContext();
}
