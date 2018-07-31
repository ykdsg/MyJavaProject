package com.hz.yk.spock;

/**
 * @author wuzheng.yk
 * @date 2018/7/30
 */
public interface BizService {

    String insert(String id, String name, int age);

    String remove(String id);

    String update(String name, int age);

    String finds(String name);

    boolean isAdult(int age) throws Exception;
}
