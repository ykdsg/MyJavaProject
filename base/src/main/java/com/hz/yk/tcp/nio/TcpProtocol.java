package com.hz.yk.tcp.nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;

/**
 * @author wuzheng.yk
 * @date 2020/10/5
 */
public interface TcpProtocol {

    void handleAccept(SelectionKey selectionKey) throws IOException;

    void handleRead(SelectionKey selectionKey) throws IOException;

    void handleWrite(SelectionKey selectionKey) throws IOException;
}
