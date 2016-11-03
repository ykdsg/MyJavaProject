package com.hz.yk.netty.example.codec.lengthFieldBasedFrame;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.Charset;

/**
 * Created by wuzheng.yk on 16/11/3.
 */
public class CustomEncoder extends MessageToByteEncoder<CustomMsg> {

    @Override
    protected void encode(ChannelHandlerContext ctx, CustomMsg msg, ByteBuf out) throws Exception {
        if(null == msg){
            throw new Exception("msg is null");
        }

        String body = msg.getBody();
        byte[] bodyBytes = body.getBytes(Charset.forName("utf-8"));
        out.writeByte(msg.getType());
        out.writeByte(msg.getFlag());
        out.writeInt(bodyBytes.length);
        out.writeBytes(bodyBytes);

    }
}
