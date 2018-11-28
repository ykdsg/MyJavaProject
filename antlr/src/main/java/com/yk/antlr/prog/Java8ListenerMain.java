package com.yk.antlr.prog;

import com.yk.antlr.gen.java8.Java8BaseListener;
import com.yk.antlr.gen.java8.Java8Lexer;
import com.yk.antlr.gen.java8.Java8Parser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * @author wuzheng.yk
 * @date 2018/11/28
 */
public class Java8ListenerMain {

    public static void main(String[] args) {
        String javaStr =
                "/**\n" + " * Created by wuzheng.yk on 16/8/25.\n" + " */\n" + "public interface DubboService {\n"
                + "\n" + "    /**\n" + "     * 获取泛化的service\n" + "     * @param interfaceName\n"
                + "     * @param group\n" + "     * @return\n" + "     */\n"
                + "    GenericService getServiceByCache(String interfaceName, String group);\n" + "}";

        Java8Lexer lexer = new Java8Lexer(new ANTLRInputStream(javaStr));

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        //进行语法分析
        Java8Parser parser = new Java8Parser(tokens);

        ParseTree tree = parser.compilationUnit();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new MyJava8Listener(), tree);
        System.out.println();
    }

    static class MyJava8Listener extends Java8BaseListener {

        @Override
        public void enterMethodName(Java8Parser.MethodNameContext ctx) {

        }

    }

}
