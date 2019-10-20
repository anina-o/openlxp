package cn.elvea.lxp.modules.resource.type;

import lombok.Getter;

/**
 * 尝试次数计算策略
 */
@Getter
public enum PaperAttemptPolicyEnum {
    /**
     * 进入时计算尝试次数
     */
    OPEN(1, "OPEN", "resource.paper.attempt.policy.OPEN", "进入时计算尝试次数"),
    /**
     * 提交后计算尝试次数
     */
    SUBMIT(2, "SUBMIT", "resource.paper.attempt.policy.SUBMIT", "提交后计算尝试次数");

    /**
     * 类型
     */
    private final int type;
    /**
     * 编号
     */
    private final String code;
    /**
     * 文本
     */
    private final String label;
    /**
     * 描述
     */
    private final String desc;

    PaperAttemptPolicyEnum(final int type, final String code, final String label, final String desc) {
        this.type = type;
        this.code = code;
        this.label = label;
        this.desc = desc;
    }

    public static PaperAttemptPolicyEnum getDefaultAttemptPolicy() {
        return SUBMIT;
    }

    public static PaperAttemptPolicyEnum getAttemptPolicy(int type) {
        PaperAttemptPolicyEnum[] ts = PaperAttemptPolicyEnum.values();
        for (PaperAttemptPolicyEnum t : ts) {
            if (t.getType() == type) {
                return t;
            }
        }
        return OPEN;
    }

    public static PaperAttemptPolicyEnum getAttemptPolicy(String code) {
        PaperAttemptPolicyEnum[] ts = PaperAttemptPolicyEnum.values();
        for (PaperAttemptPolicyEnum t : ts) {
            if (t.getCode().equalsIgnoreCase(code)) {
                return t;
            }
        }
        return OPEN;
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
