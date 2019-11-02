import axios, {AxiosRequestConfig,} from 'axios';
import qs from 'qs';
//
import environment from '@common/environments/environment'

// 设置基本参数
axios.defaults.timeout = 60000;
axios.defaults.baseURL = environment.server;
axios.defaults.withCredentials = true;
axios.defaults.headers['Content-Type'] = 'application/x-www-form-urlencoded';

// 创建实例
const http = axios.create({});

// Add a request interceptor
http.interceptors.request.use(function (config) {
    return config;
}, function (error) {
    return Promise.reject(error);
});
http.interceptors.response.use(function (response) {
    return response;
}, function (error) {
    return Promise.reject(error);
});

/**
 * 文件上传的表单头信息
 */
const postMultipartHeaders : AxiosRequestConfig = {
    headers : {
        'Content-Type' : 'multipart/form-data'
    },
    transformRequest : (data : any) => {
        return data
    }
};

/**
 * Json数据的表单头信息
 */
const postJsonHeaders : AxiosRequestConfig = {
    headers : {
        'Content-Type' : 'application/json'
    },
    transformRequest : (data : any) => {
        return JSON.stringify(data);
    }
};

/**
 * 表单头信息
 */
const postHeaders : AxiosRequestConfig = {
    transformRequest : (data : any, headers : any) => {
        console.log('transformRequest...');
        console.log(headers);
        console.log(data);
        console.log(qs.stringify(data));
        return qs.stringify(data);
    },
    paramsSerializer : (data : {}) => {
        console.log('paramsSerializer...');
        console.log(data);
        return qs.stringify(data);
    },
};

// Get
const get = (url : string, params : any = {}, config : AxiosRequestConfig = {}) => {
    config.params = params;
    return http.get(url, config).then(res => res.data);
};

// Post
const post = (url : string, data : any = {}, config : AxiosRequestConfig = postHeaders) => {
    return http.post(url, data, config).then(res => res.data);
};

// Post
const postJson = (url : string, data : any = {}, config : AxiosRequestConfig = postJsonHeaders) => {
    return http.post(url, data, config).then(res => res.data);
};

// Upload
const postMultiple = (url : string, data : any = {}, config : AxiosRequestConfig = postMultipartHeaders) => {
    return http.post(url, data, config).then(res => res.data)
};

export default http;
export {get, post, postJson, postMultiple}
export {postHeaders, postJsonHeaders, postMultipartHeaders}
