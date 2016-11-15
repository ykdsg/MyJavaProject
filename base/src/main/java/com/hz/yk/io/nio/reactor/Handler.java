package com.hz.yk.io.nio.reactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * @author wuzheng.yk
 *         Date: 14-8-9
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
        // Optionally try first read now
        selectionKey = socketChannel.register(se1, 0);
        selectionKey.attach(this);  //将Handler作为callback对象
        selectionKey.interestOps(SelectionKey.OP_READ); //第二步,接收Read事件
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
            // Normally also do first write now
            selectionKey.interestOps(SelectionKey.OP_WRITE);//第三步,接收write事件
        }
    }

    void send() throws IOException {
        socketChannel.write(output);
        if (outputIsComplete()) {
            selectionKey.cancel();//write完就结束了, 关闭select key
        }
    }

    class Sender implements Runnable {
        public void run(){ // ...
            try {
                socketChannel.write(output);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (outputIsComplete()) selectionKey.cancel();
        }
    }
}
