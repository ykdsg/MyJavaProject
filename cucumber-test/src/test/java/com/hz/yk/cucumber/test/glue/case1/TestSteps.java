package com.hz.yk.cucumber.test.glue.case1;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

/**
 * @author wuzheng.yk
 * @date 2019-06-19
 */
public class TestSteps {

    @When("查询{long}-{string}")
    public void queryItem(long itemId, String itemName) {
        System.out.println(itemId);
    }

    @Then("检查{string}")
    public void checkName(String itemName) {
        System.out.println(itemName);
        Assert.assertNotNull(itemName);

    }

    @When("I add {int} and {int}")
    public void adding(int arg1, int arg2) {
        System.out.println(arg1);
        System.out.println(arg2);
    }

    @Given("the previous entries:")
    public void thePreviousEntries(List<Entry> entries) {
        System.out.println(entries.size());
    }

    static final class Entry {

        private Integer first;
        private Integer second;
        private String  operation;

        public Integer getFirst() {
            return first;
        }

        public void setFirst(Integer first) {
            this.first = first;
        }

        public Integer getSecond() {
            return second;
        }

        public void setSecond(Integer second) {
            this.second = second;
        }

        public String getOperation() {
            return operation;
        }

        public void setOperation(String operation) {
            this.operation = operation;
        }
    }

}
