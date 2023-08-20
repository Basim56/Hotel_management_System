package org.hotel_manegement.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Booking {
    private int booking_id;
    private int hotel_id;
    private int room_id;
    private int customer_id;
    private String arrival_date;
    private String departure_date;
    private double price;
    private String b_status;


}
