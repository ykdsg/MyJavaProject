package com.yk.express;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * aviator最快，QlExpress其次，groovy 最慢，慢好多个数量级。QlExpress支持更多语法，优先选择
 * Created by wuzheng.yk on 17/4/7.
 */
public class TestExpress {
    public static final String YOUR_NAME = "yourName";
    public static final int TIMES = 1000000;
    String expression = " 'hello' == yourName || 'world'== yourName || 'jack'== yourName";

    String groovyText = "def check(yourName) { 'hello' == yourName || 'world'== yourName || 'jack'== yourName }";

    final String name1 = "hello";
    final String name2 = "world";
    final String name3 = "ahahahahh";


    @Test
    public void testAviator() {
        long start =new Date().getTime();
        Map<String, Object> env = new HashMap<String, Object>();
        // 编译表达式
        Expression compiledExp =AviatorEvaluator.compile(expression);

        for (int i = 0; i < TIMES; i++) {
            AviatorEvaluator.exec(expression, name1);
            //env.put(YOUR_NAME, name1);
            //compiledExp.execute(env);

            //System.out.println(i+"name1="+compiledExp.execute(env));
            AviatorEvaluator.exec(expression, name2);
            //env.put(YOUR_NAME, name2);
            //compiledExp.execute(env);
            //System.out.println(i + "name2=" + compiledExp.execute(env));

            AviatorEvaluator.exec(expression, name3);
            //env.put(YOUR_NAME, name3);
            //compiledExp.execute(env);
            //System.out.println(i + "name3=" + compiledExp.execute(env));
        }
        System.out.println("aviator cost=" + (new Date().getTime() - start));
    }

    @Test
    public void testQlExpress() throws Exception {
        long start =new Date().getTime();
        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        for (int i = 0; i < TIMES; i++) {
            context.put(YOUR_NAME, name1);
            runner.execute(expression, context, null, true, false);

            //System.out.println(i + "name1=" + runner.execute(expression, context, null, true, false));

            context.put(YOUR_NAME, name2);
            runner.execute(expression, context, null, true, false);
            //System.out.println(i + "name2=" + runner.execute(expression, context, null, true, false));
            context.put(YOUR_NAME, name3);
            runner.execute(expression, context, null, true, false);
            //System.out.println(i + "name3=" + runner.execute(expression, context, null, true, false));
        }
        System.out.println("qlExpress cost=" + (new Date().getTime() - start));
    }

    @Test
    public void testGroovyShell() {
        long start =new Date().getTime();
        Binding binding = new Binding();
        GroovyShell shell = new GroovyShell(binding);
        //Script script = shell.parse(expression);
        for (int i = 0; i < TIMES; i++) {
            binding.setVariable(YOUR_NAME, name1);
            shell.evaluate(expression);

            //System.out.println(script.evaluate(expression));
            binding.setVariable(YOUR_NAME, name2);
            shell.evaluate(expression);


            //System.out.println(script.evaluate(expression));

            binding.setVariable(YOUR_NAME, name3);
            shell.evaluate(expression);

            //System.out.println(script.evaluate(expression));
        }
        System.out.println("groovy shell cost=" + (new Date().getTime() - start));
    }


    @Test
    public void testGroovyClassLoader() throws IOException, IllegalAccessException, InstantiationException {
        long start =new Date().getTime();
        GroovyClassLoader loader = new GroovyClassLoader(this.getClass().getClassLoader());
        Class<?> groovyClass = loader.parseClass(groovyText);

        //File groovyFile = new File("src/main/java/com/yk/express/GroovyCheck.groovy");
        //Class<?> groovyClass = loader.parseClass(groovyFile);
        // 获得GroovyShell_2的实例
        GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();

        for (int i = 0; i < TIMES; i++) {
            groovyObject.invokeMethod("check", name1);
            groovyObject.invokeMethod("check", name2);
            groovyObject.invokeMethod("check", name3);

            //System.out.println(groovyObject.invokeMethod("check", name1));
            //System.out.println(groovyObject.invokeMethod("check", name2));
            //System.out.println(groovyObject.invokeMethod("check", name3));
        }
        System.out.println("groovyClassLoader cost=" + (new Date().getTime() - start));

    }


    @Test
    public void testGroovyClassLoader2() throws IOException, IllegalAccessException, InstantiationException {
        long start =new Date().getTime();

        GroovyClassLoader loader = new GroovyClassLoader(this.getClass().getClassLoader());
        Class<?> groovyClass = loader.parseClass(expression);
        Object obj = groovyClass.newInstance();
        Script script = (Script) obj;
        Binding binding = new Binding();
        script.setBinding(binding);

        for (int i = 0; i < TIMES; i++) {
            binding.setVariable(YOUR_NAME, name1);
            script.run();
            binding.setVariable(YOUR_NAME, name2);
            script.run();
            binding.setVariable(YOUR_NAME, name3);
            script.run();
        }
        System.out.println("groovyClassLoader2 cost=" + (new Date().getTime() - start));

    }
}
