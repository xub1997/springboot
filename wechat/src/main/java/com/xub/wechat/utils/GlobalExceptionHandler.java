package com.xub.wechat.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



import javax.servlet.http.HttpServletRequest;


/**
 * @ClassName GlobalExceptionHandler
 * @Description TODO
 * @Author lqx
 * @Date 2019/3/10.13:44
 **/
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理 Error
     *
     * @param httpServletRequest httpServletRequest
     * @param e                  异常
     * @return
     */
    @ExceptionHandler(value = Error.class)
    public ResponseData exceptionHandler(HttpServletRequest httpServletRequest, Error e) {
        logger.error(e.getMessage(), e);
        return ResponseData.exception(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }


    /**
     * 处理 BusinessException 异常
     *
     * @param httpServletRequest httpServletRequest
     * @param e                  异常
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    public ResponseData businessExceptionHandler(HttpServletRequest httpServletRequest, BusinessException e) {
        logger.info("业务异常:code:{},msg:{}" ,e.getCode() , e.getMessage());
        return ResponseData.exception(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }



}
