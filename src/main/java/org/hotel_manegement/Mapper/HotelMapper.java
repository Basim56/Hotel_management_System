package org.hotel_manegement.Mapper;

import org.hotel_manegement.domain.Hotel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class HotelMapper implements IMapper<Hotel>{
    private static final String ID="id";
    private static final String NAME="name";
    private static final String LOCATION="location";
    private static final String URL="url";
    private static final String ADMIN_ID="admin_id";

    @Override
    public List<Hotel> getResultList(ResultSet rs) throws SQLException {
        List<Hotel> hotels=new ArrayList<>();
        while (rs.next()){
            Hotel hotel=Hotel.builder()
                    .id((long) rs.getInt(ID))
                    .hotel_name(rs.getString(NAME))
                    .location(rs.getString(LOCATION))
                    .url(rs.getString(URL))
                    .admin_id((long)rs.getInt(ADMIN_ID))
                    .build();
            hotels.add(hotel);
        }
        return hotels;
    }

    @Override
    public Hotel getResultobject(ResultSet rs) throws SQLException {
        if(rs.next()){
            return Hotel.builder()
                    .id((long) rs.getInt(ID))
                    .hotel_name(rs.getString(NAME))
                    .location(rs.getString(LOCATION))
                    .url(rs.getString(URL))
                    .admin_id((long)rs.getInt(ADMIN_ID))
                    .build();
        }
        return null;
    }
}
