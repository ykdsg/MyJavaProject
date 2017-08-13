package com.hz.yk.proxy;

/**
 * Created by wuzheng.yk on 2017/8/10.
 */
public class CookImpl implements ICook {

    @Override
    public void dealWithFood() {
        System.out.println("food had been dealed with");
    }

    @Override
    public void cook() {
        System.out.println("cook food");
    }

}
