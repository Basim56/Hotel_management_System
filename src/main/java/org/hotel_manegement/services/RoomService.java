package org.hotel_manegement.services;

import org.hotel_manegement.dao.ICrud;
import org.hotel_manegement.dao.RoomDAO;
import org.hotel_manegement.domain.Room;

import java.sql.SQLException;
import java.util.List;

public class RoomService {
    RoomDAO dao=new RoomDAO();

    public String[][] getAllroomsforJtable(){
        List<Room> roomList=dao.getAll();
        return transformtoJtable(roomList,6);
    }
    private String[][] transformtoJtable(List<Room> roomList,int columnSize){
        String[][] data=new String[roomList.size()][columnSize];
        for (int i = 0; i < roomList.size() ; i++) {
            data[i][0]= String.valueOf(roomList.get(i).getId());
            data[i][1]=roomList.get(i).getCategory();
            data[i][2]=roomList.get(i).getRoom_floor();
            data[i][3]= String.valueOf(roomList.get(i).getPrice());
            data[i][4]= String.valueOf(roomList.get(i).getHotel_id());
            data[i][5]=roomList.get(i).getUrl();

        }
        return data;

    }
    public String[][] getRoombyCategory(String category){
        List<Room> roomList=dao.getByCategory(category);
        return transformtoJtable(roomList,6);
    }
    public void insert(String category,String roomFloor,int hotel_id,double price,String url) throws SQLException {
        Room room= Room.builder()
                .category(category)
                .room_floor(roomFloor)
                .price(price)
                .hotel_id((long) hotel_id)
                .url(url)
                .build();
        dao.insert(room);
    }
    public void update(String category,String roomFloor,int hotel_id,double price,String url,int id){
        Room room= Room.builder()
                .category(category)
                .room_floor(roomFloor)
                .price(price)
                .hotel_id((long) hotel_id)
                .url(url)
                .build();
        dao.update(room, (long) id);
    }
    public void delete(int id){
        dao.deleteById((long) id);
    }
}
