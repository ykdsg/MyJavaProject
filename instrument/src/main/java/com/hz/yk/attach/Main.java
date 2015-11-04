package com.hz.yk.attach;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

/**
 * Created by wuzheng.yk on 15/11/4.
 */
public class Main {

    public static void main(String[] args) throws AttachNotSupportedException,
            IOException, AgentLoadException, AgentInitializationException {
        VirtualMachine vm = VirtualMachine.attach(args[0]);
        vm.loadAgent("/Users/ykdsg/my_workspace/MyJavaProject/out/artifacts/instrument_jar/instrument.jar");

    }
}
