package com.example.mall.POJO.DTO;

public enum ResponseObjectEnum {
    SUCCESS(200L, "Success"),
    ERROR(500L, "Error"),
    LOGIN_ERROR(501L,"Login Error: Username or Password Incorrect");

    private final Long code;
    private final String message;
    ResponseObjectEnum(Long code, String message){
        this.code = code;
        this.message = message;
    }

    public Long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
