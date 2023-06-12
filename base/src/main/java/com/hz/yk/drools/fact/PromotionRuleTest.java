package com.hz.yk.drools.fact;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by wuzheng.yk on 15/10/28.
 */
public class PromotionRuleTest {
    private KieServices kieServices;
    private KieContainer kieContainer;
    @BeforeAll
    public void setUp() {
        kieServices = KieServices.Factory.get();
        kieContainer = kieServices.getKieClasspathContainer();
    }
    @Test
    public void testOrdinaryPromotion() {
        OrderItem orderItem = new OrderItem();
        orderItem.setPromotionType(OrderItem.PromotionType.ORDINARY);
        orderItem.setQty(125);
        KieSession kSession = kieContainer.newKieSession("ksession-rules");
        kSession.insert(orderItem);
        kSession.fireAllRules();
        kSession.dispose();
        assertThat(orderItem.getRewardQty(), is(12));
    }
    @Test
    public void testStairPromotion() {
        OrderItem orderItem = new OrderItem();
        orderItem.setPromotionType(OrderItem.PromotionType.STAIR);
        orderItem.setQty(15);
        KieSession kSession = kieContainer.newKieSession("ksession-rules");
        kSession.insert(orderItem);
        kSession.fireAllRules();
        kSession.dispose();
        assertThat(orderItem.getRewardQty(), is(4));
    }
}
