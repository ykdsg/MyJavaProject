package com.hz.yk.stack;

/**
 * Created by wuzheng.yk on 15/12/23.
 */
public class T2 {
    public void t2Method(){
        getCaller();
    }
    public  void  getCaller(){
        StackTraceElement stack[] = Thread.currentThread().getStackTrace();
        for (StackTraceElement ste:stack){
            if((ste.getClassName().indexOf("T1"))!=-1){
                System.out.println("called by "+ste.getClassName()+"."+ste.getMethodName()+"/"+ste.getFileName());
            }
        }
    }
}
