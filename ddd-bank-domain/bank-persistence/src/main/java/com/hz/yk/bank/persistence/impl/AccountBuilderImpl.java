package com.hz.yk.bank.persistence.impl;

import com.hz.yk.bank.domain.entity.Account;
import com.hz.yk.bank.persistence.AccountBuilder;
import com.hz.yk.bank.persistence.AccountDO;
import com.hz.yk.bank.types.AccountId;
import com.hz.yk.bank.types.AccountNumber;
import com.hz.yk.bank.types.Currency;
import com.hz.yk.bank.types.Money;
import com.hz.yk.bank.types.UserId;

/**
 * @author wuzheng.yk
 * @date 2021/2/5
 */
public class AccountBuilderImpl implements AccountBuilder {

    @Override
    public Account toAccount(AccountDO accountDO) throws Exception {
        Account account = new Account();
        account.setId(new AccountId(accountDO.getId()));
        account.setAccountNumber(new AccountNumber(accountDO.getAccountNumber()));
        account.setUserId(new UserId(accountDO.getUserId()));
        Currency currency = new Currency(accountDO.getCurrency());
        account.setAvailable(new Money(accountDO.getAvailableAmout(), currency));
        account.setDailyLimit(new Money(accountDO.getDailyLimitAmout(), currency));
        return account;
    }

    @Override
    public AccountDO fromAccount(Account account) {
        AccountDO accountDO = new AccountDO();
        if (account.getId() != null) {
            accountDO.setId(account.getId().getValue());
        }
        accountDO.setUserId(account.getUserId().getId());
        accountDO.setAccountNumber(account.getAccountNumber().getValue());
        accountDO.setAvailableAmout(account.getAvailable().getAmout());
        accountDO.setDailyLimitAmout(account.getDailyLimit().getAmout());
        accountDO.setCurrency(account.getCurrency().getValue());
        return accountDO;
    }

}
