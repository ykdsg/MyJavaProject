package com.hz.yk.instrument;

import java.lang.instrument.Instrumentation;

/**
 * Created by wuzheng.yk on 15/11/4.
 */
public class LoadedAgent {
    @SuppressWarnings("rawtypes")
    public static void agentmain(String args, Instrumentation inst){
        Class[] classes = inst.getAllLoadedClasses();
        for(Class cls :classes){
            System.out.println(cls.getName());
        }
    }
}
