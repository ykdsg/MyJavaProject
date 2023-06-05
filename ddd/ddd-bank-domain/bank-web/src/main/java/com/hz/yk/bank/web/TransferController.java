package com.hz.yk.bank.web;

import com.hz.yk.bank.application.TransferService;
import com.hz.yk.bank.exception.DailyLimitExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author wuzheng.yk
 * @date 2021/2/18
 */
@RestController
public class TransferController {

    @Autowired
    private TransferService transferService;

    @GetMapping("/t1")
    public String t1() {
        try {
            transferService.transfer(1L, "1", new BigDecimal("1"), "2");
        } catch (DailyLimitExceededException | Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

}
