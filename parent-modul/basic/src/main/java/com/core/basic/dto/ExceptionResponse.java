package com.core.basic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {

    private String errorMessage;
    private String errorReason;
    private Integer errorCode;
    private LocalDateTime errorCreateTime;

}
