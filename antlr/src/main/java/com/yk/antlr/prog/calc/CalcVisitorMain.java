package com.yk.antlr.prog.calc;

import com.yk.antlr.gen.calc.CalcLexer;
import com.yk.antlr.gen.calc.CalcParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * http://codemany.com/blog/reading-notes-the-definitive-antlr4-reference-part3/
 * Created by wuzheng.yk on 2017/12/6.
 */
public class CalcVisitorMain {

    public static void main(String[] args) throws Exception {
        String sentence = "193\n" + "a=5\n" + "b=6\n" + "a+b*2\n" + "(1+2)*3\n";
        CalcLexer lexer = new CalcLexer(CharStreams.fromString(sentence));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalcParser parser = new CalcParser(tokens);
        ParseTree tree = parser.prog();

        EvalVisitor eval = new EvalVisitor();
        // 开始遍历语法分析树
        eval.visit(tree);

        System.out.println(tree.toStringTree(parser));
    }
}
