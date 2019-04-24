package com.arthur;

import com.arthur.service.CustomRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@EnableFeignClients(basePackages = "com.arthur.service")
@EnableEurekaClient
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public IRule loadBalanceRule() {
		List<Integer> excludePorts = new ArrayList<>();
		excludePorts.add(8080);
		return new CustomRule(excludePorts);
	}
}
