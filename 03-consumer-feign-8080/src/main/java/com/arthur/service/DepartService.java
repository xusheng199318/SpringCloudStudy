package com.arthur.service;

import com.arthur.model.Depart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by xusheng on 2019/4/23.
 */
@FeignClient("provider-depart/provider")
@RequestMapping("/provider/depart")
public interface DepartService {

    @GetMapping("/queryDeparts")
    List<Depart> queryAllDeparts();
}
