package com.hz.yk.jmx.model;

import javax.management.Descriptor;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanParameterInfo;
import javax.management.modelmbean.DescriptorSupport;
import javax.management.modelmbean.ModelMBeanAttributeInfo;
import javax.management.modelmbean.ModelMBeanInfo;
import javax.management.modelmbean.ModelMBeanInfoSupport;
import javax.management.modelmbean.ModelMBeanOperationInfo;
import javax.management.modelmbean.RequiredModelMBean;

/**
 * Model MBean也是一种专门化的动态管理构件。它是预制的、通用的和动态的 MBean 类，已经包含了所有必要缺省行为的实现，并允许在运行时添加或覆盖需要定制的那些实现
 * Created by wuzheng.yk on 2017/12/8.
 */
public class ModelMBeanUtils {

    private static final boolean READABLE     = true;
    private static final boolean WRITABLE     = true;
    private static final boolean BOOLEAN      = true;
    private static final String  STRING_CLASS = "java.lang.String";

    public static RequiredModelMBean createModelerMBean() {
        RequiredModelMBean model = null;
        try {
            model = new RequiredModelMBean();
            model.setManagedResource(new Hello(), "ObjectReference");
            ModelMBeanInfo info = createModelMBeanInfo();
            model.setModelMBeanInfo(info);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    private static ModelMBeanInfo createModelMBeanInfo() {
        //                        属性                                        //
        // 构造name属性信息
        Descriptor portAttrDesc = new DescriptorSupport();
        portAttrDesc.setField("name", "Name");
        portAttrDesc.setField("descriptorType", "attribute");
        portAttrDesc.setField("displayName", "Name");
        portAttrDesc.setField("getMethod", "getName");
        portAttrDesc.setField("setMethod", "setName");
        ModelMBeanAttributeInfo nameAttrInfo = new ModelMBeanAttributeInfo(//
                                                                           "Name", // 属性名
                                                                           STRING_CLASS, //属性类型
                                                                           "people name", // 描述文字
                                                                           READABLE, WRITABLE, !BOOLEAN, // 读写
                                                                           portAttrDesc // 属性描述
        );

        //                        方法                                        //
        // 构造 getName操作描述符信息
        Descriptor getStateDesc = new DescriptorSupport("name=getName", "descriptorType=operation",
                                                        "class=com.hz.yk.jmx.model.Hello", "role=operation");

        ModelMBeanOperationInfo getName = new ModelMBeanOperationInfo(//
                                                                      "getName", //
                                                                      "get name attribute", //
                                                                      null, //
                                                                      "java.lang.String", //
                                                                      MBeanOperationInfo.ACTION, //
                                                                      getStateDesc //
        );

        // 构造 setName操作描述符信息
        Descriptor setStateDesc = new DescriptorSupport("name=setName", "descriptorType=operation",
                                                        "class=com.hz.yk.jmx.model.Hello", "role=operation");

        MBeanParameterInfo[] setStateParms = new MBeanParameterInfo[] {
                (new MBeanParameterInfo("name", "java.lang.String", "new name value")) };

        ModelMBeanOperationInfo setName = new ModelMBeanOperationInfo(//
                                                                      "setName", //
                                                                      "set name attribute", //
                                                                      setStateParms, //
                                                                      "void", //
                                                                      MBeanOperationInfo.ACTION, //
                                                                      setStateDesc //
        );

        //构造 printHello()操作的信息
        ModelMBeanOperationInfo print1Info = new ModelMBeanOperationInfo(//
                                                                         "printHello", //
                                                                         null, //
                                                                         null, //
                                                                         "void", //
                                                                         MBeanOperationInfo.INFO, //
                                                                         null //
        );
        // 构造printHello(String whoName)操作信息
        ModelMBeanOperationInfo print2Info;
        MBeanParameterInfo[] param2 = new MBeanParameterInfo[]{ new MBeanParameterInfo("whoName", STRING_CLASS, "say hello to who")};
        print2Info = new ModelMBeanOperationInfo(//
                                                 "printHello", //
                                                 null,//
                                                 param2,//
                                                 "void", //
                                                 MBeanOperationInfo.INFO, //
                                                 null//
        );

        //                        最后总合                                    //
        // create ModelMBeanInfo
        ModelMBeanInfo mbeanInfo = new ModelMBeanInfoSupport(//
                                                             RequiredModelMBean.class.getName(), // MBean类
                                                             null, // 描述文字
                                                             new ModelMBeanAttributeInfo[] { // 所有的属性信息（数组）
                                                                                             nameAttrInfo },//只有一个属性
                                                             null, // 所有的构造函数信息
                                                             new ModelMBeanOperationInfo[] { // 所有的操作信息（数组）
                                                                                             getName, setName,
                                                                                             print1Info, print2Info },//
                                                             null, // 所有的通知信息(本例无)
                                                             null//MBean描述
        );
        return mbeanInfo;
    }
}
