package cn.elvea.lxp.core.type;

import lombok.Getter;

/**
 * 设备平台枚举
 *
 * @author elvea
 */
@Getter
public enum PlatformTypeEnum {
    /**
     * 未知
     */
    UNKNOW("UNKNOW", "label_platform_type_unknow"),
    /**
     * PC端
     */
    PC("PC", "label_platform_type_pc"),
    /**
     * 移动端
     */
    MOBILE("MOBILE", "label_platform_type_mobile");

    /**
     * 编号
     */
    private final String code;
    /**
     * 多语言文本
     */
    private final String label;

    PlatformTypeEnum(final String code, final String label) {
        this.code = code;
        this.label = label;
    }

    public static PlatformTypeEnum getPlatformType(String platform) {
        PlatformTypeEnum[] ps = PlatformTypeEnum.values();
        for (PlatformTypeEnum p : ps) {
            if (p.getCode().equalsIgnoreCase(platform)) {
                return p;
            }
        }
        return PC;
    }

}
