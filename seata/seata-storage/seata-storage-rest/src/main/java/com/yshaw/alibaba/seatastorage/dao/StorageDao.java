package com.yshaw.alibaba.seatastorage.dao;

import com.yshaw.alibaba.seatastorage.model.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 库存
 *
 * @author shaw
 * @date 2021-04-09
 */
public interface StorageDao extends JpaRepository<Storage, Integer> {

    Storage findTopByCommodityCode(String commodityCode);

}
