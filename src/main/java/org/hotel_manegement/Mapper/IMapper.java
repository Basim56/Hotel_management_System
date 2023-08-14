package org.hotel_manegement.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IMapper<T>{
    List<T> getResultList(ResultSet rs) throws SQLException;
    T getResultobject(ResultSet rs) throws SQLException;
}
