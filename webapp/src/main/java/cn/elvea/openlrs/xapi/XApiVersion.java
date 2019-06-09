package cn.elvea.openlrs.xapi;

import lombok.Getter;

/**
 * XApiVersion
 *
 * @author elvea
 */
@Getter
public enum XApiVersion {
    V103("1.0.3");

    private final String text;

    XApiVersion(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    /**
     * 获取支持的最新的版本
     *
     * @return {{@link XApiVersion}}
     */
    public static XApiVersion latest() {
        return XApiVersion.values()[0];
    }

    /**
     * 获取对应的版本
     *
     * @return {{@link XApiVersion}}
     */
    public static XApiVersion fromString(String text) {
        if (text != null) {
            for (XApiVersion v : XApiVersion.values()) {
                if (text.equalsIgnoreCase(v.text)) {
                    return v;
                }
            }
        }
        return XApiVersion.latest();
    }

}
