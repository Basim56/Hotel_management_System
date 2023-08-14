package org.hotel_manegement.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Hotel {
    private Long id;
    private String hotel_name;
    private String location;
    private String url;
    private Long admin_id;
}
