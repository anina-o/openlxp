package cn.elvea.lxp.xapi.enums;

import com.google.common.collect.Lists;
import lombok.Getter;

import java.util.List;

/**
 * 版本枚举
 *
 * @author elvea
 */
@Getter
public enum VersionEnum {
    V101("1.0.1"),
    V102("1.0.2"),
    V103("1.0.3");

    private final String text;

    VersionEnum(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    /**
     * 获取支持的最新版本
     *
     * @return {{@link VersionEnum}}
     */
    public static VersionEnum latest() {
        return VersionEnum.V103;
    }

    /**
     * 获取所有支持版本
     */
    public static List<String> versions() {
        List<String> versionList = Lists.newLinkedList();
        for (VersionEnum v : VersionEnum.values()) {
            versionList.add(v.text);
        }
        return versionList;
    }

    /**
     * 获取对应的版本，找不到对应的版本时，将返回支持的最新版本
     *
     * @return {{@link VersionEnum}}
     */
    public static VersionEnum fromString(String text) {
        for (VersionEnum v : VersionEnum.values()) {
            if (v.text.equalsIgnoreCase(text)) {
                return v;
            }
        }
        return VersionEnum.latest();
    }

}
