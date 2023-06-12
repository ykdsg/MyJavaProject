package com.hz.yk.tdd;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
    public void should_set_boolean_option_to_true_if_flag_present() {
        final Boolean result = new BooleanOptionParser().parse(asList("-l"), option("l"));
        assertTrue(result);
    }

    @Test
    public void should_set_boolean_option_to_false_if_flag_not_present() {
        final Boolean result = new BooleanOptionParser().parse(asList(), option("l"));
        assertFalse(result);
    }
    
    @Test //Sad Path
    public void should_not_accept_extra_argument_for_boolean_option() {
        TooManyArgumentsException e = assertThrows(TooManyArgumentsException.class, () -> {
            new BooleanOptionParser().parse(asList("-l", "t","f"), option("l"));
        });
    }

    @Test //Dafault Value
    public void should_set_default_value_to_false_if_option_not_present() {
        Boolean result = new BooleanOptionParser().parse(asList(), option("l"));
        assertFalse(result );
    }


    @Test  //Happy Path
    public void should_set_value_to_true_if_option_present() {
        Boolean result = new BooleanOptionParser().parse(asList("-l"), option("l"));
        assertTrue(result);
    }
    
    public  static Option option(String vaule) {
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
