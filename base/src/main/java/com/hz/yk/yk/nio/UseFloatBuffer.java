package com.hz.yk.yk.nio;

import com.hz.yk.yk.doclet.annotation.DocAPIResource;
import java.nio.FloatBuffer;

/**
 * @author yangke
 *         Date: 11-12-23
 *         Time: обнГ8:49
 */
@DocAPIResource
public class UseFloatBuffer {
    static public void main(String args[]) throws Exception {
        FloatBuffer buffer = FloatBuffer.allocate(10);

        for (int i = 0; i < buffer.capacity(); ++i) {
            float f = (float) Math.sin((((float) i) / 10) * (2 * Math.PI));
            buffer.put(f);
        }

        buffer.flip();

        while (buffer.hasRemaining()) {
            float f = buffer.get();
            System.out.println(f);
        }
    }
}
