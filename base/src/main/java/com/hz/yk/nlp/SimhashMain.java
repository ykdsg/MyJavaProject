package com.hz.yk.nlp;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author wuzheng.yk
 * @date 2019-08-02
 */
public class SimhashMain {

    public static void main(String[] args) throws IOException {
        List<String> ls = FileUtils.readLines(new File("test"));
        Simhash simhash = new Simhash(4, 3);
        for (String content : ls) {
            Long simhashVal = simhash.calSimhash(content);
            System.out.println(Long.toBinaryString(simhashVal));
            System.out.println(simhash.isDuplicate(content));
            simhash.store(simhashVal, content);
        }

    }
}
