package com.yk.antlr.prog;

import com.yk.antlr.gen.ArrayInitLexer;
import com.yk.antlr.gen.ArrayInitParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * Created by wuzheng.yk on 16/9/23.
 */
public class ArrayInitMain {

    public static void main(String[] args) {
        String sentence = "{99,3,451}";

        //词法分析
        ArrayInitLexer lexer = new ArrayInitLexer(new ANTLRInputStream(sentence));

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        ArrayInitParser parser = new ArrayInitParser(tokens);
        ParseTree tree = parser.init();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new ArrayInitBaseListenerImpl(), tree);
        System.out.println();

    }

}
