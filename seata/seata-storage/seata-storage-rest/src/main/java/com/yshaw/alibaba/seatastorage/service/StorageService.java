package com.yshaw.alibaba.seatastorage.service;

/**
 * 仓储服务
 *
 * @author shaw
 * @date 2021-04-09
 */
public interface StorageService {

    /**
     * 扣除存储数量
     */
    void deduct(String commodityCode, int count);

}
