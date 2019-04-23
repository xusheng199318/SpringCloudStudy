package com.arthur.dao;

import com.arthur.model.Depart;

import java.util.List;

public interface DepartDAO {
    void saveDepart(Depart depart);

    Depart getDepartById(int id);

    List<Depart> queryAllDeparts();

}
