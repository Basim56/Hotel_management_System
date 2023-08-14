package org.hotel_manegement.dao;

import java.sql.SQLException;
import java.util.List;

public interface ICrud<T> {
    void insert(T obj) throws SQLException;
    List<T> getAll();
    T getById(Long id);
    void update(T obj, Long id);
    void deleteById(Long id);
}

