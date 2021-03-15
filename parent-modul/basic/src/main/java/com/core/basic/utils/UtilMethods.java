package com.core.basic.utils;

import lombok.experimental.UtilityClass;

import java.util.Set;
import java.util.stream.Stream;

@UtilityClass
public class UtilMethods {

    public static boolean isNullOrBlankCheck(String value){
        return value == null || value.trim().isEmpty();
    }

    public static <T> boolean isNullOrEmptySet(Set<T> setData){
        return setData == null || setData.isEmpty();
    }

    public static <T> Stream<T> isNullSetSafely(Set<T> setData){
        return setData == null ? Stream.empty() : setData.stream();
    }
}
