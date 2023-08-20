package org.hotel_manegement.Mapper;

import org.hotel_manegement.domain.Bill;
import org.hotel_manegement.domain.Booking;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillMapper implements IMapper<Bill>{
    @Override
    public List<Bill> getResultList(ResultSet rs) throws SQLException {
        List<Bill> bills=new ArrayList<>();
        while (rs.next()){
            Bill bill= Bill.builder()
                    .totalprice(Integer.valueOf("This is total Price"))
                    .build();
            bills.add(bill);
        }
        return bills;
    }

    @Override
    public Bill getResultobject(ResultSet rs) throws SQLException {
        return null;
    }
}
