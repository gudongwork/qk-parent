package com.itheima.exception;

import com.itheima.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@Slf4j
@RestControllerAdvice // 表示这是一个全局异常处理器
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result handleException(Exception e){
        log.error("异常信息：{}", e.getMessage());
        return Result.error("系统繁忙，请稍后再试！"+e.getMessage());
    }
}
