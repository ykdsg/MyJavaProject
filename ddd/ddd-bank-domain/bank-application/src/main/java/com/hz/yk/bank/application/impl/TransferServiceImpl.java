package com.hz.yk.bank.application.impl;

import com.hz.yk.bank.application.TransferService;
import com.hz.yk.bank.common.Result;
import com.hz.yk.bank.domain.entity.Account;
import com.hz.yk.bank.domain.service.AccountTransferService;
import com.hz.yk.bank.domain.types.AuditMessage;
import com.hz.yk.bank.exception.DailyLimitExceededException;
import com.hz.yk.bank.external.ExchangeRateService;
import com.hz.yk.bank.messaging.AuditMessageProducer;
import com.hz.yk.bank.repository.AccountRepository;
import com.hz.yk.bank.types.AccountNumber;
import com.hz.yk.bank.types.Currency;
import com.hz.yk.bank.types.ExchangeRate;
import com.hz.yk.bank.types.Money;
import com.hz.yk.bank.types.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author wuzheng.yk
 * @date 2021/2/5
 */
@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AuditMessageProducer auditMessageProducer;
    @Autowired
    private ExchangeRateService exchangeRateService;
    @Autowired
    private AccountTransferService accountTransferService;

    //    @Transactional(rollbackFor = Exception.class)
    @Override
    public Result<Boolean> transfer(Long sourceUserId, String targetAccountNumber, BigDecimal targetAmount,
                                    String targetCurrency) throws Exception, DailyLimitExceededException {
        // 参数校验
        Money targetMoney = new Money(targetAmount, new Currency(targetCurrency));

        // 读数据
        Account sourceAccount = accountRepository.find(new UserId(sourceUserId));
        Account targetAccount = accountRepository.find(new AccountNumber(targetAccountNumber));
        ExchangeRate exchangeRate = exchangeRateService
                .getExchangeRate(sourceAccount.getCurrency(), targetMoney.getCurrency());

        // 业务逻辑
        accountTransferService.transfer(sourceAccount, targetAccount, targetMoney, exchangeRate);

        // 保存数据
        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);

        // 发送审计消息
        AuditMessage message = new AuditMessage(sourceAccount, targetAccount, targetMoney);
        auditMessageProducer.send(message);

        return Result.success(true);
    }

}
