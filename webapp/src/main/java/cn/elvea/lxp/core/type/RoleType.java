package cn.elvea.lxp.core.type;

import lombok.Getter;

/**
 * RoleType
 *
 * @author elvea
 */
@Getter
public enum RoleType {
    /**
     * 系统管理员
     */
    SYSTEM_ADMINISTRATOR("SYSTEM_ADMINISTRATOR", "role_system_administrator"),
    /**
     * 管理员
     */
    ADMINISTRATOR("ADMINISTRATOR", "role_administrator"),
    /**
     * 用户
     */
    USER("USER", "role_user");

    /**
     * 编号
     */
    private final String code;
    /**
     * 多语言文本
     */
    private final String label;

    RoleType(final String code, final String label) {
        this.code = code;
        this.label = label;
    }

}
