package com.yshaw.alibaba.seataorder.service;

import com.yshaw.alibaba.seataorder.model.Order;

/**
 * 订单服务
 *
 * @author shaw
 * @date 2021-04-09
 */
public interface OrderService {

    /**
     * 创建订单
     */
    void create(String userId, String commodityCode, int orderCount);

}
