package com.hz.yk.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * @author yangke
 *         Date: 12-8-30
 *         Time: обнГ5:28
 */
public class ClientHandler extends IoHandlerAdapter {
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        Message m = (Message) message;
        System.out.println(m.getId() + " " + m.getContent() + " " + m.getDate());
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        session.close(true);
    }

}
