package cn.elvea.lxp.security.filter;

import cn.elvea.lxp.core.type.PlatformType;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * SecurityBaseAuthenticationFilter
 *
 * @author elvea
 */
public abstract class SecurityBaseAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    /**
     * 获取当前登录请求的登陆平台
     *
     * @param request {@link HttpServletRequest}
     * @return String
     */
    public String obtainPlatformType(HttpServletRequest request) {
        String platform = request.getParameter("platform");
        return PlatformType.getPlatformType(platform).getCode();
    }

    /**
     * 获取当前登录请求的移动的客户端版本
     *
     * @param request {@link HttpServletRequest}
     * @return String
     */
    public String obtainAppVersion(HttpServletRequest request) {
        String appVersion = request.getParameter("appVersion");
        if (StringUtils.isEmpty(appVersion)) {
            appVersion = "--";
        }
        return appVersion;
    }

}
