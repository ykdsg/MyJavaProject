package com.hz.yk.bank.repository;

import com.hz.yk.bank.domain.entity.Account;
import com.hz.yk.bank.types.AccountId;
import com.hz.yk.bank.types.AccountNumber;
import com.hz.yk.bank.types.UserId;

/**
 * Repository对应的是Entity对象读取储存的抽象，在接口层面做统一，不关注底层实现。比如，通过 save 保存一个Entity对象，但至于具体是 insert 还是 update 并不关心。Repository的具体实现类通过调用DAO来实现各种操作
 *
 * @author wuzheng.yk
 * @date 2021/2/5
 */
public interface AccountRepository {

    Account find(AccountId id) throws Exception;

    Account find(AccountNumber accountNumber) throws Exception;

    Account find(UserId userId) throws Exception;

    Account save(Account account) throws Exception;
}
