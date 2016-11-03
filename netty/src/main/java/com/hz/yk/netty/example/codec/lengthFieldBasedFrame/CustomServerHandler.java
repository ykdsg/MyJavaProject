package com.hz.yk.netty.example.codec.lengthFieldBasedFrame;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by wuzheng.yk on 16/11/3.
 */
public class CustomServerHandler extends SimpleChannelInboundHandler<Object> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof CustomMsg) {
            CustomMsg customMsg = (CustomMsg) msg;
            System.out.println("Client->Server:" + ctx.channel().remoteAddress() + " send " + customMsg.getBody());
        }

    }
}
