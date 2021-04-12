package com.yshaw.alibaba.seataorder.dao;

import com.yshaw.alibaba.seataorder.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author shaw
 * @date 2021-04-09
 */
public interface OrderDao extends JpaRepository<Order, String> {
}
