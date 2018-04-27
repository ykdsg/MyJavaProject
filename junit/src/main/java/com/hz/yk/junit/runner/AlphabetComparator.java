package com.hz.yk.junit.runner;

import org.junit.runner.Description;

import java.util.Comparator;

/**
 * 对于Sorter只实现了一个按字母序排列的Comparator，它会以参数形式传递给Sorter构造函数，以决定测试方法的顺序，Runner在运行之前调用sort()方法，以按指定的顺序排列测试方法
 * Created by wuzheng.yk on 2018/4/26.
 */
public class AlphabetComparator implements Comparator<Description> {

    @Override
    public int compare(Description desc1, Description desc2) {
        return desc1.getMethodName().compareTo(desc2.getMethodName());
    }

}
