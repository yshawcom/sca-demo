package com.yshaw.alibaba.sentinelapp.feign;

import com.yshaw.alibaba.sentinelapp.feign.fallback.EchoServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author shaw
 * @date 2021-04-08
 */
@FeignClient(name = "nacos-provider", fallbackFactory = EchoServiceFallbackFactory.class)
public interface EchoService {

    @GetMapping(value = "/echo/{str}")
    String echo(@PathVariable("str") String str);

}
