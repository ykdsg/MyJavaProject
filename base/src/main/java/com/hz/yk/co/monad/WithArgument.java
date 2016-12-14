package com.hz.yk.co.monad;

import com.hz.yk.co.monad.component.Component;

import static com.hz.yk.co.monad.Util.checkTypeMatch;

/**
 * Created by wuzheng.yk on 16/12/8.
 */
public class WithArgument implements Component {
    private final Component parent;
    private final int pos;
    private final Component arg;

    public WithArgument(Component parent, int pos, Component arg) {
        this.parent = parent;
        this.pos = pos;
        this.arg = arg;
    }

    @Override
    public Class getType() {
        return null;
    }

    @Override
    public Object create(Dependency dep) {
        return parent.create(withArg(dep));
    }

    @Override
    public Class verify(Dependency dep) {
        return parent.verify(withArg(dep));
    }

    private Dependency withArg(final Dependency dep){
        return new Dependency() {
            @Override
            public Object getArgument(int i, Class type) {
                if(i==pos){
                    checkTypeMatch(type, arg.getType());
                    return arg.create(dep);
                }
                else {
                    return dep.getArgument(i, type);
                }
            }

            @Override
            public Object getProperty(Object key, Class type) {
                return null;
            }

            @Override
            public Class verifyArgument(int i, Class type) {
                return null;
            }

            @Override
            public Class verifyProperty(Object key, Class type) {
                return null;
            }
        };
    }
}
