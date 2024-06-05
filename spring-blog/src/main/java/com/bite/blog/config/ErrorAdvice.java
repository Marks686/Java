package com.bite.blog.config;

import com.bite.blog.common.Constants;
import com.bite.blog.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ResponseBody
@ControllerAdvice
public class ErrorAdvice {
    @ExceptionHandler
    public Result errorHandler(Exception e){
        log.error("发生错误， e", e);

        Result result =  new Result<>();
        result.setErrorMsg("内部发生错误, 请联系管理员");
        result.setCode(Constants.RESULT_FAIL);
        return result;
    }
}
