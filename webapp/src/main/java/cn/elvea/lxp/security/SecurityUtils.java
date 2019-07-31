package cn.elvea.lxp.security;

import cn.elvea.lxp.core.type.LangType;
import com.google.common.collect.Maps;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * SecurityUtils
 *
 * @author elvea
 */
public class SecurityUtils {

    /**
     * 当前登录请求是否是接口登录
     */
    public static boolean isApiLogin(HttpServletRequest request) {
        return SecurityUtils.isUrlMatches(request, SecurityConstants.LOGIN_URL);
    }

    /**
     * 当前请求是否是请求接口
     */
    public static boolean isApiRequest(HttpServletRequest request) {
        return SecurityUtils.isUrlMatches(request, SecurityConstants.API_REQUEST_URL);
    }

    /**
     * 当前请求是否是请求接口
     */
    public static boolean isXApiRequest(HttpServletRequest request) {
        return SecurityUtils.isUrlMatches(request, SecurityConstants.XAPI_REQUEST_URL);
    }

    /**
     * 工具类，验证当前请求连接是否匹配
     *
     * @param request 请求
     * @param pattern 连接
     * @return boolean
     */
    public static boolean isUrlMatches(HttpServletRequest request, String pattern) {
        return isUrlMatches(request, pattern, null);
    }

    /**
     * 工具类，验证当前请求连接是否匹配
     *
     * @param request 请求
     * @param pattern 连接
     * @return boolean
     */
    public static boolean isUrlMatches(HttpServletRequest request, String... pattern) {
        if (pattern != null) {
            for (String p : pattern) {
                if (isUrlMatches(request, p)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 工具类，验证当前请求连接是否匹配
     *
     * @param request    请求
     * @param pattern    连接
     * @param httpMethod 请求方法
     * @return boolean
     */
    public static boolean isUrlMatches(HttpServletRequest request, String pattern, String httpMethod) {
        RequestMatcher requestMatcher = new AntPathRequestMatcher(pattern, httpMethod);
        return requestMatcher.matches(request);
    }

    /**
     * 是否是匿名用户
     */
    public static boolean isAnonymous() {
        return getPrincipal() == null;
    }

    /**
     * 获取当前登录用户名
     */
    public static String getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                return ((UserDetails) principal).getUsername();
            } else if (principal instanceof String) {
                return (String) principal;
            }
        }
        return null;
    }

    /**
     * 获取当前登录用户ID
     */
    public static Long getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof SecurityUser) {
                return ((SecurityUser) principal).getId();
            }
        }
        return null;
    }

    /**
     * 获取当前登录用户
     */
    public static SecurityUser getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof SecurityUser) {
                return ((SecurityUser) principal);
            }
        }
        return null;
    }

    /**
     * 获取当前登录账号所设置的区域
     *
     * @return Locale 国际化区域
     */
    public static Locale getCurrentLocale() {
        return LangType.getDefaultLangType().getLocale();
    }

    /**
     * 获取当前语言
     *
     * @return 当前语言
     */
    public static String getCurrentLang() {
        return LangType.getDefaultLang();
    }

    /**
     * 公共秘钥
     */
    private static final byte[] SECRET = "jHwskkOFNmBISheIpxBvUBwVjvTahXgP".getBytes();

    private static final String HEADER_PREFIX = "Bearer ";

    /**
     * 获取请求中的Token
     *
     * @param request {{@link HttpServletRequest}}
     * @return Token
     */
    public static String getRequestToken(HttpServletRequest request) {
        // 检查Header是否包含Token信息
        String header = request.getHeader("Authorization");
        if (StringUtils.isBlank(header)) {
            throw new AuthenticationServiceException("Authorization header cannot be blank!");
        }
        if (header.length() < HEADER_PREFIX.length()) {
            throw new AuthenticationServiceException("Invalid authorization header size.");
        }
        return header.substring(HEADER_PREFIX.length());
    }

    /**
     * Create JWT
     */
    public static String sign(String uuid, SecurityUser user) throws JOSEException {
        // JWSHeader
        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS256);
        // JWSSigner
        JWSSigner jwsSigner = new MACSigner(SECRET);
        //
        Map<String, Object> principal = Maps.newHashMap();
        principal.put("id", user.getUsername());
        principal.put("username", user.getUsername());
        principal.put("nickname", user.getNickname());
        principal.put("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
        principal.put("authorities", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
        // JWTClaimsSet
        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .jwtID(uuid)
                .subject(user.getUsername())
                .claim("principal", principal)
                .build();
        //
        SignedJWT signedJWT = new SignedJWT(jwsHeader, claimsSet);
        signedJWT.sign(jwsSigner);
        return signedJWT.serialize();
    }

    /**
     * Verify JWT
     */
    public static JWTClaimsSet verify(String token) throws JOSEException, ParseException {
        // JWSVerifier
        JWSVerifier verifier = new MACVerifier(SECRET);
        // SignedJWT
        SignedJWT signedJWT = SignedJWT.parse(token);
        signedJWT.verify(verifier);
        return signedJWT.getJWTClaimsSet();
    }

}
