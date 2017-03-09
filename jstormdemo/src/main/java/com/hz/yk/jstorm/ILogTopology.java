package com.hz.yk.jstorm;

import backtype.storm.generated.AlreadyAliveException;
import backtype.storm.generated.InvalidTopologyException;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by wuzheng.yk on 17/3/6.
 */
public interface ILogTopology {

    public void start(Properties properties) throws AlreadyAliveException, InvalidTopologyException,
                                            InterruptedException, IOException;

}
