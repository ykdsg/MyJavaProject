package com.hz.yk.function;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by wuzheng.yk on 2018/1/30.
 */
public class FunctionMain {

    public static void main(String[] args) {
        List<Gauge> gaugeList = Lists.newArrayList();

        for (int i = 0; i < 10; i++) {
            Data data = new Data(i);
            //函数式接口的强转
            gaugeList.add((Gauge<Long>) data::getValue);
        }

        for (Gauge gauge : gaugeList) {
            System.out.println(gauge.getValue());
        }
    }

}
