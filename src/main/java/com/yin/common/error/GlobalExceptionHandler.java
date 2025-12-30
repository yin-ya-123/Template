package com.yin.common.error;

import com.yin.common.Result;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


//全局异常处理，捕获controller层异常
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public Result<?> bizException(HttpServletRequest req, BizException e) {
        log.error("发生业务异常！原因是：{}",e.getErrorMsg());
        return Result.error(e.getErrorMsg(),null);
    }

//    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
//    public Result<?> exception(HttpServletRequest req, Exception e) {
//        log.error("发生业务异常！原因是：{}",e.getMessage());
//        return Result.error(e.getMessage(),null);
//    }
}
