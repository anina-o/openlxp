package cn.elvea.lxp.core.security;

import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * SecurityAuthenticationDetailsSource
 *
 * @author elvea
 */
@Component
public class SecurityAuthenticationDetailsSource extends WebAuthenticationDetailsSource {

    @Override
    public WebAuthenticationDetails buildDetails(HttpServletRequest context) {
        return new SecurityDetails(context);
    }

}
