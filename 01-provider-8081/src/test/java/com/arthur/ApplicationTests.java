package com.arthur;

import com.arthur.model.Depart;
import com.arthur.service.DepartService;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.arthur.dao")
@Log4j2
public class ApplicationTests {

    @Autowired
    private DepartService departService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSaveDepart() {
        Depart depart = new Depart();
        depart.setName("开发部");
        depart.setDbase("上海");
        departService.saveDepart(depart);
        log.info("return departId is {}", depart.getId());
    }

}
