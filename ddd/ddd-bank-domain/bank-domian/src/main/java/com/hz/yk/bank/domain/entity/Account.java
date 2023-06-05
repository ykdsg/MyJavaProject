package com.hz.yk.bank.domain.entity;

import com.hz.yk.bank.exception.DailyLimitExceededException;
import com.hz.yk.bank.exception.InsufficientFundsException;
import com.hz.yk.bank.exception.InvalidCurrencyException;
import com.hz.yk.bank.exception.MoneyAmoutNotNullException;
import com.hz.yk.bank.types.AccountId;
import com.hz.yk.bank.types.AccountNumber;
import com.hz.yk.bank.types.Currency;
import com.hz.yk.bank.types.Money;
import com.hz.yk.bank.types.UserId;

/**
 * Entity实体类：Account 是基于领域逻辑的实体类，它的字段和数据库储存不需要有必然的联系。Entity包含数据，同时也应该包含行为。在 Account 里，字段也不仅仅是String等基础类型，而应该尽可能用上一讲的 Domain Primitive 代替，可以避免大量的校验代码。
 *
 * @author wuzheng.yk
 * @date 2021/2/5
 */
public class Account {

    private AccountId id;
    private AccountNumber accountNumber;
    private UserId userId;
    private Money available;
    private Money dailyLimit;

    private Currency currency;

    // 转出
    public void withdraw(Money money) throws Exception, DailyLimitExceededException {
        if (this.available.compareTo(money) < 0) {
            throw new InsufficientFundsException();
        }

        if (this.dailyLimit.compareTo(money) < 0) {
            throw new DailyLimitExceededException();
        }

        this.available = this.available.subtract(money);
    }

    // 转入
    public void deposit(Money money) throws InvalidCurrencyException, MoneyAmoutNotNullException {
        if (!this.getCurrency().equals(money.getCurrency())) {
            throw new InvalidCurrencyException();
        }

        this.available = this.available.add(money);

    }

    public AccountId getId() {
        return id;
    }

    public void setId(AccountId id) {
        this.id = id;
    }

    public AccountNumber getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(AccountNumber accountNumber) {
        this.accountNumber = accountNumber;
    }

    public UserId getUserId() {
        return userId;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    public Money getAvailable() {
        return available;
    }

    public void setAvailable(Money available) {
        this.available = available;
    }

    public Money getDailyLimit() {
        return dailyLimit;
    }

    public void setDailyLimit(Money dailyLimit) {
        this.dailyLimit = dailyLimit;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
