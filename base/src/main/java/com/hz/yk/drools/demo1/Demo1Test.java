package com.hz.yk.drools.demo1;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;

/**
 * @author wuzheng.yk
 * @date 2021/6/8
 */
public class Demo1Test {

    private static KieContainer container = null;
    private KieSession statefulKieSession = null;

    @Test
    public void test() {
        KieServices kieServices = KieServices.Factory.get();
        //getKieClasspathContainer，会加载kmodule.xml 配置路径的文件
        container = kieServices.getKieClasspathContainer();
        statefulKieSession = container.newKieSession("demo1-rules");
        Person person = new Person();

        person.setAge(12);
        person.setName("Test");

        statefulKieSession.insert(person);
        statefulKieSession.fireAllRules();
        statefulKieSession.dispose();
    }

    @Test
    public void testRuleString() {
        String myRule =
                "import com.hz.yk.drools.demo1.Person\n" + "\n" + "dialect  \"mvel\"\n" + "\n" + "rule \"age\"\n"
                + "    when\n" + "        $person : Person(age<16 || age>50)\n" + "    then\n"
                + "        System.out.println(\"这个人的年龄不符合要求！（基于动态加载）\");\n" + "end\n";

        KieHelper helper = new KieHelper();

        helper.addContent(myRule, ResourceType.DRL);

        KieSession ksession = helper.build().newKieSession();

        Person person = new Person();

        person.setAge(12);
        person.setName("Test");

        ksession.insert(person);

        ksession.fireAllRules();

        ksession.dispose();
    }
}
