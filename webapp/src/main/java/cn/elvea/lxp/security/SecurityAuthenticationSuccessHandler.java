package cn.elvea.lxp.security;

import cn.elvea.lxp.common.exception.ServiceException;
import cn.elvea.lxp.common.utils.UUIDUtils;
import cn.elvea.lxp.common.utils.WebUtils;
import cn.elvea.lxp.common.web.WebResponse;
import com.google.common.collect.Maps;
import com.nimbusds.jose.JOSEException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 处理登录成功
 *
 * @author elvea
 */
@Slf4j
@Service
public class SecurityAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    /**
     * @see SimpleUrlAuthenticationSuccessHandler#handle(HttpServletRequest, HttpServletResponse, Authentication)
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        // 生成唯一会话ID
        String uuid = UUIDUtils.randomUUID();
        SecurityUser user = SecurityUtils.getCurrentUser();
        if (user == null) {
            log.error("Principal cannot be null.");
            throw new ServiceException("Principal cannot be null.");
        }

        Map<String, Object> resultMap = Maps.newHashMap();
        try {
            resultMap.put("token", SecurityUtils.sign(uuid, user));
        } catch (JOSEException e) {
            log.error("Token generate failed.");
            throw new ServiceException("Token generate failed.");
        }
        WebUtils.renderJson(response, WebResponse.success(resultMap));
    }

}
