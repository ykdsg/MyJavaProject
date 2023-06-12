package com.hz.yk.junit;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

/**
 * Created by wuzheng.yk on 2018/4/26.
 */
public class CoreJUnit4SampleTest {
    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass() method executed.");
        System.out.println();
    }
    @BeforeClass
    public static void beforeClass2() {
        System.out.println("beforeClass2() method executed.");
        System.out.println();
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass() method executed.");
        System.out.println();
    }
    @Before
    public void before() {
        System.out.println("before() method executed.");
    }
    @After
    public void after() {
        System.out.println("after() method executed");
    }
    @Test
    public void testSucceeded() {
        System.out.println("testSucceeded() method executed.");
    }
    @Test
    @Ignore
    public void testIgnore() {
        System.out.println("testIgnore() method executed.");
    }
    @Test
    public void testFailed() {
        System.out.println("testFailed() method executed.");
        throw new RuntimeException("Throw delibrately");
    }
    @Test
    public void testAssumptionFailed() {
        System.out.println("testAssumptionFailed() method executed.");
        Assume.assumeThat(0, Is.is(1));
    }
    @Test
    public void testFilteredOut() {
        System.out.println("testFilteredOut() method executed.");
    }
}
