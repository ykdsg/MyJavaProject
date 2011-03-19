package net.zj.hz.yk.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class FileUtil {
	/** 从一个文件中逐行读取字符串，采用本地平台的字符编码 */
	public void readFile(String fileName) throws IOException {
		readFile(fileName, null);
	}

	/** 从一个文件中逐行读取字符串，参数charsetName指定文件的字符编码 */
	public void readFile(String fileName, String charsetName)
			throws IOException {
		InputStream in = new FileInputStream(fileName);
		InputStreamReader reader;
		if (charsetName == null)
			reader = new InputStreamReader(in);
		else
			reader = new InputStreamReader(in, charsetName);
		BufferedReader br = new BufferedReader(reader);
		String data;
		while ((data = br.readLine()) != null)
			// 逐行读取数据
			System.out.println(data);

		br.close();
	}

	/** 把一个文件中的字符内容拷贝到另一个文件中，并且进行了相关的字符编码转换 */
	public void copyFile(String from, String charsetFrom, String to,
			String charsetTo) throws IOException {
		InputStream in = new FileInputStream(from);
		InputStreamReader reader;
		if (charsetFrom == null)
			reader = new InputStreamReader(in);
		else
			reader = new InputStreamReader(in, charsetFrom);
		BufferedReader br = new BufferedReader(reader);

		OutputStream out = new FileOutputStream(to);
		OutputStreamWriter writer = new OutputStreamWriter(out, charsetTo);
		BufferedWriter bw = new BufferedWriter(writer);
		PrintWriter pw = new PrintWriter(bw, true);

		String data;
		while ((data = br.readLine()) != null)
			pw.println(data); // 向目标文件逐行写数据

		br.close();
		pw.close();
	}

	public static void main(String args[]) throws IOException {
		FileUtil util = new FileUtil();
		// 按照本地平台的字符编码读取字符
		util.readFile("D:\\test.txt");

		// 把test.txt文件中的字符内容拷贝到out.txt中，out.txt采用UTF-8编码
		util.copyFile("D:\\test.txt", null, "D:\\out.txt", "UTF-8");

		// 按照本地平台的字符编码读取字符，读到错误的数据
		util.readFile("D:\\out.txt");

		// 按照UTF-8字符编码读取字符
		util.readFile("D:\\out.txt", "UTF-8");
	}
}
