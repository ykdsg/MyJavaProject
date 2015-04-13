package com.hz.yk.yk.guava;

import com.google.common.base.Objects;
import com.google.common.base.Optional;

/**
 * @author wuzheng.yk
 *         Date: 13-2-20
 *         Time: ÉÏÎç11:56
 */
public class OptionalDemo {
    public static void main(String[] args) {
        Optional<Integer> possible = Optional.<Integer>of(5);
        if (possible.isPresent()) // true
            System.out.println(possible.get()); // 5
        System.out.println(possible.asSet()); // [5]

        Optional<Integer> absentValue = Optional.<Integer>absent();
        if (absentValue.isPresent()) // false
            System.out.println(absentValue.get());
        System.out.println(absentValue.or(-1)); // -1
        System.out.println(absentValue.orNull()); // null
        System.out.println(absentValue.asSet()); // []

        // absent is not null
        System.out.println(Objects.firstNonNull(possible, absentValue)); // Optional.of(5)
        System.out.println(Objects.firstNonNull(absentValue, possible)); // Optional.absent()
        System.out.println(Objects.firstNonNull(absentValue, absentValue)); // Optional.absent()

        Optional<Integer> nullValue = Optional.<Integer>fromNullable(null);
        if (nullValue.isPresent()) // false
            System.out.println(nullValue.get());
        System.out.println(nullValue.or(-1)); // -1
        System.out.println(nullValue.orNull()); // null
        System.out.println(nullValue.asSet()); // []

        System.out.println(Objects.firstNonNull(possible, nullValue)); // Optional.of(5)
        System.out.println(Objects.firstNonNull(nullValue, possible)); // Optional.absent()
        System.out.println(Objects.firstNonNull(nullValue, nullValue)); // Optional.absent()

        System.out.println(Objects.firstNonNull(null, 1)); // 1
        System.out.println(Objects.firstNonNull(1, null)); // 1
        System.out.println(Objects.firstNonNull(null, null)); // cause a java.lang.NullPointerException
    }
}
