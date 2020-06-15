package com.hz.yk;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuzheng.yk
 * @date 2018/7/17
 */
public class Main2 {

    private static final Logger log = LoggerFactory.getLogger(Main2.class);

    private static <T> List<List<T>> split(List<T> orignList, int divide) {
        if (orignList.size() <= divide)
            divide = orignList.size();
        int k = orignList.size() / divide;
        List<List<T>> res = new ArrayList<>();
        for (int i = 0; i < divide; i++) {
            List<T> lice0 = new ArrayList<>();
            if (i == divide - 1) {
                for (int j = i * k; j < orignList.size(); j++) {
                    lice0.add(orignList.get(j));
                }
                res.add(lice0);
            } else {
                List<T> lice1 = new ArrayList<>();
                for (int m = i * k; m < (i + 1) * k; m++) {
                    lice1.add(orignList.get(m));
                }
                res.add(lice1);
            }
        }
        return res;
    }

    /**
     * 异常日志输出测试，看看error msg 会不会丢失，实际会在caused by中显示
     *
     * @param args
     */
    public static void main(String[] args) {
        List<String> testList = Lists.newArrayList("A", "B", "c", "d");
        List split = split(testList, 3);
        System.out.println(split);
    }

}
