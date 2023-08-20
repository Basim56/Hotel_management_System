package org.hotel_manegement.dao;

import org.hotel_manegement.Mapper.RoomMapper;
import org.hotel_manegement.domain.Room;
import static org.hotel_manegement.dao.SQLQueryConstants.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

public class RoomDAO extends BaseDAO implements ICrud<Room>{
    RoomMapper roomMapper=new RoomMapper();
    @Override
    public void insert(Room obj) throws SQLException {
        try {
            PreparedStatement ps = conn.prepareStatement(CREATE_ROOM);
            ps.setString(1, obj.getCategory());
            ps.setString(2,obj.getRoom_floor());
            ps.setDouble(3,obj.getPrice());
            ps.setLong(4,obj.getHotel_id());
            ps.setString(5,obj.getUrl());
            ps.executeUpdate();
        }
        catch (SQLException e){
            throw new RuntimeException(e);

        }
    }

    @Override
    public List<Room> getAll() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(GET_ALL_ROOMS);
            return roomMapper.getResultList(rs);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Room getById(Long id) {
        try {
            PreparedStatement ps = conn.prepareStatement(GET_ROOM_BY_ID);
            ps.setInt(1,id.intValue());
            ResultSet rs=ps.executeQuery();
            return roomMapper.getResultobject(rs);
        }
        catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    @Override
    public void update(Room obj, Long id) {
        try {
            PreparedStatement ps = conn.prepareStatement(UPDATE_ROOM);
            ps.setString(1, obj.getCategory());
            ps.setString(2, obj.getRoom_floor());
            ps.setLong(3, id.intValue());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }


    @Override
    public void deleteById(Long id) {
            try {
                PreparedStatement ps = conn.prepareStatement(DELETE_ROOM);
                ps.setInt(1,id.intValue());
                ps.executeUpdate();
            }
            catch (Exception e){
                throw new RuntimeException();
            }
        }
        public List<Room> getByCategory(String category){
        try {
            PreparedStatement ps = conn.prepareStatement("select * from room where room_category like '%" + category + "%'");
            ResultSet rs=ps.executeQuery();
            return roomMapper.getResultList(rs);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }

        }
    public List<Room> getAllAvailableRoom(Integer id, LocalDate arrival, LocalDate departure) {
        try {
            String get_all = "SELECT * FROM room\n" +
                    "WHERE hotel_id = ? and id NOT IN \n" +
                    "                    (select r_id FROM booking\n" +
                    "                    where arrival_date BETWEEN ? AND ? OR  departure_date BETWEEN ? AND ?)";
            PreparedStatement ps = conn.prepareStatement(get_all);
            ps.setInt(1, id);
            ps.setString(2, String.valueOf(arrival));
            ps.setString(3, String.valueOf(departure));
            ps.setString(4, String.valueOf(arrival));
            ps.setString(5, String.valueOf(departure));

            ResultSet rs = ps.executeQuery();
            return roomMapper.getResultList(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    }
