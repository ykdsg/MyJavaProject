package com.hz.yk.tcp.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

/**
 * @author wuzheng.yk
 * @date 2020/10/5
 */
public class TcpServerSeclector {

    private static final int BUFSIZE = 256;
    private static final int TIMEOUT = 3000;

    public static void main(String[] args) throws IOException {
        int port = 9088;
        final Selector selector = Selector.open();
        final ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        TcpProtocol protocol = new EchoSelectorProtocol(BUFSIZE);
        while (true) {
            if (selector.select(TIMEOUT) == 0) {
                System.out.println(".");
                continue;
            }
            final Iterator<SelectionKey> selectionKeyIterator = selector.selectedKeys().iterator();

            while (selectionKeyIterator.hasNext()) {
                final SelectionKey selectionKey = selectionKeyIterator.next();
                if (selectionKey.isAcceptable()) {
                    protocol.handleAccept(selectionKey);
                }
                if (selectionKey.isReadable()) {
                    protocol.handleRead(selectionKey);
                }
                if (selectionKey.isWritable()) {
                    protocol.handleWrite(selectionKey);
                }
                //由于 select()操作只是向 Selector 所关联的键集合中添加元素, 因此, 如果不移除每个处理过的键,它就会在下次调用 select()方法是仍然保留在集合中,而且可能会有无用的操作来调用它。
                selectionKeyIterator.remove(); // remove from set of selected keys
            }
        }

    }
}
