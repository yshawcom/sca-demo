package com.yshaw.alibaba.seatastorage.controller;

import com.yshaw.alibaba.seatastorage.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shaw
 * @date 2021-04-08
 */
@RestController
@RequestMapping("storage")
public class StorageController {

    private static final Logger logger = LoggerFactory.getLogger(StorageController.class);

    private final StorageService storageService;

    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("deduct")
    public void deduct(@RequestParam("commodityCode") String commodityCode, @RequestParam("count") int count) {
        storageService.deduct(commodityCode, count);
    }

}
