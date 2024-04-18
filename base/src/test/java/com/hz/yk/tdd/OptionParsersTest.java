package com.hz.yk.tdd;

import com.hz.yk.tdd.exception.IllegalValueException;
import com.hz.yk.tdd.exception.InsufficientArgumentsException;
import com.hz.yk.tdd.exception.TooManyArgumentsException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.annotation.Annotation;
import java.util.function.Function;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author wuzheng.yk
 * @date 2023/6/6
 */
public class OptionParsersTest {

    @Nested
    class UnAryOptionParser {

        @Test
        public void should_not_accept_extra_argument_for_single_valued_option() {
            TooManyArgumentsException e = assertThrows(TooManyArgumentsException.class, () -> {
                OptionParsers.unary(Integer::parseInt, 0).parse(asList("-p", "8080", "8081"), option("p"));
            });

            assertEquals("p", e.getOption());
        }

        @ParameterizedTest
        @ValueSource(strings = { "-p -l", "-p" })
        public void should_not_accept_insufficient_argument_for_single_valued_option(String arguments) {
            InsufficientArgumentsException e = assertThrows(InsufficientArgumentsException.class, () -> {
                OptionParsers.unary(Integer::parseInt, 0).parse(asList(arguments.split(" ")), option("p"));
            });

            assertEquals("p", e.getOption());
        }

        @Test
        public void should_set_default_value_to_0_for_int_option() {
            final Integer result = OptionParsers.unary(Integer::parseInt, 0).parse(asList(), option("p"));
            assertEquals(0, result.intValue());

        }

        @Test
        public void should_not_accept_extra_argument_for_string_single_valued_option() {
            TooManyArgumentsException e = assertThrows(TooManyArgumentsException.class, () -> {
                OptionParsers.unary(String::valueOf, "").parse(asList("-d", "/user/log", "/usr/tmp"), option("d"));
            });

            assertEquals("d", e.getOption());
        }

        @Test
        public void should_set_default_value_for_single_valued_option() {
            Function<String, Object> whatever = (it) -> null;
            Object defaultValue = new Object();
            final Object result = OptionParsers.unary(whatever, defaultValue).parse(asList(), option("p"));
            assertSame(defaultValue, result);
        }

        @Test
        public void should_parse_int_option() {
            final Integer result = OptionParsers.unary(Integer::parseInt, 0).parse(asList("-p", "8080"), option("p"));
            assertEquals(8080, result.intValue());
        }

        @Test
        public void should_parse_String_option() {
            final String result = OptionParsers.unary(String::valueOf, "")
                    .parse(asList("-d", "/usr/logs"), option("d"));
            assertEquals("/usr/logs", result);
        }
    }

    @Nested
    class BooleanOptionParserTest {
        //sad path:
        //    -bool -l t
        //default:
        // - bool: false

        @Test
        public void should_set_boolean_option_to_true_if_flag_present() {
            final Boolean result = OptionParsers.bool().parse(asList("-l"), option("l"));
            assertTrue(result);
        }

        @Test
        public void should_set_boolean_option_to_false_if_flag_not_present() {
            final Boolean result = OptionParsers.bool().parse(asList(), option("l"));
            assertFalse(result);
        }

        @Test //Sad Path
        public void should_not_accept_extra_argument_for_boolean_option() {
            TooManyArgumentsException e = assertThrows(TooManyArgumentsException.class, () -> {
                OptionParsers.bool().parse(asList("-l", "t", "f"), option("l"));
            });
        }

        @Test //Dafault Value
        public void should_set_default_value_to_false_if_option_not_present() {
            Boolean result = OptionParsers.bool().parse(asList(), option("l"));
            assertFalse(result);
        }

        @Test  //Happy Path
        public void should_set_value_to_true_if_option_present() {
            Boolean result = OptionParsers.bool().parse(asList("-l"), option("l"));
            assertTrue(result);
        }

    }

    @Nested
    class ListOptionParser {
        //    TODO: -g "this" "is" {"this", "is"}

        @Test
        public void should_parser_list_value() {
            final String[] value = OptionParsers.list(String[]::new, String::valueOf)
                    .parse(asList("-g", "this", "is"), option("g"));
            assertArrayEquals(new String[]{ "this", "is" }, value);
        }

        @Test
        public void should_user_empty_array_as_default_value() {
            final String[] value = OptionParsers.list(String[]::new, String::valueOf).parse(asList(), option("g"));
            assertEquals(0, value.length);
        }

        @Test
        public void should_throw_exception_if_value_parse_cant_parse_value() {
            Function<String, String> parse = (it) -> {throw new RuntimeException();};

            final IllegalValueException e = assertThrows(IllegalValueException.class, () -> {
                OptionParsers.list(String[]::new, parse).parse(asList("-g", "this", "is"), option("g"));
            });
            assertEquals("g", e.getOption());
            assertEquals("this", e.getValue());

        }

    }

    public static Option option(String vaule) {
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
