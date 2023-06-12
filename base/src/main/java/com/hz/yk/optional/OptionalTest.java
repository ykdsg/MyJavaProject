package com.hz.yk.optional;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author wuzheng.yk
 * @date 2019/11/5
 */
public class OptionalTest {

    @Test
    public void whenMap_thenOk() {
        User user = new User("anna@gmail.com", "1234");
        String email = Optional.ofNullable(user).map(u -> u.getEmail()).orElse("default@gmail.com");

        assertEquals(email, user.getEmail());
    }

    @Test
    public void whenNull_thenOk() {
        User user = null;
        String email = Optional.ofNullable(user).map(u -> u.getEmail()).orElse("default@gmail.com");

        assertEquals(email, "default@gmail.com");
    }

    @Test
    public void whenFlatMap_thenOk() {
        User user = new User("anna@gmail.com", "1234");
        user.setPosition("Developer");
        String position = Optional.ofNullable(user).flatMap(u -> u.getPosition()).orElse("default");

        assertEquals(position, user.getPosition().get());
    }

    @Test
    public void whenListFlatMap_thenOk() {
        User user = new User("anna@gmail.com", "1234");
        List<String> demoList = Optional.ofNullable(user).flatMap(u -> u.getDemoList()).orElse(Collections.emptyList());
        assertTrue(CollectionUtils.isEmpty(demoList));

        ArrayList<String> demoList1 = Lists.newArrayList("s", "a");
        user.setDemoList(demoList1);
        demoList = Optional.ofNullable(user).flatMap(u -> u.getDemoList()).orElse(Collections.emptyList());
        assertTrue(CollectionUtils.isNotEmpty(demoList));
        assertEquals(demoList, demoList1);
    }
}
