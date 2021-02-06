package com.hz.yk.bank.persistence;

import java.math.BigDecimal;

/**
 * 单纯跟数据库表映射
 *
 * @author wuzheng.yk
 * @date 2021/2/5
 */
public class AccountDO {

    private Long id;

    private String accountNumber;
    private Long userId;
    private BigDecimal availableAmout;
    private BigDecimal dailyLimitAmout;
    private String currency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getAvailableAmout() {
        return availableAmout;
    }

    public void setAvailableAmout(BigDecimal availableAmout) {
        this.availableAmout = availableAmout;
    }

    public BigDecimal getDailyLimitAmout() {
        return dailyLimitAmout;
    }

    public void setDailyLimitAmout(BigDecimal dailyLimitAmout) {
        this.dailyLimitAmout = dailyLimitAmout;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "AccountDO{" + "id=" + id + ", accountNumber='" + accountNumber + '\'' + ", userId=" + userId
               + ", availableAmout=" + availableAmout + ", dailyLimitAmout=" + dailyLimitAmout + ", currency='"
               + currency + '\'' + '}';
    }
}
