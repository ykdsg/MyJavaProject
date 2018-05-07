package com.hz.yk.co.factory;

/**
 * Created by wuzheng.yk on 2018/5/2.
 */
public class ReturnFactory implements Factory{
    private final String s;

    public ReturnFactory(String s) {
        this.s = s;
    }

    @Override
    public String create(){return s;}

}
