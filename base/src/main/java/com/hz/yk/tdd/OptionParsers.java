package com.hz.yk.tdd;

import com.hz.yk.tdd.exception.IllegalValueException;
import com.hz.yk.tdd.exception.InsufficientArgumentsException;
import com.hz.yk.tdd.exception.TooManyArgumentsException;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

/**
 * @author wuzheng.yk
 * @date 2023/6/5
 */
public class OptionParsers {

    public static OptionParser<Boolean> bool() {
        return (arguments, option) -> {
            return values(arguments, option, 0).isPresent();
        };
    }

    public static <T> OptionParser<T> unary(Function<String, T> valuePraser, T defaultValue) {
        return (arguments, option) -> getT(arguments, option, valuePraser, defaultValue);
    }

    public static <T> OptionParser<T[]> list(IntFunction<T[]> intFunction,Function<String, T> valuePraser) {
        return (arguments, option) -> {
            return values(arguments, option).map(
                            it -> it.stream().map(value -> parseValue(option, value, valuePraser)).toArray(intFunction))
                    .orElse(intFunction.apply(0));
        };
                
    }

    private static <T> T getT(List<String> arguments, Option option, Function<String, T> valuePraser, T defaultValue) {
        Optional<List<String>> argumentList = values(arguments, option, 1);
        return argumentList.map(it -> parseValue(option, it.get(0), valuePraser)).orElse(defaultValue);
    }

    private static Optional<List<String>> values(List<String> arguments, Option option) {
        int index = arguments.indexOf("-" + option.value());
        return Optional.ofNullable(index == -1 ? null : getValuesFrom(arguments, index));

    }

    @NotNull
    private static Optional<List<String>> values(List<String> arguments, Option option, int expectedSize) {
        int index = arguments.indexOf("-" + option.value());
        if (index == -1) {
            return Optional.empty();
        }
        final List<String> values = getValuesFrom(arguments, index);
        if (values.size() < expectedSize) {
            throw new InsufficientArgumentsException(option.value());
        }
        if (values.size() > expectedSize) {
            throw new TooManyArgumentsException(option.value());
        }
        return Optional.of(values);
    }

    private static <T> T parseValue(Option option, String value, Function<String, T> valuePraser) {
        try {
            return valuePraser.apply(value);
        } catch (Exception e) {
            throw new IllegalValueException(option.value(), value);
        }
    }

    @NotNull
    private static List<String> getValuesFrom(List<String> arguments, int index) {
        final int followingFlag = IntStream.range(index + 1, arguments.size())
                .filter(it -> arguments.get(it).startsWith("-")).findFirst().orElse(arguments.size());
        //两个flag之间的参数
        return arguments.subList(index + 1, followingFlag);
    }

}
