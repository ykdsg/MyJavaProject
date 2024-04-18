package com.hz.yk.tdd;

import com.google.common.collect.Maps;
import com.hz.yk.tdd.exception.IllegalOptionException;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author wuzheng.yk
 * @date 2023/6/5
 */
public class Args {

    public static <T> T parse(Class<T> optionsClass, String... args) {
        try {
            final List<String> arguments = Arrays.asList(args);
            Constructor<?> constructor = optionsClass.getDeclaredConstructors()[0];
            final Object[] values = Arrays.stream(constructor.getParameters()).map(p -> parseOption(p, arguments))
                    .toArray();

            return (T) constructor.newInstance(values);
        } catch (IllegalOptionException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Nullable
    private static Object parseOption(Parameter parameter, List<String> arguments) {
        final Option option = parameter.getAnnotation(Option.class);
        if (option == null) {
            throw new IllegalOptionException(parameter.getName());
        }
        final Class<?> type = parameter.getType();

        OptionParser parser = PARSERS.get(type);
        return parser.parse(arguments, option);
    }

    private static Map<Class<?>, OptionParser> PARSERS = Maps.newHashMap();
    static {
        PARSERS.put(boolean.class, OptionParsers.bool());
        PARSERS.put(int.class, OptionParsers.unary(Integer::parseInt, 0));
        PARSERS.put(String.class, OptionParsers.unary(String::valueOf, ""));
    }

}
