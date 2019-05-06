package com.arthur.feign.controller;

import com.arthur.feign.service.HiService;
import com.arthur.feign.service.HiServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xusheng on 2019/5/6.
 */
@RestController
public class HiController {

    @Autowired
    private HiService hiService;

    @Autowired
    private HiServiceTest serviceTest;

    @GetMapping("/hi")
    public String sayHi(@RequestParam(required = false, defaultValue = "lisi") String name) {
        return hiService.sayHi(name);
    }

    @GetMapping("/hiTest")
    public String hiTest(@RequestParam(required = false, defaultValue = "zhangsan") String name) {
        return serviceTest.sayHi(name);
    }
}
