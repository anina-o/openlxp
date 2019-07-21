package cn.elvea.lxp.core.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/**
 * 用户注册表单
 *
 * @author elvea
 */
@Getter
@Setter
@NoArgsConstructor
public class Register {
    /**
     *
     */
    @NotEmpty(message = "{user_validation_username_not_empty}")
    @Length(min = 3, max = 30)
    private String username;
    /**
     *
     */
    @NotEmpty(message = "{user_validation_password_not_empty}")
    @Length(min = 6, max = 30)
    private String password;
}
