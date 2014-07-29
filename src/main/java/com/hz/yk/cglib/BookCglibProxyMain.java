package com.hz.yk.cglib;

import java.lang.reflect.InvocationTargetException;
import javassist.CannotCompileException;
import javassist.NotFoundException;

/**
 * @author wuzheng.yk
 *         Date: 14-7-11
 *         Time: обнГ5:34
 */
public class BookCglibProxyMain {
    public static void main(String[] args) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        BookFacadeImpl bookCglib=(BookFacadeImpl)BookFacadeCglib.getInstance(new BookFacadeImpl());
        bookCglib.addBook();

    }

}
