package cn.elvea.lxp.common.handler;

import cn.elvea.lxp.common.web.WebResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

/**
 * 全局的异常处理
 *
 * @author elvea
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 方法参数校验异常
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public WebResponse constraintViolationException(Exception e) {
        System.out.println(e);
        return WebResponse.success();
    }

    /**
     * 类检验异常
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public WebResponse notValidExceptionHandler(MethodArgumentNotValidException e) {
        System.out.println(e);
        return WebResponse.success();
    }

    /**
     * 表单参数验证异常
     */
    @ExceptionHandler(BindException.class)
    public WebResponse handleValidationExceptions(BindException e) {
        e.getBindingResult().getAllErrors().forEach((error) -> {
            if (error instanceof FieldError) {
                FieldError fieldError = (FieldError) error;
                fieldError.getField();
            }
            System.out.println(error.getDefaultMessage());
            System.out.println(error.getCode());
        });
        return WebResponse.success();
    }

}
