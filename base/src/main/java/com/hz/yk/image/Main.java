package com.hz.yk.image;

import org.apache.commons.codec.binary.Base64;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wuzheng.yk on 16/11/30.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String file = "/Users/ykdsg/Pictures/idea.png";
        InputStream inStream = new FileInputStream(file);
        byte[] in2b = getBytes(inStream);
        String base64Img = Base64.encodeBase64String(in2b);

        byte[] byt = Base64.decodeBase64(base64Img);

        InputStream is = new ByteArrayInputStream(byt);
        System.out.println("img1 length="+getBytes(is).length);
        is.reset();
        BufferedImage img1 = ImageIO.read(is);      // 构造Image对象
        System.out.printf("width=%s,height=%s",img1.getWidth(),img1.getHeight());
        System.out.println();

        System.out.println("img2 length="+getBytes(is).length);
        is.reset();

        BufferedImage img2 = ImageIO.read(is);      // 构造Image对象
        //BufferedImage img2 = ImageIO.read(new ByteArrayInputStream(byt));      // 构造Image对象
        System.out.printf("width=%s,height=%s",img2.getWidth(),img2.getHeight());

    }

    private static byte[] getBytes(InputStream inStream) throws IOException {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        while ((rc = inStream.read(buff, 0, 100)) > 0) {
            swapStream.write(buff, 0, rc);
        }
        return swapStream.toByteArray();
    }
}
