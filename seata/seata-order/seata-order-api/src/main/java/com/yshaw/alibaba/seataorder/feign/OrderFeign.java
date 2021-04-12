package com.yshaw.alibaba.seataorder.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author shaw
 * @date 2021-04-09
 */
@FeignClient(name = "seata-order", fallbackFactory = OrderFeignFallbackFactory.class)
public interface OrderFeign {

    @PostMapping("order/create")
    void create(@RequestParam("userId") String userId, @RequestParam("commodityCode") String commodityCode,
                @RequestParam("orderCount") int orderCount);

}
