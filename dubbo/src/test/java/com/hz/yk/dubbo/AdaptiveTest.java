package com.hz.yk.dubbo;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.hz.yk.dubbo.adaptive.AdaptiveExt2;
import org.junit.Test;

/**
 * https://www.jianshu.com/p/dc616814ce98
 *
 * @author wuzheng.yk
 * @date 2018/9/5
 */
public class AdaptiveTest {

    /**
     * 测试一：SPI注解中有value值 @SPI("dubbo")
     */
    @Test
    public void test1() {
        ExtensionLoader<AdaptiveExt2> loader = ExtensionLoader.getExtensionLoader(AdaptiveExt2.class);
        AdaptiveExt2 adaptiveExtension = loader.getAdaptiveExtension();
        URL url = URL.valueOf("test://localhost/test");
        System.out.println(adaptiveExtension.echo("d", url));
    }

    /**
     * 测试二：SPI注解中有value值，URL中也有具体的值
     */
    @Test
    public void test2() {
        ExtensionLoader<AdaptiveExt2> loader = ExtensionLoader.getExtensionLoader(AdaptiveExt2.class);
        AdaptiveExt2 adaptiveExtension = loader.getAdaptiveExtension();
        URL url = URL.valueOf("test://localhost/test?adaptive.ext2=cloud");
        System.out.println(adaptiveExtension.echo("d", url));
    }

    /**
     * SPI注解中有value值,实现类上没有@Adaptive注解，在方法上打上@Adaptive注解，注解中的value与链接中的参数的key一致，链接中的key对应的value就是spi中的name,获取相应的实现类。
     */
    @Test
    public void test3() {
        ExtensionLoader<AdaptiveExt2> loader = ExtensionLoader.getExtensionLoader(AdaptiveExt2.class);
        AdaptiveExt2 adaptiveExtension = loader.getAdaptiveExtension();
        URL url = URL.valueOf("test://localhost/test?t=cloud");
        System.out.println(adaptiveExtension.echo("d", url));
    }

}
