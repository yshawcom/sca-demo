package com.yshaw.alibaba.seatabusiness.service.impl;

import com.yshaw.alibaba.seatabusiness.service.BusinessService;
import com.yshaw.alibaba.seataorder.feign.OrderFeign;
import com.yshaw.alibaba.seatastorage.feign.StorageFeign;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务
 *
 * @author shaw
 * @date 2021-04-09
 */
@Service
public class BusinessServiceImpl implements BusinessService {

    private StorageFeign storageFeign;
    private OrderFeign orderFeign;

    public BusinessServiceImpl(StorageFeign storageFeign, OrderFeign orderFeign) {
        this.storageFeign = storageFeign;
        this.orderFeign = orderFeign;
    }

    @Override
    @GlobalTransactional
    @Transactional(rollbackFor = RuntimeException.class)
    public void purchase(String userId, String commodityCode, int orderCount) {
        // 扣库存
        storageFeign.deduct(commodityCode, orderCount);
        // 下订单
        orderFeign.create(userId, commodityCode, orderCount);
    }

}
