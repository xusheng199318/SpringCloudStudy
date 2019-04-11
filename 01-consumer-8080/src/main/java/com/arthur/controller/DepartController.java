package com.arthur.controller;

import com.arthur.model.Depart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by xusheng on 2019/4/11.
 */
@RestController
@RequestMapping("/consumer/depart")
public class DepartController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String SERVER_PROVIDER = "http://localhost:8081/provider";

    @GetMapping("/queryAllDeparts")
    public List<Depart> queryAllDeparts() {
        String url = SERVER_PROVIDER + "/provider/depart/queryDeparts";
        return restTemplate.getForObject(url, List.class);
    }

    @GetMapping("/getDepartById/{id}")
    public Depart getDepartById(@PathVariable("id") int id) {
        String url = SERVER_PROVIDER + "/provider/depart/getDepart/" + id;
        return restTemplate.getForObject(url, Depart.class);
    }
}
