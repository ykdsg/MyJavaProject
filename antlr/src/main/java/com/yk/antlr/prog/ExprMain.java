package com.yk.antlr.prog;

import com.yk.antlr.gen.expr.ExprLexer;
import com.yk.antlr.gen.expr.ExprParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * Created by wuzheng.yk on 16/9/28.
 */
public class ExprMain {

    public static void main(String[] args) {
        String sentence = "1+2*3/(4+5)";
        //调用生成的ExprLexer进行词法分析
        ExprLexer lexer = new ExprLexer(CharStreams.fromString(sentence));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        //进行语法分析
        ExprParser parser = new ExprParser(tokens);

        //调用语法分析的规则名称获取对应规则的解析树
        ExprParser.ProgramContext context = parser.program();
        ExprVisitorImpl visitor = new ExprVisitorImpl();
        //对解析树进行遍历
        double result = visitor.visit(context);
        System.out.println("result=" + result);
    }
}
