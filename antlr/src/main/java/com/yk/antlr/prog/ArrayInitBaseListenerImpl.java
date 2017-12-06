package com.yk.antlr.prog;

import com.yk.antlr.gen.ArrayInitBaseListener;
import com.yk.antlr.gen.ArrayInitParser;

/**
 * 实现了ArrayInitBaseListener
 * Created by wuzheng.yk on 16/9/23.
 */
public class ArrayInitBaseListenerImpl extends ArrayInitBaseListener {

    @Override
    public void enterInit(ArrayInitParser.InitContext ctx) {
        System.out.print('"');
    }

    @Override
    public void exitInit(ArrayInitParser.InitContext ctx) {
        System.out.print('"');
    }

    @Override
    public void enterValue(ArrayInitParser.ValueContext ctx) {
        if (ctx.INT() == null) {
            System.out.println(ctx.INT());
        } else {
            System.out.printf("\\u%04x", Integer.valueOf(ctx.INT().getText()));
        }
    }
}
