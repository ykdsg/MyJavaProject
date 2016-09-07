package com.hz.yk.shell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by wuzheng.yk on 15/10/29.
 */
public class ShellExample {

    public static void main(String[] args) throws IOException {
        String cmd = "echo 'hello';echo 'world' ";
        Process pro = Runtime.getRuntime().exec(new String[]{"sh", "-c", cmd});
        BufferedReader buf = new BufferedReader(new InputStreamReader(pro.getInputStream()));
        String line;
        while ((line = buf.readLine()) != null) {
            System.out.println(line);

        }
    }
}
