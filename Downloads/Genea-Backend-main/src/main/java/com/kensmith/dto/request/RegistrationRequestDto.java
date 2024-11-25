package com.kensmith.dto.request;

import com.kensmith.enums.Role;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RegistrationRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String Password;
    private String phoneNumber;
    private Role role;


}
