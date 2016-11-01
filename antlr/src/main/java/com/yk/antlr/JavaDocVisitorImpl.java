package com.yk.antlr;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.yk.antlr.gen.javadoc.JavadocParser;
import com.yk.antlr.gen.javadoc.JavadocParserVisitor;

/**
 * Created by wuzheng.yk on 16/10/17.
 */
public class JavaDocVisitorImpl extends AbstractParseTreeVisitor implements JavadocParserVisitor {
    @Override
    public Object visitDocumentation(JavadocParser.DocumentationContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitDocumentationContent(JavadocParser.DocumentationContentContext ctx) {
        return null;
    }

    @Override
    public Object visitSkipWhitespace(JavadocParser.SkipWhitespaceContext ctx) {
        return null;
    }

    @Override
    public Object visitDescription(JavadocParser.DescriptionContext ctx) {
        return null;
    }

    @Override
    public Object visitDescriptionLine(JavadocParser.DescriptionLineContext ctx) {
        return null;
    }

    @Override
    public Object visitDescriptionLineStart(JavadocParser.DescriptionLineStartContext ctx) {
        return null;
    }

    @Override
    public Object visitDescriptionLineNoSpaceNoAt(JavadocParser.DescriptionLineNoSpaceNoAtContext ctx) {
        return null;
    }

    @Override
    public Object visitDescriptionLineElement(JavadocParser.DescriptionLineElementContext ctx) {
        return null;
    }

    @Override
    public Object visitDescriptionLineText(JavadocParser.DescriptionLineTextContext ctx) {
        return null;
    }

    @Override
    public Object visitDescriptionNewline(JavadocParser.DescriptionNewlineContext ctx) {
        return null;
    }

    @Override
    public Object visitTagSection(JavadocParser.TagSectionContext ctx) {
        return null;
    }

    @Override
    public Object visitBlockTag(JavadocParser.BlockTagContext ctx) {
        return null;
    }

    @Override
    public Object visitBlockTagName(JavadocParser.BlockTagNameContext ctx) {
        return null;
    }

    @Override
    public Object visitBlockTagContent(JavadocParser.BlockTagContentContext ctx) {
        return null;
    }

    @Override
    public Object visitBlockTagText(JavadocParser.BlockTagTextContext ctx) {
        return null;
    }

    @Override
    public Object visitBlockTagTextElement(JavadocParser.BlockTagTextElementContext ctx) {
        return null;
    }

    @Override
    public Object visitInlineTag(JavadocParser.InlineTagContext ctx) {
        return null;
    }

    @Override
    public Object visitInlineTagName(JavadocParser.InlineTagNameContext ctx) {
        return null;
    }

    @Override
    public Object visitInlineTagContent(JavadocParser.InlineTagContentContext ctx) {
        return null;
    }

    @Override
    public Object visitBraceExpression(JavadocParser.BraceExpressionContext ctx) {
        return null;
    }

    @Override
    public Object visitBraceContent(JavadocParser.BraceContentContext ctx) {
        return null;
    }

    @Override
    public Object visitBraceText(JavadocParser.BraceTextContext ctx) {
        return null;
    }

    @Override
    public Object visit(ParseTree tree) {
        return super.visit(tree);
    }

    @Override
    public Object visitChildren(RuleNode node) {
        return null;
    }

    @Override
    public Object visitTerminal(TerminalNode node) {
        return null;
    }

    @Override
    public Object visitErrorNode(ErrorNode node) {
        return null;
    }
}
