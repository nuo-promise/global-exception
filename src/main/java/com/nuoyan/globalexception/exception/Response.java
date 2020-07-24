package com.nuoyan.globalexception.exception;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Response<T>{

    private int code;
    private String message;
    private T data;

    public Response(T data) {
        this(ResponseEnum.SUCCESS, data);
    }

    public Response(IResponseEnum responseEnum, T data){
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
        this.data = data;
    }

    /**
     * 自定义 成功返回信息
     * @param data
     * @return
     */
    public static Response success(Object data) {
        Response response = new Response();
        response.setCode(ResponseEnum.SUCCESS.getCode());
        response.setMessage(ResponseEnum.SUCCESS.getMessage());
        response.setData(data);
        return response;
    }

    /**
     * 不带业务数据的错误返回
     * @param responseEnum
     * @return
     */
    public static Response error(IResponseEnum responseEnum) {
        Response response = new Response();
        response.setCode(responseEnum.getCode());
        response.setMessage(responseEnum.getMessage());
        response.setData(null);
        return response;
    }

    /**
     * 返回用户指定的错误 号与错误描述
     * @param code
     * @param message
     * @return
     */
    public static Response error(int code, String message) {
        Response response = new Response();
        response.setCode(code);
        response.setMessage(message);
        response.setData(null);
        return response;
    }
    /**
     * 带业务数据的错误返回
     * @param responseEnum
     * @return
     */
    public static Response error(IResponseEnum responseEnum, Object data) {
        Response response = new Response();
        response.setCode(responseEnum.getCode());
        response.setMessage(responseEnum.getMessage());
        response.setData(data);
        return response;
    }
    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
