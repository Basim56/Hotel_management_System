package org.hotel_manegement.Mapper;

import lombok.Data;
import org.hotel_manegement.domain.Room;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoomMapper implements IMapper<Room>{
    private static final String ID="id";
    private static final String CATEGORY="room_category";
    private static final String FLOOR="floor";

    private static final String PRICE="price";
    private static final String HOTEL_ID="hotel_id";
    private static final String URL="url";


    @Override
    public List<Room> getResultList(ResultSet rs) throws SQLException {
        List<Room> rooms=new ArrayList<>();
        while (rs.next()){
            Room room= Room.builder()
                    .id((long) rs.getInt(ID))
                    .category(rs.getString(CATEGORY))
                    .room_floor(rs.getString(FLOOR))
                    .price(rs.getDouble(PRICE))
                    .hotel_id((long) rs.getInt(HOTEL_ID))
                    .url(rs.getString(URL))
                    .build();
            rooms.add(room);
        }
        return rooms;

    }

    @Override
    public Room getResultobject(ResultSet rs) throws SQLException {
       if(rs.next()){
           return   Room.builder()
                   .id((long) rs.getInt(ID))
                   .category(rs.getString(CATEGORY))
                   .room_floor(rs.getString(FLOOR))
                   .price(rs.getDouble(PRICE))
                   .hotel_id((long) rs.getInt(HOTEL_ID))
                   .url(rs.getString(URL))
                   .build();
       }
       return null;
    }
}
