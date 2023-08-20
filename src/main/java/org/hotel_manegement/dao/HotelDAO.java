package org.hotel_manegement.dao;

import org.hotel_manegement.Mapper.HotelMapper;
import org.hotel_manegement.domain.Hotel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.hotel_manegement.dao.SQLQueryConstants.*;

public class HotelDAO extends BaseDAO implements ICrud<Hotel> {
    HotelMapper hotelMapper = new HotelMapper();

    @Override
    public void insert(Hotel obj) throws SQLException {
        try {
            PreparedStatement ps = conn.prepareStatement(CREATE_HOTEL);
            ps.setString(1, obj.getHotel_name());
            ps.setString(2, obj.getLocation());
            ps.setString(3, obj.getUrl());
            ps.setLong(4, obj.getAdmin_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    @Override
    public List<Hotel> getAll() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQLQueryConstants.GET_ALL_HOTELS);
            return hotelMapper.getResultList(rs);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public Hotel getById(Long id) {
        try {
            PreparedStatement ps = conn.prepareStatement(GET_HOTEL_BY_ID);
            ps.setInt(1,id.intValue());
            ResultSet rs=ps.executeQuery();
            return hotelMapper.getResultobject(rs);
        }
        catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    @Override
    public void update(Hotel obj, Long id) {
        try {
            PreparedStatement ps = conn.prepareStatement(UPDATE_HOTEL);
            ps.setString(1,obj.getHotel_name());
            ps.setString(2,obj.getLocation());
            ps.setInt(3,id.intValue());
            ps.executeUpdate();
        }
        catch (Exception e){
            throw new RuntimeException();
        }


    }

    @Override
    public void deleteById(Long id) {
        try {
            PreparedStatement ps = conn.prepareStatement(DELETE_HOTEL);
            ps.setInt(1,id.intValue());
            ps.executeUpdate();
        }
        catch (Exception e){
            throw new RuntimeException();
        }
    }
    public List<Hotel> getHotelByName(String name) {
        try {
            PreparedStatement ps = conn.prepareStatement("select * from hotel where hotel_name like '%"+name+"%'");
            ResultSet rs=ps.executeQuery();
            return hotelMapper.getResultList(rs);
        }
        catch (Exception e){
            throw  new RuntimeException(e);
        }
    }
    }

