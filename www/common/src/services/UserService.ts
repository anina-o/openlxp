import {post, postJson} from '@common/utils/http';
import {Credentials} from "@common/types/credentials";

/**
 * 用户服务
 */
class UserService {
    /**
     * 用户登录
     */
    login = (credentials : Credentials) => {
        return post('/api/login', credentials);
    };
    /**
     * 用户注册
     */
    register = (params = {}) => {
        return postJson('/api/user/register', params)
    };
    /**
     * 获取用户列表
     */
    getUserList = (params = {}, config = {}) => {
        return post('/api/user/list', params, config);
    };
}

export default new UserService();
