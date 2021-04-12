package com.yshaw.alibaba.sentinelapp.cotroller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.yshaw.alibaba.sentinelapp.feign.EchoService;
import com.yshaw.alibaba.sentinelapp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shaw
 * @date 2021-04-08
 */
@RestController
public class TestController {

    private final TestService testService;
    private final EchoService echoService;

    public TestController(TestService testService, EchoService echoService) {
        this.testService = testService;
        this.echoService = echoService;
    }

    @GetMapping(value = "/hello")
    @SentinelResource("hello")
    public String hello() {
        return "Hello Sentinel";
    }

    @GetMapping(value = "/hello/{name}")
    public String apiHello(@PathVariable String name) {
        return testService.sayHello(name);
    }

    @GetMapping(value = "/feign/nacos-provider/echo/{str}")
    public String echo(@PathVariable String str) {
        return echoService.echo(str);
    }

}
