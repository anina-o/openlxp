import {format} from "date-fns";
import {isUndefined} from "lodash";

/**
 * 格式化日期
 */
export function formatDatetime(date : Date | number) {
    if (!isUndefined(date)) {
        return format(date, "YYYY-MM-DD HH:mm")
    }
    return '--';
}

/**
 * 格式化日期
 */
export function formatDate(date : Date | number) {
    if (!isUndefined(date)) {
        return format(date, "YYYY-MM-DD")
    }
    return '--';
}

/**
 * 格式化年份
 */
export function formatYear(date : Date | number) {
    if (!isUndefined(date)) {
        return format(date, "YYYY")
    }
    return '--';
}
