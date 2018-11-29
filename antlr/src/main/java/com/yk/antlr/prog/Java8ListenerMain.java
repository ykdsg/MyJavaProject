package com.yk.antlr.prog;

import com.yk.antlr.gen.java8.Java8BaseVisitor;
import com.yk.antlr.gen.java8.Java8Lexer;
import com.yk.antlr.gen.java8.Java8Parser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

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

        MyJava8Visitor listener = new MyJava8Visitor();
        listener.visit(tree);

    }

    static class MyJava8Visitor extends Java8BaseVisitor {

        @Override
        public Object visitMethodDeclaration(Java8Parser.MethodDeclarationContext ctx) {
            return visitChildren(ctx);
        }

        @Override
        public Object visitInterfaceMethodDeclaration(Java8Parser.InterfaceMethodDeclarationContext ctx) {
            return visitChildren(ctx);
        }
    }

}
