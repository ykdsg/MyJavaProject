package com.hz.yk.yk.doclet.support;

import java.io.Serializable;

/**
 * @author wuzheng.yk
 *         Date: 13-3-20
 *         Time: ионГ9:40
 */
public class FieldInfo extends BaseInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    public static FieldInfo create(String name,String comment,Object type) {

        FieldInfo info = new FieldInfo();
        info.setName(name);
        info.setComment(comment);
        info.setType(type);

        return info;
    }
}
