package com.hz.yk.zest.m10;

import org.qi4j.api.activation.ActivationException;
import org.qi4j.api.property.Property;
import org.qi4j.bootstrap.AssemblyException;
import org.qi4j.bootstrap.ModuleAssembly;
import org.qi4j.bootstrap.SingletonAssembler;

/**
 * Created by wuzheng.yk on 16/12/17.
 */
public class Main {

    public static void main(String[] args) throws ActivationException, AssemblyException {
        SingletonAssembler assembler = new SingletonAssembler() // <1>
        {
            @Override
            public void assemble(ModuleAssembly assembly) throws AssemblyException {
                assembly.transients(OrderEntity.class); // We declare a TransientComposite of type Speaker.
            }
        };
        //从模块中创建组合实例
        OrderEntity orderEntity = assembler.module().newTransient(OrderEntity.class); // We create the Composite instance from the Module.
        LineItem item = new LineItem() {
            @Override
            public Property<String> name() {
                return null;
            }

            @Override
            public Property<String> productCode() {
                return null;
            }

            @Override
            public Property<Integer> quantity() {
                return null;
            }
        };
        orderEntity.addLineItem(item);

    }
}
