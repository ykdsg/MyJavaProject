package com.hz.yk.instrument;

import com.hz.yk.attach.MonitorTest;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

/**
 * Created by wuzheng.yk on 15/11/4.
 */
public class MonitorAgent {

    public static void agentmain(String args, Instrumentation inst) throws UnmodifiableClassException {
        System.out.println("MonitorAgent agentmain attach...");
        for (Class clazz :inst.getAllLoadedClasses()){
            System.out.println(clazz.getName());
        }

        inst.addTransformer(new MonitorTransformer(),true);
        inst.retransformClasses(MonitorTest.class);
        System.out.println("MyAgentMain agentmain end...");
    }
}
