package com.hz.avro.yk;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * 根据avsc 生成的code进行序列化
 * Created by wuzheng.yk on 17/3/31.
 */
public class SerialWithCode {

    @Test
    public void testSerializing() throws IOException {
        // 3种生成user对象的方法
        User user1 = new User();
        user1.setName("张山");
        user1.setAge(23);
        user1.setPhone("123456789");

        User user2 = new User("李斯", 45, "987654321");

        User user3 = User.newBuilder().setName("王二").setAge(57).setPhone("456893256").build();

        DatumWriter<User> userDatumWriter = new SpecificDatumWriter<User>(User.class);
        DataFileWriter<User> dataFileWriter = new DataFileWriter<User>(userDatumWriter);
        dataFileWriter.create(user1.getSchema(), new File("users.avro"));
        dataFileWriter.append(user1);
        dataFileWriter.append(user2);
        dataFileWriter.append(user3);
        dataFileWriter.flush();
        dataFileWriter.close();
    }

    @Test
    public void testDeserializing() throws IOException {
        // 从文件中反序列化对象
        DatumReader<User> userDatumReader = new SpecificDatumReader<User>(User.class);
        DataFileReader<User> dataFileReader = null;
        // 序列化user到文件中
        File file = new File("users.avro");
        try {
            dataFileReader = new DataFileReader<User>(file, userDatumReader);
        } catch (IOException e) {
        }
        User user = null;
        while (dataFileReader.hasNext()) {
            //注意:avro为了提升性能，_current对象只会被创建一次，且每次遍历都会重用此对象
            //next方法只是给_current对象的各个属性赋值，而不是重新new。
            user = dataFileReader.next(user);
            //toString方法被重写，将获得JSON格式
            System.out.println(user);
        }
    }

}
