package com.example.common;

import com.example.exception.BusinessException;
import com.example.exception.ParamException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintDeclarationException;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 拦截所有异常
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 表单绑定到 java bean 出错时抛出 BindException 异常
     *
     * @param
     * @return
     */
//    @ExceptionHandler({BindException.class})
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    protected JsonData handleBindException(BindException ex) {
//        List<Map<String, String>> list = new ArrayList<>();
//        for (ObjectError objectError : ex.getAllErrors()) {
//            Map<String, String> map = new HashMap<>();
//            if (objectError instanceof FieldError) {
//                FieldError fieldError = (FieldError) objectError;
//                map.put("field", fieldError.getField());
//                map.put("message", fieldError.getDefaultMessage());
//            } else {
//                map.put("field", objectError.getObjectName());
//                map.put("message", objectError.getDefaultMessage());
//            }
//            list.add(map);
//        }
//        return JsonData.fail(ApplicationEnum.NO_LOGIN.getMessage());
//    }

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public JsonData exceptionHandler(RuntimeException e){
        log.error("unknown exception", e);
        if(e instanceof ParamException || e instanceof BusinessException){
            return JsonData.fail(e.getMessage());
        }
        if(e instanceof ConstraintViolationException ){
            List<Map<String, String>> list = new ArrayList<>();
            // e.getMessage() 的格式为 getUser.id: id不能为空, getUser.name: name不能为空
            String[] msgs = e.getMessage().split(", ");
            for(String msg : msgs){
                String[] fieldAndMsg = msg.split(": ");
                String field = fieldAndMsg[0].split("\\.")[1];
                String message = fieldAndMsg[1];

                Map<String, String> map = new HashMap<>();
                map.put("field", field);
                map.put("message", message);
                list.add(map);
            }
            return JsonData.fail(list.toString());
        }
        return JsonData.fail("系统异常， 请稍后重试");
    }

    @ExceptionHandler(ConstraintDeclarationException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public JsonData handleConstraintViolationException(ConstraintViolationException e) {
        return JsonData.fail(ApplicationEnum.NO_LOGIN.getMessage());
    }


    @ExceptionHandler(value = Error.class)
    @ResponseBody
    public JsonData errorHandler(RuntimeException e){
        log.error("unknown exception", e);
        return JsonData.fail("系统异常，请联系管理员");
    }
}
