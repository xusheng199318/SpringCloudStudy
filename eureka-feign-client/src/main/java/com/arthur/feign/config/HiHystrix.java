package com.arthur.feign.config;

import com.arthur.feign.service.HiServiceTest;
import org.springframework.stereotype.Component;

/**
 * Created by xusheng on 2019/5/6.
 */
@Component
public class HiHystrix implements HiServiceTest {

    public String sayHi(String name) {
        return "hi " + name + " ,sorry ,error";
    }
}
