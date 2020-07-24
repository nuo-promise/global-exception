package com.nuoyan.globalexception.exceptionadvice;

import com.nuoyan.globalexception.exception.BaseException;
import com.nuoyan.globalexception.exception.Response;
import com.nuoyan.globalexception.exception.ResponseEnum;
import com.sun.deploy.util.ArrayUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 使用Valid 时候 对入参进行检查
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Response methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
       ObjectError objectError = ex.getBindingResult().getAllErrors().get(0);
       return Response.error(ResponseEnum.BODY_NOT_MATCH, objectError.getDefaultMessage());
    }

    /**
     * 业务层异常处理
     * @param exception
     * @return
     */
    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public Response businessExceptionHandler(BaseException exception){
        log.error("发生业务异常! 原因是: {}", exception.getMessage());
        return Response.error(exception.getResponseEnum(),exception.getCustomArgs());
    }

    /**
     * 空指针异常
     * @param exception
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Response nullExceptionHandler(NullPointerException exception){
        log.error("发生空指针异常! 原因是:", exception);
        return Response.error(ResponseEnum.BODY_NOT_MATCH);
    }

    /**
     * 发生未知异常
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response unknownHandleException(Exception ex) {
       log.error("发生未知异常!, 原因是:{}", ex);
       return Response.error(ResponseEnum.INTERNAL_SERVER_ERROR);
    }

    /**
     * Controller 上一层相关的异常
     * @param ex
     * @return
     */
    @ExceptionHandler({
            NoHandlerFoundException.class,
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class,
            MissingPathVariableException.class,
            MissingServletRequestParameterException.class,
            TypeMismatchException.class,
            HttpMessageNotReadableException.class,
            HttpMessageNotWritableException.class,
            HttpMediaTypeNotAcceptableException.class,
            ServletRequestBindingException.class,
            ConversionNotSupportedException.class,
            MissingServletRequestPartException.class,
            AsyncRequestTimeoutException.class
    })
    @ResponseBody
    public Response servletHandleException(Exception ex) {
        log.error("发生请求未进入Controller 的异常: ", ex);
        return Response.error(ResponseEnum.NOT_FOUND, ex.getMessage());
    }
}
