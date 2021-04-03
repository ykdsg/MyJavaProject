package com.hz.yk.io.nio.practice;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

/**
 * 《Java NIO》 书中的例子，书感觉非常一般，大段的概念对初学者非常不友好，缺少实例
 *
 * @author wuzheng.yk
 * @date 2021/4/2
 */
public class SelectSockets {

    public static int PORT = 1234;

    public void go() throws IOException {
        final ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(PORT));
        serverSocketChannel.configureBlocking(false);

        final Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            int n = selector.select();
            if (n == 0) {
                continue;
            }
            final Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()) {
                final SelectionKey selectionKey = it.next();
                if (selectionKey.isAcceptable()) {
                    final ServerSocketChannel serverChannel = (ServerSocketChannel) selectionKey.channel();
                    final SocketChannel socketChannel = serverChannel.accept();
                    registerChannel(selector, socketChannel, SelectionKey.OP_READ);
                    sayHello(socketChannel);
                }
                if (selectionKey.isReadable()) {
                    readDataFromSocket(selectionKey);
                }
                it.remove();
            }
        }
    }

    private void sayHello(SocketChannel channel) throws IOException {
        buffer.clear();
        buffer.put("hi there \r\n".getBytes(StandardCharsets.UTF_8));
        buffer.flip();
        channel.write(buffer);
    }

    private void registerChannel(Selector selector, SocketChannel channel, int ops) throws IOException {
        if (channel == null) {
            return;
        }
        channel.configureBlocking(false);
        channel.register(selector, ops);
    }

    private ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

    void readDataFromSocket(SelectionKey key) throws IOException {
        final SocketChannel socketChannel = (SocketChannel) key.channel();
        int count;
        buffer.clear();
        while ((count = socketChannel.read(buffer)) > 0) {
            buffer.flip();
            //书上中指出这样的写法并不好，写入数据到读数据的channel
            while (buffer.hasRemaining()) {
                socketChannel.write(buffer);
            }
        }
    }
}
