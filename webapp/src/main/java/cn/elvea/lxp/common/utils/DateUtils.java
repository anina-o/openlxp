package cn.elvea.lxp.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author elvea
 */
@Slf4j
public final class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    /**
     * 最大和最小的时间日期
     */
    public final static Date MIN_DATE;
    public final static Date MAX_DATE;
    public final static Timestamp MIN_TIMESTAMP;
    public final static Timestamp MAX_TIMESTAMP;

    static {
        MIN_DATE = new DateTime(1970, 1, 1, 0, 0, 0, 0).toDate();
        MAX_DATE = new DateTime(9999, 12, 31, 23, 59, 59, 0).toDate();

        MIN_TIMESTAMP = new Timestamp(MIN_DATE.getTime());
        MAX_TIMESTAMP = new Timestamp(MAX_DATE.getTime());
    }

    /**
     * 默认时区
     */
    public final static String DEFAULT_TIME_ZONE = "GMT+8";
    /**
     * 默认时间格式
     */
    public final static String DEFAULT_TIME_PATTEN = "HH:mm:ss";
    /**
     * 默认日期格式
     */
    public final static String DEFAULT_DATE_PATTEN = "yyyy-MM-dd";
    /**
     * 默认日期时间格式
     */
    public final static String DEFAULT_DATETIME_PATTEN = "yyyy-MM-dd HH:mm";
    /**
     * 默认时间戳格式
     */
    public final static String DEFAULT_TIMESTAMP_PATTEN = "yyyy-MM-dd HH:mm:ss.SSS";
    /**
     * 当前支持的时间格式
     */
    private final static String[] SUPPORT_PATTENS = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM",
            "yyyy年MM月dd日"
    };

    /**
     * 格式化日期（yyyy-MM-dd）
     */
    public static String formatDate(Date date) {
        return format(date, DEFAULT_DATE_PATTEN);
    }

    /**
     * 格式化日期（yyyy-MM-dd HH:mm）
     */
    public static String formatDatetime(Date date) {
        return format(date, DEFAULT_DATETIME_PATTEN);
    }

    /**
     * 格式化日期（yyyy-MM-dd HH:mm:ss.SSS）
     */
    public static String formatTimestamp(Date date) {
        return format(date, DEFAULT_TIMESTAMP_PATTEN);
    }

    /**
     * 格式化日期
     *
     * @param date    日期
     * @param pattern 格式
     * @return String
     */
    public static String format(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        if (pattern == null) {
            return formatDate(date);
        }
        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     * 获取时间字符串（yyyy-MM-dd HH:mm:ss.SSS）
     */
    public static String getDateTime() {
        return getDateTime(new Date(), DEFAULT_DATETIME_PATTEN);
    }

    /**
     * 获取时间字符串（yyyy-MM-dd HH:mm:ss.SSS）
     */
    public static String getDateTime(Date data, String pattern) {
        return format(data, pattern);
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd）
     */
    public static String getDate() {
        return getDate(new Date());
    }

    public static String getDate(Date date) {
        return format(date, DEFAULT_DATE_PATTEN);
    }

    /**
     * 得到当前时间字符串 格式（HH:mm:ss）
     */
    public static String getTime() {
        return format(new Date(), DEFAULT_TIME_PATTEN);
    }

    /**
     * 得到当前年份字符串 格式（yyyy）
     */
    public static String getYear() {
        return getYear(new Date());
    }

    /**
     * 得到当前年份字符串 格式（yyyy）
     */
    public static String getYear(Date data) {
        return format(data, "yyyy");
    }

    /**
     * 得到当前月份字符串 格式（MM）
     */
    public static String getMonth() {
        return getMonth(new Date());
    }

    /**
     * 得到指定时间的月份字符串 格式（MM）
     */
    public static String getMonth(Date date) {
        return format(date, "MM");
    }

    /**
     * 得到当天字符串 格式（dd）
     */
    public static String getDay() {
        return getDay(new Date());
    }

    /**
     * 得到指定时间的日期字符串 格式（MM）
     */
    public static String getDay(Date date) {
        return format(date, "dd");
    }

    /**
     * 得到当前小时 格式（HH）
     */
    public static String getHour() {
        return getHour(new Date());
    }

    /**
     * 得到指定时间的日期字符串 格式（HH）
     */
    public static String getHour(Date date) {
        return format(date, "HH");
    }

    /**
     * 得到当前星期字符串 格式（E）星期几
     */
    public static String getWeek() {
        return getWeek(new Date());
    }

    /**
     * 得到指定时间的星期字符串 格式（E）星期几
     */
    public static String getWeek(Date date) {
        return format(date, "E");
    }

    /**
     * 日期型字符串转化为日期 格式 { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
     * "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy.MM.dd",
     * "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
     */
    public static Date parseDateTime(Object str) {
        return parse(str, DEFAULT_DATETIME_PATTEN);
    }

    public static Date parseTimestamp(Object str) {
        return parse(str, DEFAULT_TIMESTAMP_PATTEN);
    }

    public static Date parseDate(Object str) {
        return parse(str, DEFAULT_DATE_PATTEN);
    }

    public static Date parse(Object str, String patten) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), patten);
        } catch (ParseException e) {
            // 默认解析错误后，尝试其他格式
            try {
                return parseDate(str.toString(), SUPPORT_PATTENS);
            } catch (ParseException ee) {
                log.error("Unsupported date patten. [{} - {}]", str, patten, ee);
                ee.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 判断日期是否是最小的时间戳，只判断日期部分，忽略时间部分
     */
    public static boolean isMinDate(Date date) {
        return date == null
                || formatDate(MIN_DATE).equalsIgnoreCase(formatDate(date))
                || new DateTime(date).isBefore(new DateTime(MIN_DATE));
    }

    /**
     * 判断时间戳是否是最小的时间戳，只判断日期部分，忽略时间部分
     */
    public static boolean isMinTimestamp(Timestamp timestamp) {
        return timestamp == null
                || formatDate(MIN_TIMESTAMP).equalsIgnoreCase(formatDate(timestamp))
                || new DateTime(timestamp).isBefore(new DateTime(MIN_TIMESTAMP));
    }

    /**
     * 判断日期是否是最大的时间戳，只判断日期部分，忽略时间部分
     */
    public static boolean isMaxDate(Date date) {
        return date == null
                || formatDate(MAX_DATE).equalsIgnoreCase(formatDate(date))
                || new DateTime(date).isAfter(new DateTime(MAX_DATE));
    }

    /**
     * 判断时间戳是否是最大的时间戳，只判断日期部分，忽略时间部分
     */
    public static boolean isMaxTimestamp(Timestamp timestamp) {
        return timestamp == null
                || formatDate(MAX_TIMESTAMP).equalsIgnoreCase(formatDate(timestamp))
                || new DateTime(timestamp).isAfter(new DateTime(MAX_TIMESTAMP));
    }


}
