package com.hz.yk.agile.patterns.command;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by wuzheng.yk on 2018/3/14.
 */
public class TestActiveObjectEngine {

    private boolean firstCommandExecuted = false;

    @Test
    public void testOneCommand() throws Exception {
        ActiveObjectEngine e = new ActiveObjectEngine();
        e.addCommand(new Command() {

            @Override
            public void execute() {
                firstCommandExecuted = true;
            }
        });
        e.run();
        Assert.assertTrue ("Command not executed", firstCommandExecuted);

    }

    private boolean secondCommandExecuted = false;
    
    @Test
    public void testTwoCommands() throws Exception {
        ActiveObjectEngine e = new ActiveObjectEngine();
        e.addCommand(new Command() {

            @Override
            public void execute() {
                firstCommandExecuted = true;
            }
        });
        e.addCommand(new Command() {

            @Override
            public void execute() {
                secondCommandExecuted = true;
            }
        });
        e.run();
        Assert.assertTrue ("Commands not executed",firstCommandExecuted && secondCommandExecuted);
    }
}
