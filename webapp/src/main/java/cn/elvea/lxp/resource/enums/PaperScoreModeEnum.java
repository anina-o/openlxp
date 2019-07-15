package cn.elvea.lxp.resource.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 试卷计分模式
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PaperScoreModeEnum {
    /**
     * 按题目数量平均计分
     */
    AVERAGE(1, "AVERAGE", "resource.paper.score.mode.AVERAGE", "按题目数量平均计分"),
    /**
     * 按题目实际分数计分
     */
    QUESTION(2, "QUESTION", "resource.paper.score.mode.QUESTION", "按题目实际分数计分");

    // 类型
    private final int type;
    // 编号
    private final String code;
    // 文本
    private final String label;
    // 描述
    private final String desc;

    PaperScoreModeEnum(final int type, final String code, final String label, final String desc) {
        this.type = type;
        this.code = code;
        this.label = label;
        this.desc = desc;
    }

    public static PaperScoreModeEnum getDefaultPaperScoreMode() {
        return QUESTION;
    }

    public static PaperScoreModeEnum getPaperScoreMode(int type) {
        PaperScoreModeEnum[] ts = PaperScoreModeEnum.values();
        for (PaperScoreModeEnum t : ts) {
            if (t.getType() == type) {
                return t;
            }
        }
        return QUESTION;
    }

    public static PaperScoreModeEnum getPaperScoreMode(String code) {
        PaperScoreModeEnum[] ts = PaperScoreModeEnum.values();
        for (PaperScoreModeEnum t : ts) {
            if (t.getCode().equalsIgnoreCase(code)) {
                return t;
            }
        }
        return QUESTION;
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
