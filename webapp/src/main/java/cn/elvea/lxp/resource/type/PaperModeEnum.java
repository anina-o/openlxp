package cn.elvea.lxp.resource.type;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 试卷模式
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PaperModeEnum {
    /**
     * 编辑模式
     */
    EDIT(1, "EDIT", "resource.paper.mode.EDIT", "编辑"),
    /**
     * 预览模式
     */
    PREVIEW(2, "PREVIEW", "resource.paper.mode.PREVIEW", "预览"),
    /**
     * 答题模式
     */
    ANSWER(3, "ANSWER", "resource.paper.mode.ANSWER", "答题"),
    /**
     * 查看回答结果模式
     */
    POST_ANSWER(4, "POST_ANSWER", "resource.paper.mode.POST_ANSWER", "提交答案后"),
    /**
     * 评分模式
     */
    POST_ANSWER_SCORE(5, "POST_ANSWER_SCORE", "resource.paper.mode.POST_ANSWER_SCORE", "评分模式"),
    /**
     * 分析模式
     */
    STATISTIC(6, "STATISTIC", "resource.paper.mode.STATISTIC", "分析");

    // 类型
    private final int type;
    // 编号
    private final String code;
    // 文本
    private final String label;
    // 描述
    private final String desc;

    PaperModeEnum(final int type, final String code, final String label, final String desc) {
        this.type = type;
        this.code = code;
        this.label = label;
        this.desc = desc;
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
