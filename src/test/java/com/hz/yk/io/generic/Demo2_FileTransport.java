package com.hz.yk.io.generic;

import com.hz.yk.io.generic.impl.Inputs;
import com.hz.yk.io.generic.impl.Outputs;
import java.io.File;
import java.io.IOException;

/**
 * @author wuzheng.yk
 *         Date: 13-4-17
 *         Time: 下午4:49
 */
public class Demo2_FileTransport {

    public static void main(String[] args) throws IOException {
        File source = new File("in");
        File destination = new File("out");

        Inputs.text(source).transferTo(Outputs.text(destination));
    }
}
