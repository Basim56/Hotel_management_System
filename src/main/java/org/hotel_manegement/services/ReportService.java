package org.hotel_manegement.services;

import org.hotel_manegement.dao.HotelDAO;
import org.hotel_manegement.domain.Hotel;

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
}
