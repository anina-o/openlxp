package cn.elvea.lxp.core.system.type;

import lombok.Getter;

/**
 * 角色类型
 *
 * @author elvea
 */
@Getter
public enum RoleTypeEnum {
    /**
     * 系统管理员
     */
    SYSTEM_ADMINISTRATOR("SYSTEM_ADMINISTRATOR", "role_type_system_administrator"),
    /**
     * 管理员
     */
    ADMINISTRATOR("ADMINISTRATOR", "role_type_administrator"),
    /**
     * 讲师
     */
    TRAINER("TRAINER", "role_type_trainer"),
    /**
     * 学员
     */
    LEARNER("LEARNER", "role_type_learner");

    /**
     * 编号
     */
    private final String code;
    /**
     * 多语言文本
     */
    private final String label;

    RoleTypeEnum(final String code, final String label) {
        this.code = code;
        this.label = label;
    }

}
