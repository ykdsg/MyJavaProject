// Generated from /Users/ykdsg/my_workspace/MyJavaProject/antlr/src/main/resources/Hello.g4 by ANTLR 4.7
package com.yk.antlr.gen.hello;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HelloParser}.
 */
public interface HelloListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HelloParser#s}.
	 * @param ctx the parse tree
	 */
	void enterS(HelloParser.SContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#s}.
	 * @param ctx the parse tree
	 */
	void exitS(HelloParser.SContext ctx);
}