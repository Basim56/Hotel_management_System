package org.hotel_manegement.Mapper;

import org.hotel_manegement.domain.Booking;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingMapper implements IMapper<Booking> {
    private static final String BOOKING_ID="b_id";
    private static final String HOTEL_ID="h_id";
    private static final String ROOM_ID="r_id";
    private static final String CUSTOMER_ID="c_id";
    private static final String ARRIVAL_DATE="arrival_date";
    private static final String DEPARTURE_DATE="departure_date";
    private static final String BOOKING_DATE="booking_date";
    private static final String PRICE="price";


    @Override
    public List<Booking> getResultList(ResultSet rs) throws SQLException {
        List<Booking> bookingList=new ArrayList<>();
        while (rs.next()) {
            Booking booking = Booking.builder()
                    .booking_id(rs.getInt(BOOKING_ID))
                    .hotel_id(rs.getInt(HOTEL_ID))
                    .room_id(rs.getInt(ROOM_ID))
                    .customer_id(rs.getInt(CUSTOMER_ID))
                    .arrival_date(rs.getString(ARRIVAL_DATE))
                    .departure_date(rs.getString(DEPARTURE_DATE))
                    .booking_date(rs.getString(BOOKING_DATE))
                    .price(rs.getInt(PRICE))
                    .build();
            bookingList.add(booking);
        }
        return bookingList;
        }

    @Override
    public Booking getResultobject(ResultSet rs) throws SQLException {
        if(rs.next()){
            return   Booking.builder()
                    .booking_id(rs.getInt(BOOKING_ID))
                    .hotel_id(rs.getInt(HOTEL_ID))
                    .room_id(rs.getInt(ROOM_ID))
                    .customer_id(rs.getInt(CUSTOMER_ID))
                    .arrival_date(rs.getString(ARRIVAL_DATE))
                    .departure_date(rs.getString(DEPARTURE_DATE))
                    .booking_date(rs.getString(BOOKING_DATE))
                    .price(rs.getInt(PRICE))
                    .build();
        }
        return null;

    }
}
