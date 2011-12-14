package yk.concurrent.frame;

/**
 * Created by IntelliJ IDEA.
 * User: yangke
 * Date: 11-8-21
 * Time: 下午2:41
 * To change this template use File | Settings | File Templates.
 */
public class ServiceProxy implements Service {
    public ServiceProxy() {
        _service = new ServiceImp();
        //这里就启动了线程监听队列
        _active_object = new ActiveObject();
    }

    public void sayHello() {
        MethodRequest mr = new SayHello(_service);
        _active_object.enqueue(mr);
    }

    private Service _service;
    private ActiveObject _active_object;
}