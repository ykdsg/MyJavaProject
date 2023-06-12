package com.hz.yk.agile.patterns.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by wuzheng.yk on 2018/3/14.
 */
public class TestSleepCommand {
    private boolean commandExecuted = false;

    @Test
    public void testSleep() throws Exception
    {
        Command wakeup = new Command()
        {
            @Override
            public void execute() {commandExecuted = true;}
        };
        ActiveObjectEngine e = new ActiveObjectEngine();
        int milliseconds = 50000;
        SleepCommand c = new SleepCommand(milliseconds, e, wakeup);
        e.addCommand(c);
        long start = System.currentTimeMillis();
        e.run();
        long stop = System.currentTimeMillis();
        long sleepTime = (stop-start);
        assertEquals(sleepTime, milliseconds, "SleepTime " + sleepTime + " expected == 1000");
        assertTrue( commandExecuted,"Command Executed");
    }
}
