package com.hz.yk.area.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author wuzheng.yk
 * @date 2019-05-20
 */
public class AreaUtilOld {

    /**
     * 批次中区域字符串中用到的地区和地区的分隔字符串
     */
    public static final String ITEM_BATCH_AREA_SPLIT = ";";

    /**
     * 批次中区域字符串中用到的地区上下级的分隔字符串
     */
    public static final  String ITEM_BATCH_AREA_DETAIL_SPLIT = ":";
    private static final Logger log                          = LoggerFactory.getLogger(AreaUtilOld.class);

    public static void main(String[] args) {
        String areaStr1 = ";1;2:36;3:37;3:40;3:41;3:42;4:48;4:51;4:52;4:55;10:108;10:109;10:110;11:121;11:122;11:123;11:127;12:132;12:134;12:142;14:158;14:168;15:169;15:170;15:172;15:174;15:183;15:185;16;17:203;18:217;18:220;18:221;19:231;22;23:269;24:290;25:299;27:322;28:332;28:336:10089;";
        String areaStr2 = ";1;2;3;4;5:59;5:60;5:62;6;7:85;7:86;7:87;8:94;9;10;11;12;13;14;15;16;17:203;17:204;17:205;17:206;17:207;17:208;17:209;17:210;17:211;17:212;17:213;17:214;18:217;18:218;18:219;18:220;18:221;18:222;18:223;18:224;18:225;18:226;18:227;18:228;18:229;19;27:322;";

        for (int i = 0; i < 100000; i++) {
            List<String> interval = intersect(areaStr1, areaStr2);
            System.out.println(i + interval.size());
        }
        List<String> result = intersect(areaStr1, areaStr2);
        System.out.println(result);
    }

    /**
     * 新区域字段简单匹配是否供货的逻辑
     *
     * @param provinceArea          省市区
     * @param newSupplyAreaRelation 新的供货区域字段,格式如 1.到省";9;10;" 或 到市";9;10:113;"或到区";10:109:1137;"
     * @return
     */
    //cs:off
    public static boolean isSupplyAreaSimpleBySupplyDetail(ProvinceArea provinceArea, String newSupplyAreaRelation) {
        if (org.apache.commons.lang3.StringUtils.isBlank(newSupplyAreaRelation) || provinceArea == null) {
            return false;
        }
        String provinceId = provinceArea.getProvinceId();
        //匹配
        if (org.apache.commons.lang3.StringUtils
                .contains(newSupplyAreaRelation, ITEM_BATCH_AREA_SPLIT + provinceId + ITEM_BATCH_AREA_SPLIT)) {
            return true;
        }

        //新数据转化格式
        String[] provinceRootAreaArray = newSupplyAreaRelation.split(ITEM_BATCH_AREA_SPLIT);

        // 先循环切出地址，数组的每一位，代表一个具体的地址，可能是省、或者省+市、或者是省+市+区
        for (String provinceRootArea : provinceRootAreaArray) {
            if (org.apache.commons.lang3.StringUtils.isEmpty(provinceRootArea)) {
                continue;
            }

            String[] areaDetailArray = provinceRootArea.split(ITEM_BATCH_AREA_DETAIL_SPLIT);
            if (areaDetailArray.length == 1 && org.apache.commons.lang3.StringUtils
                    .equals(provinceId, areaDetailArray[0])) {
                return true;
            }
            if (areaDetailArray.length == 2 && org.apache.commons.lang3.StringUtils
                    .equals(provinceId, areaDetailArray[0]) && org.apache.commons.lang3.StringUtils
                        .equals(provinceArea.getCityId(), areaDetailArray[1])) {
                return true;
            }
            if (areaDetailArray.length == 3 && org.apache.commons.lang3.StringUtils
                    .equals(provinceId, areaDetailArray[0]) && org.apache.commons.lang3.StringUtils
                        .equals(provinceArea.getCityId(), areaDetailArray[1]) && org.apache.commons.lang3.StringUtils
                        .equals(provinceArea.getCountyId(), areaDetailArray[2])) {
                return true;
            }
        }
        return false;
    }

    public static List<String> intersect(String supplyAreaJson1, String supplyAreaJson2) {

        List<LeafArea> leafAreaListFor1 = parseLeafArea(supplyAreaJson1);
        List<LeafArea> leafAreaListFor2 = parseLeafArea(supplyAreaJson2);

        //获取两个区域的交集
        List<String> intersectAreaIdList = Lists.newArrayList();
        //1.区域一所有节点和区域二的叶子节点交集
        intersectAreaIdList
                .addAll(intersectAreaIds(LeafArea.parseAllLeafAreaIdList(leafAreaListFor1), leafAreaListFor2));
        //2.区域二所有节点和区域一叶子节点有交集
        intersectAreaIdList
                .addAll(intersectAreaIds(LeafArea.parseAllLeafAreaIdList(leafAreaListFor2), leafAreaListFor1));
        intersectAreaIdList = intersectAreaIdList.stream().distinct().collect(Collectors.toList());
        return intersectAreaIdList;
    }

    /**
     * 获取两个区域的交集.
     * 区域一的任何节点与区域二叶子节点的任一层级区域id匹配则取区域二叶子节点的叶子区域id.
     *
     * @param leafAreaIdList 区域1的叶子节点
     * @param leafAreaList   区域2的叶子节点(含省市区级联关系)
     * @return 交集区域id
     */
    private static List<String> intersectAreaIds(List<String> leafAreaIdList, List<LeafArea> leafAreaList) {

        if (CollectionUtils.isEmpty(leafAreaIdList) || CollectionUtils.isEmpty(leafAreaList)) {
            return Collections.emptyList();
        }
        // 任何一个是全国则表示有交集
        if (leafAreaIdList.contains("0")) {
            return LeafArea.parseAllLeafAreaIdList(leafAreaList);
        }
        // 区域id交集
        List<String> intersectAreaIdList = Lists.newArrayList();
        for (LeafArea leafArea : leafAreaList) {
            if ((leafArea.getProvinceAreaId() != null && leafAreaIdList.contains(leafArea.getProvinceAreaId())) || (
                    leafArea.getCityAreaId() != null && leafAreaIdList.contains(leafArea.getCityAreaId())) || (
                        leafArea.getCountryAreaId() != null && leafAreaIdList.contains(leafArea.getCountryAreaId()))) {
                intersectAreaIdList.add(leafArea.getLeafAreaId());
            }
        }
        return intersectAreaIdList;
    }

    /**
     * 解析区域的所有节点和叶子节点(叶子节点包含省市区完整信息).
     *
     * @param supplyAreaJson 区域(区域树json字符串,例如"[{"checkedAll":true,"id":"9","childList":[]}]")。同时支持新老两种格式
     * @return left:所有节点;right:叶子节点
     */
    private static List<LeafArea> parseLeafArea(String supplyAreaJson) {

        List<AreaJson> areaJsonList = changeAreaJsonFormat(supplyAreaJson);
        return parseLeafAreaForAreaJsonList(areaJsonList, 1, null);
    }

    /**
     * 解析区域树的所有节点和叶子节点(从根节点遍历一直到叶子节点).
     *
     * @param areaJsonList 区域树
     * @return 叶子节点(含省市区级联关系)
     */
    private static List<LeafArea> parseLeafAreaForAreaJsonList(List<AreaJson> areaJsonList, int rootIndex,
                                                               String rootAreaId) {
        //所有区域的叶子节点id
        List<LeafArea> allLeafList = Lists.newArrayList();

        for (AreaJson areaJson : areaJsonList) {

            //无父节点代表是省,记下这个根节点省id,root层级设置为1,即从根节点层级1开始
            if (org.apache.commons.lang3.StringUtils.isBlank(areaJson.getParentId())) {
                rootAreaId = areaJson.getId();
                rootIndex = 1;
            }

            //不是叶子节点
            if (CollectionUtils.isNotEmpty(areaJson.getChildList())) {
                List<LeafArea> childAreaListPair = parseLeafAreaForAreaJsonList(areaJson.getChildList(),
                                                                                rootIndex + 1, rootAreaId);
                allLeafList.addAll(childAreaListPair);
            }
            //是叶子节点
            else {
                LeafArea leafArea;
                //到达树的第三层表示是区,则叶子节点为省市区
                if (rootIndex == 3) {
                    leafArea = new LeafArea(rootAreaId, areaJson.getParentId(), areaJson.getId());
                }
                //如果当前节点有父节点则表示是市,叶子节点为市区
                else if (org.apache.commons.lang3.StringUtils.isNotBlank(areaJson.getParentId())) {
                    leafArea = new LeafArea(areaJson.getParentId(), areaJson.getId(), null);
                }
                //如果父节点为空,表示叶子节点是省
                else {
                    leafArea = new LeafArea(areaJson.getId(), null, null);
                }
                allLeafList.add(leafArea);
            }
        }
        return allLeafList;
    }

    /**
     * 兼容新老的区域格式，变成老的json格式。数据格式如 ;11;12:13;14; 或者json格式
     *
     * @param supplyAreaRelation
     * @return
     */
    //cs:off
    public static List<AreaJson> changeAreaJsonFormat(String supplyAreaRelation) {
        List<AreaJson> result = Lists.newArrayList();
        if (org.apache.commons.lang3.StringUtils.isEmpty(supplyAreaRelation)) {
            return result;
        }

        //所有的默认对象
        Map<String, AreaJson> areaJsonMap = getAllJsonMap(supplyAreaRelation);

        //新数据转化格式
        String[] areaArray = supplyAreaRelation.split(";");

        //记录所有的根节点
        Set<String> resultSet = Sets.newHashSet();

        //先循环切出地址，数组的每一位，代表一个具体的地址，可能是省、或者省+市、或者是省+市+区
        for (String area : areaArray) {
            if (org.apache.commons.lang3.StringUtils.isEmpty(area)) {
                continue;
            }

            String[] areaDetailArray = area.split(":");
            //循环切出省市区放列表中
            List<String> areaDetailList = Lists.newArrayList();

            for (String subDetail : areaDetailArray) {
                if (org.apache.commons.lang3.StringUtils.isEmpty(subDetail)) {
                    continue;
                }
                areaDetailList.add(subDetail);
            }
            if (CollectionUtils.isEmpty(areaDetailList)) {
                continue;
            }

            //循环遍历省市区，只为了把父子节点关联好，节点对象在前面已经创建好了
            for (int i = 0; i < areaDetailList.size(); i++) {
                AreaJson areaJson = areaJsonMap.get(areaDetailList.get(i));
                if (null == areaJson) {//数据遍历都是从省到市到区，默认应该是先有省的，所以出现这种没有父节点的都要报错
                    log.error("[ItemAreaUtil-changeAreaJsonFormat] format area error,get area obj is null! area={}", supplyAreaRelation);
                    throw new RuntimeException("商品批次区域格式解析失败");
                }
                if (i - 1 >= 0) {//是不是省的数据，省的数据没有parentId
                    String parentId = areaDetailList.get(i - 1);
                    AreaJson parentArea = areaJsonMap.get(parentId);
                    if (null == parentArea) {//数据遍历都是从省到市到区，默认应该是先有省的，所以出现这种没有父节点的都要报错
                        log.error("[ItemAreaUtil-changeAreaJsonFormat] format area error! area={}", supplyAreaRelation);
                        throw new RuntimeException("商品批次区域格式解析失败");
                    } else {
                        parentArea.setCheckedAll(false);//父节点发现子节点时，设置字段
                        List<AreaJson> childList = parentArea.getChildList();
                        if (null == childList) {
                            childList = Lists.newArrayList();
                            parentArea.setChildList(childList);
                        } else if (!childList.contains(areaJson)) {
                            childList.add(areaJson);//只有没有合并进去的才可以
                        }
                    }
                    areaJson.setParentId(parentId);
                }
                if (org.apache.commons.lang3.StringUtils.isEmpty(areaJson.getParentId()) && !resultSet
                        .contains(areaJson.getId())) {//省一级数据抽出来，这要添加到返回结果
                    resultSet.add(areaJson.getId());
                    result.add(areaJson);
                }
            }
        }
        return result;
    }

    /**
     * 先按照新的格式，获取出所有的对象结构
     *
     * @param newFormatData
     * @return
     */
    private static Map<String, AreaJson> getAllJsonMap(String newFormatData) {

        Map<String, AreaJson> result = Maps.newHashMap();
        String[] areaArray = newFormatData.split(";");

        if (org.apache.commons.lang3.StringUtils.isEmpty(newFormatData)) {
            return result;
        }

        List<String> areaDetailList = Lists.newArrayList();
        for (String area : areaArray) {
            String[] areaDetailArray = area.split(":");

            //循环把省市区切分开
            for (String subDetail : areaDetailArray) {
                if (org.apache.commons.lang3.StringUtils.isEmpty(subDetail) || areaDetailList.contains(subDetail)) {
                    continue;
                }
                areaDetailList.add(subDetail);
            }
        }

        areaDetailList.forEach(p -> {
            if (org.apache.commons.lang3.StringUtils.isNoneEmpty(p)) {
                AreaJson areaJson = new AreaJson();
                areaJson.setId(p);
                areaJson.setCheckedAll(true);//先设置默认值
                result.put(p, areaJson);
            }
        });
        return result;
    }

    static class AreaJson {

        private String         id;
        private String         parentId;
        private Boolean        checkedAll;
        private List<AreaJson> childList = new ArrayList();

        public static AreaJson createAreaJson(String id, String parentId, Boolean checkedAll,
                                              List<AreaJson> childList) {
            AreaJson areaJson = new AreaJson();
            areaJson.setId(id);
            areaJson.setParentId(parentId != null ? parentId : "");
            areaJson.setCheckedAll(checkedAll != null ? checkedAll : true);
            areaJson.setChildList(childList != null ? childList : new ArrayList());
            return areaJson;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public Boolean getCheckedAll() {
            return checkedAll;
        }

        public void setCheckedAll(Boolean checkedAll) {
            this.checkedAll = checkedAll;
        }

        public List<AreaJson> getChildList() {
            return childList;
        }

        public void setChildList(List<AreaJson> childList) {
            this.childList = childList;
        }

    }

    static class LeafArea {

        //叶子节点区域id
        private String leafAreaId;
        //省id
        private String provinceAreaId;
        //市id
        private String cityAreaId;
        //去id
        private String countryAreaId;

        public static final LeafArea WHOLE_COUNTRY_AREA = new LeafArea("0", null, null);

        /**
         * 解析出所有的叶子节点
         *
         * @param leafAreaList 叶子节点集合
         * @return 叶子节点区域id, 不含父节点
         */
        public static List<String> parseAllLeafAreaIdList(List<LeafArea> leafAreaList) {
            if (CollectionUtils.isEmpty(leafAreaList)) {
                return Collections.emptyList();
            }
            List<String> leafAreaIdList = Lists.newArrayList();
            for (LeafArea leafArea : leafAreaList) {
                if (leafArea != null && StringUtils.isNotBlank(leafArea.getLeafAreaId())) {
                    leafAreaIdList.add(leafArea.getLeafAreaId());
                }
            }
            return leafAreaIdList;
        }

        public LeafArea(String provinceAreaId, String cityAreaId, String countryAreaId) {
            this.provinceAreaId = provinceAreaId;
            this.cityAreaId = cityAreaId;
            this.countryAreaId = countryAreaId;
            if (StringUtils.isNotBlank(provinceAreaId)) {
                leafAreaId = provinceAreaId;
            }
            if (StringUtils.isNotBlank(cityAreaId)) {
                leafAreaId = cityAreaId;
            }
            if (StringUtils.isNotBlank(countryAreaId)) {
                leafAreaId = countryAreaId;
            }
        }

        public String getLeafAreaId() {
            return leafAreaId;
        }

        public void setLeafAreaId(String leafAreaId) {
            this.leafAreaId = leafAreaId;
        }

        public String getProvinceAreaId() {
            return provinceAreaId;
        }

        public void setProvinceAreaId(String provinceAreaId) {
            this.provinceAreaId = provinceAreaId;
        }

        public String getCityAreaId() {
            return cityAreaId;
        }

        public void setCityAreaId(String cityAreaId) {
            this.cityAreaId = cityAreaId;
        }

        public String getCountryAreaId() {
            return countryAreaId;
        }

        public void setCountryAreaId(String countryAreaId) {
            this.countryAreaId = countryAreaId;
        }
    }

    static class ProvinceArea {

        private String provinceId;
        private String cityId;
        private String countyId;

        public ProvinceArea() {
        }

        public ProvinceArea(String provinceId) {
            this.provinceId = provinceId;
        }

        public ProvinceArea(String provinceId, String cityId, String countyId) {
            this.provinceId = provinceId;
            this.cityId = cityId;
            this.countyId = countyId;
        }

        /**
         * 构建简单的字符串[省-市-区].
         *
         * @param provinceArea
         * @return
         */
        public static String buildSimpleStr(ProvinceArea provinceArea) {
            if (provinceArea == null) {
                return org.apache.commons.lang3.StringUtils.EMPTY;
            }
            return String.valueOf(provinceArea.getProvinceId()) + "-" + String.valueOf(provinceArea.getCityId()) + "-"
                   + String.valueOf(provinceArea.getCountyId());
        }

        public String getProvinceId() {
            return provinceId;
        }

        public void setProvinceId(String provinceId) {
            this.provinceId = provinceId;
        }

        public String getCityId() {
            return cityId;
        }

        public void setCityId(String cityId) {
            this.cityId = cityId;
        }

        public String getCountyId() {
            return countyId;
        }

        public void setCountyId(String countyId) {
            this.countyId = countyId;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }
    }

}

