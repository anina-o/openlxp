package cn.elvea.lxp.common.utils;

import java.util.regex.Pattern;

/**
 * 正则表达式工具类
 *
 * @author elvea
 */
public class RegexUtils {

    /**
     * 验证邮箱
     *
     * @param email 电子邮箱
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean isEmail(String email) {
        String regex = "\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?";
        return Pattern.matches(regex, email);
    }

    /**
     * 验证手机号码
     *
     * @param mobile 手机号码
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean isMobile(String mobile) {
        String regex = "(\\+\\d+)?1[3-9]\\d{9}$";
        return Pattern.matches(regex, mobile);
    }

}
