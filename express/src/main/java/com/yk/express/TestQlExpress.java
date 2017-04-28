package com.yk.express;

import org.junit.Assert;
import org.junit.Test;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;

/**
 * Created by wuzheng.yk on 17/4/12.
 */
public class TestQlExpress {

    @Test
    public void testIn() throws Exception {
        String express = "a in ['1','2','3']";
        ExpressRunner runner = new ExpressRunner(false,true);
        DefaultContext<String, Object> context = new DefaultContext<String, Object>();
        context.put("a","1");

        Object r = runner.execute(express, context, null, true, true);
        System.out.println(r);

        String express2 = "a in [1,2,3]";
        context.put("a",1);
        r = runner.execute(express2, context, null, true, false);
        System.out.println(r);

    }

    @Test
    public void testDemo() throws Exception{
        String express = "10 * 10 + 1 + 2 * 3 + 5 * 2";
        ExpressRunner runner = new ExpressRunner(false,true); // 显示执行编译过程
        Object r = runner.execute(express,null, null, false,true); // 显示指令执行过程
        Assert.assertTrue("表达式计算", r.toString().equalsIgnoreCase("117"));
        System.out.println("表达式计算：" + express + " = " + r);
    }

}
