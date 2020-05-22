package com.hz.yk.practice.general.io;

import com.hz.yk.practice.general.io.impl.InputImpl;
import com.hz.yk.practice.general.io.impl.OutputImpl;

import java.io.File;
import java.io.IOException;

/**
 * @author wuzheng.yk
 * @date 2020/3/10
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Input<String, IOException> input = new InputImpl(new File("in"));
        Output<String, IOException> output = new OutputImpl(new File("out"));
        input.transferTo(Transforms.filter((str) -> {return "11".equals(str);}, output));

    }

}
