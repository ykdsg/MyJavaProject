package test.load.sims

import com.alibaba.dubbo.config.{ApplicationConfig, ReferenceConfig}
import com.yt.icp.domain.query.QueryBrandOptionsDO
import com.yt.icp.facade.BrandQueryFacade

/**
  * @author wuzheng.yk
  * @date 2019-05-29
  */
object Main {
  def main(args: Array[String]): Unit = {
    val application = new ApplicationConfig()
    application.setName("gatling-dubbo")
    // 引用远程服务
    val reference = new ReferenceConfig[BrandQueryFacade] // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
    reference.setApplication(application)
    //  reference.setUrl("dubbo://ip:port/com.youzan.xxx.XxxService")  //设置服务地址、端口、全限定服务类名
    reference.setUrl("dubbo://10.250.34.27:28889/com.yt.icp.facade.BrandQueryFacade") //设置服务地址、端口、全限定服务类名
    reference.setInterface(classOf[BrandQueryFacade])
    //    reference.setGroup("test_gz")
    //  reference.setVersion("1.0.0") //设置版本号，可以不设置
    //  reference.setTimeout(3000)        //设置超时时间，可以不设置
    //
    val brandQueryFacade = reference.get()
    val result = brandQueryFacade.getBrandById(160L, new QueryBrandOptionsDO())
    println(result)

  }
}
