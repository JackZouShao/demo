package com.example.exception;

import com.example.common.ApplicationEnum;

public class BusinessException extends RuntimeException  {

    private ApplicationEnum applicationEnum;

    public BusinessException(ApplicationEnum applicationEnum) {
        super(applicationEnum.getMessage());
        this.applicationEnum = applicationEnum;
    }
}
