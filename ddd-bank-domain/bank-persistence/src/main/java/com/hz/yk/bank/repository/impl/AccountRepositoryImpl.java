package com.hz.yk.bank.repository.impl;

import com.hz.yk.bank.domain.entity.Account;
import com.hz.yk.bank.exception.BusinessException;
import com.hz.yk.bank.persistence.AccountBuilder;
import com.hz.yk.bank.persistence.AccountDAO;
import com.hz.yk.bank.persistence.AccountDO;
import com.hz.yk.bank.repository.AccountRepository;
import com.hz.yk.bank.types.AccountId;
import com.hz.yk.bank.types.AccountNumber;
import com.hz.yk.bank.types.UserId;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wuzheng.yk
 * @date 2021/2/5
 */
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private AccountBuilder accountBuilder;

    @Override
    public Account find(AccountId id) throws Exception {
        AccountDO accountDO = accountDAO.selectById(id.getValue());
        return accountBuilder.toAccount(accountDO);
    }

    @Override
    public Account find(AccountNumber accountNumber) throws Exception {
        AccountDO accountDO = accountDAO.selectByAccountNumber(accountNumber.getValue());
        if (accountDO == null) {
            throw new BusinessException(String.format("账户[%s]不存在", accountNumber.getValue()));
        }
        return accountBuilder.toAccount(accountDO);
    }

    @Override
    public Account find(UserId userId) throws Exception {
        AccountDO accountDO = accountDAO.selectByUserId(userId.getId());
        if (accountDO == null) {
            throw new BusinessException("账户不存在");
        }
        return accountBuilder.toAccount(accountDO);
    }

    @Override
    public Account save(Account account) throws Exception {
        AccountDO accountDO = accountBuilder.fromAccount(account);
        if (accountDO.getId() == null) {
            accountDAO.insert(accountDO);
        } else {
            accountDAO.update(accountDO);
        }
        return accountBuilder.toAccount(accountDO);
    }
}
