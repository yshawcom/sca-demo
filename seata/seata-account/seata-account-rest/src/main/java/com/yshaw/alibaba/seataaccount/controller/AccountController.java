package com.yshaw.alibaba.seataaccount.controller;

import com.yshaw.alibaba.seataaccount.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shaw
 * @date 2021-04-09
 */
@RestController
@RequestMapping("account")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 从用户账户中借出
     *
     * @param userId
     * @param money
     */
    @PostMapping("debit")
    public void debit(@RequestParam("userId") String userId, @RequestParam("money") int money) {
        accountService.debit(userId, money);
    }

}
