package cn.elvea.lxp.common.web.validation;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * ValidationResult
 *
 * @author elvea
 */
@Getter
@Setter
public class ValidationResult {

    /**
     * 验证错误
     */
    List<ValidationFieldError> errors = Lists.newArrayList();

}
