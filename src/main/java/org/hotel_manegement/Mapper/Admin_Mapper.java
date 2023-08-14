package org.hotel_manegement.Mapper;

import org.hotel_manegement.domain.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Admin_Mapper implements IMapper<Admin>{
    private static final String ID="id";
    private static final String FIRST_NAME="first_name";
    private static final String LAST_NAME="last_name";
    private static final String EMAIL="email";
    private static final String PASSWORD="admin_password";

    @Override
    public List<Admin> getResultList(ResultSet rs) throws SQLException {
        List<Admin> adminList=new ArrayList<>();
        while (rs.next()){
            Admin admin=Admin.builder()
                    .id(rs.getInt(ID))
                    .first_name(rs.getString(FIRST_NAME))
                    .last_name(rs.getString(LAST_NAME))
                    .email(rs.getString(EMAIL))
                    .password(rs.getString(PASSWORD))
                    .build();
            adminList.add(admin);
        }
        return adminList;
    }

    @Override
    public Admin getResultobject(ResultSet rs) throws SQLException {
        if(rs.next()){
            return Admin.builder()
                    .id(rs.getInt(ID))
                    .first_name(rs.getString(FIRST_NAME))
                    .last_name(rs.getString(LAST_NAME))
                    .email(rs.getString(EMAIL))
                    .password(rs.getString(PASSWORD))
                    .build();
        }
        return null;
    }
}
