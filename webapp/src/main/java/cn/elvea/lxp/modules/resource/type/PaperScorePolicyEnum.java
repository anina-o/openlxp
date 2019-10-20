package cn.elvea.lxp.modules.resource.type;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 试卷计分策略
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PaperScorePolicyEnum {
    /**
     * 第一次交卷分数
     */
    FIRST(1, "FIRST", "resource.paper.score.policy.FIRST", "第一次交卷分数"),
    /**
     * 最后一次交卷分数
     */
    LAST(2, "LAST", "resource.paper.score.policy.LAST", "最后一次交卷分数"),
    /**
     * 最高分数
     */
    MAX(3, "MAX", "resource.paper.score.policy.MAX", "最高分数"),
    /**
     * 平均分
     */
    AVG(4, "AVG", "resource.paper.score.policy.AVG", "平均分");

    // 类型
    private final int type;
    // 编号
    private final String code;
    // 文本
    private final String label;
    // 描述
    private final String desc;

    PaperScorePolicyEnum(final int type, final String code, final String label, final String desc) {
        this.type = type;
        this.code = code;
        this.label = label;
        this.desc = desc;
    }

    public static PaperScorePolicyEnum getDefaultPaperScorePolicy() {
        return MAX;
    }

    public static PaperScorePolicyEnum getPaperScorePolicy(int type) {
        PaperScorePolicyEnum[] ts = PaperScorePolicyEnum.values();
        for (PaperScorePolicyEnum t : ts) {
            if (t.getType() == type) {
                return t;
            }
        }
        return MAX;
    }

    public static PaperScorePolicyEnum getPaperScorePolicy(String code) {
        PaperScorePolicyEnum[] ts = PaperScorePolicyEnum.values();
        for (PaperScorePolicyEnum t : ts) {
            if (t.getCode().equalsIgnoreCase(code)) {
                return t;
            }
        }
        return MAX;
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
