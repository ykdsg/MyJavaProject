package com.hz.yk.spock

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.support.FileSystemXmlApplicationContext
import spock.lang.Specification
import spock.lang.Unroll

/**
 * spock 的使用
 * https://blog.csdn.net/zhglance/article/details/52535799
 * @author wuzheng.yk
 * @date 2018/7/30
 */
class BizServiceTest extends Specification {

    @Autowired
    private BizServiceImpl bizService;

    Dao dao = Mock(Dao)  // 生成dao的Mock对象

    /**
     * Spock和Junit类似也将单元测试划分成了多个阶段
     * 如 setup()  类似于Junit的@Before,在这个方法中的代码块会在测试用例执行之前执行,一般用于初始化程序以及Mock定义
     *
     *    when:和then:  表示当...的时候,结果怎样.
     *
     *
     *
     * @return
     */

    def setup() {
        println(" ============= test start =============")
        // 关联Mock对象，由于本测试是基于接口的测试，没有相应的setDao()方法,故采用此方法设置dao
//

        ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:spockSpring.xml");
        bizService = ac.getBean(BizService.class)
//        bizService.h.advised.targetSource.target.dao = dao;
        bizService.setDao(dao)

    }


    def "test isAdult"() {

        setup:  //setup: 代码块主要针对自己所在方法的初始化参数操作
        int age = 20

        when:
        bizService.isAdult(age)  // 当执行isAdult方法时


        then:

        true  // 判断when执行bizService.isAdult(age)结果为true
        notThrown()   // 表示没有异常抛出
        println("age = " + age)
    }

    def "test isAdult except"() {
        expect:         // expect简化了when...then的操作
        bizService.isAdult(20) == true
    }


    def "age less than zero"() {
        setup:
        int age = -100

        when:
        bizService.isAdult(age)

        then:

        def e = thrown(Exception)  //thrown() 捕获异常,通常在then:中判断
        e.message == "age is less than zero."
        println(e.message)

        cleanup:
        println("test clean up")  // 单元测试执行结束后的清理工作，如清理内存，销毁对象等
    }


    @Unroll
    // 表示根君where的参数生成多个test方法,如本例生成了2个方法,方法名称分别为:
    // 1."where blocks test 20 isadult() is true"
    // 2."where blocks test 17 isadult() is false"
    def "where blocks test #age isadult() is #result"() {

        expect:
        bizService.isAdult(age) == result

        where:      // 其实实质是执行了两次"where blocks test"方法，但是参数不一样
        age || result
        20  || true
        17  || false
    }

    def "insert test"() {

        setup:
        PersonEntity person = new PersonEntity();
        person.setAge(28)
        person.setPersonId("id_1")
        person.setPersonName("zhangsan")

        when:
        bizService.insert("id_1", "zhangsan", 28)



        then:
        PersonEntity

        1 * dao.insert(person)  //判断dao执行了一次insert，且插入的对象是否equals


    }
}
