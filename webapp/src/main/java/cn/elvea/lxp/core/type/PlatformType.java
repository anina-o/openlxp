package cn.elvea.lxp.core.type;

import lombok.Getter;

/**
 * 设备平台枚举
 *
 * @author elvea
 */
@Getter
public enum PlatformType {
    /**
     * 未知
     */
    UNKNOW("UNKNOW", "platform_type_unknow"),
    /**
     * PC端
     */
    PC("PC", "platform_type_pc"),
    /**
     * 移动端
     */
    MOBILE("MOBILE", "platform_type_mobile");

    /**
     * 编号
     */
    private final String code;
    /**
     * 多语言文本
     */
    private final String label;

    PlatformType(final String code, final String label) {
        this.code = code;
        this.label = label;
    }

    public static PlatformType getPlatformType(String platform) {
        PlatformType[] ps = PlatformType.values();
        for (PlatformType p : ps) {
            if (p.getCode().equalsIgnoreCase(platform)) {
                return p;
            }
        }
        return PC;
    }

}
