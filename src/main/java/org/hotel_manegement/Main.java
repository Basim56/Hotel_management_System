package org.hotel_manegement;

import org.hotel_manegement.dao.BookingDAO;
import org.hotel_manegement.dao.CustomerDAO;
import org.hotel_manegement.dao.HotelDAO;
import org.hotel_manegement.dao.Hotel_AdminDAO;
import org.hotel_manegement.domain.Admin;
import org.hotel_manegement.domain.Booking;
import org.hotel_manegement.domain.Customer;
import org.hotel_manegement.domain.Hotel;
import org.hotel_manegement.ui.*;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
//        LoginUI loginUI=new LoginUI();
//        Hotel hotel= Hotel.builder()
//                .hotel_name("Basims")
//                .location("Karachi")
//                .url("33255335456")
//                .admin_id(1L)
//                .build();
//        HotelDAO hotelDAO=new HotelDAO();
//        hotelDAO.insert(hotel);
//        hotelDAO.getAll().forEach(System.out::println);
//       new CustomerUI();
//
//        CustomerDAO dao=new CustomerDAO();
//        dao.deleteById(16L);
//        dao.getAll().forEach(System.out::println);
//        new AdminUI();

//        new AddBookingUI();
//        BookingDAO bookingDAO=new BookingDAO();
//        Booking booking= Booking.builder()
//                .hotel_id(1)
//                .room_id(4)
//                .customer_id(3)
//                .arrival_date("2023-06-17")
//                .departure_date("2023-06-25")
//                .booking_date("2023-06-17")
//                .price(50000.0)
//                .b_status("available")
//                .build();
//        bookingDAO.insert(booking);
//        bookingDAO.getAll().forEach(System.out::println);
        new AddBookingUI();
    }


}