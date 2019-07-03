package cn.elvea.lxp.common;

import cn.elvea.lxp.core.type.LangType;

import java.util.Locale;

/**
 * 全局变量
 *
 * @author elvea
 */
public class Constants {

    /**
     * 系统默认编码
     */
    public final static String ENCODING = "UTF-8";

    /**
     * 默认分隔符
     */
    public final static String DELIMITER = "~|~";

    /**
     * 默认区域
     */
    public static final Locale DEFAULT_LOCALE = LangType.getDefaultLangType().getLocale();

}