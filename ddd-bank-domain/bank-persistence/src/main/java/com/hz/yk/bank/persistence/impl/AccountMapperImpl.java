package com.hz.yk.bank.persistence.impl;

import com.hz.yk.bank.persistence.AccountDAO;
import com.hz.yk.bank.persistence.AccountDO;
import org.springframework.stereotype.Repository;

/**
 * @author wuzheng.yk
 * @date 2021/2/5
 */
@Repository
public class AccountMapperImpl implements AccountDAO {

    @Override
    public int insert(AccountDO accountDO) {
        System.err.println("------------------插入:" + accountDO);
        return 0;
    }

    @Override
    public int update(AccountDO accountDO) {
        System.err.println("------------------更新:" + accountDO);
        return 0;
    }

    @Override
    public AccountDO selectByUserId(Long id) {
        return new AccountDO();
    }

    @Override
    public AccountDO selectByAccountNumber(String accountNumber) {
        return null;
    }

    @Override
    public AccountDO selectById(Long id) {
        return null;
    }

}
