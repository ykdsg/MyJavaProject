package com.hz.yk.jmx;

/**
 * MXBean 规定了标准 MBean 也要实现一个接口，所有向外界公开的方法都要在这个接口中声明。否则，管理系统就不能从中获得相应的信息。此外，该接口的名字也有一定的规范：即在标准 MBean 类名之后加上“MBean”后缀。若
 * MBean 的类名叫做 MBeansName 的话，对应的接口就要叫做 MBeansNameMBean
 * Created by wuzheng.yk on 2017/12/1.
 */
public interface ServerMonitorMBean {

    long getUpTime();
}
