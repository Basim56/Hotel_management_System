package org.hotel_manegement.services;

import org.hotel_manegement.dao.BookingDAO;
import org.hotel_manegement.dao.CustomerDAO;
import org.hotel_manegement.dao.HotelDAO;
import org.hotel_manegement.dao.RoomDAO;
import org.hotel_manegement.domain.*;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookingService {
    BookingDAO dao=new BookingDAO();
    HotelDAO hdao=new HotelDAO();
    RoomDAO rdao=new RoomDAO();

    CustomerDAO cdao=new CustomerDAO();
    public String[][] searchbyStatus(String status){
        List<Booking> bookingList=dao.getByName(status);
        return transformtoJtable(bookingList,8);

    }


    public String getHotelName(Integer id){
        HotelDAO hotelDAO = new HotelDAO();
        Hotel hotel = hotelDAO.getById(Long.valueOf(id));

        return  hotel.getHotel_name();

    }
    public String getRoomName(Integer id){
        RoomDAO roomDAO=new RoomDAO();
        Room room=roomDAO.getById(Long.valueOf(id));
        return room.getCategory();
    }

    public String getCustomerName(Integer id){
        CustomerDAO customerDAO=new CustomerDAO();
        Customer customer=customerDAO.getById(Long.valueOf(id));
        return customer.getName();

    }

    public String[][] getAllbookingforJtable() {
        List<Booking> bookingList=dao.getAll();
        return transformtoJtable(bookingList,8);

    }
    public String[][] transformtoJtable(List<Booking> bookingList,int columnSize){
        String[][] data=new String[bookingList.size()][columnSize];
        for (int i = 0; i <bookingList.size() ; i++) {
            data[i][0]= String.valueOf(bookingList.get(i).getBooking_id());
            data[i][1]=getHotelName(bookingList.get(i).getHotel_id());
            data[i][2] = getRoomName(bookingList.get(i).getRoom_id());
            data[i][3]=getCustomerName(bookingList.get(i).getCustomer_id());
            data[i][4]=bookingList.get(i).getArrival_date();
            data[i][5]=bookingList.get(i).getDeparture_date();
            data[i][6]= String.valueOf(bookingList.get(i).getPrice());
            data[i][7]=bookingList.get(i).getB_status();
        }
        return data;
    }
    public void save(int hotel_id, int room_id, int customer_id, String arrival_date, String departure_date) throws SQLException {
        Booking booking=Booking.builder()
                .hotel_id(Integer.parseInt(String.valueOf(hotel_id)))
                .room_id(Integer.parseInt(String.valueOf(room_id)))
                .customer_id(Integer.parseInt(String.valueOf(customer_id)))
                .arrival_date(arrival_date)
                .departure_date(departure_date)
                .b_status("Booked")
                .build();
        dao.insert(booking);
    }
    public void update(int hotel_id, int room_id, int customer_id, String arrival_date, String departure_date, String status, int booking_id) throws SQLException {
        Booking booking=Booking.builder()
                .hotel_id(hotel_id)
                .room_id(room_id)
                .customer_id(customer_id)
                .arrival_date(String.valueOf(arrival_date))
                .departure_date(String.valueOf(departure_date))
                .b_status(status)
                .build();
        dao.update(booking, (long) booking_id);
    }
    public void delete(int id){
        dao.deleteById((long) id);
    }
    public String[] Addhotel(){
        List<Hotel> hotelList= hdao.getAll();
        String[] data = new String[hotelList.size()];
        String[][] data3=new String[hotelList.size()][4];
        for (int i = 0; i < hotelList.size(); i++) {
            data3[i][1]=hotelList.get(i).getHotel_name();
            data3[i][0]= String.valueOf(hotelList.get(i).getId());
            data[i] = data3[i][0]+", "+data3[i][1];

        }
        return data;
    }
    public String[] AddRoom(){

        List<Booking> bookingList=dao.getAll();
        List<Room> roomList= rdao.getAll();
        String[] data = new String[bookingList.size()];
        String[][] data2=new String[bookingList.size()][8];
        String[][] data3=new String[roomList.size()][5];
        for (int i = 0; i < bookingList.size(); i++) {
            data3[i][1]=roomList.get(i).getCategory();
            data2[i][2]= String.valueOf(bookingList.get(i).getRoom_id());
            data[i] = data2[i][2]+","+data3[i][1];

        }
        return data;
    }
    public String[] AddCustomer(){
        List<Customer> customerList= cdao.getAll();
        String[] data=new String[customerList.size()];
        String[][] data3=new String[customerList.size()][3];
        for (int i = 0; i < customerList.size(); i++) {
            data3[i][1]=customerList.get(i).getName();
            data3[i][0]= String.valueOf(customerList.get(i).getId());
            data[i] = data3[i][0]+","+data3[i][1];

        }
        return data;
    }
    public String[] getAvailableRoom(Integer hotels, LocalDate arrivalLocalDate, LocalDate departureLocalDate){
        List<Room> rooms = rdao.getAllAvailableRoom(hotels,arrivalLocalDate,departureLocalDate);
        String[] data = new String[rooms.size()];
        String[][] data2 = new String[rooms.size()][2];

        for(int i=0;i<rooms.size();i++) {
            data2[i][0] = String.valueOf(rooms.get(i).getId());
            data2[i][1] = rooms.get(i).getCategory();
            data[i] = data2[i][0]+ ",  "+ data2[i][1];
        }

        return data;
    }
    public String[][] MonthlyReportBooking(String adate, String ddate, Integer id){
        List<Booking> bookingList = dao.getMonthlyReport(adate, ddate, id);
        return transformtoJtable(bookingList, 8);
    }
    public String getTotalPrice(String adate, String ddate, Integer h_id){
        List<Bill> bookingList = dao.getTotalPrice( adate, ddate,h_id);

        Integer price = bookingList.get(0).getTotalprice();
        HotelDAO hotelDAO  = new HotelDAO();
        Hotel hotel = hotelDAO.getById(Long.valueOf(h_id));

        return "The  total  bill  of  Hotel   : "+hotel.getHotel_name()+"  is  "+price;
    }

}
