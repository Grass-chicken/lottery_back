package com.example.demo.config;

import com.example.demo.util.rest.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author ankelen
 * @date 2022-01-10 15:23
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public R<?> onException(Exception e) {
        log.error(e.getMessage());
        e.printStackTrace();
        return R.fail(e.getMessage());
    }


}
