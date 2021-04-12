package com.yshaw.alibaba.seatastorage.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author shaw
 * @date 2021-04-09
 */
public class StorageFeignFallback implements StorageFeign {

    private static final Logger logger = LoggerFactory.getLogger(StorageFeignFallback.class);

    private Throwable throwable;

    public StorageFeignFallback(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public void deduct(String commodityCode, int count) {
        logger.error("StorageFeignFallback.deduct: {}", throwable.getMessage());
    }
}
