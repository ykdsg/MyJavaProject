package com.hz.yk.guice;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * https://zhuanlan.zhihu.com/p/32299568
 *
 * @author wuzheng.yk
 * @date 2020/8/27
 */
@Singleton
public class SampleMain {

    @Inject
    private IHelloPrinter printer;

    @Inject
    @Named("simple")
    private IHelloPrinter simplePrinter;
    @Inject
    @Named("complex")
    private IHelloPrinter complexPrinter;

    @Inject
    private ILog log;

    public void hello() {
        int i = ILog.age;
        printer.print();
        simplePrinter.print();
        complexPrinter.print();
        log.log("success");
    }

    public static void main(String[] args) {
        //使用Guice创建了一个注射器Injector，然后从Injector拿到你想要的对象就可以了，Guice会自动装配依赖树
        Injector injector = Guice.createInjector(new SampleModule());
        SampleMain sample = injector.getInstance(SampleMain.class);
        sample.hello();
    }

}
