package yk.concurrent.frame;

/**
 * Created by IntelliJ IDEA.
 * User: yangke
 * Date: 11-8-21
 * Time: 下午2:55
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {
        /*
        并发逻辑增加前，对于sayHello服务的调用方法
         */
//        Service s = new ServiceImp();
//        Client c = new Client(s);
//        c.requestService();

        /*
        并发逻辑增加后，对于sayHello服务的调用方法
         */
        Service s = new ServiceProxy();
        Client c = new Client(s);
        c.requestService();
    }
}
