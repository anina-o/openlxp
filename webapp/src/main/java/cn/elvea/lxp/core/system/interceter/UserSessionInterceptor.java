package cn.elvea.lxp.core.system.interceter;

import cn.elvea.lxp.core.security.SecurityUtils;
import cn.elvea.lxp.core.system.service.UserSessionService;
import com.nimbusds.jwt.JWTClaimsSet;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户会话拦截器
 *
 * @author elvea
 */
@Slf4j
public class UserSessionInterceptor implements HandlerInterceptor {

    private UserSessionService userSessionService;

    private String sessionId = null;

    /**
     * @see HandlerInterceptor#preHandle(HttpServletRequest, HttpServletResponse, Object)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        try {
            String token = SecurityUtils.getRequestToken(request);
            JWTClaimsSet claimsSet = SecurityUtils.verify(token);
            this.sessionId = claimsSet.getJWTID();
            log.debug("user session interceptor. token [{}]...", sessionId);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed to parse request token.", e);
        }
        return true;
    }

    /**
     * @see HandlerInterceptor#postHandle(HttpServletRequest, HttpServletResponse, Object, ModelAndView)
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }

    /**
     * @see HandlerInterceptor#afterCompletion(HttpServletRequest, HttpServletResponse, Object, Exception)
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (StringUtils.isNotEmpty(sessionId)) {
            log.debug("user session interceptor. update session. token [{}].", sessionId);
            userSessionService.updateSession(sessionId);
        }
    }

    @Autowired
    public void setUserSessionService(UserSessionService userSessionService) {
        this.userSessionService = userSessionService;
    }

}
