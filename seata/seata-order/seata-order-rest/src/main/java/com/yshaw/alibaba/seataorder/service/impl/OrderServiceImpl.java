package com.yshaw.alibaba.seataorder.service.impl;

import com.yshaw.alibaba.seataaccount.feign.AccountFeign;
import com.yshaw.alibaba.seataorder.dao.OrderDao;
import com.yshaw.alibaba.seataorder.model.Order;
import com.yshaw.alibaba.seataorder.service.OrderService;
import io.seata.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * 订单服务
 *
 * @author shaw
 * @date 2021-04-09
 */
@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    private final AccountFeign accountFeign;
    private final OrderDao orderDao;
    private Random random;

    public OrderServiceImpl(OrderDao orderDao, AccountFeign accountFeign) {
        this.orderDao = orderDao;
        this.accountFeign = accountFeign;
        this.random = new Random();
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void create(String userId, String commodityCode, int orderCount) {
        logger.info("Order Service Begin ... xid: " + RootContext.getXID());

        int orderMoney = calculate(commodityCode, orderCount);

        // 扣款
        accountFeign.debit(userId, orderMoney);

        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(orderCount);
        order.setMoney(orderMoney);
        orderDao.save(order);

        if (random.nextBoolean()) {
            throw new RuntimeException("this is a mock Exception");
        }

        logger.info("Order Service End ... Created " + order);
    }

    private int calculate(String commodityCode, int orderCount) {
        // 假设商品单价为 2
        return 2 * orderCount;
    }

}
