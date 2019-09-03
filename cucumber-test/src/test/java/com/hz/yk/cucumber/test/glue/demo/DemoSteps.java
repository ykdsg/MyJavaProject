package com.hz.yk.cucumber.test.glue.demo;

import com.hz.yk.cucumber.domain.DemoDTO;
import com.hz.yk.cucumber.service.ServiceA;
import com.hz.yk.cucumber.test.util.AopTargetUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wuzheng.yk
 * @date 2019/9/2
 */
@PrepareForTest(ServiceA.class)
public class DemoSteps {

    @Autowired
    @InjectMocks
    ServiceA serviceA;

    @Mock
    DemoDTO demoDTO;

    @When("钉钉知人创建:新增用户,staffId={string}")
    public void 钉钉知人创建新增用户StaffIdStaffId(String arg) {
        DemoSteps test = new DemoSteps();
        DemoSteps spy = Mockito.spy(test);
        //PowerMockito.doNothing().when(spy).testStr();
        //spy.testStr();
        //spring bean 代理进行spy 会有问题，实际还是会调用真实的方法，所以这里获取实际的target进行spy
        ServiceA serviceATarget = serviceA;
        if (AopUtils.isAopProxy(serviceA)) {
            serviceATarget = (ServiceA) AopTargetUtils.getTarget(serviceA);
        }
        ServiceA serviceSpy = Mockito.spy(serviceATarget);
        PowerMockito.doNothing().when(serviceSpy).test();
        serviceSpy.test();
    }

    public void testStr() {
        System.out.println("---------------@@@sout test str");
    }

    @Then("钉钉知人创建:校验调用zhirenService的接口的入参{string}")
    public void 钉钉知人创建校验调用zhirenService的接口的入参Param(String arg) {
    }
}
