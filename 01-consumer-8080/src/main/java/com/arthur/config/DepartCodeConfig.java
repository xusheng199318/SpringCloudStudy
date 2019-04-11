package com.arthur.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by xusheng on 2019/4/11.
 */
@Configuration
public class DepartCodeConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
