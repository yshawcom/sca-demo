package com.yshaw.alibaba.seataaccount.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author shaw
 * @date 2021-04-09
 */
@FeignClient(name = "seata-account", fallbackFactory = AccountFeignFallbackFactory.class)
public interface AccountFeign {

    /**
     * 从用户账户中借出
     *
     * @param userId
     * @param money
     */
    @PostMapping("account/debit")
    void debit(@RequestParam("userId") String userId, @RequestParam("money") int money);

}
