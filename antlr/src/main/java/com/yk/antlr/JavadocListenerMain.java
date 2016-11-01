package com.yk.antlr;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.yk.antlr.gen.javadoc.JavadocLexer;
import com.yk.antlr.gen.javadoc.JavadocParser;

/**
 * Created by wuzheng.yk on 16/10/18.
 */
public class JavadocListenerMain {

    public static void main(String[] args) {
        String javaStr = "/**\n" +
                " * Created by wuzheng.yk on 16/8/25.\n" +
                " */\n" +
                "public interface DubboService {\n" +
                "\n" +
                "    /**\n" +
                "     * 获取泛化的service\n" +
                "     * @param interfaceName\n" +
                "     * @param group\n" +
                "     * @return\n" +
                "     */\n" +
                "    GenericService getServiceByCache(String interfaceName, String group);\n" +
                "}";


        JavadocLexer lexer = new JavadocLexer(new ANTLRInputStream(javaStr));

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        //进行语法分析
        JavadocParser parser = new JavadocParser(tokens);

        ParseTree tree = parser.documentation();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new JavaDocListenerImpl(), tree);
        System.out.println();
    }
}
