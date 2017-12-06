package com.hz.yk.jmx;

/**
 * 使用一个标准 MBean，ServerMonitor 来监控 ServerImpl
 * Created by wuzheng.yk on 2017/12/1.
 */
public class ServerMonitor  implements ServerMonitorMBean{
    private final ServerImpl target;
    public ServerMonitor(ServerImpl target){
        this.target = target;
    }
    public long getUpTime(){
        return System.currentTimeMillis() - target.startTime;
    }
}
