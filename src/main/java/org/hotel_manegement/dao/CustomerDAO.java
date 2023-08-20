package org.hotel_manegement.dao;

import org.hotel_manegement.Mapper.CustomerMapper;
import org.hotel_manegement.domain.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.hotel_manegement.dao.SQLQueryConstants.*;

public class CustomerDAO extends BaseDAO implements ICrud<Customer>{
    CustomerMapper customerMapper=new CustomerMapper();

    @Override
    public void insert(Customer obj) {
        try {
            PreparedStatement ps = conn.prepareStatement(CREATE_CUSTOMER);
            ps.setString(1, obj.getName());
            ps.setString(2,obj.getPhone_number());
            ps.setString(3,obj.getCnic());
            ps.executeUpdate();
        }
        catch (SQLException e){
            throw new RuntimeException(e);

        }

    }

    @Override
    public List<Customer> getAll() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery(GET_ALL_CUSTOMERS);
            return customerMapper.getResultList(rs);
        }
        catch (Exception e){
          throw new RuntimeException(e);
        }
    }

    @Override
    public Customer getById(Long id) {
        try {
            PreparedStatement ps = conn.prepareStatement(GET_CUSTOMER_BY_ID);
            ps.setLong(1,id.intValue());
            ResultSet rs=ps.executeQuery();
            return customerMapper.getResultobject(rs);
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Customer obj, Long id) {
        try {
            PreparedStatement ps = conn.prepareStatement(UPDATE_CUSTOMER);
            ps.setString(1,obj.getName());
            ps.setString(2,obj.getPhone_number());
            ps.setString(3,obj.getCnic());
            ps.setLong(4,id.intValue());
            ps.executeUpdate();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            PreparedStatement pd = conn.prepareStatement(DELETE_CUSTOMER);
            pd.setInt(1,id.intValue());
            pd.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
    public List<Customer> getByName(String name) {

        try {
            PreparedStatement ps = conn.prepareStatement("select * from customer where customer_name like '%"+name+"%';");
            ResultSet rs=ps.executeQuery();
            return customerMapper.getResultList(rs);
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
