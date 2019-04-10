package com.arthur.service;

import com.arthur.model.Depart;

import java.util.List;

public interface DepartService {
    void saveDepart(Depart depart);

    Depart getDepartById(int id);

    List<Depart> queryAllDeparts();
}
