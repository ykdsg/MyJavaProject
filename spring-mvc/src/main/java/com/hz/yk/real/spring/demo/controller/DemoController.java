package com.hz.yk.real.spring.demo.controller;

import com.hz.yk.real.spring.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassNameDemoController
 * @Description TODO
 * @Date 2018/8/9 下午4:56
 **/
@Controller
@RequestMapping("demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/query")
    public void query(HttpServletRequest request, HttpServletResponse response, @RequestParam("name") String name) {
        String result = this.demoService.get(name);
        try {
            response.getWriter().write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/get-url")
    public void getUrl(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") Integer id) {

    }

    @RequestMapping("/remove")
    public void remove(HttpServletRequest request, HttpServletResponse response, @RequestParam("id") Integer id) {

    }

}

