package com.hz.yk.co;

import com.hz.yk.co.rule.ErrorMessageLogger;

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
 * Created by wuzheng.yk on 16/12/2.
 */
public class Main {
    //代码特定的文件
    private static PrintWriter err_writer = new PrintWriter(System.err);
    private static PrintWriter warning_writer = new PrintWriter(System.out);
    private static PrintWriter info_writer = new PrintWriter(System.out);

    public static void main(String[] args) {
        //表示不同的log文件
        Logger err_log = writer(err_writer);
        Logger warning_log = writer(warning_writer);
        Logger info_log = writer(info_writer);

        //各个文件记录不同重要程度的信息
        err_log = LoggerFacade.filter(ERROR, err_log, nop());
        warning_log = LoggerFacade.filter(WARNING, warning_log, nop());
        info_log = LoggerFacade.filter(INFO, info_log, nop());

        //把三个不同的logger串联起来
        Logger logger = sequence(err_log, warning_log, info_log);

        //每条logging信息同时打印当前的系统时间
        logger = timestamp(logger);

        //能够在标准错误输出上直接看见错误，普通的信息可以打印到log文件中，对错误信息，我们希望log文件和标准输出上都有
        Logger std_logger = writer(new PrintWriter(System.err));
        std_logger = ignore(ERROR, std_logger);
        logger = sequence(std_logger, logger);

        //标准输出上的东西只要通知我们出错了就行，不需要详细的stack trace
        PrintWriter out = new PrintWriter(System.err);
        std_logger = new ErrorMessageLogger(out, writer(out));
        std_logger = ignore(ERROR, std_logger);
    }
}
