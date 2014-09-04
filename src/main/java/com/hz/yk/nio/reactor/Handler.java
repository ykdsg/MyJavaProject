package com.hz.yk.nio.reactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * @author wuzheng.yk
 *         Date: 14-8-9
 *         Time: ÏÂÎç5:09
 */
public class Handler implements Runnable {
    final SocketChannel socketChannel;
    final SelectionKey selectionKey;

    ByteBuffer input = ByteBuffer.allocate(10000);
    ByteBuffer output = ByteBuffer.allocate(10000);

    static final int READING = 0, SENDING = 1;
    int state = READING;

    Handler(Selector se1, SocketChannel c) throws IOException {
        socketChannel = c;
        c.configureBlocking(false);
        selectionKey = socketChannel.register(se1, 0);
        selectionKey.attach(this);
        selectionKey.interestOps(SelectionKey.OP_READ);
        se1.wakeup();
    }

    boolean inputIsComplete() { /* ... */
        return false;
    }

    boolean outputIsComplete() { /* ... */
        return false;
    }

    void process() { /* ... */ }

    @Override
    public void run() {
        try {
            if (state == READING)
                read();
            else if (state == SENDING)
                send();
        } catch (IOException ex) { /* ... */ }
    }

    void read() throws IOException {
        socketChannel.read(input);
        if (inputIsComplete()) {
            process();
            state = SENDING;
            // Normally also do first write now sk.interestOps(SelectionKey.OP_WRITE);
        }
    }

    void send() throws IOException {
        socketChannel.write(output);
        if (outputIsComplete())
            selectionKey.cancel();
    }
}
