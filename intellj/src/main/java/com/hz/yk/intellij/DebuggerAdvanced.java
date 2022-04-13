package com.hz.yk.intellij;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;








/**
 * <h1>Debugger 高级技巧</h1>
 *
 * @author wuzheng.yk
 * @date 2022/4/7
 */
public class DebuggerAdvanced {

    
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * <h1>Breakpoints dialog(cmd+shift+F8)</h1>
     * <ul>
     *     <li><font size=6>自定义分组管理-统一开关</font></li>
     *     <li><font size=6>增加注释</font></li>
     * </ul>
     */
    int slide1;

    @Test
    public void breakPointsDialog() throws InterruptedException {

        System.out.println("step1");
        Thread.sleep(500);
        System.out.println("step2");
        Thread.sleep(500);
        System.out.println("end");

    }

    
    
    
    
    /**
     * <h1>Breakpoints types</h1>
     * <ul>
     *     <li><font size=6>行断点-最常用的断点</font></li>
     *     <li><font size=6>字段断点</font>
     *      <ul>
     *          <li><font size=5>监测字段读写-对于集合和对象来说需要更关注读</font></li>
     *      </ul>
     *     </li>
     *     <li><font size=6>方法断点</font>
     *      <ul>
     *          <li><font size=5>监测方法进入、离开</font></li>
     *          <li><font size=5>在interface上特别好用</font></li>
     *      </ul>
     *      </li>
     *     <li><font size=6>异常断点</font></li>
     * </ul>
     */
    int slide2;

    
    
    
    
    
    
    
    
    public static class BreakPointsType {

        public List<String> strList;

        public void initList() {
            strList = new ArrayList<>();
        }

        public void printList() {
            System.out.println("strList = " + strList);
        }

        /**
         * <h1>字段断点</h1>
         */
        @Test
        public void fieldBreakpoint() {
            BreakPointsType breakPointsType = new BreakPointsType();
            breakPointsType.initList();
            breakPointsType.strList.add("2");
            breakPointsType.printList();
        }
        
        
        
        
        
        
        
        

        /**
         * <h1>方法断点</h1>
         */
        @Test
        public void methodBreakPoint() {
            SuperI superI = new Son();
            superI.method1();

        }

        interface SuperI {

            void method1();
        }

        static class Son implements SuperI {

            @Override
            public void method1() {
                System.out.println("son print ....");
                System.out.println("end...");
            }
        }

        
        
        
        
        
        
        /**
         * <h1>异常断点</h1>
         * <ul>
         *     <li><font size=5>在BreakPoints 对话框中新建对应类型的异常断点</font> </li>
         *     <li><font size=5>一般情况下需要配合filter 使用</font></li>
         * </ul>
         */
        @Test
        public void exceptionBreakPoint() {
            try {
                int i = 9, j = 0;
                System.out.println(i / j);
            } catch (Exception e) {
                System.err.println(e);
            }
        }

    }
    
    
    
    

    /**
     * <h1>Breakpoints suspend</h1>
     * <ul>
     *     <li><font size=6>无阻塞断点</font>
     *     <li><font size=6>All</font></li>
     *     <li><font size=6>Thread</font></li>
     * </ul>
     */
    int slide3;

    
    
    
    
    /**
     * <h1>无阻塞断点 </h1>
     *  <ul>
     *      <li><font size=5>临时增加日志</font></li>
     *      <li><font size=5>结合表达式，作为后续断点的触发器</font></li>
     *      <li><font size=5>利用表达式，完成各种匪夷所思的事情</font></li>
     *  </ul>
     * 
     *
     * @throws InterruptedException
     */
    public static class BreadkPointsSettings {

        @Test
        public void testBreadkpointSuspend() throws InterruptedException {
            for (int i = 0; i < 50; i++) {
                work();
            }
        }

        public void work() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("current time " + new Date());
        }

    }

    
    
    /**
     * <h1>Suspend All VS  Thread<h1/>
     * <h3>* 在多线程调试的时候，可以在run config 界面中设置Repet为"until Failure"</h2>
     */
    public static class ConcurrencyTest {

        @Test
        public void test() throws InterruptedException {
            final List<Integer> list = work();
            Assert.assertEquals(1, list.size());
        }

        static List<Integer> work() throws InterruptedException {
            final List<Integer> list = Collections.synchronizedList(new ArrayList<>());
            Thread thread = new Thread(() -> addIfAbsent(list, 17));
            thread.start();
            addIfAbsent(list, 17);
            thread.join();
            System.out.println("Elements:" + list);
            return list;
        }

        private static void addIfAbsent(List<Integer> list, int x) {
            synchronized (list) {
                if (!list.contains(x)) {
                    list.add(x);
                }
            }

        }

    }

    /**
     * <h1>Breakpoints 运行时技巧</h1>
     * <ul>
     *     <li><font size=6>Drop Frame-返回调用栈的上一层</font>
     *     <ul>
     *         <li><font size=5>在环境拉起成本高的场景能够顾提升效率</font></li>
     *     </ul>
     *     <li><font size=6>Force Return</font>
     *      <ul>
     *          <li><font size=5>避免走后续的流程</font></li>
     *          <li><font size=5>让代码按照想要的结果返回</font></li>
     *      </ul>
     *      </li>
     *     <li><font size=6>Throw Exception-模拟抛出异常</font></li>
     *     <li><font size=6>Run to Cursor-运行到你想要的位置</font></li>
     * </ul>
     */
    int slide4;

    public static class BreakpointsStep {

        public static void main(String[] args) throws IOException {
            while (true) {
                int read = System.in.read();
                System.out.println("Input:" + read);
                if (filter(read)) {
                    process(read);
                }
            }
        }

        private static boolean filter(int read) {
            return read != '\n' && read != 'a';
        }

        private static void process(int arg) {
            arg = arg * 2;
            arg += 4;
            if (arg > 1) {
                arg = Math.max(arg, 10);
            }
            if (Math.max(arg, 90) % 2 == 0) {
                System.out.println("!");
            }
        }

    }

    
    
    
    
    
    
    
    /**
     * <h1>The End </h1>
     * <ul>
     *     <li><font size=6>工具是圣衣</font></li>
     *     <li><font size=6>技巧是招式</font></li>
     *     <li><font size=6>但是最重要的是...</font></li>
     * </ul>
     */
    int slide5;

    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * <h1>Thank you</h1>
     * <ul>
     *     <li><font size=6>Now you can debugger much better</font></li>
     * </ul>
     */
    int questions;
    
    
    
    
    
    
    
    
    
}


