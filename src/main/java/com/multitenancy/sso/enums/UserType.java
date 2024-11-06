package com.multitenancy.sso.enums;

import com.multitenancy.sso.exception.SystemException;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public enum UserType {
    EMPLOYEE,
    VENDOR;


    public static UserType getType(int userType) throws SystemException {
        return Arrays.stream(values())
                .filter(value -> value.ordinal() == userType)
                .findFirst()
                .orElseThrow(() -> new SystemException(HttpStatus.BAD_REQUEST, "Provide valid userType"));
    }

    public static UserType getType(String userType) throws SystemException {
        return Arrays.stream(values())
                .filter(value -> value.name().equalsIgnoreCase(userType))
                .findFirst()
                .orElseThrow(() -> new SystemException(HttpStatus.BAD_REQUEST, "Provide valid userType"));
    }
}
