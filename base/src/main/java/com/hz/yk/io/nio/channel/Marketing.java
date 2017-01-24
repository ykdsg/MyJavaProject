package com.hz.yk.io.nio.channel;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.GatheringByteChannel;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Scatter/Gather会是一个极其强大的工具。它允许您委托操作系统来完成辛苦活：将读取到的数据分开存放到多个存储桶(bucket)或者将不同的数据区块合并成一个整体。这是一个巨大的成就，因为操作系统已经被高度优化来完成此类工作了
 * 。它节省了您来回移动数据的工作，也就避免了缓冲区拷贝和减少了您需要编写、调试的代码数量。既然您基本上通过提供数据容器引用来组合数据，那么按照不同的组合构建多个缓冲区阵列引用，各种数据区块就可以以不同的方式来组合了 Created by
 * wuzheng.yk on 17/1/23.
 */
public class Marketing {

    private static final String DEMOGRAPHIC = "blahblah.txt";

    // "Leverage frictionless methodologies"
    public static void main(String[] argv) throws Exception {
        int reps = 10;
        if (argv.length > 0) {
            reps = Integer.parseInt(argv[0]);
        }
        FileOutputStream fos = new FileOutputStream(DEMOGRAPHIC);
        GatheringByteChannel gatherChannel = fos.getChannel();
        // Generate some brilliant marcom, er, repurposed content
        ByteBuffer[] bs = utterBS(reps);
        // Deliver the message to the waiting market
        while (gatherChannel.write(bs) > 0) {
            // Empty body
            // Loop until write( ) returns zero
        }
        System.out.println("Mindshare paradigms synergized to " + DEMOGRAPHIC);
        fos.close();
    }

    // ------------------------------------------------
    // These are just representative; add your own
    private static String[] col1    = { "Aggregate", "Enable", "Leverage", "Facilitate", "Synergize", "Repurpose",
            "Strategize", "Reinvent", "Harness" };
    private static String[] col2    = { "cross-platform", "best-of-breed", "frictionless", "ubiquitous", "extensible",
            "compelling", "mission-critical", "collaborative", "integrated" };
    private static String[] col3    = { "methodologies", "infomediaries", "platforms", "schemas", "mindshare",
            "paradigms", "functionalities", "web services", "infrastructures" };
    private static String   newline = System.getProperty("line.separator");

    // The Marcom-atic 9000
    private static ByteBuffer[] utterBS(int howMany) throws Exception {
        List<ByteBuffer> list = new LinkedList<>();
        for (int i = 0; i < howMany; i++) {
            list.add(pickRandom(col1, " "));
            list.add(pickRandom(col2, " "));
            list.add(pickRandom(col3, newline));
        }
        ByteBuffer[] bufs = new ByteBuffer[list.size()];
        list.toArray(bufs);
        return (bufs);
    }

    // The communications director
    private static Random rand = new Random();

    // Pick one, make a buffer to hold it and the suffix, load it with
    // the byte equivalent of the strings (will not work properly for
    // non-Latin characters), then flip the loaded buffer so it's ready
    // to be drained

    private static ByteBuffer pickRandom(String[] strings, String suffix) throws Exception {
        String string = strings[rand.nextInt(strings.length)];
        int total = string.length() + suffix.length();
        ByteBuffer buf = ByteBuffer.allocate(total);
        buf.put(string.getBytes("US-ASCII"));
        buf.put(suffix.getBytes("US-ASCII"));
        buf.flip();
        return (buf);
    }
}
