package com.hz.yk.bank.persistence;

/**
 * DAO对应的是一个特定的数据库类型的操作，相当于SQL的封装。所有操作的对象都是DO类，所有接口都可以根据数据库实现的不同而改变。
 *
 * @author wuzheng.yk
 * @date 2021/2/5
 */
public interface AccountDAO {

    int insert(AccountDO accountDO);

    int update(AccountDO accountDO);

    AccountDO selectByUserId(Long id);

    AccountDO selectByAccountNumber(String accountNumber);

    AccountDO selectById(Long id);

}
