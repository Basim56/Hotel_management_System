package org.hotel_manegement.dao;

import org.hotel_manegement.Mapper.RoomMapper;
import org.hotel_manegement.domain.Room;
import static org.hotel_manegement.dao.SQLQueryConstants.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    }
