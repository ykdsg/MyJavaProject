package com.hz.yk.yk.io.generic.impl;

import com.hz.yk.yk.io.generic.Input;
import java.io.File;
import java.io.IOException;

/**
 * @author wuzheng.yk
 *         Date: 13-4-5
 *         Time: 下午3:36
 */
public class Inputs {

    private Inputs(){

    }

    public static Input<String, IOException> text(File source) throws IOException {
       return new FileInput(source);
    }

}
