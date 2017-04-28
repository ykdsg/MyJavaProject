package com.yk.express;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * aviator最快，QlExpress其次，groovy 最慢，慢好多个数量级。QlExpress支持更多语法，优先选择
 * Created by wuzheng.yk on 17/4/7.
 */
public class TestExpress {
    public static final String YOUR_NAME = "yourName";
    String expression = " 'hello' == yourName || 'world'== yourName || 'jack'== yourName";

    final String name1 = "hello";
    final String name2 = "world";
    final String name3 = "ahahahahh";


    @Test
    public void testAviator() {
        long start =new Date().getTime();
        Map<String, Object> env = new HashMap<String, Object>();
        // 编译表达式
        Expression compiledExp =AviatorEvaluator.compile(expression);

        for (int i = 0; i < 100000; i++) {
            env.put(YOUR_NAME, name1);
            System.out.println(i+"name1="+compiledExp.execute(env));
            env.put(YOUR_NAME, name2);
            System.out.println(i + "name2=" + compiledExp.execute(env));
            env.put(YOUR_NAME, name3);
            System.out.println(i + "name3=" + compiledExp.execute(env));
        }
        System.out.println("aviator cost=" + (new Date().getTime() - start));
    }

    @Test
    public void testQlExpress() throws Exception {
        long start =new Date().getTime();
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        for (int i = 0; i < 100000; i++) {
            context.put(YOUR_NAME, name1);
            System.out.println(i + "name1=" + runner.execute(expression, context, null, true, false));

            context.put(YOUR_NAME, name2);
            System.out.println(i + "name2=" + runner.execute(expression, context, null, true, false));
            context.put(YOUR_NAME, name3);
            System.out.println(i + "name3=" + runner.execute(expression, context, null, true, false));
        }
        System.out.println("qlExpress cost=" + (new Date().getTime() - start));
    }

    @Test
    public void testGroovy() {
        long start =new Date().getTime();
        Binding binding = new Binding();
        GroovyShell shell = new GroovyShell(binding);
        Script script = shell.parse(expression);
        for (int i = 0; i < 100000; i++) {
            binding.setVariable(YOUR_NAME, name1);
            System.out.println(script.evaluate(expression));
            binding.setVariable(YOUR_NAME, name2);
            System.out.println(script.evaluate(expression));

            binding.setVariable(YOUR_NAME, name3);
            System.out.println(script.evaluate(expression));
        }
        System.out.println("qlExpress cost=" + (new Date().getTime() - start));
    }

}
