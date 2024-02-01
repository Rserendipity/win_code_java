package com.cjj.forum.exception;

import com.cjj.forum.common.ResultBody;
import com.cjj.forum.common.ReturnCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobeExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResultBody exceptionHandler(Exception e) {
        return ResultBody.fail(ReturnCode.SERVICE_ERROR);
    }
}
