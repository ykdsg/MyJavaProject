package com.yk.express;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 表达式错误提示自定义
     * @throws Exception
     */
    @Test
    public void testErrorInfo() throws Exception {
        String express = "100 < 99 and 100 <= 99 and 100 < 1 and 11 >  13";
        ExpressRunner runner = new ExpressRunner(false,true); // 显示执行编译过程
        //避免逻辑短路，因为要输出所有出错信息
        runner.setShortCircuit(false);
        runner.getOperatorFactory().getOperator("<").setErrorInfo("$1 没有小于 $2");
        runner.getOperatorFactory().getOperator("<=").setErrorInfo("$1 没有小等于 $2");
        runner.getOperatorFactory().getOperator(">").setErrorInfo("$1 没有大于 $2");

        List<String> errorList = new ArrayList<String>();

        boolean r = (boolean) runner.execute(express, null, errorList, false, true); // 显示指令执行过程
        Assert.assertFalse(r);
        System.out.println("表达式计算：" + express + " = " + r);
        errorList.forEach(eStr -> System.out.println(eStr));

    }
}
