package com.hz.yk.junit.runner;

import com.hz.yk.junit.CoreJUnit4SampleTest;
import org.junit.internal.runners.ErrorReportingRunner;
import org.junit.runner.Result;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.manipulation.Sorter;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * 从上面的分析中，这个运行结果应该已经很清晰了，只是有两点需要注意，其一，@Ignore注解的方法会被忽略不执行，包括@Before、@After注解的方法，也不会触发该testStarted事件，但是在Result
 * 会记录被忽略的测试方法数，而被Filter过滤掉的方法（testFilteredOut()
 * ）则不会有任何记录；其二，事件的触发都是在@Before注解之前或@After注解之后，事实上，如果测试方法中包含Rule字段的话，也会在Rule执行之前或之后，这就是JUnit抽象出的Statement
 * 提供的特性，这是一个非常好的设计，这个特性将会在下一节：深入JUnit源码之Statement中讲解
 * Created by wuzheng.yk on 2018/4/26.
 */
public class BlockJUnit4ClassRunnerExecutor {

    public static void main(String[] args) {
        RunNotifier notifier = new RunNotifier();
        Result result = new Result();
        notifier.addFirstListener(result.createListener());
        notifier.addListener(new LogRunListener());

        Runner runner = null;
        try {
            runner = new BlockJUnit4ClassRunner(CoreJUnit4SampleTest.class);
            try {
                ((BlockJUnit4ClassRunner) runner).filter(new MethodNameFilter("testFilteredOut"));
            } catch (NoTestsRemainException e) {
                System.out.println("All methods are been filtered out");
                return;
            }
            ((BlockJUnit4ClassRunner) runner).sort(new Sorter(new AlphabetComparator()));
        } catch (Throwable e) {
            runner = new ErrorReportingRunner(CoreJUnit4SampleTest.class, e);
        }
        notifier.fireTestRunStarted(runner.getDescription());
        runner.run(notifier);
        notifier.fireTestRunFinished(result);
    }
}
