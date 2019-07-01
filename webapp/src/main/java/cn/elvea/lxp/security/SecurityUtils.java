package cn.elvea.lxp.security;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

/**
 * SecurityUtils
 *
 * @author elvea
 */
public class SecurityUtils {

    /**
     * 当前登录请求是否是接口登录
     */
    public static boolean isApiLogin(HttpServletRequest request) {
        return SecurityUtils.isUrlMatches(request, SecurityConstants.LOGIN_URL);
    }

    /**
     * 当前请求是否是请求接口
     */
    public static boolean isApiRequest(HttpServletRequest request) {
        return SecurityUtils.isUrlMatches(request, SecurityConstants.API_REQUEST_URL);
    }

    /**
     * 当前请求是否是请求接口
     */
    public static boolean isXApiRequest(HttpServletRequest request) {
        return SecurityUtils.isUrlMatches(request, SecurityConstants.XAPI_REQUEST_URL);
    }

    /**
     * 工具类，验证当前请求连接是否匹配
     *
     * @param request 请求
     * @param pattern 连接
     * @return boolean
     */
    public static boolean isUrlMatches(HttpServletRequest request, String pattern) {
        return isUrlMatches(request, pattern, null);
    }

    /**
     * 工具类，验证当前请求连接是否匹配
     *
     * @param request 请求
     * @param pattern 连接
     * @return boolean
     */
    public static boolean isUrlMatches(HttpServletRequest request, String... pattern) {
        if (pattern != null) {
            for (String p : pattern) {
                if (isUrlMatches(request, p)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 工具类，验证当前请求连接是否匹配
     *
     * @param request    请求
     * @param pattern    连接
     * @param httpMethod 请求方法
     * @return boolean
     */
    public static boolean isUrlMatches(HttpServletRequest request, String pattern, String httpMethod) {
        RequestMatcher requestMatcher = new AntPathRequestMatcher(pattern, httpMethod);
        return requestMatcher.matches(request);
    }

}
