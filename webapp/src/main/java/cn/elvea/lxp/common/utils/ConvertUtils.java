package cn.elvea.lxp.common.utils;

import cn.elvea.lxp.common.Constants;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

import java.util.Iterator;
import java.util.List;

/**
 * 字符串转换成其他类型的工具类
 *
 * @author elvea
 */
public class ConvertUtils {

    /**
     * @see ConversionService
     */
    private static ConversionService conversionService = DefaultConversionService.getSharedInstance();

    /**
     * 将字符串转换成指定类型
     *
     * @param value      字符串
     * @param targetType 目标类型
     * @param <T>        目标类型
     * @return 目标类型实例
     */
    public static <T> T convert(String value, Class<T> targetType) {
        return convert(value, targetType, null);
    }

    /**
     * 将字符串转换成指定类型
     *
     * @param value        字符串
     * @param targetType   目标类型
     * @param defaultValue 默认值
     * @param <T>          目标类型
     * @return 目标类型实例
     */
    public static <T> T convert(String value, Class<T> targetType, T defaultValue) {
        T t = conversionService.convert(value, targetType);
        return t == null ? defaultValue : t;
    }

    /**
     * 使用默认分隔符将字符串转换成集合
     *
     * @param str 字符串
     * @param <T> 集合元素类型
     * @return 集合
     */
    public static <T> List<T> stringToList(String str, Class<T> targetType) {
        return stringToList(str, Constants.DELIMITER, targetType);
    }

    /**
     * 将字符串转换成集合
     *
     * @param str       字符串
     * @param delimiter 分隔符
     * @param <T>       集合元素类型
     * @return 集合
     */
    public static <T> List<T> stringToList(String str, String delimiter, Class<T> targetType) {
        if (Strings.isNullOrEmpty(str)) {
            return Lists.newArrayList();
        }

        Iterable<String> ia = Splitter.on(delimiter).split(str);

        List<T> lst = Lists.newArrayList();
        Iterator<String> it = ia.iterator();
        while (it.hasNext()) {
            lst.add(ConvertUtils.convert(it.next(), targetType));
        }
        return lst;
    }

    /**
     * 使用默认分隔符将集合转换成字符串
     *
     * @param list 集合
     * @param <T>  集合元素类型
     * @return 字符串
     */
    public static <T> String listToString(List<T> list) {
        return listToString(list, Constants.DELIMITER);
    }

    /**
     * 将集合转换成字符串
     *
     * @param list      集合
     * @param delimiter 分隔符
     * @param <T>       集合元素类型
     * @return 字符串
     */
    public static <T> String listToString(List<T> list, String delimiter) {
        String str = null;
        if (list != null && !list.isEmpty()) {
            str = "";
            for (int i = 0; i < list.size(); i++) {
                str += list.get(i);
                if (i != (list.size() - 1)) {
                    str += delimiter;
                }
            }
        }
        return str;
    }

}
