package com.hz.yk.bank.external;

import com.hz.yk.bank.external.impl.YahooForexService;
import com.hz.yk.bank.types.Currency;
import com.hz.yk.bank.types.ExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * @author wuzheng.yk
 * @date 2021/2/5
 */
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Autowired
    private YahooForexService yahooForexService;

    @Override
    public ExchangeRate getExchangeRate(Currency source, Currency target) {
        if (source.equals(target)) {
            return new ExchangeRate(BigDecimal.ONE, source, target);
        }
        BigDecimal forex = yahooForexService.getExchangeRate(source.getValue(), target.getValue());
        return new ExchangeRate(forex, source, target);

    }

}
