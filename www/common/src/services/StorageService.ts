import * as localforage from "localforage";

/**
 * 存储设置
 */
localforage.config({
    name : 'lxp-application',
    driver : localforage.LOCALSTORAGE
});

/**
 * Keys
 * @type {{token: string}}
 */
const keys = {
    token : 'token'
};

/**
 * 存储服务
 */
class StorageService {
    /**
     * 获取Token
     */
    getToken = () => {
        return this.getItem(keys.token);
    };

    /**
     * 设置Token
     */
    setToken = (val : any) => {
        if (val) {
            return this.setItem(keys.token, val);
        } else {
            return this.removeItem(keys.token);
        }
    };

    getItem = (key : string) => {
        return localforage.getItem(key);
    };

    removeItem = (key : string) => {
        return localforage.removeItem(key);
    };

    setItem = (key : string, val : any) => {
        if (val) {
            return localforage.setItem(key, val);
        } else {
            return this.removeItem(key);
        }
    };

    clear = () => {
        return localforage.clear();
    }
}

const storageService = new StorageService();

export default storageService;
