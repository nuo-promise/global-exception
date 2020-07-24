package com.nuoyan.globalexception.exception;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException{
    /**
     * 标准错误码,
     * 标准错误信息
     * 异常处理类型
     * 自定义参数
     * 自定义错误类型
     */
    private int code;
    private String message;
    private IResponseEnum responseEnum;
    private Object[] customArgs;
    private String customMessage;

    /**
     * 自定义 500 系统内部错误
     * @param message
     */
    public BaseException(String message) {
        this(ResponseEnum.INTERNAL_SERVER_ERROR.getCode(),message);
    }

    /**
     * 自定义 错误号与 错误描述
     * @param code
     * @param message
     */
    public BaseException(int code, String message){
        super(message);
        this.code = code;
        this.message = message;
    }

    public BaseException(IResponseEnum responseEnum, Object[] args, String message) {
        super(responseEnum.getMessage());
        this.responseEnum = responseEnum;
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
        this.customArgs = args;
        this.customMessage = message;
    }

    public BaseException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
        super(responseEnum.getMessage(),cause);
        this.responseEnum = responseEnum;
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
        this.customArgs = args;
        this.customMessage = message;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
