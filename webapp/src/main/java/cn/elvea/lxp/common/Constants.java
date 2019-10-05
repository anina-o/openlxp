package cn.elvea.lxp.common;

import cn.elvea.lxp.core.type.LangTypeEnum;

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
     *
     */
    public static final String CONTENT_TYPE_JSON = "application/json;charset=UTF-8";

    /**
     * 默认分隔符
     */
    public final static String DELIMITER = "~|~";

    /**
     * 默认区域
     */
    public static final Locale DEFAULT_LOCALE = LangTypeEnum.getDefaultLangType().getLocale();

}