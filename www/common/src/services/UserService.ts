import {post, postJson} from '@common/utils/request'

/**
 * 用户服务
 */
class UserService {
    /**
     * 用户登录
     */
    login = (username: string, password: string) => {
        return post('/api/login', {
            username: username,
            password: password
        })
    };
    /**
     * 用户注册
     */
    register = (params = {}) => {
        return postJson('/api/user/register', params)
    };
    /**
     * 获取用户列表
     * @param params
     * @param config
     */
    getUserList = (params = {}, config = {}) => {
        return post('/api/user/list', params, config);
    };
}

export default new UserService();
