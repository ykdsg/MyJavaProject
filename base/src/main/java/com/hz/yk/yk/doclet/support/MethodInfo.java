package com.hz.yk.yk.doclet.support;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wuzheng.yk
 *         Date: 13-3-20
 *         Time: ÉÏÎç9:40
 */
public class MethodInfo extends BaseInfo implements Serializable {


    private static final long serialVersionUID = 1L;

    private List<ParameterInfo> parameterInfos;

    public static MethodInfo create(String name, String comment, Object returnType) {

        MethodInfo info = new MethodInfo();
        info.setName(name);
        info.setComment(comment);
        info.setType(returnType);
        info.setParameterInfos(new ArrayList<ParameterInfo>());

        return info;
    }

    public MethodInfo addParameterInfo(ParameterInfo parameterInfo) {

        this.parameterInfos.add(parameterInfo);
        return this;
    }

    public ParameterInfo getParameterInfo(String name) {

        ParameterInfo result = null;

        for(ParameterInfo info : this.parameterInfos) {
            if(info.getName().equals(name)) {

                result = info;
                break;
            }
        }

        return result;

    }

    public List<ParameterInfo> getParameterInfos() {
        return parameterInfos;
    }

    public void setParameterInfos(List<ParameterInfo> parameterInfos) {
        this.parameterInfos = parameterInfos;
    }
}
