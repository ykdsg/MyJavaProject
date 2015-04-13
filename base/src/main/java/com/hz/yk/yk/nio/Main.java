package com.hz.yk.yk.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;

/**
 * @author yangke
 *         Date: 11-12-14
 *         Time: 下午9:58
 */
public class Main {


    public static void main(String[] args) throws IOException {
        //        首先创建一个Selector，在NIO中SelectorProvider提供Selector。
        Selector socketSelector = SelectorProvider.provider().openSelector();
        //        创建一个服务器套接字通道,并将通道配置成非阻塞型
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.configureBlocking(false);
        //        （iii）将服务器套接字通道关联的套接字绑定到指定的地址
        InetSocketAddress address = new InetSocketAddress("localhost", 9999);
        serverChannel.socket().bind(address);
        //        （iv）将服务器套接字通道注册到Selector中，并且指定它关联的套接字处理什么状态时通知它。对于服务器套接字通道关联的服务器套接字只有一种状态：即OP_ACCEPT状态。
        serverChannel.register(socketSelector, SelectionKey.OP_ACCEPT);

        while (true) {
            socketSelector.select();
            Iterator selectedKeys = socketSelector.selectedKeys().iterator();
            while (selectedKeys.hasNext()) {
                SelectionKey key = (SelectionKey) selectedKeys.next();
                selectedKeys.remove();
                if (key.isAcceptable()) {//服务器套接字收到客户请求，此时只可能是服务器套接字
                    //取出key对应的Channel，取出Channel对应的服务器套接字通道对应的服务器套
                    //接字，然后调用此服务器套接字的accept（）与客户建立连接，将accept()返
                    //回的套接字注册到Selector中，以便在该套接字有数据时读取时再让Selector
                    //通道应用程序
                } else if (key.isReadable()) {//套接字作好了数据读取准备
                    //从key中取出对应的Channel，使用Channel读取数据，在前面已经讨论过
                } else if (key.isWritable()) {//套接字作好了数据写入准备
                    //从key中取出对应的Channel,使用Channel写入数据，在前面已经讨论过
                }
            }
        }


    }


}
