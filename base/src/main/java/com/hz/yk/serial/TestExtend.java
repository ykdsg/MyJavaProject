package com.hz.yk.serial;

import java.io.ObjectStreamClass;

/**
 * 能够看到继承不能解决SerialVersionUID 的问题，son跟parent 的uid 不同，Son 中增加字段之后，uid也会发生变化
 *
 * @author wuzheng.yk
 * @date 2022/3/21
 */
public class TestExtend {

    public static void main(String[] args) {
        final ObjectStreamClass sonInputStream = ObjectStreamClass.lookup(Son.class);
        final long sonId = sonInputStream.getSerialVersionUID();

        final ObjectStreamClass parentInputStream = ObjectStreamClass.lookup(Parent.class);
        final long parentId = parentInputStream.getSerialVersionUID();

        System.out.println("son:" + sonId);
        System.out.println("parent:" + parentId);
    }
}
