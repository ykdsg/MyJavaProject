package com.yk.antlr.prog.calc;

import com.yk.antlr.gen.calc.CalcLexer;
import com.yk.antlr.gen.calc.CalcParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * http://codemany.com/blog/reading-notes-the-definitive-antlr4-reference-part4/
 * Created by wuzheng.yk on 2017/12/6.
 */
public class CalcListenerMain {

    public static void main(String[] args) throws Exception {
        String sentence = "193\n" + "a=5\n" + "b=6\n" + "a+b*2\n" + "(1+2)*3\n";
        CalcLexer lexer = new CalcLexer(CharStreams.fromString(sentence));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalcParser parser = new CalcParser(tokens);
        ParseTree tree = parser.prog();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new DirectiveListener(), tree);

        // print LISP-style tree
        System.out.println(tree.toStringTree(parser));
    }
}
