package org.hotel_manegement;

import org.hotel_manegement.dao.CustomerDAO;
import org.hotel_manegement.dao.Hotel_AdminDAO;
import org.hotel_manegement.domain.Admin;
import org.hotel_manegement.domain.Customer;
import org.hotel_manegement.ui.CustomerUI;
import org.hotel_manegement.ui.HomeUI;
import org.hotel_manegement.ui.LoginUI;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
//        LoginUI loginUI=new LoginUI();
        new CustomerUI();


    }

}