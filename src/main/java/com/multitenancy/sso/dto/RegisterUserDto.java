package com.multitenancy.sso.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserDto {

    private String loggedInUserId;

    private String fullName;

    private int businessId;

    private Long mobileNumber;

    private String password;


}
