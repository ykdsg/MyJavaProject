package com.hz.yk.junit.runner;

import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;

import java.util.HashSet;
import java.util.Set;

/**
 * 在构造时指定要过滤掉的方法名，Runner在运行之前调用filter()方法，以过滤掉这些方法
 * Created by wuzheng.yk on 2018/4/26.
 */
public class MethodNameFilter extends Filter {
    private final Set<String> excludedMethods = new HashSet<String>();

    public MethodNameFilter(String... excludedMethods) {
        for(String method : excludedMethods) {
            this.excludedMethods.add(method);
        }
    }
    @Override
    public boolean shouldRun(Description description) {
        String methodName = description.getMethodName();
        if(excludedMethods.contains(methodName)) {
            return false;
        }
        return true;
    }
    @Override
    public String describe() {
        return this.getClass().getSimpleName() + "-excluded methods: " +
               excludedMethods;
    }
}
