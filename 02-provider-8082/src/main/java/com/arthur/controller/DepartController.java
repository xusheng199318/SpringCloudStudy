package com.arthur.controller;

import com.arthur.model.Depart;
import com.arthur.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provider/depart")
public class DepartController {

    @Autowired
    private DepartService departService;

    @PostMapping("/save")
    public void saveDepart(@RequestBody Depart depart) {
        departService.saveDepart(depart);
    }

    @GetMapping("/getDepart/{id}")
    public Depart getDepartById(@PathVariable int id) {
        return departService.getDepartById(id);
    }

    @GetMapping("/queryDeparts")
    public List<Depart> queryAllDeparts() {
        return departService.queryAllDeparts();
    }
}
