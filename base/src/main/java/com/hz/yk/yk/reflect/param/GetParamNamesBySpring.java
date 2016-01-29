package com.hz.yk.yk.reflect.param;

import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

import java.lang.reflect.Method;

/**
 * Created by wuzheng.yk on 16/1/29.
 */
public class GetParamNamesBySpring {
    public static void main(String[] args) {
        LocalVariableTableParameterNameDiscoverer u =
                new LocalVariableTableParameterNameDiscoverer();
        Demo demo = new Demo();
        Method[] methods = demo.getClass().getDeclaredMethods();
        String[] params = u.getParameterNames(methods[0]);
        for (int i = 0; i < params.length; i++) {
            System.out.println(params[i]);
        }
    }
}
