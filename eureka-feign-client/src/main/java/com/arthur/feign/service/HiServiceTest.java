package com.arthur.feign.service;

import com.arthur.feign.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xusheng on 2019/5/6.
 */
@FeignClient(value = "eureka-client", configuration = FeignConfig.class)
public interface HiServiceTest {

    @GetMapping("/hi")
    String sayHi(@RequestParam("name") String name);
}
