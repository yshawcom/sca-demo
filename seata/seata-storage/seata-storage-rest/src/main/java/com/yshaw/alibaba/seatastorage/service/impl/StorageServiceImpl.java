package com.yshaw.alibaba.seatastorage.service.impl;

import com.yshaw.alibaba.seatastorage.dao.StorageDao;
import com.yshaw.alibaba.seatastorage.model.Storage;
import com.yshaw.alibaba.seatastorage.service.StorageService;
import io.seata.core.context.RootContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 仓储服务
 *
 * @author shaw
 * @date 2021-04-09
 */
@Service
public class StorageServiceImpl implements StorageService {

    private static final Logger logger = LoggerFactory.getLogger(StorageServiceImpl.class);

    private final StorageDao storageDao;

    public StorageServiceImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void deduct(String commodityCode, int count) {
        logger.info("Storage Service Begin ... xid: " + RootContext.getXID());

        Storage storage = storageDao.findTopByCommodityCode(commodityCode);
        if (storage == null) {
            throw new RuntimeException("没有商品 " + commodityCode);
        }

        int remainingCount = storage.getCount() - count;
        if (remainingCount < 0) {
            throw new RuntimeException("商品 " + commodityCode + " 剩余库存数量不足");
        }
        storage.setCount(storage.getCount() - count);
        storageDao.save(storage);

        logger.info("Storage Service End ... ");
    }

}
