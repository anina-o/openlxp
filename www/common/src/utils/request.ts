import axios, {AxiosRequestConfig} from 'axios';
import {stringify} from 'qs';
import {isEmpty} from 'lodash';
//
import environment from '@common/environments/environment'

/**
 * 文件上传的表单头信息
 */
const postMultipartHeaders: AxiosRequestConfig = {
    method: 'post',
    headers: {
        'Content-Type': 'multipart/form-data'
    },
    transformRequest: (data: {}) => {
        return data
    }
};

/**
 * Json数据的表单头信息
 */
const postJsonHeaders: AxiosRequestConfig = {
    headers: {'Content-Type': 'application/json'},
    transformRequest: (data: {}) => {
        return JSON.stringify(data);
    }
};

/**
 * 表单头信息
 */
const postHeaders: AxiosRequestConfig = {
    headers: {'Content-Type': 'application/x-www-form-urlencoded'},
    transformRequest: (data: {}) => {
        return stringify(data);
    },
    paramsSerializer: (data: {}) => {
        return stringify(data);
    },
};

/**
 * 初始化
 */
const setupAxios = async () => {
    // 设置基本参数
    axios.defaults.timeout = 60000;
    axios.defaults.baseURL = environment.server;
    // 添加Token信息
    axios.interceptors.request.use((config) => {
        let token = '';
        if (isEmpty(token)) {
            config.headers.common['authorization'] = null;
        } else {
            config.headers.common['authorization'] = 'Bearer ' + token;
        }
        return config;
    }, (error) => {
        return Promise.reject(error)
    });
    // 结果处理
    axios.interceptors.response.use((response) => {
        return response
    }, (error) => {
        if (error.response) {
            switch (error.response.status) {
                case 400:
                    console.log(error.response.data.message);
                    break;
                case 401:
                    break;
                default:
                    console.log(error.response);
                    break
            }
        } else {
            console.log(error);
        }
        return Promise.reject(error);
    });
};

// URL
const getUrl = (url: string) => {
    return environment.server + url;
};

// Get
const get = (url: string, params: any = {}, config: AxiosRequestConfig = {}) => {
    config.params = params;
    return axios.get(url, config).then(res => res.data)
};

// Post
const post = (url: string, data: any = {}, config: AxiosRequestConfig = postHeaders) => {
    return axios.post(url, data, config).then(res => res.data)
};

// Post
const postJson = (url: string, data: any = {}, config: AxiosRequestConfig = postJsonHeaders) => {
    return axios.post(url, data, config).then(res => res.data)
};

// Upload
const postMultiple = (url: string, data: any = {}, config: AxiosRequestConfig = postMultipartHeaders) => {
    return axios.post(url, data, config).then(res => res.data)
};

export default axios;

export {getUrl, setupAxios}
export {get, post, postJson, postMultiple}
export {postHeaders, postJsonHeaders, postMultipartHeaders}
