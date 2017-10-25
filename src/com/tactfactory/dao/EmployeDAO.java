package com.tactfactory.dao;

import java.util.ArrayList;
import java.util.List;

import com.tactfactory.model.Employe;

public class EmployeDAO implements DAO<Employe> {
    private static volatile EmployeDAO instance = null;

    private List<Employe> data = new ArrayList<>();

    private EmployeDAO() {
        this.data.add(new Employe("Durant", "Michele"));
        this.data.add(new Employe("Durand", "Michel"));
        this.data.add(new Employe("Dupont", "Helêne"));
    }

    @Override
    public List<Employe> findAll() {
        return this.data;
    }

    public static EmployeDAO getInstance() {
        if (instance == null) {
            instance = new EmployeDAO();
        }

        return instance;
    }
}
