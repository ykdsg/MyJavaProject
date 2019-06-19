package com.hz.yk.cucumber.test.glue;

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

        private final Integer first;
        private final Integer second;
        private final String  operation;

        Entry(Integer first, Integer second, String operation) {
            this.first = first;
            this.second = second;
            this.operation = operation;
        }
    }

    public class MoneyConverter extends Transformer<Money> 

    {

        @Override

        public Money transform(String amount) {

        String[] numbers = amount.split("\\.");

        int dollars = Integer.parseInt(numbers[0]);

        int cents = Integer.parseInt(numbers[1]);

        return new Money(dollars, cents);

    }
    」
    }
