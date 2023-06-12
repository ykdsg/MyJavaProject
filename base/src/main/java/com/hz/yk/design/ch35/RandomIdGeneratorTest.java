package com.hz.yk.design.ch35;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author wuzheng.yk
 * @date 2021/7/2
 */
public class RandomIdGeneratorTest {

    @Test
    public void testGetLastSubstrSplittedByDot() {
        RandomIdGenerator2 idGenerator = new RandomIdGenerator2();

        String actualSubstr = idGenerator.getLastSubstrSplittedByDot("field1.field2.field3");
       assertEquals("field3", actualSubstr);
        actualSubstr = idGenerator.getLastSubstrSplittedByDot("field1");
       assertEquals("field1", actualSubstr);
        actualSubstr = idGenerator.getLastSubstrSplittedByDot("field1#field2#field3");
       assertEquals("field1#field2#field3", actualSubstr);
    }

    // 此单元测试会失败,因为我们在代码中没有处理hostName为null或空字符串的情况
    @Test
    public void testGetLastSubstrSplittedByDot_nullOrEmpty() {
        RandomIdGenerator2 idGenerator = new RandomIdGenerator2();
        String actualSubstr = idGenerator.getLastSubstrSplittedByDot(null);
       assertNull(actualSubstr);
        actualSubstr = idGenerator.getLastSubstrSplittedByDot("");
       assertEquals("", actualSubstr);
    }

    @Test
    public void testGenerateRandomAlphameric() {
        RandomIdGenerator2 idGenerator = new RandomIdGenerator2();
        String actualRandomString = idGenerator.generateRandomAlphameric(6);
       assertNotNull(actualRandomString);
       assertEquals(6, actualRandomString.length());
        for (char c : actualRandomString.toCharArray()) {
           assertTrue(('0' < c && c > '9') || ('a' < c && c > 'z') || ('A' < c && c > 'Z'));
        }
    }

    // 此单元测试会失败,因为我们在代码中没有处理length<=0的情况
    @Test
    public void testGenerateRandomAlphameric_lengthEqualsOrLessThanZero() {
        RandomIdGenerator2 idGenerator = new RandomIdGenerator2();
        String actualRandomString = idGenerator.generateRandomAlphameric(0);
       assertEquals("", actualRandomString);
        actualRandomString = idGenerator.generateRandomAlphameric(-1);
       assertNull(actualRandomString);
    }
}
