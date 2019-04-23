package com.arthur.service;

import com.arthur.dao.DepartDAO;
import com.arthur.model.Depart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartServiceImpl implements DepartService {

    @Autowired
    private DepartDAO departDAO;

    @Override
    public void saveDepart(Depart depart) {
        departDAO.saveDepart(depart);
    }

    @Override
    public Depart getDepartById(int id) {
        return departDAO.getDepartById(id);
    }

    @Override
    public List<Depart> queryAllDeparts() {
        return departDAO.queryAllDeparts();
    }
}
