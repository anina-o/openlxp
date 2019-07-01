package cn.elvea.lxp.security;

import cn.elvea.lxp.common.utils.WebUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理登录失败
 */
@Slf4j
@Service
public class SecurityAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        // 登录失败后返回错误信息或者跳转回登录页面
        if (SecurityUtils.isApiRequest(request)) {
            WebUtils.renderJson(response, response);
        } else if (SecurityUtils.isXApiRequest(request)) {

        }
    }

}
