package cn.elvea.lxp.core.security.filter;

import cn.elvea.lxp.core.security.SecurityAuthenticationDetailsSource;
import cn.elvea.lxp.core.security.SecurityUtils;
import cn.elvea.lxp.core.security.service.SecurityUserService;
import com.nimbusds.jwt.JWTClaimsSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录认证过滤器
 *
 * @author elvea
 */
public class SecurityTokenAuthenticationFilter extends BasicAuthenticationFilter {

    @Autowired
    private SecurityAuthenticationDetailsSource securityAuthenticationDetailsSource;

    @Autowired
    private SecurityUserService securityService;

    public SecurityTokenAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            String token = SecurityUtils.getRequestToken(request);
            JWTClaimsSet claimsSet = SecurityUtils.verify(token);
            String username = claimsSet.getSubject();
            UserDetails userDetails = securityService.loadUserByUsername(username);
            AbstractAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            authentication.setDetails(securityAuthenticationDetailsSource.buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception ex) {
            logger.error("Could not set user authentication in security context", ex);
        }
        chain.doFilter(request, response);
    }

}
