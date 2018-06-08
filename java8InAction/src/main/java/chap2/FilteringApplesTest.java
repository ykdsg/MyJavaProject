package chap2;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author wuzheng.yk
 * @date 2018/6/5
 */

public class FilteringApplesTest {

    List<Apple> appList = Lists.newArrayList();

    @Before
    public void setup() {

        appList.add(new Apple(1, "app1"));
        appList.add(new Apple(2, "app2"));
        appList.add(new Apple(3, "app3"));
        appList.add(new Apple(4, "app4"));
        appList.add(new Apple(5, "app5"));
        appList.add(new Apple(6, "app6"));
        appList.add(new Apple(7, "app7"));
        appList.add(new Apple(8, "app8"));
        appList.add(new Apple(9, "app9"));
        appList.add(new Apple(10, "app10"));
        appList.add(new Apple(11, "app11"));
        appList.add(new Apple(12, "app12"));
        appList.add(new Apple(13, "app13"));
        appList.add(new Apple(14, "app14"));

    }

    @Test
    public void testPrettyPrintApple() {
        FilteringApples.prettyPrintApple(appList, app -> app.getWeight() + " apple");
    }
}
