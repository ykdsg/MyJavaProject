package com.hz.yk.co;

import com.hz.yk.co.combinator.NopLogger;
import com.hz.yk.co.combinator.WriterLogger;
import com.hz.yk.co.rule.EqualLogger;
import com.hz.yk.co.rule.IgnoringLogger;
import com.hz.yk.co.rule.SequenceLogger;
import com.hz.yk.co.rule.TimestampLogger;

import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * 为了避免写一大堆的new和冗长的类名字，我们做一个facade类，来提供简短点的名字
 * Created by wuzheng.yk on 16/12/2.
 */
public class LoggerFacade {
    public static Logger nop(){return new NopLogger();}
    public static Logger writer(PrintWriter writer){
        return new WriterLogger(writer);
    }
    public static Logger writer(OutputStream out){
        return writer(new PrintWriter(out, true));
    }
    public static Logger filter(int lvl, Logger l1, Logger l2){
        return new EqualLogger(lvl,l1, l2);
    }

    public static Logger ignore(int lvl, Logger l1) {
        return new IgnoringLogger(lvl, l1, nop());
    }


    public static Logger timestamp(Logger l1) {
        return new TimestampLogger(l1);
    }

    public static Logger sequence(Logger... loggers) {
        return new SequenceLogger(loggers);
    }
}
