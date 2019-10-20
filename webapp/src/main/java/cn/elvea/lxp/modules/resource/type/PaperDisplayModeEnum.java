package cn.elvea.lxp.modules.resource.type;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 试卷作答模式
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PaperDisplayModeEnum {
    /**
     * 整卷作答
     */
    PAPER(1, "PAPER", "resource.paper.display.mode.PAPER", "整卷作答"),
    /**
     * 逐题作答
     */
    QUESTION(2, "QUESTION", "resource.paper.display.mode.QUESTION", "逐题作答");

    // 类型
    private final int type;
    // 编号
    private final String code;
    // 文本
    private final String label;
    // 描述
    private final String desc;

    PaperDisplayModeEnum(final int type, final String code, final String label, final String desc) {
        this.type = type;
        this.code = code;
        this.label = label;
        this.desc = desc;
    }

    public static PaperDisplayModeEnum getDefaultPaperDisplayMode() {
        return PAPER;
    }

    public static PaperDisplayModeEnum getPaperDisplayMode(int type) {
        PaperDisplayModeEnum[] ts = PaperDisplayModeEnum.values();
        for (PaperDisplayModeEnum t : ts) {
            if (t.getType() == type) {
                return t;
            }
        }
        return PAPER;
    }

    public static PaperDisplayModeEnum getPaperDisplayMode(String code) {
        PaperDisplayModeEnum[] ts = PaperDisplayModeEnum.values();
        for (PaperDisplayModeEnum t : ts) {
            if (t.getCode().equalsIgnoreCase(code)) {
                return t;
            }
        }
        return PAPER;
    }

    public int getType() {
        return type;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public String getDesc() {
        return desc;
    }
}
