package com.hz.yk.cucumber.test.glue.common;

import com.hz.yk.cucumber.test.util.SpringBootApplicationConfig;
import cucumber.api.java.Before;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author wuzheng.yk
 * @date 2019-06-11
 */
@SpringBootTest(classes = { SpringBootApplicationConfig.class })
public class CucumberSpringContext {

    //这个必须要有，否则不会加载spring的配置
    @Before
    public void setup_cucumber_spring_context() {
        // Dummy method so cucumber will recognize this class as glue
        // and use its context configuration.
    }

}
