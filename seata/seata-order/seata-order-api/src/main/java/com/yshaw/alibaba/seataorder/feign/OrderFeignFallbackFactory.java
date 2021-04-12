package com.yshaw.alibaba.seataorder.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author shaw
 * @date 2021-04-09
 */
@Component
public class OrderFeignFallbackFactory implements FallbackFactory<OrderFeignFallback> {

    @Override
    public OrderFeignFallback create(Throwable throwable) {
        return new OrderFeignFallback(throwable);
    }

}
