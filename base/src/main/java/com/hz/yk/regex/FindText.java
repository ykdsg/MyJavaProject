package com.hz.yk.regex;

import com.google.common.collect.Maps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wuzheng.yk on 15/12/29.
 */
public class FindText {

    public static void main(String[] args) throws IOException {
        Pattern pattern = Pattern.compile("\\(\\D+\\d+\\)");
        Map<String, String> errorMap = Maps.newHashMap();
        try (BufferedReader in = new BufferedReader(new FileReader("/Users/ykdsg/Documents/nul.txt"))){
            String s;
            while ((s = in.readLine()) != null) {
                Matcher matcher = pattern.matcher(s);
                if (matcher.find()) {
                    String stack = matcher.group();
                    errorMap.put(stack.split(":")[0], stack.split(":")[1]);
                }
            }
        }
        System.out.println(errorMap);
    }
}
