package com.hz.yk.tdd;

import org.junit.Test;

import static com.hz.yk.tdd.BooleanOptionParserTest.option;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * @author wuzheng.yk
 * @date 2023/6/6
 */
public class SingleValuedOptionParserTest {


    @Test
    public void should_parse_int_option() {
        final Integer result = new SingleValueOptionParser<>(Integer::parseInt).parse(asList("-p", "8080"),
                                                                                      option("p"));
        assertEquals(8080, result.intValue());
    }

    @Test
    public void should_parse_String_option() {
        final String result = new SingleValueOptionParser<>(String::valueOf).parse(asList("-d", "/usr/logs"), option("d"));
        assertEquals("/usr/logs",result);
    }
}
