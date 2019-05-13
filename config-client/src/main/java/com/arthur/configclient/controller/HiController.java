package com.arthur.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xusheng on 2019/5/13.
 */
@RestController
public class HiController {

    @Value("${foo}")
    private String foo;

    @GetMapping("/hi")
    public String sayHi() {
        return foo;
    }
}
