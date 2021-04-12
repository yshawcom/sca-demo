package com.yshaw.alibaba.seatabusiness.service;

/**
 * 业务
 *
 * @author shaw
 * @date 2021-04-09
 */
public interface BusinessService {

    /**
     * 采购
     */
    void purchase(String userId, String commodityCode, int orderCount);

}
