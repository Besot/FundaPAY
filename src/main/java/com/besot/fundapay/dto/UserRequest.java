package com.besot.fundapay.dto;

import com.besot.fundapay.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String firstName;
    private String lastName;
    private String otherName;
    private Gender gender;
    private String address;
    private String stateOfOrigin;
    private String nationality;
    private String dateOfBirth;
    private String email;
    private String phoneNumber;
    private String alternativePhoneNO;
}
