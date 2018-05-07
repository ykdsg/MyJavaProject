package com.hz.yk.co.factory;

import java.text.DateFormat;
import java.util.Date;

/**
 * 负责打印时间
 * Created by wuzheng.yk on 2018/5/2.
 */
public class TimestampFactory implements Factory{
    private final DateFormat fmt;

    public TimestampFactory(DateFormat fmt) {
        this.fmt = fmt;
    }

    @Override
    public String create(){
        return fmt.format(new Date());
    }

}
