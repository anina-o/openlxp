package cn.elvea.lxp.modules.resource.type;

/**
 * 试卷类型
 */
public enum PaperTypeEnum {
    /**
     * 静态试卷
     */
    STATIC(1, "STATIC", "resource.paper.type.STATIC", "静态试卷"),
    /**
     * 动态试卷
     */
    DYNAMIC(2, "DYNAMIC", "resource.paper.type.DYNAMIC", "动态试卷");

    // 类型
    private final int type;
    // 编号
    private final String code;
    // 文本
    private final String label;
    // 描述
    private final String desc;

    PaperTypeEnum(final int type, final String code, final String label, final String desc) {
        this.type = type;
        this.code = code;
        this.label = label;
        this.desc = desc;
    }

    public static PaperTypeEnum getDefaultPaperType() {
        return STATIC;
    }

    public static PaperTypeEnum getPaperType(int type) {
        PaperTypeEnum[] ts = PaperTypeEnum.values();
        for (PaperTypeEnum t : ts) {
            if (t.getType() == type) {
                return t;
            }
        }
        return STATIC;
    }

    public static PaperTypeEnum getPaperType(String code) {
        PaperTypeEnum[] ts = PaperTypeEnum.values();
        for (PaperTypeEnum t : ts) {
            if (t.getCode().equalsIgnoreCase(code)) {
                return t;
            }
        }
        return STATIC;
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
