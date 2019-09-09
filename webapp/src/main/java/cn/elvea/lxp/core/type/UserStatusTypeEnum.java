package cn.elvea.lxp.core.type;

import lombok.Getter;

/**
 * 用户状态类型
 *
 * @author elvea
 */
@Getter
public enum UserStatusTypeEnum {
    /**
     * 正常
     */
    OK(1, "user_status_on"),
    /**
     * 已删除
     */
    DELETED(0, "user_status_deleted");

    /**
     * 值
     */
    private final int value;
    /**
     * 多语言文本
     */
    private final String label;

    UserStatusTypeEnum(final int value, final String label) {
        this.value = value;
        this.label = label;
    }

}
