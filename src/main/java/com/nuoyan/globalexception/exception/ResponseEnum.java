package com.nuoyan.globalexception.exception;

import com.nuoyan.globalexception.businessassert.BusinessExceptionAssert;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseEnum implements BusinessExceptionAssert {
    SUCCESS(200,"成功!"),
    BODY_NOT_MATCH(400,"请求数据格式不符!"),
    SIGNATURE_NOT_MATCH(401,"请求的数字签名不匹配!"),
    NOT_FOUND(404,"未找到该资源"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误!"),
    SERVER_BUSY(503,"服务器正忙,请稍后再试!"),
    BAD_LICENCE_TYPE(7001, "Bad licence type."),
    LICENCE_NOT_FOUND(7002, "Licence not fount");


    private int code;
    private String message;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
