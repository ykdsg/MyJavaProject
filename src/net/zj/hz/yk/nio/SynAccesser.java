package net.zj.hz.yk.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class SynAccesser {
	static FileChannel fc;

	public static void main(String args[]) throws Exception {
		final int capacity = 0x800; // 2K
		fc = new RandomAccessFile("test.txt", "rw").getChannel();
		MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0,
				capacity);
		for (int i = 0; i < capacity / 2; i++)
			mbb.put((byte) 'a');
		for (int i = capacity / 2; i < capacity; i++)
			mbb.put((byte) 'c');

		new Modifier(mbb, 0, capacity / 2);
		new Modifier(mbb, capacity / 2, capacity);
	}

	// 对文件部分区域加锁并且修改文件
	static class Modifier extends Thread {
		private ByteBuffer buff;
		private int start, end;

		Modifier(ByteBuffer mbb, int start, int end) {
			this.start = start;
			this.end = end;
			mbb.limit(end);
			mbb.position(start);
			buff = mbb.slice(); // 获得需要处理的缓冲区域，它和相应的文件区域映射
			start();
		}

		public void run() {
			try {
				FileLock fl = fc.lock(start, end, false);
				System.out.println("Locked: " + start + " to " + end);

				// 修改数据
				while (buff.position() < buff.limit() - 1)
					buff.put((byte) (buff.get() + 1)); // buff.put()和buff.get()方法都会改变buff的position

				fl.release();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
