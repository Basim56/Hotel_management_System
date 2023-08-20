package org.hotel_manegement.services;

import org.hotel_manegement.dao.Hotel_AdminDAO;
import org.hotel_manegement.dao.ICrud;
import org.hotel_manegement.domain.Admin;

import java.util.ArrayList;
import java.util.List;

public class AdminService {
   Hotel_AdminDAO dao=new Hotel_AdminDAO();

    public String[][] searchAdminByName(String name){
        List<Admin> adminList=dao.getByName(name);
        return transformtoJtable(adminList,5);
    }
    public String[][] getAllAdminsForJtable(){
        List<Admin> adminList=dao.getAll();
        return transformtoJtable(adminList,5);
    }
    public String[][] transformtoJtable(List<Admin> adminList,int columnSize){
        String[][] data=new String[adminList.size()][columnSize];
        for (int i = 0; i < adminList.size(); i++) {
            data[i][0]= String.valueOf(adminList.get(i).getId());
            data[i][1]=adminList.get(i).getFirst_name();
            data[i][2]=adminList.get(i).getLast_name();
            data[i][3]=adminList.get(i).getEmail();
            data[i][4]=adminList.get(i).getPassword();
        }
        return data;
    }
    public void insert(String firstName,String lastName,String email,String password){
        Admin admin= Admin.builder()
                .first_name(firstName)
                .last_name(lastName)
                .email(email)
                .password(password)
                .build();
        dao.insert(admin);
    }
 public void update(String first_name,String last_name,String email,String password,int id){
        Admin admin=Admin.builder()
                .first_name(first_name)
                .last_name(last_name)
                .email(email)
                .password(password)
                .build();
        dao.update(admin, (long) id);
 }
 public void delete(int id){
        dao.deleteById((long) id);
 }
}
