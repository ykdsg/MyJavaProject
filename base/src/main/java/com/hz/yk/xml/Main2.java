package com.hz.yk.xml;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wuzheng.yk on 17/2/21.
 */
public class Main2 {
    public static void main(String[] args) throws ParseException {
        String dataStr = "2017-02-16 03:38:43.0 UTC";
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format1.parse(dataStr);
        System.out.println(date);
    }
}
