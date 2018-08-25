package com.example.demo.exception;

import com.example.demo.enums.ResultEnum;

/**
 * 扩展异常类
 * 增加了code属性的构造和获取
 */
public class UserException extends RuntimeException {

    private Integer code;

    public UserException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
