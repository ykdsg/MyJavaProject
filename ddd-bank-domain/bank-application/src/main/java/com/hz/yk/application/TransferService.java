package com.hz.yk.application;

import com.hz.yk.bank.common.Result;
import com.hz.yk.bank.exception.DailyLimitExceededException;

import java.math.BigDecimal;

/**
 * @author wuzheng.yk
 * @date 2021/2/5
 */
public interface TransferService {

    Result<Boolean> transfer(Long sourceUserId, String targetAccountNumber, BigDecimal targetAmount,
                             String targetCurrency) throws Exception, DailyLimitExceededException;

}
