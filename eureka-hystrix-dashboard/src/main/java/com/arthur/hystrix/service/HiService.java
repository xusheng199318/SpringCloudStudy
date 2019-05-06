package com.arthur.hystrix.service;

import com.arthur.hystrix.config.FeignConfig;
import com.arthur.hystrix.config.HiHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xusheng on 2019/5/6.
 */
@FeignClient(value = "eureka-client",
        configuration = FeignConfig.class,
        fallback = HiHystrix.class)
public interface HiService {

    @GetMapping("/hi")
    String sayHi(@RequestParam(value = "name", required = false) String name);
}
