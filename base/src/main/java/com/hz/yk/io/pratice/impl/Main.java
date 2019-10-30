package com.hz.yk.io.pratice.impl;

import com.hz.yk.io.pratice.Input;
import com.hz.yk.io.pratice.Output;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author wuzheng.yk
 * @date 2019/10/23
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Input<String> input = new FileInput(new File("in"));
        Output<String> out = new FileOutput(new File("out"));

        input.transferTo(out);

        Reader reader = new FileReader("out");
        BufferedReader bfReader = new BufferedReader(reader);
        String line;
        while ((line = bfReader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

}
