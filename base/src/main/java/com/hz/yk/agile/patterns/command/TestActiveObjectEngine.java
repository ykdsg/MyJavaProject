package com.hz.yk.agile.patterns.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertTrue (firstCommandExecuted,"Command not executed");

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
        assertTrue (firstCommandExecuted && secondCommandExecuted,"Commands not executed");
    }
}
