package com.example.common;

import lombok.Data;
import lombok.Getter;

@Getter
public enum ApplicationEnum {

    SUCCESS("2000", "成功"),
    NO_LOGIN("4002", "用户名错误");
    private String code;
    private String message;
    ApplicationEnum(String code, String message){
        this.code = code;
        this.message = message;
    }
}
