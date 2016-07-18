package com.hz.yk.yk.serial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * java本身的序列化多字段或者少字段都可以正常的反序列化.
 *
 * @author wuzheng.yk
 * @since 16/7/18
 */
public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("person.txt");

        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
        Person person = new Person("testName",11);
        oout.writeObject(person);
        oout.close();

        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
        Person newPerson = (Person) oin.readObject(); // 没有强制转换到Person类型
        oin.close();
        System.out.println(newPerson);
    }

}
