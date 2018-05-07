package com.hz.yk.co;

import com.hz.yk.co.combinator.NopLogger;
import com.hz.yk.co.combinator.WriterLogger;
import com.hz.yk.co.factory.ConcatFactory;
import com.hz.yk.co.factory.Factory;
import com.hz.yk.co.factory.ReturnFactory;
import com.hz.yk.co.factory.SourceLocationFormat;
import com.hz.yk.co.factory.TimestampFactory;
import com.hz.yk.co.factory.TraceBackFactory;
import com.hz.yk.co.factory.impl.SourceLocationFormatImpl;
import com.hz.yk.co.rule.FilterLogger;
import com.hz.yk.co.rule.IgnoringLogger;
import com.hz.yk.co.rule.PrefixLogger;
import com.hz.yk.co.rule.SequenceLogger;
import com.hz.yk.co.rule.TimestampLogger;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * 为了避免写一大堆的new和冗长的类名字，我们做一个facade类，来提供简短点的名字
 * Created by wuzheng.yk on 16/12/2.
 */
public class LoggerFacade {
    static DateFormat some_date_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static SourceLocationFormat some_location_format = new SourceLocationFormatImpl();

    public static Logger nop(){return new NopLogger();}
    public static Logger writer(PrintWriter writer){
        return new WriterLogger(writer);
    }
    public static Logger writer(OutputStream out){
        return writer(new PrintWriter(out, true));
    }
    public static Logger filter(int lvl, Logger l1, Logger l2){
        return new FilterLogger(lvl,l1, l2);
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

    public static Logger myprefix(Logger l){
        Factory timestamp = new TimestampFactory(some_date_format);
        Factory traceback = new TraceBackFactory(some_location_format);
        Factory both = new ConcatFactory(
                timestamp,
                new ReturnFactory(" - "),
                traceback,
                new ReturnFactory(" : ")
        );
        return new PrefixLogger(l, both);
    }

}
