package com.hz.yk.spock;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wuzheng.yk
 * @date 2018/7/30
 */

@Service
public class BizServiceImpl implements BizService {

    @Autowired
    private Dao dao;

    @Override
    public String insert(String id, String name, int age) {

        if (StringUtils.isAnyBlank(id, name)) {
            return "";
        }

        PersonEntity bean = new PersonEntity();
        bean.setAge(age);
        bean.setPersonId(id);
        bean.setPersonName(name);
        dao.insert(bean);

        return name;
    }

    @Override
    public String remove(String id) {
        if (StringUtils.isBlank(id)) {
            return "";
        }
        dao.remove(id);

        return id;
    }

    @Override
    public String update(String name, int age) {
        if (StringUtils.isAnyBlank(name)) {
            return "";
        }
        dao.update(name, age);
        return name;
    }

    @Override
    public String finds(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        List<PersonEntity> beans = dao.finds(name);

        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (PersonEntity bean : beans) {
            sb.append(bean.getAge()).append("#");
        }

        return sb.toString();
    }

    @Override
    public boolean isAdult(int age) throws Exception {

        if (age < 0) {
            throw new Exception("age is less than zero.");
        }

        return age >= 18;
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

}
