package com.hz.yk.interrupt;


import sun.nio.ch.Interruptible;

/**
 * @author ykdsg
 *         Date: 11-11-4
 *         Time: 下午10:17
 *         To change this template use File | Settings | File Templates.
 */
abstract class InterruptSupport implements InterruptAble {

    private volatile boolean interrupted = false;
    private Interruptible interruptor = new Interruptible() {
<<<<<<< HEAD
        public void interrupt(Thread thread) {
=======
        @Override
        public void interrupt() {
>>>>>>> 8e1a9339994054d4b9b34fddd3168f0d9e3edfb4
            interrupted = true;
            //定义了Interruptible事件钩子的处理方法，回调InterruptSupport.this.interrupt()方法，
            // 子类可以集成实现自己的业务逻辑，比如sock流关闭等等。
            InterruptSupport.this.interrupt(); // 位置3
        }
    };

    public final boolean execute() throws InterruptedException {
        try {
            //利用sun提供的blockedOn方法，绑定对应的Interruptible事件处理钩子到指定的Thread上。
            blockedOn(interruptor); // 位置1
            if (Thread.currentThread().isInterrupted()) { // 立马被interrupted
                interruptor.interrupt(Thread.currentThread());
            }
            // 执行业务代码
            bussiness();
        } finally {
            //执行完代码后，清空钩子。避免使用连接池时，对下一个Thread处理事件的影响。
            blockedOn(null);   // 位置2
        }

        return interrupted;
    }

    public abstract void bussiness();

    public abstract void interrupt();

    // -- sun.misc.SharedSecrets --
    static void blockedOn(Interruptible intr) { // package-private
        sun.misc.SharedSecrets.getJavaLangAccess().blockedOn(Thread.currentThread(), intr);
    }
}
