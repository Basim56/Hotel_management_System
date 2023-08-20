package org.hotel_manegement.services;

import org.hotel_manegement.dao.CustomerDAO;
import org.hotel_manegement.dao.HotelDAO;
import org.hotel_manegement.dao.RoomDAO;
import org.hotel_manegement.domain.Customer;
import org.hotel_manegement.domain.Hotel;
import org.hotel_manegement.domain.Room;

import java.time.LocalDate;
import java.util.List;

public class ReportService {
    HotelDAO hdao=new HotelDAO();
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
    public String getHotelName(Integer id){
        HotelDAO hotelDAO = new HotelDAO();
        Hotel hotel = hotelDAO.getById(Long.valueOf(id));

        return  hotel.getHotel_name();

    }
    public String getRoomName(Integer id){
        RoomDAO rDAO = new RoomDAO();
        Room room = rDAO.getById(Long.valueOf(id));

        return  room.getCategory();
    }
    public String getCustomerName(Integer id){
        CustomerDAO cDao=new CustomerDAO();
        Customer customer= cDao.getById(Long.valueOf(id));

        return customer.getName();
    }
    public String[][] getAvailableRoom(Integer id, String a_date, String d_Date){
        RoomDAO roomDAO = new RoomDAO();
        List<Room> roomList = roomDAO.getAllAvailableRoom(id, LocalDate.parse(a_date), LocalDate.parse(d_Date));

        return convertValuesIntoJTableForRoom(roomList, 6);
    }

    private String[][] convertValuesIntoJTableForRoom(List<Room> roomList, int columnSize) {

        String[][] data = new String[roomList.size()][columnSize];

        for(int i=0; i<roomList.size(); i++){
            data[i][0] = String.valueOf(roomList.get(i).getId());
            data[i][1] = roomList.get(i).getRoom_floor();
            data[i][2] = roomList.get(i).getCategory();
            data[i][3] = roomList.get(i).getUrl();
            data[i][4] = String.valueOf(roomList.get(i).getPrice());
            data[i][5] = String.valueOf(roomList.get(i).getHotel_id());
        }

        return data;
    }

}
