package com.hz.yk.co;

import com.hz.yk.co.rule.ErrorMessageLogger;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintWriter;

import static com.hz.yk.co.LogLevelConstant.ERROR;
import static com.hz.yk.co.LogLevelConstant.INFO;
import static com.hz.yk.co.LogLevelConstant.WARNING;
import static com.hz.yk.co.LoggerFacade.ignore;
import static com.hz.yk.co.LoggerFacade.nop;
import static com.hz.yk.co.LoggerFacade.sequence;
import static com.hz.yk.co.LoggerFacade.timestamp;
import static com.hz.yk.co.LoggerFacade.writer;

/**
 * Created by wuzheng.yk on 2017/6/7.
 */
public class LoggerTest {

    private Logger err_log;
    private Logger warning_log;
    private Logger info_log;

    @Before
    public void setup() {
        // 代表特定的日志文件
        PrintWriter err_writer = new PrintWriter(System.err, true);
        PrintWriter warning_writer = new PrintWriter(System.out, true);
        PrintWriter info_writer = new PrintWriter(System.out, true);
        // 表示不同的log文件
        err_log = writer(err_writer);
        warning_log = writer(warning_writer);
        info_log = writer(info_writer);

        // 各个文件记录不同重要程度的信息
        err_log = LoggerFacade.filter(ERROR, err_log, nop());
        warning_log = LoggerFacade.filter(WARNING, warning_log, nop());
        info_log = LoggerFacade.filter(INFO, info_log, nop());
    }

    @Test
    public void testSequence() {
        // 把三个不同的logger串联起来
        Logger logger = sequence(err_log, warning_log, info_log);

        logger.println(INFO, "我是info信息");
        logger.println(WARNING, "我是warning ");
        logger.println(ERROR, "ERROR~~~");

    }

    @Test
    public void testTimestamp() {
        Logger logger = sequence(err_log, warning_log, info_log);
        // 每条logging信息同时打印当前的系统时间
        logger = timestamp(logger);
        logger.println(INFO, "我是info******");
        logger.println(WARNING, "我是warning&&&&&& ");
        logger.println(ERROR, "ERROR~~~");
    }

    @Test
    public void testIgnore() {
        Logger logger = sequence(err_log, warning_log, info_log);
        // 能够在标准错误输出上直接看见错误，普通的信息可以打印到log文件中，对错误信息，我们希望log文件和标准输出上都有
        Logger std_logger = writer(new PrintWriter(System.err,true));
        std_logger = ignore(ERROR, std_logger);
        logger = sequence(std_logger, logger);
        logger.println(INFO, "我是info******");
        logger.println(WARNING, "我是warning&&&&&& ");
        logger.println(ERROR, "ERROR~~~");
        logger.printException(new NullPointerException("空指针了"));

    }

    @Test
    public void testErrorException() {
        //标准输出上的东西只要通知我们出错了就行，不需要详细的stack trace
        PrintWriter out = new PrintWriter(System.err,true);
        Logger std_logger = new ErrorMessageLogger(out, writer(out));
        std_logger = ignore(ERROR, std_logger);
        std_logger.printException(new NullPointerException("空指针了"));
    }

    /**
     * 通过命令行来决定log的细节程度，比如只关心WARING 级别以上的信息
     */
    @Test
    public void testLogLevel() {
        Logger logger = sequence(err_log, warning_log, info_log);
        logger = ignore(WARNING, logger);
        logger = timestamp(logger);

        logger.println(INFO, "我是info******");
        logger.println(WARNING, "我是warning&&&&&& ");
        logger.println(ERROR, "ERROR~~~");
        logger.printException(new NullPointerException("空指针了"));
    }
}
