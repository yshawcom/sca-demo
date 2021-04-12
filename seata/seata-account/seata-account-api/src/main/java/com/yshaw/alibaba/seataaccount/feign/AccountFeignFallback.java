package com.yshaw.alibaba.seataaccount.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author shaw
 * @date 2021-04-09
 */
public class AccountFeignFallback implements AccountFeign {

    private static final Logger logger = LoggerFactory.getLogger(AccountFeignFallback.class);

    private Throwable throwable;

    public AccountFeignFallback(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public void debit(String userId, int money) {
        logger.error("AccountFeignFallback.debit: {}", throwable.getMessage());
    }

}
