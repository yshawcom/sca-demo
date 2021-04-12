package com.yshaw.alibaba.sentinelapp.feign.fallback;

import com.yshaw.alibaba.sentinelapp.feign.EchoService;

/**
 * @author shaw
 * @date 2021-04-08
 */
public class EchoServiceFallback implements EchoService {

    private Throwable throwable;

    EchoServiceFallback(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public String echo(String str) {
        return "consumer-fallback-default-str" + throwable.getMessage();
    }

}
