package com.yshaw.alibaba.seatastorage.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author shaw
 * @date 2021-04-09
 */
@FeignClient(name = "seata-storage", fallbackFactory = StorageFeignFallbackFactory.class)
public interface StorageFeign {

    @PostMapping("storage/deduct")
    void deduct(@RequestParam("commodityCode") String commodityCode, @RequestParam("count") int count);

}
