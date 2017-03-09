package com.hz.yk.jstorm;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wuzheng.yk on 17/3/6.
 */
public class TestSpout extends BaseRichSpout {
    private static final Logger log = LoggerFactory.getLogger(TestSpout.class);
    
    private static final long serialVersionUID = 1L;
    static AtomicInteger sAtomicInteger = new AtomicInteger(0);
    static AtomicInteger pendNum = new AtomicInteger(0);
    private int sqnum;
    SpoutOutputCollector collector;


    @Override
    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        sqnum = sAtomicInteger.incrementAndGet();
        this.collector = collector;
    }

    @Override
    public void nextTuple() {
        while (true) {
            int a = pendNum.incrementAndGet();
            log.info(String.format("spount %d,pendNum %d", sqnum, a));
            this.collector.emit(new Values("xxxxx:"+a));
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                log.error("[TestSpout-nextTuple]error", e);
            }
        }

    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("log"));
    }

    /**
     * 启用 ack 机制，详情参考：https://github.com/alibaba/jstorm/wiki/Ack-%E6%9C%BA%E5%88%B6
     * @param msgId
     */
    @Override
    public void ack(Object msgId) {
        super.ack(msgId);
    }

    /**
     * 消息处理失败后需要自己处理
     * @param msgId
     */
    @Override
    public void fail(Object msgId) {
        super.fail(msgId);
        log.info("ack fail,msgId"+msgId);
    }



}
