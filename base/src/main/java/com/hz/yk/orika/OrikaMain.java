package com.hz.yk.orika;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * Created by wuzheng.yk on 2017/12/21.
 */
public class OrikaMain {

    public static void main(String[] args) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(User.class, UserA.class).field("id", "id").field("name", "name").byDefault().register();

        User user = new User();
        user.setId(123L);
        user.setName("小明");

        MapperFacade mapper = mapperFactory.getMapperFacade();

        UserA userA = mapper.map(user, UserA.class);
        System.out.println(userA.toString());
    }

}
