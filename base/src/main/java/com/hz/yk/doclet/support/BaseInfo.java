package com.hz.yk.doclet.support;

import java.io.Serializable;

/**
 * @author wuzheng.yk
 *         Date: 13-3-20
 *         Time: ����9:38
 */
public class BaseInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String comment;
    private Object type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }
}
