package com.arthur.feign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xusheng on 2019/5/6.
 */
@Service
public class HiService {

    @Autowired
    private EurekaFeignClient feignClient;

    public String sayHi(String name) {
        return feignClient.sayHiFromClientEureka(name);
    }
}
