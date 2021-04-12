package com.yshaw.alibaba.seataaccount.service.impl;

import com.yshaw.alibaba.seataaccount.dao.AccountDao;
import com.yshaw.alibaba.seataaccount.model.Account;
import com.yshaw.alibaba.seataaccount.service.AccountService;
import io.seata.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * 账户服务
 *
 * @author shaw
 * @date 2021-04-09
 */
@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    private Random random;
    private AccountDao accountDao;

    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
        this.random = new Random();
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void debit(String userId, int money) {
        logger.info("Account Service ... xid: " + RootContext.getXID());

        if (random.nextBoolean()) {
            throw new RuntimeException("this is a mock Exception");
        }

        Account account = accountDao.findTopByUserId(userId);
        if (account == null) {
            throw new RuntimeException("没有用户 " + userId);
        }

        int remainingMoney = account.getMoney() - money;
        if (remainingMoney < 0) {
            throw new RuntimeException("用户 " + userId + " 余额不足");
        }
        account.setMoney(remainingMoney);
        accountDao.save(account);

        logger.info("Account Service End ... ");
    }

}
