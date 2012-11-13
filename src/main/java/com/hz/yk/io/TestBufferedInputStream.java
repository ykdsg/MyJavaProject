package com.hz.yk.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author ykdsg
 *         Date: 12-5-27
 *         Time: 上午12:07
 */
public class TestBufferedInputStream {

    public static void main(String[] args) {
            testBufferedStream();
        }


        /**
         * 缓冲的字节流测试
         */
        public static void testBufferedStream() {
    		BufferedInputStream bis=null;
            try {
    			FileInputStream fis = new FileInputStream("F:\\My Document\\dropbox\\讲义\\java io\\例子\\x.txt");
                bis = new BufferedInputStream(fis);
                int bench = 0;
                byte tempBuf[] = new byte[8];      //创建字节流缓存，大小为1024个字节
                while ((bis.read(tempBuf)) != -1) {
    				String copyStr = new String(tempBuf);
                    System.out.println(copyStr);
                    bench++;
                }
    			System.out.println("文件结束");
                System.out.println("bench=" + bench);
            } catch (FileNotFoundException e) {
                System.out.println("找不到指定的文件！");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("文件读取时发生IO异常！");
                e.printStackTrace();
            } finally {
    			try{
    				bis.close();
    			}catch(IOException e){
    				e.printStackTrace();
    			}
    		}
        }
}
