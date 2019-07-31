// 路由状态
import {RouterStore, syncHistoryWithStore} from "mobx-react-router";
import {createBrowserHistory} from "history";
import {action, computed, observable} from "mobx";
import {indexOf, isArray} from "lodash";
//
import storageService from "@common/services/StorageService";
import {availableApplicationLocales, defaultApplicationLocale} from "@common/constants";
import {parseJwtToken} from "@common/utils/jwt-utils";
import {defaultPreference, Preference} from "@common/types/preference";
import {Principal} from "@common/types/principal";
//
const routingStore = new RouterStore();
const browserHistory = createBrowserHistory();
const history = syncHistoryWithStore(browserHistory, routingStore);
//
const STORAGE_PREFERENCE_KEY = "preference";

/**
 * 全局状态
 */
export default class GlobalStore {

    /**
     * RouterStore
     */
    history: RouterStore = routingStore;

    /**
     * Token
     */
    @observable
    token: string | null = null;

    /**
     * 账号
     */
    @observable
    principal: Principal | null = null;

    /**
     * 用户喜好
     */
    @observable
    preference: Preference = defaultPreference;

    /**
     * 切换语言
     */
    @action changeLocale = async (locale: string) => {
        if (indexOf(availableApplicationLocales, locale) < 0) {
            locale = defaultApplicationLocale;
        }
        this.preference.locale = locale;
        return storageService.setItem(STORAGE_PREFERENCE_KEY, this.preference);
    };

    /**
     * 切换侧边栏样式
     */
    @action toggleSidebar = async () => {
        this.preference.sidebar.collapsed = !this.preference.sidebar.collapsed;
        return storageService.setItem(STORAGE_PREFERENCE_KEY, this.preference);
    };

    /**
     * 检查当前是否已经登录
     */
    @computed get authenticated() {
        return (this.token != null && this.principal != null)
    };

    /**
     * 登陆成功后回调
     */
    @action hasPermission = (authority: any) => {
        // 用户为空等同于没有权限
        if (this.principal === null) {
            return false;
        }
        // 未指定权限时等同于只需要用户已经登录
        if (!authority) {
            return true;
        }
        // 获取账号权限信息
        const authorities = (this.principal && this.principal.authorities) ? this.principal.authorities : [];
        // 权限信息是数组
        if (isArray(authority)) {
            let result = false;
            authority.forEach((a: any) => {
                if (authorities.indexOf(a) >= 0) {
                    result = true;
                }
            });
            return result;
        }
        // 权限信息是字符串
        if (typeof authority === 'string') {
            if (authorities.indexOf(authority) >= 0) {
                return true;
            }
        }
        return false;
    };

    /**
     * 登陆成功后回调
     */
    @action loginSuccess = async (token: string) => {
        // 登录成功后清空本地已保存的登录信息
        await this.clear();

        // 保存登录用户信息
        this.token = token;
        this.principal = parseJwtToken(token);

        // 更新本地存储的用户信息
        await storageService.setToken(token);
    };

    /**
     * 初始化
     * 用于页面初始后，从浏览器缓存加载已保存的信息，比如用户登录信息，界面设置，多语言等等。
     */
    @action init = async (): Promise<boolean> => {
        this.preference = await storageService.getItem(STORAGE_PREFERENCE_KEY) as Preference;
        this.token = await storageService.getToken() as string;
        this.principal = parseJwtToken(this.token);
        console.log(this.token);
        console.log(this.principal);
        console.log(this.preference);
        return true;
    };

    /**
     * 用户退出
     * 清空所有状态和用户登录信息
     */
    @action clear = async () => {
        // 退出后清空存储信息
        await storageService.clear();
        // 清空用户相关信息
        this.token = null;
        this.principal = null;
        // 重置用户喜好
        this.preference = defaultPreference;
    };
}

export {history, browserHistory, routingStore}
