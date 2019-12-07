package com.hz.yk.io.nio.socketDemos;

import com.hz.yk.io.nio.socketDemos.util.IOUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author wuzheng.yk
 * @date 2019/11/29
 */
public class NioReceiveServer {

    private Charset charset = Charset.forName("UTF-8");

    /**
     * 入口
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        NioReceiveServer server = new NioReceiveServer();
        server.startServer();
    }

    private ByteBuffer buffer = ByteBuffer.allocate(NioDemoConfig.SERVER_BUFFER_SIZE);

    Map<SelectableChannel, Client> clientMap = new HashMap<>();

    public void startServer() throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverChannel.socket();
        InetSocketAddress address = new InetSocketAddress(NioDemoConfig.SOCKET_SERVER_PORT);
        serverSocket.bind(address);

        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("serverChannel is listening..");
        while (selector.select() > 0) {
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey key = it.next();
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel socketChannel = server.accept();
                    if (socketChannel == null) {
                        continue;
                    }
                    socketChannel.configureBlocking(false);
                    SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_READ);
                    Client client = new Client();
                    client.remoteAddress = (InetSocketAddress) socketChannel.getRemoteAddress();
                    clientMap.put(socketChannel, client);
                    System.out.println(client.remoteAddress + "连接成功。。");
                } else if (key.isReadable()) {
                    processData(key);
                }
                it.remove();
            }
        }
    }

    private void processData(SelectionKey key) {
        Client client = clientMap.get(key.channel());
        SocketChannel socketChannel = (SocketChannel) key.channel();
        int num = 0;
        try {
            buffer.clear();
            while ((num = socketChannel.read(buffer)) > 0) {
                buffer.flip();
                //客户端发送过来的，首先是文件名
                if (null == client.fileName) {
                    // 文件名
                    String fileName = charset.decode(buffer).toString();
                    String destPath = IOUtil.getResourcePath(NioDemoConfig.SOCKET_RECEIVE_PATH);
                    File directory = new File(destPath);
                    if (!directory.exists()) {
                        directory.mkdir();
                    }
                    client.fileName = fileName;
                    String fullName = directory.getAbsolutePath() + File.separatorChar + fileName;

                    System.out.println("NIO  传输目标文件：" + fullName);
                    File file = new File(fullName);
                    client.outChannel = new FileOutputStream(file).getChannel();
                } else if (0 == client.fileLength) {
                    client.fileLength = buffer.getLong();
                    client.startTime = System.currentTimeMillis();
                    System.out.println("NIO 传输开始");
                } else {
                    client.outChannel.write(buffer);
                }
                buffer.clear();

            }
            key.cancel();
        } catch (IOException e) {
            key.cancel();
            e.printStackTrace();
            return;
        }
        // 调用close为-1 到达末尾
        if (num == -1) {
            IOUtil.closeQuietly(client.outChannel);
            System.out.println("上传完毕");
            key.cancel();
            System.out.println("文件接收成功,File Name：" + client.fileName);
            System.out.println(" Size：" + IOUtil.getFormatFileSize(client.fileLength));
            long endTime = System.currentTimeMillis();
            System.out.println("NIO IO 传输毫秒数：" + (endTime - client.startTime));
        }
    }

    static class Client {

        String fileName;
        long fileLength;
        long startTime;
        InetSocketAddress remoteAddress;
        FileChannel outChannel;
    }
}
