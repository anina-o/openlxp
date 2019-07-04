package cn.elvea.lxp.security;

import cn.elvea.lxp.core.type.LangType;
import com.google.common.collect.Maps;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import net.minidev.json.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

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
     * 获取当前登录用户
     *
     * @return 当前登录用户
     */
    public static SecurityUserDetails getLoginUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof SecurityUserDetails) {
                return (SecurityUserDetails) principal;
            }
        }
        return null;
    }

    /**
     * 获取当前登录账号所设置的区域
     *
     * @return Locale 国际化区域
     */
    public static Locale getCurLocale() {
        return LangType.getDefaultLangType().getLocale();
    }

    /**
     * 是否是匿名用户
     *
     * @return boolean
     */
    public static boolean isAnonymous() {
        return getLoginUser() == null;
    }

    /**
     * 获取当前语言
     *
     * @return 当前语言
     */
    public static String getCurLang() {
        return LangType.getDefaultLang();
    }

    /**
     * 公共秘钥
     */
    private static final byte[] SECRET = "LXP2019".getBytes();

    /**
     * 生成JWT
     *
     * @param payloadMap 载荷
     * @return String
     * @throws JOSEException JOSEException
     */
    public static String sign(Map<String, Object> payloadMap) throws JOSEException {

        // JWSHeader
        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS512);
        // Payload
        Payload payload = new Payload(new JSONObject(payloadMap));
        // JWSObject
        JWSObject jwsObject = new JWSObject(jwsHeader, payload);
        // JWSSigner
        JWSSigner jwsSigner = new MACSigner(SECRET);
        // 签名
        jwsObject.sign(jwsSigner);

        return jwsObject.serialize();
    }

    /**
     * 生成JWT
     *
     * @param token JWT
     * @return String
     * @throws JOSEException JOSEException
     */
    public static Map<String, Object> verify(String token) throws JOSEException, ParseException {
        // JWSObject
        JWSObject jwsObject = JWSObject.parse(token);
        // Payload
        Payload payload = jwsObject.getPayload();
        // JWSVerifier
        JWSVerifier jwsVerifier = new MACVerifier(SECRET);

        Map<String, Object> resultMap = Maps.newHashMap();
        if (jwsObject.verify(jwsVerifier)) {
            resultMap.put("Result", 0);
            // 载荷的数据解析成json对象。
            JSONObject jsonObject = payload.toJSONObject();
            resultMap.put("data", jsonObject);

            //判断token是否过期
            if (jsonObject.containsKey("exp")) {
                Long expTime = Long.valueOf(jsonObject.get("exp").toString());
                Long nowTime = new Date().getTime();
                //判断是否过期
                if (nowTime > expTime) {
                    //已经过期
                    resultMap.clear();
                    resultMap.put("Result", 2);
                }
            }
        } else {
            resultMap.put("Result", 1);
        }
        return resultMap;
    }

}
