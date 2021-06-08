package com.hz.yk.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author wuzheng.yk
 * @date 2021/6/8
 */
public class DroolsUtil {

    public static KieSession getSession(String sessionName) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        return kc.newKieSession(sessionName);
    }
}
