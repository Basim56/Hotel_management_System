package org.hotel_manegement.dao;
import static org.hotel_manegement.dao.SQLQueryConstants.*;
import org.hotel_manegement.Mapper.Admin_Mapper;
import org.hotel_manegement.domain.Admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Hotel_AdminDAO extends BaseDAO implements ICrud<Admin>{
Admin_Mapper adminMapper=new Admin_Mapper();
    @Override
    public void insert(Admin obj) {
        try {
            PreparedStatement ps = conn.prepareStatement(CREATE_ADMIN);
            ps.setString(1,obj.getFirst_name());
            ps.setString(2, obj.getLast_name());
            ps.setString(3, obj.getEmail());
            ps.setString(4,obj.getPassword());
            ps.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Admin> getAll() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQLQueryConstants.GET_ALL_ADMINS);
            return adminMapper.getResultList(rs);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Admin getById(Long id) {
        try {
            PreparedStatement ps = conn.prepareStatement(GET_ADMIN_BY_ID);
            ps.setInt(1,id.intValue());
            ResultSet rs=ps.executeQuery();
            return adminMapper.getResultobject(rs);
        }
        catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    @Override
    public void update(Admin obj, Long id) {
        try {
            PreparedStatement ps = conn.prepareStatement(UPDATE_ADMIN);
            ps.setString(1,obj.getFirst_name());
            ps.setString(2,obj.getLast_name());
            ps.setInt(3,id.intValue());
            ps.executeUpdate();
        }
        catch (Exception e){
            throw new RuntimeException();
        }

    }

    @Override
    public void deleteById(Long id) {
        try {
        PreparedStatement ps = conn.prepareStatement(DELETE_ADMIN);
        ps.setInt(1,id.intValue());
        ps.executeUpdate();
        }
        catch (Exception e){
            throw new RuntimeException();
        }
    }
    public Admin getadminByemailandpassword(String email,String password){
        try {
            PreparedStatement ps=conn.prepareStatement(ADMIN_AUTHENTICATION);
            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet rs= ps.executeQuery();
            return adminMapper.getResultobject(rs);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
