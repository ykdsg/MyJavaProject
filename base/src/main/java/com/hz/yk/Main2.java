package com.hz.yk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wuzheng.yk
 * @date 2018/7/17
 */
public class Main2 {

    private static final Logger log = LoggerFactory.getLogger(Main2.class);

    /**
     * 异常日志输出测试，看看error msg 会不会丢失，实际会在caused by中显示
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            try {
                try {
                    String msg = "test1";
                    throw new Exception(msg);
                } catch (Exception e) {
                    String msg = "test2";
                    throw new Exception(msg, e);
                }
            } catch (Exception e) {
                String msg = "test3";
                throw new Exception(msg, e);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            log.error("[Main2-main]error", e);
        }
    }

}
