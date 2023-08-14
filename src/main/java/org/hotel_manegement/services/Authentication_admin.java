package org.hotel_manegement.services;

import org.hotel_manegement.dao.Hotel_AdminDAO;
import org.hotel_manegement.domain.Admin;

public class Authentication_admin {
   private final Hotel_AdminDAO adminDAO=new Hotel_AdminDAO();

    public Boolean adminlogin(String email,String password){
        Admin admin=adminDAO.getadminByemailandpassword(email,password);

        if(admin!=null){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
