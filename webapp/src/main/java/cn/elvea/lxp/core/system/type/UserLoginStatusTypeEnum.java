package cn.elvea.lxp.core.system.type;

import lombok.Getter;

/**
 * 用户状态类型
 *
 * @author elvea
 */
@Getter
public enum UserLoginStatusTypeEnum {
    /**
     * 成功登录
     */
    SUCCESS(1, "user_login_status_success"),
    /**
     * 登录失败
     */
    FAIL(0, "user_login_status_fail");

    /**
     * 值
     */
    private final int value;
    /**
     * 多语言文本
     */
    private final String label;

    UserLoginStatusTypeEnum(final int value, final String label) {
        this.value = value;
        this.label = label;
    }

}
