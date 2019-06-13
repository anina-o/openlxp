import {defaultApplicationLocale} from '@common/constants';

/**
 * 用户喜好
 */
export interface Preference {
    /**
     * 当前语言
     */
    locale: string;
    /**
     * 侧边栏
     */
    sidebar: {
        /**
         * 是否收起
         */
        collapsed: boolean;
    };
}

/**
 * 默认用户喜好
 */
export const defaultPreference: Preference = {
    /**
     * 当前语言
     */
    locale: defaultApplicationLocale,
    /**
     * 侧边栏
     */
    sidebar: {
        /**
         * 是否收起
         */
        collapsed: false,
    },
};
