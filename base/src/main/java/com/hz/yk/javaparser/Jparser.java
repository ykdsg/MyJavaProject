package com.hz.yk.javaparser;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author wuzheng.yk
 * @date 2018/11/29
 */
public class Jparser {

    public static void main(String[] args) {

        File javaFile = new File("base/src/main/java/com/hz/yk/javaparser/TestJavaCode.java");
        //System.out.println(javaFile.getAbsolutePath());

        try {
            // 将一个 java 代码的文本解析为一棵 CompilationUnit 类型的树
            CompilationUnit unit = JavaParser.parse(javaFile);
            classUnit vc = new classUnit();
            // 在指定的树上进行搜索，然后根据遇到的节点的类型调用具体的回调
            vc.visit(unit, null);
            //unit.accept(vc, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
