package cn.elvea.lxp.resource.enums;

import lombok.Getter;

/**
 * 试卷类型
 */
@Getter
public enum ResourceType {
    /**
     * 静态试卷
     */
    STATIC_PAPER(1, "STATIC_PAPER", "label_resource_type_static_paper"),
    /**
     * 动态试卷
     */
    DYNAMIC_PAPER(2, "DYNAMIC_PAPER", "label_resource_type_dynamic_paper"),
    /**
     * Office
     */
    OFFICE(3, "OFFICE", "label_resource_type_office"),
    /**
     * PDF
     */
    PDF(4, "PDF", "label_resource_type_pdf"),
    /**
     * Image
     */
    IMAGE(5, "IMAGE", "label_resource_type_image"),
    /**
     * Video
     */
    VIDEO(6, "VIDEO", "label_resource_type_video"),
    /**
     * AUDIO
     */
    AUDIO(7, "AUDIO", "label_resource_type_audio");

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

    ResourceType(final int type, final String code, final String label) {
        this.type = type;
        this.code = code;
        this.label = label;
    }

}