package com.hz.yk.doclet.support;

import java.io.Serializable;

/**
 * @author wuzheng.yk
 *         Date: 13-3-20
 *         Time: ����9:41
 */
public class ParameterInfo extends BaseInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    public static ParameterInfo create(String name,String comment,String type) {
        ParameterInfo info = new ParameterInfo();
        info.setName(name);
        info.setComment(comment);
        info.setType(type);

        return info;
    }

}
