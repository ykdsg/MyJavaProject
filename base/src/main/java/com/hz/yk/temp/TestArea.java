package com.hz.yk.temp;

import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wuzheng.yk
 * @date 2019-05-13
 */
public class TestArea {

    static Map<Integer, AreaX> areaXMap = new ConcurrentHashMap<>();

    static AtomicInteger proviceInt = new AtomicInteger(0);

    static Map<Integer, AtomicInteger> proviceAutoMap = new ConcurrentHashMap<>();
    static Map<Integer, AtomicInteger> cityAutoMap    = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        List<AreaX> areaXList1 = getAreaX(";1;2:36;3:37;3:40;3:41;3:42;4:48;4:51;4:52;4:55;10:108;10:109;10:110;11:121;11:122;11:123;11:127;12:132;12:134;12:142;14:158;14:168;15:169;15:170;15:172;15:174;15:183;15:185;16;17:203;18:217;18:220;18:221;19:231;22;23:269;24:290;25:299;27:322;28:332;28:336:10089;");

        List<AreaX> areaXList2 = getAreaX(";1;2;3:41;28:332;28:336:10089;");

        System.out.println(areaXList1);

        List<AreaX> interval = interval(areaXList1, areaXList2);
        System.out.println(interval);
    }

    public static List<AreaX> interval(List<AreaX> aList, List<AreaX> bList) {
        List<AreaX> resultList = Lists.newArrayList();
        int i = 0, j = 0;
        while (i < aList.size() && j < bList.size()) {

            AreaX ax = aList.get(i);
            AreaX bx = bList.get(j);
            int left = Math.max(ax.left, bx.left);
            int right = Math.min(ax.right, bx.right);
            //如果命中，就说明a包含b或者b包含a
            if (left <= right) {
                resultList.add(right == ax.right ? ax : bx);
            }
            if (ax.right == right) {
                i++;
            } else {
                j++;
            }
        }
        return resultList;
    }

    public static List<AreaX> getAreaX(String areaStr) {
        String[] areaArray = areaStr.split(";");
        List<AreaX> resultList = Lists.newArrayList();
        for (String area : areaArray) {
            if (StringUtils.isBlank(area)) {
                continue;
            }
            String[] areaDetailArray = area.split(":");
            //省份
            String proviceStr = areaDetailArray[0];
            if (areaDetailArray.length == 1 && StringUtils.isNotBlank(areaDetailArray[0])) {
                resultList.add(getProvice(proviceStr));
            }

            if (areaDetailArray.length == 2) {
                resultList.add(getCity(areaDetailArray[1], proviceStr));

            }
            if (areaDetailArray.length == 3) {
                resultList.add(getCounty(areaDetailArray, proviceStr));
            }

        }
        Collections.sort(resultList);
        return resultList;
    }

    private static AreaX getCounty(String[] areaDetailArray, String proviceStr) {
        AreaX city = getCity(areaDetailArray[1], proviceStr);
        Integer countyId = Integer.valueOf(areaDetailArray[2]);
        return areaXMap.computeIfAbsent(countyId, id -> {
            AtomicInteger cityAuto = cityAutoMap.computeIfAbsent(city.getId(), cityId -> new AtomicInteger(0));
            int nextInt = cityAuto.addAndGet(2);
            //这里需要补位
            String countySerial = city.getSerial() + getFillTwoNum(nextInt);
            Integer left = Integer.valueOf(countySerial) - 1;
            Integer right = Integer.valueOf(countySerial);
            AreaX areaX = new AreaX(countySerial, left, right, id);
            areaX.setLevel(3);
            return areaX;
        });
    }

    /**
     * 不足2位的数组前面+0 补足
     *
     * @param value
     * @return
     */
    private static String getFillTwoNum(int value) {
        return value < 10 ? "0" + value : "" + value;
    }

    /**
     * 获取城市
     *
     * @param cityStr
     * @param proviceStr
     * @return
     */
    private static AreaX getCity(String cityStr, String proviceStr) {
        AreaX provice = getProvice(proviceStr);
        Integer cityId = Integer.valueOf(cityStr);
        return areaXMap.computeIfAbsent(cityId, id -> {
            AtomicInteger proviceAuto = proviceAutoMap
                    .computeIfAbsent(provice.getId(), proviceId -> new AtomicInteger(0));
            String citySerial = provice.getSerial() + getFillTwoNum(proviceAuto.addAndGet(1));
            Integer left = Integer.valueOf(citySerial + "00");
            Integer right = Integer.valueOf(citySerial + "99");
            AreaX areaX = new AreaX(citySerial, left, right, id);
            areaX.setLevel(2);
            return areaX;
        });
    }

    /**
     * 获取省份
     *
     * @param s
     * @return
     */
    private static AreaX getProvice(String s) {
        Integer proviceId = Integer.valueOf(s);
        return areaXMap.computeIfAbsent(proviceId, id -> {
            String serial = String.valueOf(proviceInt.addAndGet(1));
            Integer left = Integer.valueOf(serial + "0000");
            Integer right = Integer.valueOf(serial + "9999");
            AreaX areaX = new AreaX(serial, left, right, id);
            areaX.setLevel(1);
            return areaX;
        });
    }

    static class AreaX implements Comparable<AreaX> {

        /**
         * 序列
         */
        private String  serial;
        private Integer left;
        private Integer right;

        private Integer id;
        /**
         * 省市区(1,2,3)
         */
        private int     level;

        public AreaX(String serial, Integer left, Integer right, Integer id) {
            this.serial = serial;
            this.left = left;
            this.right = right;
            this.id = id;
        }

        public Integer getLeft() {
            return left;
        }

        public void setLeft(Integer left) {
            this.left = left;
        }

        public Integer getRight() {
            return right;
        }

        public void setRight(Integer right) {
            this.right = right;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getSerial() {
            return serial;
        }

        public void setSerial(String serial) {
            this.serial = serial;
        }

        @Override
        public int compareTo(AreaX obj) {
            if (obj == null || obj.getLeft() == null) {
                return 1;
            }
            return this.getLeft().compareTo(obj.getLeft());
        }
    }

}

