package com.hz.yk.cucumber.test.util;

import cucumber.api.java.Before;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

/**
 * @author wuzheng.yk
 * @date 2019-07-01
 */
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@EnableCaching
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ImportResource(value = { "classpath*:spring-context-test.xml" })
@SpringBootConfiguration()
public class SpringBootApplicationConfig {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @org.junit.Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
}
