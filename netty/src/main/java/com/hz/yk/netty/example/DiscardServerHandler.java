package com.hz.yk.netty.example;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by wuzheng.yk on 16/10/19.
 */
/*
DiscardServerHandler extends ChannelInboundHandlerAdapter, which is an implementation of ChannelInboundHandler. ChannelInboundHandler provides various event handler methods that you can override. For now, it is just enough to extend ChannelInboundHandlerAdapter rather than to implement the handler interface by yourself.
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter { // (1)

    /*
    We override the channelRead() event handler method here. This method is called with the received message, whenever new data is received from a client. In this example, the type of the received message is ByteBuf.
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
        /*
        A ChannelHandlerContext object provides various operations that enable you to trigger various I/O events and operations. Here, we invoke write(Object) to write the received message in verbatim. Please note that we did not release the received message unlike we did in the DISCARD example. It is because Netty releases it for you when it is written out to the wire.
         */
        ctx.write(msg); // (1)
        ctx.flush(); // (2)
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}