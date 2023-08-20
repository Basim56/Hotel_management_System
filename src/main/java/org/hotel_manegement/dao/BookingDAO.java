package org.hotel_manegement.dao;

import com.sun.org.apache.bcel.internal.generic.LoadClass;
import org.hotel_manegement.Mapper.BillMapper;
import org.hotel_manegement.Mapper.BookingMapper;
import org.hotel_manegement.domain.Bill;
import org.hotel_manegement.domain.Booking;
import org.hotel_manegement.dao.SQLQueryConstants.*;

import java.awt.print.Book;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.hotel_manegement.dao.SQLQueryConstants.*;

public class BookingDAO extends BaseDAO implements ICrud<Booking>{
    BookingMapper bookingMapper=new BookingMapper();
    BillMapper billMapper=new BillMapper();
    @Override
    public void insert(Booking obj) throws SQLException {
        try{
            PreparedStatement ps=conn.prepareStatement(CREATE_BOOKING);
            ps.setInt(1,obj.getHotel_id());
            ps.setInt(2,obj.getRoom_id());
            ps.setInt(3,obj.getCustomer_id());
            ps.setDate(4, Date.valueOf(obj.getArrival_date()));
            ps.setDate(5, Date.valueOf(obj.getDeparture_date()));
            ps.setDouble(6,obj.getPrice());
            ps.setString(7,obj.getB_status());
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
           throw new RuntimeException(e);
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
            ps.setString(4, obj.getArrival_date());
            ps.setString(5, obj.getDeparture_date());
            ps.setDouble(6,obj.getPrice());
            ps.setString(7, obj.getB_status());
            ps.setInt(8,id.intValue());

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
    public List<Booking> getByName(String status){
        try {
            PreparedStatement ps=conn.prepareStatement("select * from booking where status like '%"+status+"%'");
            ResultSet rs=ps.executeQuery();
            return bookingMapper.getResultList(rs);
        }
        catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
    public List<Booking> getHotels(String arrival, String departure,Integer id){
        try {
            PreparedStatement ps = conn.prepareStatement("select * from booking where arrival_date between '"+arrival+"' and '"+departure+"' and h_id="+id+";");
            ResultSet rs=ps.executeQuery();
            return bookingMapper.getResultList(rs);

        }
        catch (Exception e){
            throw new RuntimeException(e);
        }

    }
    public List<Bill> getTotalPrice(String arrival,String departure,Integer id){
        try {
            PreparedStatement ps = conn.prepareStatement("select sum(b.price*datediff(b.departure_date, b.arrival_date)) as total_price " +
                    "from booking b " +
                    "where b.arrival_date between '" + arrival + "' and '" + departure + " ' or b.departure_date between '" + arrival + "' and '" + departure + "' and b.h_id=" + id + ";");
            ResultSet rs=ps.executeQuery();
            return billMapper.getResultList(rs);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public Booking getAllNames(Integer hid,Integer rid,Integer cid){
        try{
            PreparedStatement ps= conn.prepareStatement(GET_ALL_NAME);
            ps.setInt(1,hid);
            ps.setInt(2,rid);
            ps.setInt(3,cid);
            ResultSet rs = ps.executeQuery();
            return bookingMapper.getResultobject(rs);

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
