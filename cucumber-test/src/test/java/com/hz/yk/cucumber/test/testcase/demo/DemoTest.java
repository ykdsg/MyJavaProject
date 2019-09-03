package com.hz.yk.cucumber.test.testcase.demo;

import com.hz.yk.cucumber.test.testcase.SpringTestCase;
import cucumber.api.CucumberOptions;

/**
 * @author wuzheng.yk
 * @date 2019/9/2
 */
@CucumberOptions(features = { "classpath:features/demo/demo.feature" }, plugin = { "pretty" }, strict = true, glue = {
        "com.hz.yk.cucumber.test.glue.common", "com.hz.yk.cucumber.test.glue.demo" })
public class DemoTest extends SpringTestCase {

}
