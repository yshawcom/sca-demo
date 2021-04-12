package com.yshaw.alibaba.seataorder.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author shaw
 * @date 2021-04-09
 */
public class OrderFeignFallback implements OrderFeign {

    private static final Logger logger = LoggerFactory.getLogger(OrderFeignFallback.class);

    private Throwable throwable;

    public OrderFeignFallback(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public void create(String userId, String commodityCode, int orderCount) {
        logger.error("OrderFeignFallback.create: {}", throwable.getMessage());
    }
}
