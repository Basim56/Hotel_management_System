package org.hotel_manegement.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
    private Long id;
    private String name;
    private String phone_number;
    private String cnic;

}
