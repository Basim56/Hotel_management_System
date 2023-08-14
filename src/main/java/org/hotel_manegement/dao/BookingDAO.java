package org.hotel_manegement.dao;

import org.hotel_manegement.Mapper.BookingMapper;
import org.hotel_manegement.domain.Booking;
import org.hotel_manegement.dao.SQLQueryConstants.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.hotel_manegement.dao.SQLQueryConstants.*;

public class BookingDAO extends BaseDAO implements ICrud<Booking>{
    BookingMapper bookingMapper=new BookingMapper();
    @Override
    public void insert(Booking obj) throws SQLException {
        try{
            PreparedStatement ps=conn.prepareStatement(CREATE_BOOKING);
            ps.setInt(1,obj.getHotel_id());
            ps.setInt(2,obj.getRoom_id());
            ps.setInt(3,obj.getCustomer_id());
            ps.setString(4,obj.getArrival_date());
            ps.setString(5,obj.getDeparture_date());
            ps.setString(6, obj.getBooking_date());
            ps.setDouble(7,obj.getPrice());
            ps.executeUpdate();
        }
        catch (Exception e){
            throw new RuntimeException();
        }

    }

    @Override
    public List<Booking> getAll() {
       try {
           PreparedStatement ps=conn.prepareStatement(GET_ALL_BOOKINGS);
           ResultSet rs= ps.executeQuery();
           return bookingMapper.getResultList(rs);
       }
       catch (Exception e){
           throw new RuntimeException();
       }
    }

    @Override
    public Booking getById(Long id) {
        try {
            PreparedStatement ps=conn.prepareStatement(GET_BOOKING_BY_ID);
            ps.setLong(1,id.intValue());
            ResultSet rs=ps.executeQuery();
            return bookingMapper.getResultobject(rs);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Booking obj, Long id) {
        try {
            PreparedStatement ps=conn.prepareStatement(UPDATE_BOOKING);
            ps.setInt(1,obj.getHotel_id());
            ps.setInt(2,obj.getRoom_id());
            ps.setInt(3,obj.getCustomer_id());
            ps.setInt(4,id.intValue());
            ps.executeUpdate();
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteById(Long id) {
        try{
            PreparedStatement ps=conn.prepareStatement(DELETE_BOOKING);
            ps.setInt(1,id.intValue());
            ps.executeUpdate();

        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
