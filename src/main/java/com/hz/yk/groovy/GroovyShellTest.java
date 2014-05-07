package com.hz.yk.groovy;/**
 * @author wuzheng.yk
 * Date: 14-2-7
 * Time: 下午4:40
 */

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import java.math.BigDecimal;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * @author wuzheng.yk
 *         Date: 14-2-7
 *         Time: 下午4:40
 */
public class GroovyShellTest {

    @Test
    public void testCallStatement() {
        // 1.在Java代码中调用Groovy语句
        Binding binding = new Binding();
        binding.setVariable("price", new Integer(200));
        GroovyShell shell = new GroovyShell(binding);
        Object value = shell.evaluate("println 'Hello World!'; site = \"qiangpai\"; return price * 0.1");
        assertTrue(value.equals(new BigDecimal("20.0"))); // 出于最小惊讶原则,groovy默认小数类型为BigDecimal(通常用于银行中对钱的类型)
        assertTrue(binding.getVariable("site").equals("qiangpai"));
    }
}
