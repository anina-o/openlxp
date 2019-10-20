package cn.elvea.lxp.core.security;

import cn.elvea.lxp.common.utils.WebUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理登录失败
 *
 * @author elvea
 */
@Slf4j
@Service
public class SecurityAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    /**
     * @see SimpleUrlAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String errorMessageCode = "";
        if (exception instanceof DisabledException) {
            // 账号被禁用
            errorMessageCode = "";
        } else if (exception instanceof LockedException) {
            // 账号被锁定
            errorMessageCode = "";
        } else if (exception instanceof CredentialsExpiredException) {
            // 密码过期
            errorMessageCode = "";
        } else if (exception instanceof AccountExpiredException) {
            // 账号过期
            errorMessageCode = "";
        } else if (exception instanceof AccountStatusException) {
            // 账号状态异常
            errorMessageCode = "";
        } else if (exception instanceof BadCredentialsException) {
            // 密码错误
            errorMessageCode = "";
        } else if (exception instanceof UsernameNotFoundException) {
            // 用户找不到
            errorMessageCode = "";
        }

        // 登录失败后返回错误信息或者跳转回登录页面
        if (SecurityUtils.isApiRequest(request)) {
            WebUtils.renderJson(response, "");
        } else if (SecurityUtils.isXApiRequest(request)) {
            WebUtils.renderJson(response, "");
        } else {
            super.onAuthenticationFailure(request, response, exception);
        }
    }

}
