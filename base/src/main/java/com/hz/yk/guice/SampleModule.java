package com.hz.yk.guice;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 * @author wuzheng.yk
 * @date 2020/8/27
 */
public class SampleModule extends AbstractModule {

    /**
     * 可以使用Guice Module定义装配规则，它相当于Spring的XML文件，只不过它的装配规则都是使用代码定义的。
     * 其实Guice Module在一个大型项目中也是非常的简洁，一般只会占用几十行代码，Module里面配置的仅仅是特殊的专配规则。
     */
    @Override
    protected void configure() {
        bind(IHelloPrinter.class).to(HelloPrinter.class);
        bind(IHelloPrinter.class).annotatedWith(Names.named("simple")).to(SimpleHelloPrinter.class);
        bind(IHelloPrinter.class).annotatedWith(Names.named("complex")).to(ComplexHelloPrinter.class);
        bind(ILog.class).toProvider(LogProvider.class);
    }
}
