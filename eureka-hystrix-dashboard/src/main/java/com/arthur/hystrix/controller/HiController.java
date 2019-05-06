package com.arthur.hystrix.controller;

import com.arthur.hystrix.service.HiService;
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
    private HiService service;

    @GetMapping("/hi")
    public String sayHi(@RequestParam(required = false, defaultValue = "wangwu") String name) {
        return service.sayHi(name);
    }
}
