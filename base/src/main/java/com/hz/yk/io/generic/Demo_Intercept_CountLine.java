package com.hz.yk.io.generic;

import com.hz.yk.io.generic.filter.Function;
import com.hz.yk.io.generic.filter.FunctionFilter;
import com.hz.yk.io.generic.impl.Inputs;
import com.hz.yk.io.generic.impl.Outputs;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wuzheng.yk on 16/11/1.
 */
public class Demo_Intercept_CountLine {

    public static void main(String[] args) throws IOException {
        //File f = new File("");
        //System.out.println(f.getCanonicalPath());
        File source = new File("in");
        File destination = new File("out");
        final AtomicInteger count = new AtomicInteger();

        Input<String, IOException> input = Inputs.text(source);

        Output<String, IOException> output = Outputs.text(destination);

        Function<String, String> function = new Function<String, String>() {

            public String map(String from) {
                count.incrementAndGet();
                return from;
            }
        };

        input.transferTo(FunctionFilter.filter(function, output));

        System.out.println("Counter: " + count.get());
    }
}
