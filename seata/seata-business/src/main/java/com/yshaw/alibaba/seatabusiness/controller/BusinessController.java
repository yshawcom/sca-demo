package com.yshaw.alibaba.seatabusiness.controller;

import com.yshaw.alibaba.seatabusiness.service.BusinessService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shaw
 * @date 2021-04-09
 */
@RestController
@RequestMapping("business")
public class BusinessController {

    private final BusinessService businessService;

    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @PostMapping("purchase")
    public void purchase(@RequestParam("userId") String userId, @RequestParam("commodityCode") String commodityCode,
                         @RequestParam("orderCount") int orderCount) {
        businessService.purchase(userId, commodityCode, orderCount);
    }
}
