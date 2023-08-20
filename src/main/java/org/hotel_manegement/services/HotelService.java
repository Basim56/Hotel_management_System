package org.hotel_manegement.services;

import org.hotel_manegement.dao.HotelDAO;
import org.hotel_manegement.domain.Hotel;

import java.sql.SQLException;
import java.util.List;

public class HotelService {
    HotelDAO dao=new HotelDAO();
    public String[][] getHotelbyname(String name){
        List<Hotel> hotelList=dao.getHotelByName(name);
        return transformJtable(hotelList,5);
    }
    public String[][] getAllhotelsforJtable(){
        List<Hotel> hotelList =dao.getAll();
    return transformJtable(hotelList,5);
    }
    private String[][] transformJtable(List<Hotel> hotelList,int columnSize){
        String[][] data=new String[hotelList.size()][columnSize];
        for (int i = 0; i < hotelList.size(); i++) {
            data[i][0]= String.valueOf(hotelList.get(i).getId());
            data[i][1]=hotelList.get(i).getHotel_name();
            data[i][2]=hotelList.get(i).getLocation();
            data[i][3]=hotelList.get(i).getUrl();
            data[i][4]= String.valueOf(hotelList.get(i).getAdmin_id());

        }
        return data;
    }
    public void insert(String hotel_name, String location, String url, int id) throws SQLException {
        Hotel hotel=Hotel.builder()
                .hotel_name(hotel_name)
                .location(location)
                .url(url)
                .admin_id((long) id)
                .build();
        dao.insert(hotel);
    }
    public void update(String hotel_name,String location,String url,int admin_id,int id){
        Hotel hotel=Hotel.builder()
                .hotel_name(hotel_name)
                .location(location)
                .url(url)
                .admin_id((long) admin_id)
                .build();
        dao.update(hotel, (long) id);

    }
    public void delete(int id){
        dao.deleteById((long) id);
    }
}
