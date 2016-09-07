package com.hz.yk.spring.core.io.support;

import com.hz.yk.spring.core.io.Resource;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

/**
 * ����Ϊresource �����һ��encode
 * @author wuzheng.yk
 *         Date: 13-2-8
 *         Time: ����11:09
 */
public class EncodedResource {
    private final Resource resource;

    private final String encoding;


    /**
     * Create a new EncodedResource for the given Resource,
     * not specifying a specific encoding.
     * @param resource the Resource to hold
     */
    public EncodedResource(Resource resource) {
        this(resource, null);
    }

    /**
     * Create a new EncodedResource for the given Resource,
     * using the specified encoding.
     * @param resource the Resource to hold
     * @param encoding the encoding to use for reading from the resource
     */
    public EncodedResource(Resource resource, String encoding) {
        Assert.notNull(resource, "Resource must not be null");
        this.resource = resource;
        this.encoding = encoding;
    }


    /**
     * Return the Resource held.
     */
    public final Resource getResource() {
        return this.resource;
    }

    /**
     * Return the encoding to use for reading from the resource,
     * or <code>null</code> if none specified.
     */
    public final String getEncoding() {
        return this.encoding;
    }

    /**
     * Open a <code>java.io.Reader</code> for the specified resource,
     * using the specified encoding (if any).
     * @throws java.io.IOException if opening the Reader failed
     */
    public Reader getReader() throws IOException {
        if (this.encoding != null) {
            return new InputStreamReader(this.resource.getInputStream(), this.encoding);
        }
        else {
            return new InputStreamReader(this.resource.getInputStream());
        }
    }


    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof EncodedResource) {
            EncodedResource otherRes = (EncodedResource) obj;
            return (this.resource.equals(otherRes.resource) &&
                    ObjectUtils.nullSafeEquals(this.encoding, otherRes.encoding));
        }
        return false;
    }

    public int hashCode() {
        return this.resource.hashCode();
    }

    public String toString() {
        return this.resource.toString();
    }
}
