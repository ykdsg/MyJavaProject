package com.hz.yk.cucumber.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * @author wuzheng.yk
 * @date 2019-06-19
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = { "classpath:features/test.feature" }, plugin = { "pretty" }, strict = true, glue = {
        "com.hz.yk.cucumber.test.glue" })
public class DemoTest {

}
