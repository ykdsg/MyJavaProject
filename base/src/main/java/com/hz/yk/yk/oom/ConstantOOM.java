package com.hz.yk.yk.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * 静态变量或常量也会有可能撑爆方法区
 *
 * 同样加上JVM参数：-XX:PermSize=10M -XX:MaxPermSize=10M
 * @author wuzheng.yk
 *         Date: 13-2-20
 *         Time: 下午1:20
 */
public class ConstantOOM {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<String> list = new ArrayList<String>();
        int i=0;
        while(true){
            list.add(String.valueOf(i++).intern());
        }
    }

}
