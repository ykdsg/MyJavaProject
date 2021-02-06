package com.hz.yk.bank.domain.service.impl;

import com.hz.yk.bank.domain.entity.Account;
import com.hz.yk.bank.domain.service.AccountTransferService;
import com.hz.yk.bank.exception.DailyLimitExceededException;
import com.hz.yk.bank.types.ExchangeRate;
import com.hz.yk.bank.types.Money;

/**
 * @author wuzheng.yk
 * @date 2021/2/5
 */
public class AccountTransferServiceImpl implements AccountTransferService {

    @Override
    public void transfer(Account sourceAccount, Account targetAccount, Money targetMoney, ExchangeRate exchangeRate)
            throws Exception, DailyLimitExceededException {
        Money sourceMoney = exchangeRate.exchageTo(targetMoney);
        sourceAccount.deposit(sourceMoney);
        targetAccount.withdraw(targetMoney);
    }
}
