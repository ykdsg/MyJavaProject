package com.hz.yk.tcp.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author wuzheng.yk
 * @date 2020/10/5
 */
public class EchoSelectorProtocol implements TcpProtocol {

    private int bufSize; // Size of I/O buffer

    public EchoSelectorProtocol(int bufSize) {
        this.bufSize = bufSize;
    }

    @Override
    public void handleAccept(SelectionKey selectionKey) throws IOException {
        final SocketChannel socketChannel = ((ServerSocketChannel) selectionKey.channel()).accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(selectionKey.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufSize));

    }

    @Override
    public void handleRead(SelectionKey selectionKey) throws IOException {
        final SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        final ByteBuffer buf = (ByteBuffer) selectionKey.attachment();
        int bytesRead = socketChannel.read(buf);
        //如果 read()方法返回-1,则表示底层连接已经关闭,此时需要关闭信道。关闭信道时, 将从选择器的各种集合中移除与该信道关联的键。
        if (bytesRead == -1) {
            socketChannel.close();
        } else if (bytesRead > 0) { //如果接收完数据,将其标记为可写:
            selectionKey.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        }
    }

    @Override
    public void handleWrite(SelectionKey selectionKey) throws IOException {

        final ByteBuffer buf = (ByteBuffer) selectionKey.attachment();

        buf.flip();
        final SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        socketChannel.write(buf);
        if (!buf.hasRemaining()) {
            selectionKey.interestOps(SelectionKey.OP_READ);
        }
        buf.compact();

    }
}
