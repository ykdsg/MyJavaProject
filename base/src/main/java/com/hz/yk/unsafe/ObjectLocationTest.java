package com.hz.yk.unsafe;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by wuzheng.yk on 17/3/21.
 */
public class ObjectLocationTest {
    @SuppressWarnings("unused")
    private static int apple = 10;
    @SuppressWarnings("unused")
    private int orange = 10;
    Unsafe unsafe  = null;
    @Before
    public void setUp() {
        Field theUnsafeInstance;
        try {
            theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafeInstance.setAccessible(true);
            unsafe  = (Unsafe)  theUnsafeInstance.get(Unsafe.class);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testUnsafe() {
        try {
            Field appleField = ObjectLocationTest.class.getDeclaredField("apple");
            System.out.println("Location of Apple: " + unsafe.staticFieldOffset(appleField));

            Field orangeField = ObjectLocationTest.class.getDeclaredField("orange");
            System.out.println("Location of Orange: " + unsafe.objectFieldOffset(orangeField));
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
