package com.nuoyan.globalexception.businessassert;

import com.nuoyan.globalexception.exception.BaseException;
import com.nuoyan.globalexception.exception.IResponseEnum;

import java.text.MessageFormat;

public interface BusinessExceptionAssert extends IResponseEnum, Assert {

    @Override
    default BaseException newException(Object... args){
       String msg = MessageFormat.format(this.getMessage(),args);
       return new BusinessException(this, args, msg);
    }

    @Override
    default BaseException newException(Throwable t, Object... args){
        String msg = MessageFormat.format(this.getMessage(),args);
        return new BusinessException(this, args, msg, t);
    }
}
