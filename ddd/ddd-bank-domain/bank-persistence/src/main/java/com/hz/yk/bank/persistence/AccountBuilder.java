package com.hz.yk.bank.persistence;

import com.hz.yk.bank.domain.entity.Account;

/**
 * @author wuzheng.yk
 * @date 2021/2/5
 */
public interface AccountBuilder {

    Account toAccount(AccountDO accountDO) throws Exception;

    AccountDO fromAccount(Account account);

}
