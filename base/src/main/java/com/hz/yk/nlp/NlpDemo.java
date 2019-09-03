package com.hz.yk.nlp;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.List;

/**
 * @author wuzheng.yk
 * @date 2019-08-02
 */
public class NlpDemo {

    List<Obj> list = Lists.newArrayList();

    {
        list.add(new Obj("爱他美官方唯一指定版", "爱他美三段"));
        list.add(new Obj("爱他美官方唯一指定版-三段", "爱他美三段"));
        list.add(new Obj("爱他美官方唯一指定版-三段", "爱他美-三段"));
    }

    @Test
    public void testGetJaroWinklerDistance() {

        list.forEach(obj -> {
            String k = obj.getKey();
            String v = obj.getValue();
            double dis = StringUtils.getJaroWinklerDistance(k, v);
            System.out.println(k + ":" + v + "=" + dis);

        });
    }

    static class Obj {

        String key;
        String value;

        public Obj(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }
}

