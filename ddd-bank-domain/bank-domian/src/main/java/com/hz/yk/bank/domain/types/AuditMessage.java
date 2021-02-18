package com.hz.yk.bank.domain.types;

import com.hz.yk.bank.domain.entity.Account;
import com.hz.yk.bank.types.AccountNumber;
import com.hz.yk.bank.types.Money;
import com.hz.yk.bank.types.UserId;

import java.util.Date;

/**
 * @author wuzheng.yk
 * @date 2021/2/5
 */
public class AuditMessage {

    private UserId userId;
    private AccountNumber source;
    private AccountNumber target;
    private Money money;
    private Date date;

    public String serialize() {
        return userId + "," + source + "," + target + "," + money + "," + date;
    }

    public AuditMessage(Account sourceAccount, Account targetAccount, Money targetMoney) {

    }
}
