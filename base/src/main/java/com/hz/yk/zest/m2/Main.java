package com.hz.yk.zest.m2;

import org.qi4j.bootstrap.AssemblyException;
import org.qi4j.bootstrap.ModuleAssembly;
import org.qi4j.bootstrap.SingletonAssembler;

/**
 * Created by wuzheng.yk on 16/12/1.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        // The SingletonAssembler is a convenience class that creates a Zest™ Runtime instance and an application with
        // one layer and one module in it.
        SingletonAssembler assembler = new SingletonAssembler() // <1>
        {

            @Override
            public void assemble(ModuleAssembly assembly) throws AssemblyException {
                assembly.transients(Speaker.class); // We declare a TransientComposite of type Speaker.
            }
        };
        Speaker speaker = assembler.module().newTransient(Speaker.class); // We create the Composite instance from the Module.
        System.out.println(speaker.sayHello());
    }
}
