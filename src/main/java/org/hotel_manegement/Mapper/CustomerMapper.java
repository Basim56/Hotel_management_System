package org.hotel_manegement.Mapper;

import org.hotel_manegement.domain.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerMapper implements IMapper<Customer>{
    private static final String id="id";
    private static final String CUSTOMER_NAME="customer_name";
    private static final String PHONE_NUMBER="phone_number";
    private static final String CNIC="cnic";
    @Override
    public List<Customer> getResultList(ResultSet rs) throws SQLException {
        List<Customer> customerList=new ArrayList<>();
        while (rs.next()){
            Customer customer=Customer.builder()
                    .id((long) rs.getInt(id))
                    .name(rs.getString(CUSTOMER_NAME))
                    .phone_number(rs.getString(PHONE_NUMBER))
                    .cnic(rs.getString(CNIC))
                    .build();
            customerList.add(customer);
        }
        return customerList;
    }

    @Override
    public Customer getResultobject(ResultSet rs) throws SQLException {
        if(rs.next()){
            return Customer.builder()
                    .id((long) rs.getInt(id))
                    .name(rs.getString(CUSTOMER_NAME))
                    .phone_number(rs.getString(PHONE_NUMBER))
                    .cnic(rs.getString(CNIC))
                    .build();
        }
         return null;
    }
}
