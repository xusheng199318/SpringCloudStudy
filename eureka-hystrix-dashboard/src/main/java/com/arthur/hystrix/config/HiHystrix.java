package com.arthur.hystrix.config;

import com.arthur.hystrix.service.HiService;
import org.springframework.stereotype.Component;

/**
 * Created by xusheng on 2019/5/6.
 */
@Component
public class HiHystrix implements HiService {

    public String sayHi(String name) {
        return "hi " + name + " ,sorry ,error";
    }
}
