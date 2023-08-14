package org.hotel_manegement.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Admin {
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;

}
