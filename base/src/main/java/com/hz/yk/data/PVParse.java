package com.hz.yk.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author wuzheng.yk
 * @date 2018/11/2
 */
public class PVParse {

    public static void main(String[] args) {
        long countPV = 0;
        JSONArray dataJsonArray = JSON.parseArray(data);
        for (Object o : dataJsonArray) {
            JSONObject obj = (JSONObject) o;
            Long pv = obj.getLong("pv");
            countPV += pv;

        }
        System.out.println("pv:" + countPV);
    }

    static String data = "[\n" + "\t\t{\n" + "\t\t\t\"fullCode\":\"6.4.1.0.0\",\n" + "\t\t\t\"pv\":274949,\n"
                         + "\t\t\t\"title\":\"2018-08-01\",\n" + "\t\t\t\"uv\":34906\n" + "\t\t},\n" + "\t\t{\n"
                         + "\t\t\t\"fullCode\":\"6.4.1.0.0\",\n" + "\t\t\t\"pv\":280616,\n"
                         + "\t\t\t\"title\":\"2018-08-02\",\n" + "\t\t\t\"uv\":35356\n" + "\t\t},\n" + "\t\t{\n"
                         + "\t\t\t\"fullCode\":\"6.4.1.0.0\",\n" + "\t\t\t\"pv\":276558,\n"
                         + "\t\t\t\"title\":\"2018-08-03\",\n" + "\t\t\t\"uv\":35738\n" + "\t\t},\n" + "\t\t{\n"
                         + "\t\t\t\"fullCode\":\"6.4.1.0.0\",\n" + "\t\t\t\"pv\":236002,\n"
                         + "\t\t\t\"title\":\"2018-08-04\",\n" + "\t\t\t\"uv\":33402\n" + "\t\t},\n" + "\t\t{\n"
                         + "\t\t\t\"fullCode\":\"6.4.1.0.0\",\n" + "\t\t\t\"pv\":272832,\n"
                         + "\t\t\t\"title\":\"2018-08-05\",\n" + "\t\t\t\"uv\":35412\n" + "\t\t},\n" + "\t\t{\n"
                         + "\t\t\t\"fullCode\":\"6.4.1.0.0\",\n" + "\t\t\t\"pv\":598120,\n"
                         + "\t\t\t\"title\":\"2018-08-06\",\n" + "\t\t\t\"uv\":43714\n" + "\t\t},\n" + "\t\t{\n"
                         + "\t\t\t\"fullCode\":\"6.4.1.0.0\",\n" + "\t\t\t\"pv\":259565,\n"
                         + "\t\t\t\"title\":\"2018-08-07\",\n" + "\t\t\t\"uv\":35586\n" + "\t\t},\n" + "\t\t{\n"
                         + "\t\t\t\"fullCode\":\"6.4.1.0.0\",\n" + "\t\t\t\"pv\":269745,\n"
                         + "\t\t\t\"title\":\"2018-08-08\",\n" + "\t\t\t\"uv\":36298\n" + "\t\t},\n" + "\t\t{\n"
                         + "\t\t\t\"fullCode\":\"6.4.1.0.0\",\n" + "\t\t\t\"pv\":275078,\n"
                         + "\t\t\t\"title\":\"2018-08-09\",\n" + "\t\t\t\"uv\":36680\n" + "\t\t},\n" + "\t\t{\n"
                         + "\t\t\t\"fullCode\":\"6.4.1.0.0\",\n" + "\t\t\t\"pv\":266933,\n"
                         + "\t\t\t\"title\":\"2018-08-10\",\n" + "\t\t\t\"uv\":36108\n" + "\t\t},\n" + "\t\t{\n"
                         + "\t\t\t\"fullCode\":\"6.4.1.0.0\",\n" + "\t\t\t\"pv\":247715,\n"
                         + "\t\t\t\"title\":\"2018-08-11\",\n" + "\t\t\t\"uv\":34685\n" + "\t\t},\n" + "\t\t{\n"
                         + "\t\t\t\"fullCode\":\"6.4.1.0.0\",\n" + "\t\t\t\"pv\":235960,\n"
                         + "\t\t\t\"title\":\"2018-08-12\",\n" + "\t\t\t\"uv\":33964\n" + "\t\t},\n" + "\t\t{\n"
                         + "\t\t\t\"fullCode\":\"6.4.1.0.0\",\n" + "\t\t\t\"pv\":285436,\n"
                         + "\t\t\t\"title\":\"2018-08-13\",\n" + "\t\t\t\"uv\":37318\n" + "\t\t},\n" + "\t\t{\n"
                         + "\t\t\t\"fullCode\":\"6.4.1.0.0\",\n" + "\t\t\t\"pv\":275081,\n"
                         + "\t\t\t\"title\":\"2018-08-14\",\n" + "\t\t\t\"uv\":36854\n" + "\t\t},\n" + "\t\t{\n"
                         + "\t\t\t\"fullCode\":\"6.4.1.0.0\",\n" + "\t\t\t\"pv\":370962,\n"
                         + "\t\t\t\"title\":\"2018-08-15\",\n" + "\t\t\t\"uv\":38831\n" + "\t\t},\n" + "\t\t{\n"
                         + "\t\t\t\"fullCode\":\"6.4.1.0.0\",\n" + "\t\t\t\"pv\":260741,\n"
                         + "\t\t\t\"title\":\"2018-08-16\",\n" + "\t\t\t\"uv\":36594\n" + "\t\t},\n" + "\t\t{\n"
                         + "\t\t\t\"fullCode\":\"6.4.1.0.0\",\n" + "\t\t\t\"pv\":226709,\n"
                         + "\t\t\t\"title\":\"2018-08-17\",\n" + "\t\t\t\"uv\":33830\n" + "\t\t},\n" + "\t\t{\n"
                         + "\t\t\t\"fullCode\":\"6.4.1.0.0\",\n" + "\t\t\t\"pv\":228630,\n"
                         + "\t\t\t\"title\":\"2018-08-18\",\n" + "\t\t\t\"uv\":33829\n" + "\t\t},\n" + "\t\t{\n"
                         + "\t\t\t\"fullCode\":\"6.4.1.0.0\",\n" + "\t\t\t\"pv\":275712,\n"
                         + "\t\t\t\"title\":\"2018-08-19\",\n" + "\t\t\t\"uv\":36934\n" + "\t\t},\n" + "\t\t{\n"
                         + "\t\t\t\"fullCode\":\"6.4.1.0.0\",\n" + "\t\t\t\"pv\":595976,\n"
                         + "\t\t\t\"title\":\"2018-08-20\",\n" + "\t\t\t\"uv\":44691\n" + "\t\t},\n" + "\t\t{\n"
                         + "\t\t\t\"fullCode\":\"6.4.1.0.0\",\n" + "\t\t\t\"pv\":267941,\n"
                         + "\t\t\t\"title\":\"2018-08-21\",\n" + "\t\t\t\"uv\":37248\n" + "\t\t},\n" + "\t\t{\n"
                         + "\t\t\t\"fullCode\":\"6.4.1.0.0\",\n" + "\t\t\t\"pv\":268220,\n"
                         + "\t\t\t\"title\":\"2018-08-22\",\n" + "\t\t\t\"uv\":37644\n" + "\t\t},\n" + "\t\t{\n"
                         + "\t\t\t\"fullCode\":\"6.4.1.0.0\",\n" + "\t\t\t\"pv\":268640,\n"
                         + "\t\t\t\"title\":\"2018-08-23\",\n" + "\t\t\t\"uv\":37741\n" + "\t\t},\n" + "\t\t{\n"
                         + "\t\t\t\"fullCode\":\"6.4.1.0.0\",\n" + "\t\t\t\"pv\":269193,\n"
                         + "\t\t\t\"title\":\"2018-08-24\",\n" + "\t\t\t\"uv\":37730\n" + "\t\t},\n" + "\t\t{\n"
                         + "\t\t\t\"fullCode\":\"6.4.1.0.0\",\n" + "\t\t\t\"pv\":247731,\n"
                         + "\t\t\t\"title\":\"2018-08-25\",\n" + "\t\t\t\"uv\":36061\n" + "\t\t},\n" + "\t\t{\n"
                         + "\t\t\t\"fullCode\":\"6.4.1.0.0\",\n" + "\t\t\t\"pv\":240032,\n"
                         + "\t\t\t\"title\":\"2018-08-26\",\n" + "\t\t\t\"uv\":35397\n" + "\t\t},\n" + "\t\t{\n"
                         + "\t\t\t\"fullCode\":\"6.4.1.0.0\",\n" + "\t\t\t\"pv\":321433,\n"
                         + "\t\t\t\"title\":\"2018-08-27\",\n" + "\t\t\t\"uv\":38983\n" + "\t\t},\n" + "\t\t{\n"
                         + "\t\t\t\"fullCode\":\"6.4.1.0.0\",\n" + "\t\t\t\"pv\":326677,\n"
                         + "\t\t\t\"title\":\"2018-08-28\",\n" + "\t\t\t\"uv\":39301\n" + "\t\t},\n" + "\t\t{\n"
                         + "\t\t\t\"fullCode\":\"6.4.1.0.0\",\n" + "\t\t\t\"pv\":328746,\n"
                         + "\t\t\t\"title\":\"2018-08-29\",\n" + "\t\t\t\"uv\":39206\n" + "\t\t},\n" + "\t\t{\n"
                         + "\t\t\t\"fullCode\":\"6.4.1.0.0\",\n" + "\t\t\t\"pv\":300422,\n"
                         + "\t\t\t\"title\":\"2018-08-30\",\n" + "\t\t\t\"uv\":38721\n" + "\t\t},\n" + "\t\t{\n"
                         + "\t\t\t\"fullCode\":\"6.4.1.0.0\",\n" + "\t\t\t\"pv\":283903,\n"
                         + "\t\t\t\"title\":\"2018-08-31\",\n" + "\t\t\t\"uv\":38179\n" + "\t\t}\n" + "\t]";
}
