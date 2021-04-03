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
 * @author wuzheng.yk
 * @date 2021/3/30
 */
public class NioServer {

    static int PORT = 8348;
    static int TIMEOUT = 3000;
    private static ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

    public static void main(String[] args) throws IOException {
        new NioServer().go();

    }

    public void go() throws IOException {
        final ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(PORT));
        serverSocketChannel.configureBlocking(false);
        final Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            if (selector.select(TIMEOUT) == 0) {
                System.out.println(".");
                continue;
            }
            final Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
            while (keyIterator.hasNext()) {
                final SelectionKey selectionKey = keyIterator.next();
                //获取之后需要删掉对应的的记录，否则下次还会在迭代器中
                keyIterator.remove();
                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel serverChannel = (ServerSocketChannel) selectionKey.channel();
                    final SocketChannel socketChannel = serverChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    buffer.clear();
                    buffer.put("hello from server!\r\n".getBytes(StandardCharsets.UTF_8));
                    buffer.flip();
                    socketChannel.write(buffer);
                }
                if (selectionKey.isReadable()) {
                    readDataFromSocket(selectionKey);
                }
            }
        }
    }

    private void readDataFromSocket(SelectionKey selectionKey) throws IOException {
        final SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        buffer.clear();
        int count = 0;
        while ((count = socketChannel.read(buffer)) > 0) {
            System.out.println(buffer.getChar());
        }

    }

}
