package com.yshaw.alibaba.seatastorage.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author shaw
 * @date 2021-04-09
 */
@Component
public class StorageFeignFallbackFactory implements FallbackFactory<StorageFeignFallback> {

    @Override
    public StorageFeignFallback create(Throwable throwable) {
        return new StorageFeignFallback(throwable);
    }

}
