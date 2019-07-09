package cn.elvea.lxp.security;

import cn.elvea.lxp.core.type.PlatformType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * SecurityDetails
 *
 * @author elvea
 */
@Getter
@Setter
public class SecurityDetails extends WebAuthenticationDetails {

    /**
     * 当前客户端版本
     */
    private String clientVersion;

    /**
     * 当前请求登录的平台
     */
    private String platform;

    public SecurityDetails(HttpServletRequest request) {
        super(request);

        this.platform = this.obtainPlatform(request);
        this.clientVersion = this.obtainClientVersion(request);
    }

    /**
     * 获取当前登录请求的登陆平台
     *
     * @param request {@link HttpServletRequest}
     * @return String
     */
    public String obtainPlatform(HttpServletRequest request) {
        String platform = request.getParameter("platform");
        return PlatformType.getPlatformType(platform).getCode();
    }

    /**
     * 获取当前登录请求的移动的客户端版本
     *
     * @param request {@link HttpServletRequest}
     * @return String
     */
    public String obtainClientVersion(HttpServletRequest request) {
        String clientVersion = request.getParameter("clientVersion");
        if (StringUtils.isEmpty(clientVersion)) {
            clientVersion = "--";
        }
        return clientVersion;
    }

}
