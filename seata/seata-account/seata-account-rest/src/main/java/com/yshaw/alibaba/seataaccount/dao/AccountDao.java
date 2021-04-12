package com.yshaw.alibaba.seataaccount.dao;

import com.yshaw.alibaba.seataaccount.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 账户
 *
 * @author shaw
 * @date 2021-04-09
 */
public interface AccountDao extends JpaRepository<Account, Integer> {

    Account findTopByUserId(String userId);

}
