package com.hz.yk.io.generic;

import com.hz.yk.io.generic.filter.Filters;
import com.hz.yk.io.generic.filter.Specification;
import com.hz.yk.io.generic.impl.Inputs;
import com.hz.yk.io.generic.impl.Outputs;

import java.io.File;
import java.io.IOException;

/**
 * Created by wuzheng.yk on 16/11/1.
 */
public class Demo_Intercept_FilterLine {
    public static void main(String[] args) throws IOException {
        File source = new File("in");
        File destination = new File("out");

        Input<String, IOException> input = Inputs.text(source);
        Output<String, IOException> output = Outputs.text(destination);
        Specification<String> specification = new Specification<String>() {
            public boolean test(String item) {
                if(item.trim().length() == 0) return false; // 过滤空行
                return true;
            }
        };
        input.transferTo(Filters.filter(specification, output));
    }

}
