package com.hz.yk.co.rule;

import com.hz.yk.co.Logger;
import com.hz.yk.co.factory.Factory;

/**
 * 这个"在行首打印一些前缀"就成了一个可以抽象出来的共性
 * Created by wuzheng.yk on 2018/5/2.
 */
public class PrefixLogger implements Logger {

    private final Logger  logger;
    private final Factory factory;
    private       boolean freshline = true;

    /**
     * Factory接口用来抽象往行首打印的前缀。这个地方之所以不是一个String，是因为考虑到生成这个前缀可能是比较昂贵的（比如打印行号，这需要创建一个临时异常对象）
     *
     * @param logger
     * @param factory
     */
    public PrefixLogger(Logger logger, Factory factory) {
        this.logger = logger;
        this.factory = factory;
    }

    private void prefix(int lvl) {
        if (freshline) {
            String r = factory.create();
            if (r != null) {
                logger.print(lvl, r);
            }
            freshline = false;
        }
    }

    @Override
    public void print(int lvl, String s) {
        prefix(lvl);
        logger.print(lvl, s);
    }

    @Override
    public void println(int lvl, String s) {
        prefix(lvl);
        logger.println(lvl, s);
        freshline = true;
    }

    @Override
    public void printException(int level, Throwable e) {
        prefix(level);
        logger.printException(level, e);
        freshline = true;
    }

}
