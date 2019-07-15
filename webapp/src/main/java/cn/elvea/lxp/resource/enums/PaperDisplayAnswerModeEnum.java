package cn.elvea.lxp.resource.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 试卷显示答案策略
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PaperDisplayAnswerModeEnum {
    /**
     * 第一次作答后显示答案
     */
    FIRST(1, "FIRST", "resource.paper.display.answer.mode.FIRST", "第一次作答后显示答案"),
    /**
     * 及格后显示答案
     */
    PASS(2, "PASS", "resource.paper.display.answer.mode.PASS", "及格后显示答案"),
    /**
     * 不显示答案
     */
    NO(3, "NO", "resource.paper.display.answer.mode.NO", "不显示答案");

    // 类型
    private final int type;
    // 编号
    private final String code;
    // 文本
    private final String label;
    // 描述
    private final String desc;

    PaperDisplayAnswerModeEnum(final int type, final String code, final String label, final String desc) {
        this.type = type;
        this.code = code;
        this.label = label;
        this.desc = desc;
    }

    public static PaperDisplayAnswerModeEnum getDefaultPaperDisplayAnswerMode() {
        return PASS;
    }

    public static PaperDisplayAnswerModeEnum getPaperDisplayAnswerMode(int type) {
        PaperDisplayAnswerModeEnum[] ts = PaperDisplayAnswerModeEnum.values();
        for (PaperDisplayAnswerModeEnum t : ts) {
            if (t.getType() == type) {
                return t;
            }
        }
        return NO;
    }

    public static PaperDisplayAnswerModeEnum getPaperDisplayAnswerMode(String code) {
        PaperDisplayAnswerModeEnum[] ts = PaperDisplayAnswerModeEnum.values();
        for (PaperDisplayAnswerModeEnum t : ts) {
            if (t.getCode().equalsIgnoreCase(code)) {
                return t;
            }
        }
        return NO;
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
