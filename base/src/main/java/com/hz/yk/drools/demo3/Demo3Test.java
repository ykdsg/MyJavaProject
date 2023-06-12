package com.hz.yk.drools.demo3;

import org.junit.jupiter.api.Test;
import org.kie.api.runtime.KieSession;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.hz.yk.drools.DroolsUtil.getSession;

/**
 * https://blog.csdn.net/liao0801_123/article/details/108787172
 *
 * @author wuzheng.yk
 * @date 2021/6/8
 */
public class Demo3Test {

    @Test
    public void testPackagedProduct() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse("2018-09-30");
        Date date2 = sdf.parse("2018-09-31");
        KieSession kieSession = getSession("demo3-rules");
        Segment seg = new Segment();
        seg.setArriveCity("PEK");
        seg.setStartCity("XMN");
        seg.setFlightDate(date1);
        seg.setCabin("Y");
        seg.setProCode("seg1");
        Segment seg2 = new Segment();
        seg2.setArriveCity("PEK");
        seg2.setStartCity("XMN");
        seg2.setFlightDate(date1);
        seg2.setCabin("T");
        seg2.setProCode("seg2");
        Segment seg3 = new Segment();
        seg3.setArriveCity("XMN");
        seg3.setStartCity("TSN");
        seg3.setFlightDate(date1);
        seg3.setCabin("Y");
        seg3.setProCode("seg3");
        Hotel hotel = new Hotel();
        hotel.setCheckInDate(date1);
        hotel.setIfCanPackageSale(true);
        hotel.setLocation(new Location("", "", "XMN"));
        hotel.setProCode("hotel1");
        Hotel hotel2 = new Hotel();
        hotel2.setCheckInDate(date2);
        hotel2.setIfCanPackageSale(true);
        hotel2.setLocation(new Location("", "", "XMN"));
        hotel2.setProCode("hotel2");
        Hotel hotel3 = new Hotel();
        hotel3.setCheckInDate(date1);
        hotel3.setIfCanPackageSale(true);
        hotel3.setLocation(new Location("", "", "NRT"));
        hotel3.setProCode("hotel3");
        Hotel hotel4 = new Hotel();
        hotel4.setCheckInDate(date1);
        hotel4.setIfCanPackageSale(true);
        hotel4.setLocation(new Location("", "", "PEK"));
        hotel4.setProCode("hotel4");

        ReservedLounge lounge = new ReservedLounge();
        lounge.setLocation(new Location("", "", "XMN"));
        lounge.setSelfSupport(true);
        lounge.setProCode("lounge1");
        ReservedLounge lounge2 = new ReservedLounge();
        lounge2.setLocation(new Location("", "", "PEK"));
        lounge2.setSelfSupport(true);
        lounge2.setProCode("lounge2");
        ReservedLounge lounge3 = new ReservedLounge();
        lounge3.setLocation(new Location("", "", "XMN"));
        lounge3.setSelfSupport(false);
        lounge3.setProCode("lounge3");

        kieSession.insert(seg);
        kieSession.insert(seg2);
        kieSession.insert(seg3);
        kieSession.insert(hotel);
        kieSession.insert(hotel2);
        kieSession.insert(hotel3);
        kieSession.insert(hotel4);
        kieSession.insert(lounge);
        kieSession.insert(lounge2);
        kieSession.insert(lounge3);
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}
