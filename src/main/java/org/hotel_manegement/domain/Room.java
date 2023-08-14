package org.hotel_manegement.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Room {
    private Long id;
    private String category;
    private String room_floor;
    private Double price;
    private Long hotel_id;
    private String url;
}
