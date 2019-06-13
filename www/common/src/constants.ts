import zhCnIntl from '@common/locales/zh_CN';
import zhTwIntl from '@common/locales/zh_TW';
import enUsIntl from '@common/locales/en_US';

/**
 * 应用版本号
 */
export const applicationVersion: string = '0.0.1';
/**
 * 多语言文本
 */
export const applicationLocales = {
    "zh-cn": zhCnIntl,
    "zh-tw": zhTwIntl,
    "en-us": enUsIntl,
};
/**
 * 默认语言
 */
export const defaultApplicationLocale: string = 'zh-cn';
/**
 * 可用语言
 */
export const availableApplicationLocales: string[] = [
    'zh-cn',
    'zh-tw',
    'en-us'
];
/**
 * 默认分页每页记录数
 */
export const defaultPageSize: number = 12;
/**
 * 默认显示第几页
 */
export const defaultPage: number = 1;
/**
 * 水平表单样式
 */
export const detailField = {
    style: {
        marginBottom: 10
    }
};
export const detailFieldLabel = {
    xs: {span: 4},
    sm: {span: 4},
    md: {span: 4},
    lg: {span: 4},
    xl: {span: 4},
    xxl: {span: 4},
};
export const detailFieldValue = {
    xs: {span: 18},
    sm: {span: 18},
    md: {span: 18},
    lg: {span: 18},
    xl: {span: 18},
    xxl: {span: 18},
};
export const detailTail = {
    xs: {span: 18, offset: 4},
    sm: {span: 18, offset: 4},
    md: {span: 18, offset: 4},
    lg: {span: 18, offset: 4},
    xl: {span: 18, offset: 4},
    xxl: {span: 18, offset: 4},
};
/**
 * 水平表单布局样式
 */
export const formItemLayout = {
    labelCol: {
        xs: {span: 24},
        sm: {span: 4},
    },
    wrapperCol: {
        xs: {span: 24},
        sm: {span: 12},
    },
};
export const tailFormItemLayout = {
    wrapperCol: {
        xs: {
            span: 24,
            offset: 0,
        },
        sm: {
            span: 12,
            offset: 4,
        },
    },
};
