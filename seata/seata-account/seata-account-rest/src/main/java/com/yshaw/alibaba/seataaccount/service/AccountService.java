package com.yshaw.alibaba.seataaccount.service;

/**
 * 帐户服务
 *
 * @author shaw
 * @date 2021-04-09
 */
public interface AccountService {

    /**
     * 从用户账户中借出
     *
     * @param userId
     * @param money
     */
    void debit(String userId, int money);

}
