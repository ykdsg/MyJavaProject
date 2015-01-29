package com.hz.yk.classload;

/**
 * @author wuzheng.yk
 *         Date: 15/1/29
 *         Time: 11:26
 */
public class CaseHsf {
    public static void main(String[] args) {
        MyClassLoader loader1 = new MyClassLoader(null, "loader1");// 使用根类加载器做父类，将命名空间隔离
        try {
            System.out.println(loader1.getParent());
            Class<RfqService> rfqServiceClass = RfqService.class;// 直接传入接口类，不再模拟HSF获取应用类
            Class<RfqRequestDTO> rfqRequestDTOClass = RfqRequestDTO.class;// 直接传入接口类，不再模拟HSF获取应用类
            Class<?> hsfTest = loader1.loadClass("com.hz.yk.classload.HSFTest");// 应用获取HSF类，不再模拟导出给应用
            RfqService rfqService = (RfqService)   hsfTest.getDeclaredMethod("getObject", new Class[]{Class.class, Class.class})
                    .invoke(hsfTest.newInstance(),new Class[]    {rfqServiceClass,rfqRequestDTOClass });
            System.out.println("rfqService class load = "+rfqService.getClass().getClassLoader());
            System.out.println(rfqService.getRfq().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
