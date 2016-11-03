package com.hz.yk.netty.example.codec.lengthFieldBasedFrame;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * Created by wuzheng.yk on 16/11/3.
 */
public class CustomServer {
    private static final int MAX_FRAME_LENGTH = 1024 * 1024;
    /**
     * LENGTH_FIELD_LENGTH指的就是我们这边CustomMsg中length这个属性的大小，我们这边是int型，所以是4
     */
    private static final int LENGTH_FIELD_LENGTH = 4;
    /**
     * LENGTH_FIELD_OFFSET指的就是我们这边length字段的起始位置，因为前面有type和flag两个属性，且这两个属性都是byte，两个就是2字节，所以偏移量是2
     */
    private static final int LENGTH_FIELD_OFFSET = 2;
    /**
     * LENGTH_ADJUSTMENT指的是length这个属性的值，假如我们的body长度是40，有时候，有些人喜欢将length写成44，因为length本身还占有4个字节，这样就需要调整一下，那么就需要-4，我们这边没有这样做，所以写0就可以了
     */
    private static final int LENGTH_ADJUSTMENT = 0;
    private static final int INITIAL_BYTES_TO_STRIP = 0;

    private int port;

    public CustomServer(int port) {
        this.port = port;
    }

    public void start(){
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap sbs = new ServerBootstrap().group(bossGroup,workerGroup).channel(NioServerSocketChannel.class).localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new CustomDecoder(MAX_FRAME_LENGTH,LENGTH_FIELD_LENGTH,LENGTH_FIELD_OFFSET,LENGTH_ADJUSTMENT,INITIAL_BYTES_TO_STRIP,false));
                            ch.pipeline().addLast(new CustomServerHandler());
                        };

                    }).option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            // 绑定端口，开始接收进来的连接
            ChannelFuture future = sbs.bind(port).sync();

            System.out.println("Server start listen at " + port );
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        } else {
            port = 8080;
        }
        new CustomServer(port).start();
    }
}
