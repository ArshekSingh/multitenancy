package com.multitenancy.sso.enums;

import com.multitenancy.sso.exception.SystemException;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public enum EntityStatus {

    INACTIVE, ACTIVE, PROCESSING, PENDING, ERROR, DONE, CANCELLED, FAILED,PARTIALLY_DONE;

    public static EntityStatus getStatus(String entityStatus) throws SystemException {
        return Arrays.stream(values()).filter(value -> value.name().equalsIgnoreCase(entityStatus)).findFirst()
                .orElseThrow(() -> new SystemException(HttpStatus.BAD_REQUEST, "Provide entity status"));
    }

    public static EntityStatus getStatus(int entityStatus) throws SystemException {
        return Arrays.stream(values()).filter(value -> value.ordinal() == entityStatus).findFirst()
                .orElseThrow(() -> new SystemException(HttpStatus.BAD_REQUEST, "Provide entity status"));
    }
}
