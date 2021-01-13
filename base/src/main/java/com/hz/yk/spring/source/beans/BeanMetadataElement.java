package com.hz.yk.spring.source.beans;

/**
 * @author wuzheng.yk
 * Date: 13-2-11
 * Time: ����11:33
 */
public interface BeanMetadataElement {

    /**
     * Return the configuration source <code>Object</code> for this metadata element
     * (may be <code>null</code>).
     */
    Object getSource();
}
