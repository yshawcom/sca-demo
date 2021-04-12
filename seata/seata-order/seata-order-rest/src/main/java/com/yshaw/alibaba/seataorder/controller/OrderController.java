package com.yshaw.alibaba.seataorder.controller;

import com.yshaw.alibaba.seataorder.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shaw
 * @date 2021-04-09
 */
@RestController
@RequestMapping("order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("create")
    public void create(@RequestParam("userId") String userId, @RequestParam("commodityCode") String commodityCode,
                       @RequestParam("orderCount") int orderCount) {
        orderService.create(userId, commodityCode, orderCount);
    }

}
