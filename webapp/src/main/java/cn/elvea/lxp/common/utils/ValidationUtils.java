package cn.elvea.lxp.common.utils;

import cn.elvea.lxp.common.Context;
import cn.elvea.lxp.common.web.WebResponse;
import cn.elvea.lxp.common.web.validation.ValidationFieldError;
import cn.elvea.lxp.common.web.validation.ValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * ValidationUtils
 *
 * @author elvea
 */
@Component
public class ValidationUtils {

    private Validator validator;

    private Context context;

    public void validateEntity(Object object, Class<?>... groups) {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            String msg = constraintViolations.parallelStream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining("，"));
        }
    }

    public final static WebResponse handleEntityValidationException(BindingResult result) {
        WebResponse<ValidationResult> response = new WebResponse<>(WebResponse.ERROR);
        if (result.hasFieldErrors()) {
            ValidationResult validationResult = new ValidationResult();
            result.getFieldErrors().forEach((error) -> {
                ValidationFieldError fieldError = new ValidationFieldError();
                fieldError.setField(error.getField());
                fieldError.setLabel(error.getDefaultMessage());
                fieldError.setMessage(error.getDefaultMessage());
                System.out.println(error.getRejectedValue());
                validationResult.getErrors().add(fieldError);
            });
            response.setData(validationResult);
        }
        return response;
    }

    @Autowired
    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    @Autowired
    public void setContext(Context context) {
        this.context = context;
    }

}
