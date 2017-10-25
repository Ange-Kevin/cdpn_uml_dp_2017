package com.tactfactory.dao;

import java.util.List;

public interface DAO<T> {
    List<T> findAll();
}
