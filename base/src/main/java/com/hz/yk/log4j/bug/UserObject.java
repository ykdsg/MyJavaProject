package com.hz.yk.log4j.bug;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;
import java.util.Hashtable;

public class UserObject implements ObjectFactory {

    static {
        System.out.println("i am a shell script !!!");
    }

    @Override
    public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment)
            throws Exception {
        return null;
    }
}
