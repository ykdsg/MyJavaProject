package com.hz.yk.tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.hz.yk.tdd.BooleanOptionParserTest.option;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author wuzheng.yk
 * @date 2023/6/6
 */
public class SingleValuedOptionParserTest {
    
    @Test
    public void should_not_accept_extra_argument_for_single_valued_option() {
        TooManyArgumentsException e = assertThrows(TooManyArgumentsException.class, () -> {
            new SingleValueOptionParser<>(Integer::parseInt).parse(asList("-p", "8080","8081"), option("p"));
        });
        
        assertEquals("p",e.getOption());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-p -l","-p"})
    public void should_not_accept_insufficient_argument_for_single_valued_option(String arguments) {
        InsufficientArgumentsException e = assertThrows(InsufficientArgumentsException.class, () -> {
            new SingleValueOptionParser<>(Integer::parseInt).parse(asList(arguments.split(" ")), option("p"));
        });
        
        assertEquals("p",e.getOption());
    }
    

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
