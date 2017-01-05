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
        //SingletonAssembler 是一个便利的class ，创建Zest 运行示例包含一个应用和一个层，一个模块
        SingletonAssembler assembler = new SingletonAssembler() // <1>
        {
            @Override
            public void assemble(ModuleAssembly assembly) throws AssemblyException {
                assembly.transients(Speaker.class); // We declare a TransientComposite of type Speaker.
            }
        };
        //从模块中创建组合实例
        Speaker speaker = assembler.module().newTransient(Speaker.class); // We create the Composite instance from the Module.
        System.out.println(speaker.sayHello());
    }
}
