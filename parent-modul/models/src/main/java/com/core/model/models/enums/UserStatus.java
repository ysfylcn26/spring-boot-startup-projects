package com.core.model.models.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum UserStatus {

    EMPTY("EMPTY","There isnt status"),
    ACTIVE("ACTIVE", "Active status"),
    NOTACTIVE("NOTACTIVE", "Not active status");

    private final String status;
    private final String description;

    UserStatus(String status, String description){
        this.status = status;
        this.description = description;
    }

    @JsonValue
    public String getStatus(){
        return this.status;
    }


    @JsonCreator
    public static UserStatus decode(final String status){
        return Stream.of(UserStatus.values()).filter(statu -> statu.getStatus().equals(status)).findFirst().orElse(EMPTY);
    }
}