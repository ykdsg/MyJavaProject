package com.hz.yk;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author wuzheng.yk
 *         Date: 14-9-1
 *         Time: обнГ10:20
 */
public class MainTest {

    @Before
    public void before(){
        System.out.println("before...");
    }

    @Test
    public void test(){
        Assert.assertTrue(true);
        Assert.assertTrue(false);

    }
}
