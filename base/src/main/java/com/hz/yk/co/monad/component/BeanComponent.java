package com.hz.yk.co.monad.component;

import com.hz.yk.co.monad.Dependency;

/**
 * Created by wuzheng.yk on 16/12/8.
 */
public class BeanComponent implements Component {
    private  Class type;
    @Override
    public Class getType() {
        return type;
    }

    @Override
    public Object create(Dependency dep) {
        //Object r = createInstance();
        //setJavaBeans(r,dep);
        //具体的实现我省略了很多。因为会调用java.beans的api，并且会有一些caching优化的考虑，但是思路上很清楚，就是对每个property调用getProperty()就是了。
        return null;
    }

    @Override
    public Class verify(Dependency dep) {
        return null;
    }
}
