package org.hotel_manegement.services;

import org.hotel_manegement.dao.CustomerDAO;
import org.hotel_manegement.domain.Customer;

import java.util.List;

public class CustomerService {
    CustomerDAO dao=new CustomerDAO();

    public String[][] searchCustomerbyname(String name){
        List<Customer> customerList=dao.getByName(name);
       return transformtoJtable(customerList,4);

    }


    public String[][] getAllCustomersforJtable(){
        List<Customer> customerList=dao.getAll();
      return transformtoJtable(customerList,4);

    }
    private String[][] transformtoJtable(List<Customer> customerList,int columnSize){
        String[][] data=new String[customerList.size()][columnSize];
        for (int i = 0; i < customerList.size(); i++) {
            data[i][0]= String.valueOf(customerList.get(i).getId());
            data[i][1]=customerList.get(i).getName();
            data[i][2]=customerList.get(i).getPhone_number();
            data[i][3]=customerList.get(i).getCnic();
        }
        return data;
    }

    public void update(String name, String phoneNumber, String cnic,int id){
        Customer customer=Customer.builder()
                .name(name)
                .phone_number(phoneNumber)
                .cnic(cnic)
                .build();
        dao.update(customer, (long) id);
    }

    public void save(String name, String phoneNumber, String cnic) {
        Customer customer=Customer.builder()
                .name(name)
                .phone_number(phoneNumber)
                .cnic(cnic)
                .build();
        dao.insert(customer);
    }
    public void delete(Long id){

        dao.deleteById(id);
    }
}
