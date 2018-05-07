package com.hz.yk.co.factory;

/**
 * 负责打印当前行号等源代码相关信息
 * Created by wuzheng.yk on 2018/5/2.
 */
public class TraceBackFactory implements Factory{
    private final SourceLocationFormat fmt;

    public TraceBackFactory(SourceLocationFormat fmt) {
        this.fmt = fmt;
    }

    @Override
    public String create(){
        final StackTraceElement frame = getNearestUserFrame();
        if(frame!=null) {
            return fmt.format(frame);
        } else {
            return null;
        }
    }
    private StackTraceElement getNearestUserFrame(){
        final StackTraceElement[] frames = new Throwable().getStackTrace();
        for(StackTraceElement frame: frames){
            if(!frame.getClassName().startsWith("org.mylogging")){
                //user frame
                return frame;
            }
        }
        return null;
    }

}
