package com.hz.yk.bank.external.impl;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author wuzheng.yk
 * @date 2021/2/18
 */
@Service
public class YahooForexService {

    public BigDecimal getExchangeRate(String sourceValue, String targetValue) {
        return new BigDecimal("1.0");
    }
}
