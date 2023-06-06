package com.hz.yk.tdd;

import org.junit.Test;

import java.lang.annotation.Annotation;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author wuzheng.yk
 * @date 2023/6/6
 */
public class BooleanOptionParserTest {
    //sad path:
    //    -bool -l t
    //default:
    // - bool: false

    @Test
    public void should_not_accept_extra_argument_for_boolean_option() {
        TooManyArgumentsException e = assertThrows(TooManyArgumentsException.class, () -> {
            new BooleanOptionParser().parse(asList("-l", "t","f"), option("l"));
        });
    }

    @Test
    public void should_set_default_value_to_false_if_option_not_present() {
        Boolean result = new BooleanOptionParser().parse(asList(), option("l"));
        assert result == false;
    }
    
    static Option option(String vaule) {
        return new Option() {

            @Override
            public Class<? extends Annotation> annotationType() {
                return Option.class;
            }

            @Override
            public String value() {
                return vaule;
            }
        };
    }

}
