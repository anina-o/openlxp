package cn.elvea.lxp.resource.type;

import lombok.Getter;

/**
 * 试卷生成策略
 */
@Getter
public enum PaperGenerateModeEnum {
    /**
     * 题目与选项都固定
     */
    ALL_FIXED("ALL_FIXED", "resource.paper.generate.mode.ALL_FIXED", "题目与选项都固定"),
    /**
     * 题目随机
     */
    QUESTION_RANDOM("QUESTION_RANDOM", "resource.paper.generate.mode.QUESTION_RANDOM", "题目随机"),
    /**
     * 选项随机
     */
    OPTION_RANDOM("OPTION_RANDOM", "resource.paper.generate.mode.OPTION_RANDOM", "选项随机"),
    /**
     * 题目与选项都随机
     */
    ALL_RANDOM("ALL_RANDOM", "resource.paper.generate.mode.ALL_RANDOM", "题目与选项都随机");

    // 类型
    private final String type;
    // 文本
    private final String label;
    // 描述
    private final String desc;

    PaperGenerateModeEnum(final String type, final String label, final String desc) {
        this.type = type;
        this.label = label;
        this.desc = desc;
    }

}
