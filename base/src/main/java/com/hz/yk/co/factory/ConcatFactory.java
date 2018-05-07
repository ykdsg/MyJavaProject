package com.hz.yk.co.factory;

/**
 * Created by wuzheng.yk on 2018/5/2.
 */
public class ConcatFactory implements Factory{
    private final Factory[] fs;

    public ConcatFactory(Factory... fs) {
        this.fs = fs;
    }

    @Override
    public String create(){
        StringBuffer buf = new StringBuffer();
        for(Factory f: fs){
            buf.append(f.create());
        }
        return buf.toString();
    }

}
