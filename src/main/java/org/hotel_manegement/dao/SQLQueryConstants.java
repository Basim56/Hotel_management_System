package org.hotel_manegement.dao;

public class SQLQueryConstants {
    public static final String GET_ALL_CUSTOMERS ="select * from customer";
    public static final String CREATE_CUSTOMER="insert into customer(customer_name,phone_number,cnic) values(?,?,?)";
    public static final String GET_CUSTOMER_BY_ID="select * from customer where id = ?";
    public static final String UPDATE_CUSTOMER="update customer set customer_name=? where id=?";

    public static final String DELETE_CUSTOMER="delete from customer where id=?";
    public static final String GET_ALL_ADMINS ="select * from hotel_admin";
    public static final String CREATE_ADMIN="insert into hotel_admin(first_name,last_name,email,admin_password) values(?,?,?,?)";
    public static final String GET_ADMIN_BY_ID="select * from admin where id=?";
    public static final String UPDATE_ADMIN="update hotel_admin set first_name=?,last_name=? where id =?";
    public static final String DELETE_ADMIN="delete from hotel_admin where id = ? ";
    public static final String GET_ALL_BOOKINGS="select * from booking";
    public static final String CREATE_BOOKING="insert into booking(h_id,r_id,c_id,arrival_date,departure_date,booking_date,price) values" +
            "(?,?,?,?,?,?,?)";
    public static final String GET_BOOKING_BY_ID="select * from booking where id =?";
    public static final String UPDATE_BOOKING="update booking \n" +
            "set h_id=?,r_id=?,c_id=? where b_id=?";
    public static final String DELETE_BOOKING="delete from booking where id = ?";

    public static final String GET_ALL_HOTELS="select * from hotel";
    public static final String GET_HOTEL_BY_ID="select * from hotel where id=?";
    public static final String CREATE_HOTEL="insert into hotel(hotel_name,location,url,admin_id) values (?,?,?,?)";
    public static final String UPDATE_HOTEL="update hotel set hotel_name=?,location=? where id=?";
    public static final String DELETE_HOTEL="delete from hotel where id=?";
    public static final String GET_ALL_ROOMS="select * from room";
    public static final String GET_ROOM_BY_ID="select * from room where id=?";
    public static final String CREATE_ROOM="insert into room(category,room_floor,price,hotel_id,url) values (?,?,?,?,?)";
    public static final String UPDATE_ROOM="update room set category=?,room_floor=? where id=?";
    public static final String DELETE_ROOM="delete from room where id=?";
    public static final String ADMIN_AUTHENTICATION="select * from hotel_admin where email = ? AND admin_password= ?";







}
