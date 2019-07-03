package cn.elvea.lxp.security;

import cn.elvea.lxp.common.utils.UUIDUtils;
import cn.elvea.lxp.common.utils.WebUtils;
import cn.elvea.lxp.common.web.WebResponse;
import com.google.common.collect.Maps;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理登录成功
 *
 * @author elvea
 */
@Service
public class SecurityAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 生成唯一会话ID
        String uuid = UUIDUtils.randomUUID();
        // 生成Token

        //
        if (WebUtils.isAjaxRequest(request) || SecurityUtils.isApiRequest(request)) {
            WebUtils.renderJson(response, WebResponse.success(Maps.newHashMap()));
        } else {
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }

}
