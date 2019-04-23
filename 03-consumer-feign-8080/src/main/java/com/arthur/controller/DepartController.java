package com.arthur.controller;

import com.arthur.service.DepartService;
import com.arthur.model.Depart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * Created by xusheng on 2019/4/11.
 */
@RestController
@RequestMapping("/consumer/depart")
public class DepartController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private DepartService departService;

    private static final String SERVER_PROVIDER = "http://provider-depart/provider";

    @GetMapping("/queryAllDeparts")
    public List<Depart> queryAllDeparts() {
        return departService.queryAllDeparts();
    }

    @GetMapping("/getDepartById/{id}")
    public Depart getDepartById(@PathVariable("id") int id) {
        String url = SERVER_PROVIDER + "/provider/depart/getDepart/" + id;
        return restTemplate.getForObject(url, Depart.class);
    }

    @GetMapping("/discovery")
    public Object discoveryHandle() {
        List<String> services = client.getServices();
        for (String service : services) {
            List<ServiceInstance> instances = client.getInstances(service);
            for (ServiceInstance instance : instances) {
                String serviceId = instance.getServiceId();
                URI uri = instance.getUri();
                String host = instance.getHost();
                int port = instance.getPort();
                System.out.println(serviceId + ":" + uri);
                System.out.println(host + ":" + port);
            }
        }
        return services;
    }
}
