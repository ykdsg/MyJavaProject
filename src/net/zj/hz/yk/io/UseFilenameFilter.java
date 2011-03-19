package net.zj.hz.yk.io;

import java.io.File;
import java.io.FilenameFilter;

public class UseFilenameFilter {
	public static void main(String args[]) throws Exception {
		File dir1 = new File("D:\\");

		FilenameFilter filter = new FilenameFilter() { // 匿名类
			public boolean accept(File dir, String name) {
				System.out.println("根路径：" + dir.getPath() + " 子路径：" + name);
				File currFile = new File(dir, name);
				if (currFile.isFile() && name.indexOf(".xls") != -1)
					return true;
				else
					return false;
			}
		};

		// 仅仅返回D:\目录下扩展名为“.txt”的文件清单
		String[] lists = new File("D:\\").list(filter);
		System.out.println("---------仅仅返回扩展名为“.xls”的文件清单---------");
		for (int i = 0; i < lists.length; i++)
			System.out.println(lists[i]);
	}
}
