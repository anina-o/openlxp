package cn.elvea.lxp.core.system.type;

import lombok.Getter;

/**
 * 通用状态类型
 *
 * @author elvea
 */
@Getter
public enum StatusTypeEnum {
    /**
     * 正常
     */
    ON(1, "status_on"),
    /**
     * 已删除
     */
    OFF(0, "status_deleted");

    /**
     * 值
     */
    private final int value;
    /**
     * 多语言文本
     */
    private final String label;

    StatusTypeEnum(final int value, final String label) {
        this.value = value;
        this.label = label;
    }

}
