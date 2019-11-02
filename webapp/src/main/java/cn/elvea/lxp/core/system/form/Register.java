package cn.elvea.lxp.core.system.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("注册用户实体")
public class Register {
    /**
     * 用户名
     */
    @NotEmpty(message = "{user_validation_username_not_empty}")
    @Length(min = 3, max = 30)
    @ApiModelProperty(value = "用户名", required = true)
    private String username;
    /**
     * 密码
     */
    @NotEmpty(message = "{user_validation_password_not_empty}")
    @Length(min = 6, max = 30)
    @ApiModelProperty(value = "密码", required = true)
    private String password;
}
