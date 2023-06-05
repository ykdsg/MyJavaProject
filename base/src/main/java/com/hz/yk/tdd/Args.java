package com.hz.yk.tdd;

import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;

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
        Object value = null;
        final Option option = parameter.getAnnotation(Option.class);
        OptionParser parser = null;
        if (parameter.getType() == boolean.class) {
            parser = new BooleanOptionParser();
        }
        if (parameter.getType() == int.class) {
            parser = new IntOptionParser();

        }
        if (parameter.getType() == String.class) {
            parser = new StringOptionParser();
        }
        value = parser.parse(arguments, option);
        return value;
    }

    interface OptionParser {

        Object parse(List<String> arguments, Option option);
    }

    public static class StringOptionParser implements OptionParser {

        @Override
        public Object parse(List<String> arguments, Option option) {
            int index = arguments.indexOf("-" + option.value());
            return arguments.get(index + 1);
        }
    }

    public static class IntOptionParser implements OptionParser {

        @Override
        public Object parse(List<String> arguments, Option option) {
            int index = arguments.indexOf("-" + option.value());
            return Integer.parseInt(arguments.get(index + 1));
        }
    }

    public static class BooleanOptionParser implements OptionParser {

        @Override
        public Object parse(List<String> arguments, Option option) {
            return arguments.contains("-" + option.value());
        }
    }
}
