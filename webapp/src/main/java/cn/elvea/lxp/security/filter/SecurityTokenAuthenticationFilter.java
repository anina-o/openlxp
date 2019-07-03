package cn.elvea.lxp.security.filter;

import cn.elvea.lxp.security.SecurityUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录认证过滤器
 *
 * @author elvea
 */
public class SecurityTokenAuthenticationFilter extends SecurityBaseAuthenticationFilter {

    /**
     * 只有登录认证请求才需要做登录认证
     */
    @Override
    protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
        return SecurityUtils.isApiRequest(request);
    }

}
