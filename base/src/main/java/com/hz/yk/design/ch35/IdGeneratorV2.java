package com.hz.yk.design.ch35;

import com.google.common.annotations.VisibleForTesting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * @author wuzheng.yk
 * @date 2021/7/2
 */
public class IdGeneratorV2 {

}

class RandomIdGenerator2 implements LogTraceIdGenerator {

    private static final Logger logger = LoggerFactory.getLogger(IdGeneratorV1.class);

    @Override
    public String generate() {
        String substrOfHostName = getLastfieldOfHostName();
        long currentTimeMillis = System.currentTimeMillis();
        String randomString = generateRandomAlphameric(8);
        String id = String.format("%s-%d-%s", substrOfHostName, currentTimeMillis, randomString);
        return id;
    }

    //剥离出主要代码之后这个函数变得非常简单,可以不用测试。重点测试 getLastSubstrSplittedByDot() 函数即可
    private String getLastfieldOfHostName() {
        String substrOfHostName = null;
        try {
            String hostName = InetAddress.getLocalHost().getHostName();
            substrOfHostName = getLastSubstrSplittedByDot(hostName);
        } catch (UnknownHostException e) {
            logger.warn("Failed to get the host name.", e);
        }
        return substrOfHostName;
    }

    //@VisibleForTesting,这个 annotation 没有任何实际的作用,只起到标识的作用,告诉其他人说,这两个函数本该是 private 访问权限的,
    //之所以提升访问权限到 protected,只是为了测试,只能用于单元测试中
    @VisibleForTesting
    protected String getLastSubstrSplittedByDot(String hostName) {
        String[] tokens = hostName.split("\\.");
        String substrOfHostName = tokens[tokens.length - 1];
        return substrOfHostName;
    }

    @VisibleForTesting
    protected String generateRandomAlphameric(int length) {
        char[] randomChars = new char[length];
        int count = 0;
        Random random = new Random();
        while (count < length) {
            int maxAscii = 'z';
            int randomAscii = random.nextInt(maxAscii);
            boolean isDigit = randomAscii >= '0' && randomAscii <= '9';
            boolean isUppercase = randomAscii >= 'A' && randomAscii <= 'Z';
            boolean isLowercase = randomAscii >= 'a' && randomAscii <= 'z';
            if (isDigit || isUppercase || isLowercase) {
                randomChars[count] = (char) (randomAscii);
                ++count;
            }
        }
        return new String(randomChars);
    }

    public static void main(String[] args) {
        //代码使用举例
        LogTraceIdGenerator logTraceIdGenerator = new RandomIdGenerator1();
    }
}
