package cn.elvea.lxp.core.type;

import com.google.common.collect.Lists;
import lombok.Getter;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * 多语言类型
 *
 * @author elvea
 */
@Getter
public enum LangType implements Serializable {
    EN_US("en_US", "lang_type_en_us", Locale.US),
    ZH_CN("zh_CN", "lang_type_zh_cn", Locale.SIMPLIFIED_CHINESE),
    ZH_TW("zh_TW", "lang_type_zh_tw", Locale.TRADITIONAL_CHINESE);

    /**
     * 类型
     */
    private final String code;
    /**
     * 描述
     */
    private final String label;
    /**
     * Locale
     */
    private final Locale locale;

    LangType(final String code, final String label, final Locale locale) {
        this.code = code;
        this.label = label;
        this.locale = locale;
    }

    // 获取语言类型
    public static LangType getLangType(String code) {
        LangType[] ts = LangType.values();
        for (LangType t : ts) {
            if (t.getCode().equalsIgnoreCase(code)) {
                return t;
            }
        }
        return getDefaultLangType();
    }

    /**
     * 获取全站默认语言类型
     */
    public static LangType getDefaultLangType() {
        return ZH_CN;
    }

    /**
     * 获取全站默认语言
     */
    public static String getDefaultLang() {
        return getDefaultLangType().getCode();
    }

    /**
     * 获取可用的语言类型
     */
    public static List<LangType> getAvailableLangType() {
        return Arrays.asList(LangType.values());
    }

    /**
     * 获取可用的语言
     */
    public static List<String> getAvailableLangs() {
        List<String> list = Lists.newArrayList();
        for (LangType t : LangType.values()) {
            list.add(t.getCode());
        }
        return list;
    }

}
