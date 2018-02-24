package com.hz.yk.fastjson;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.Date;

/**
 * Created by wuzheng.yk on 2018/2/23.
 */
public class Obj2MapMain {

    public static void main(String[] args) {
        Student stu = new Student();
        stu.setName("rr");
        stu.setFather("fat");
        Family family = new Family();
        family.setCreateTime(new Date());
        family.setfList(Lists.newArrayList("5","6",null));
        family.setSuperName("sname");
        stu.setFamily(family);
        stu.setsList(Lists.newArrayList("1","2",null));


        Object obj = ReflectObject2MapUtil.convertToMap(stu);
        System.out.println(JSON.toJSONString(obj));

        Object obj2 = JacksonObject2MapUtil.convertToMap(stu);
        System.out.println(JSON.toJSONString(obj2));

    }

}
