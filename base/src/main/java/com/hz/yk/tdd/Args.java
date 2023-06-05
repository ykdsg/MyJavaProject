package com.hz.yk.tdd;

import com.google.common.collect.Maps;
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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Nullable
    private static Object parseOption(Parameter parameter, List<String> arguments) {
        final Option option = parameter.getAnnotation(Option.class);
        final Class<?> type = parameter.getType();

        OptionParser parser = PARSERS.get(type);
        return parser.parse(arguments, option);
    }

    private static Map<Class<?>, OptionParser> PARSERS = Maps.newHashMap();
    static {
        PARSERS.put(boolean.class, new BooleanOptionParser());
        PARSERS.put(int.class, new IntOptionParser(Integer::parseInt));
        PARSERS.put(String.class, new IntOptionParser(String::valueOf));
    }

}
