package com.hz.yk.my.spring.propertyeditor;

import java.beans.PropertyEditorSupport;

/**
 * @author wuzheng.yk
 * Date: 13-2-1
 * Time: ����11:42
 */
public class ExoticTypeEditor extends PropertyEditorSupport {

    private String format;

    public void setFormat(String format) {
        this.format = format;
    }

    public void setAsText(String text) {
        if (format != null && format.equals("upperCase")) {
            text = text.toUpperCase();
        }
        ExoticType type = new ExoticType(text);
        setValue(type);
    }
}
