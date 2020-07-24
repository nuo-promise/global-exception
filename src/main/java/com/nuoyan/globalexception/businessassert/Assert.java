package com.nuoyan.globalexception.businessassert;

import com.nuoyan.globalexception.exception.BaseException;

import java.util.Optional;

/**
 * 定义 异常 接口类,具体抛出什么异常 则有调用方决定
 */
public interface Assert {
    BaseException newException(Object... args);
    BaseException newException(Throwable t, Object... args);

    default void assertNotNull(Object obj) {
        if (!Optional.ofNullable(obj).isPresent()){
            throw newException(obj);
        }
    }

    default  void assertNotNull(Object obj, Object... args) {
       if (!Optional.ofNullable(obj).isPresent()) {
           throw newException(args);
       }
    }
}
