package com.hz.yk.cucumber.test.testcase;

import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;

/**
 * @author wuzheng.yk
 * @date 2019/9/2
 */
@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(Cucumber.class)
@PowerMockIgnore({ "javax.management.*", "javax.net.ssl.*", "javax.security.*" })
public class SpringTestCase {

    /**
     * 这个生命周期在spring之前，所以可以在spring 加载之前就mock好
     *
     * @throws NoSuchFieldException
     */
    @BeforeClass
    public static void beforeClass() throws NoSuchFieldException {

    }
}
