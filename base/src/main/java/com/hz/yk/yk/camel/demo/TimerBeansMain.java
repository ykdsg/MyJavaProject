package com.hz.yk.yk.camel.demo;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 如果你不想像TimerMain一样过多的处理主类设置代码，那么你可以简单地继承由camel-core提供的org.apache.camel.main.Main类作为代替。通过利用这个类，
 * 你不仅可以让你的context自动设置，还可以获得所有附加的命令行特性，比如控制进程运行多久，启用追踪，加载自定义route类等等。
 * Created by wuzheng.yk on 15/11/2.
 */
public class TimerBeansMain extends Main {
    static Logger LOG = LoggerFactory.getLogger(TimerBeansMain.class);
    public static void main(String[] args) throws Exception {
        TimerBeansMain main = new TimerBeansMain();
        main.enableHangupSupport();
        main.bind("processByBean1", new Bean1());
        main.bind("processAgainByBean2", new Bean2());
        main.addRouteBuilder(createRouteBuilder());
        main.run(args);
    }
    static RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            public void configure() {
                from("timer://timer1?period=1000")
                        .to("bean:processByBean1")
                        .to("bean:processAgainByBean2");
            }
        };
    }

    // Processor beans
    static class Bean1 implements Processor {
        public void process(Exchange msg) {
            LOG.info("First process {}", msg);
        }
    }
    static class Bean2 implements Processor {
        public void process(Exchange msg) {
            LOG.info("Second process {}", msg);
        }
    }
}
