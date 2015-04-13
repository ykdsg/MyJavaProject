package com.hz.yk.yk.io.generic.impl;

import com.hz.yk.yk.io.generic.Output;
import java.io.File;
import java.io.IOException;

/**
 * @author wuzheng.yk
 *         Date: 13-4-5
 *         Time: 下午3:59
 */
public class Outputs {
    private Outputs() {}

    public static Output<String, IOException> text(File destination) throws IOException {
         return new FileOutput(destination);
    }

}
