package com.hz.yk;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        String str="ab06e715bea9f99c0abcd3d3ac9a161401e8507448c3da0d17c455890551e2fe";
//        String s="hello";
//        s=null;
//        testNotNull(null,null,null);
//        System.out.println(str.hashCode());

        Runtime runtime = Runtime.getRuntime();
        //显示java虚拟机可用的处理器个数
        int nrOfProcessors = runtime.availableProcessors();
        System.out.println("Number of processors available to the Java Virtual Machine: " + nrOfProcessors);


        List testList = Arrays.asList("A B C D E F G H I J K L".split(" "));
        testList.add("M");

        System.out.println(testList);

    }

    static void testNotNull(Map from,String s, Long l) {
        checkNotNull(s, "firstName");
        checkNotNull(l, "firstName");
        System.out.println(from.get("s"));

    }
}
