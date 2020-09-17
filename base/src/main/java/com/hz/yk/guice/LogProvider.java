package com.hz.yk.guice;

import com.google.inject.Provider;

/**
 * 如果项目中存在多个比较复杂的对象需要构建，使用@Provide方法会让配置类变得比较乱。我们可以使用Guice提供的Provider接口将复杂的代码放到单独的类中，有点像spring中的FactoryBean
 *
 * @author wuzheng.yk
 * @date 2020/9/2
 */
public class LogProvider implements Provider<ILog> {

    @Override
    public ILog get() {
        return new ConsoleLog();
    }
}
