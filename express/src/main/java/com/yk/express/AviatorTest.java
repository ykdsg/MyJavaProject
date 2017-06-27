package com.yk.express;

import com.googlecode.aviator.AviatorEvaluator;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wuzheng.yk on 2017/6/27.
 */
public class AviatorTest {

    @Test
    public void test() {
        int permitType = 1;
        int orientedCode = 1;

        Map<String, Object> env = new HashMap<String, Object>();
        env.put("permitType", permitType);
        env.put("orientedCode", orientedCode);

        Object result = AviatorEvaluator.execute("permitType==1",env);
        System.out.println(result);
    }

}
