package com.hz.yk.thread.groboutils;

import com.google.common.collect.Lists;
import com.hz.yk.reactor.price.PriceSourceMaterials;
import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
import net.sourceforge.groboutils.junit.v1.TestRunnable;
import org.junit.Test;

import java.util.List;

import static com.hz.yk.reactor.price.PriceMaterialsMain.calcPriceSourceMaterials;

/**
 * @author wuzheng.yk
 * @date 2019/10/10
 */
public class ParallncReactorTest {

    int tSize = 100;

    boolean runFlag = true;

    @Test
    public void testInc() throws Throwable {
        while (runFlag) {
            batchOperation();
        }
    }

    private void batchOperation() throws Throwable {
        TestRunnable[] tcs = new TestRunnable[tSize];

        List<PriceSourceMaterials> resultList = Lists.newArrayList();
        for (int i = 0; i < tSize; i++) {

            int tag = i;
            TestRunnable runnable = new TestRunnable() {

                @Override
                public void runTest() throws Throwable {
                    PriceSourceMaterials priceSourceMaterials = calcPriceSourceMaterials();
                    priceSourceMaterials.setTag(tag);
                    resultList.add(priceSourceMaterials);
                }
            };
            tcs[i] = runnable;
        }
        int threadCount = tcs.length;

        MultiThreadedTestRunner mttr = new MultiThreadedTestRunner(tcs);
        mttr.runTestRunnables();
        //assertEquals(threadCount, resultList.size());
        for (PriceSourceMaterials result : resultList) {
            System.out.println("==============cost:" + result.getCostTime());

            if (result.getCostTime() > 5000L) {
                runFlag = false;
                System.out.println("==============cost long :" + result.getCostTime());
            }
        }
        System.out.println("*********end");
    }
}
