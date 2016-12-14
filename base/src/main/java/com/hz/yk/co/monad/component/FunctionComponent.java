package com.hz.yk.co.monad.component;

import com.hz.yk.co.monad.Dependency;
import com.hz.yk.co.monad.Function;

import static com.hz.yk.co.monad.Util.checkTypeMatch;

/**
 * Created by wuzheng.yk on 16/12/8.
 */
public class FunctionComponent implements Component{
    private  Function f;
    @Override
    public Class getType() {
        return f.getReturnType();
    }

    @Override
    public Object create(Dependency dep) {
        final Class[] types = f.getParameterTypes();
        final Object[] args = new Object[types.length];
        for (int i = 0; i < types.length; i++) {
            args[i] = dep.getArgument(i, types[i]);

        }
        return f.call(args);
    }

    @Override
    public Class verify(Dependency dep) {
        final Class[] types = f.getParameterTypes();
        for(int i=0;i<types.length;i++) {
            Class arg_type = dep.verifyArgument(i,  types[i]);
            checkTypeMatch(types[i], arg_type);
        }
        return f.getReturnType();
    }
}
