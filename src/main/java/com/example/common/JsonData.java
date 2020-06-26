package com.example.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonData {

    private static final int SYSTEM_ERROR = 1;
    private boolean ret;

    private String msg;

    private Object data;

    private int code = 0; // success

    public JsonData(boolean ret){
        this.ret = ret;
    }

    public JsonData(String s, String success) {
        this.data = s ;
        this.msg = success;
    }

    public static JsonData success(){
        return new JsonData(true);
    }

    public static JsonData success(Object data){
        JsonData jsonData = new JsonData(true);
        jsonData.data = data;
        return jsonData;
    }

    public static JsonData success(Object data, String msg){
        JsonData jsonData = new JsonData(true);
        jsonData.data = data;
        jsonData.msg = msg;
        return jsonData;
    }

    public  static JsonData fail(String msg){
        JsonData jsonData = new JsonData(false);
        jsonData.code = SYSTEM_ERROR;
        jsonData.msg = msg;
        return jsonData;
    }

    public  static JsonData fail(String msg, int code){
        JsonData jsonData = new JsonData(false);
        jsonData.code = SYSTEM_ERROR;
        jsonData.msg = msg;
        return jsonData;
    }
}