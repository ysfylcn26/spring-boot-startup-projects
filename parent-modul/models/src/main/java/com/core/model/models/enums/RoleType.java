package com.core.model.models.enums;

import com.core.basic.utils.UtilMethods;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum RoleType {
    ROLE_ANONYMOUS,
    ROLE_USER,
    ROLE_ADMIN,
    ROLE_EDITOR;

    @JsonValue
    public String getRole(){
        return name();
    }

    @JsonCreator
    public static RoleType decode(final String role){
        return Arrays.stream(values()).filter(x -> x.name().equals(role)).findFirst().orElse(ROLE_ANONYMOUS);
    }

    public static Set<RoleType> roleTypeWithoutAnonymous(Set<RoleType> roleTypes){
        return UtilMethods.isNullOrEmptyCollectionSafely(roleTypes).filter(x -> x != ROLE_ANONYMOUS).collect(Collectors.toSet());
    }
}
