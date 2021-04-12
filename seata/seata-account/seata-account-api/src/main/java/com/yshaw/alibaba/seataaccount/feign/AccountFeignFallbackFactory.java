package com.yshaw.alibaba.seataaccount.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author shaw
 * @date 2021-04-09
 */
@Component
public class AccountFeignFallbackFactory implements FallbackFactory<AccountFeignFallback> {

    @Override
    public AccountFeignFallback create(Throwable throwable) {
        return new AccountFeignFallback(throwable);
    }

}
