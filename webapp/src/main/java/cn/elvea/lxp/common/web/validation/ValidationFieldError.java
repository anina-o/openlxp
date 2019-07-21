package cn.elvea.lxp.common.web.validation;

import lombok.Getter;
import lombok.Setter;

/**
 * ValidationFieldError
 *
 * @author elvea
 */
@Getter
@Setter
public class ValidationFieldError {
    /**
     * 错误属性名
     */
    private String field;
    /**
     * 错误属性名
     */
    private String label;
    /**
     * 错误属性名
     */
    private String message;
}
