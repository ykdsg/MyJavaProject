package com.yk.antlr.prog;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.yk.antlr.gen.expr.ExprBaseVisitor;
import com.yk.antlr.gen.expr.ExprParser;

/**
 * Created by wuzheng.yk on 16/9/28.
 */
public class ExprVisitorImpl extends ExprBaseVisitor<Double> {
    @Override
    public Double visitProgram(ExprParser.ProgramContext ctx) {
        return super.visitProgram(ctx);
    }

    @Override
    public Double visitStatement(ExprParser.StatementContext ctx) {
        return super.visitStatement(ctx);
    }

    @Override
    public Double visitExpression(ExprParser.ExpressionContext ctx) {
        String lastOp = "+";
        double result = 0;

        for (ParseTree child : ctx.children){
            if (child instanceof TerminalNode){
                lastOp = child.getText();
                continue;
            }
            ExprParser.MultExprContext context = (ExprParser.MultExprContext)child;
            switch (lastOp) {
                case "+":
                    result += visitMultExpr(context);
                    break;
                case "-":
                    result -= visitMultExpr(context);
                    break;
                default:
                    assert false : "invalid operation type";
                    break;
            }
        }
        return result;
    }

    @Override
    public Double visitMultExpr(ExprParser.MultExprContext ctx) {
        double result = 1;
        String lastOp = "*";

        for (ParseTree child : ctx.children){
            if (child instanceof TerminalNode){
                lastOp = child.getText();
                continue;
            }

            ExprParser.AtomContext atomContext = (ExprParser.AtomContext)child;
            switch (lastOp) {
                case "*":
                    result *= visitAtom(atomContext);
                    break;
                case "/":
                    result /= visitAtom(atomContext);
                    break;
                default:
                    assert false : "invalid operation type";
                    break;
            }
        }
        return result;
    }

    @Override
    public Double visitAtom(ExprParser.AtomContext ctx) {
        if (ctx.expression() != null){
            return visitExpression(ctx.expression());
        }
        else{
            return Double.parseDouble(ctx.INT().getText());
        }
    }
}
