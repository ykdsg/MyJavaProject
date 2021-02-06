package com.hz.yk.bank.external;

import com.hz.yk.bank.types.Currency;
import com.hz.yk.bank.types.ExchangeRate;

/**
 * @author wuzheng.yk
 * @date 2021/2/5
 */
public interface ExchangeRateService {

    ExchangeRate getExchangeRate(Currency source, Currency target);
}
