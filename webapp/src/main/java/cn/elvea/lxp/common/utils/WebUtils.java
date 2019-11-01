package cn.elvea.lxp.common.utils;

import cn.elvea.lxp.common.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * WebUtils
 *
 * @author elvea
 */
@Slf4j
public class WebUtils {
    //
    private static ObjectMapper mapper = new ObjectMapper();

    public static final String TEXT_TYPE = "text/plain";
    public static final String JSON_TYPE = "application/json";
    public static final String XML_TYPE = "text/xml";
    public static final String HTML_TYPE = "text/html";
    public static final String JS_TYPE = "text/javascript";
    public static final String EXCEL_TYPE = "application/vnd.ms-excel";

    /**
     * 判断当前请求是否是Ajax请求
     *
     * @param request HttpServletRequest
     * @return boolean
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With") != null
                && "XMLHttpRequest".equals(request.getHeader("X-Requested-With")));
    }


    /**
     * 直接输出内容的简便函数.
     */
    public static void render(HttpServletResponse response, final String contentType, final String content, final String... headers) {
        response = initResponseHeader(response, contentType, headers);
        try {
            response.getWriter().write(content);
            response.getWriter().flush();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * 直接输出文本.
     */
    public static void renderText(HttpServletResponse response, final String text, final String... headers) {
        render(response, TEXT_TYPE, text);
    }

    /**
     * 直接输出HTML.
     */
    public static void renderHtml(HttpServletResponse response, final String html, final String... headers) {
        render(response, HTML_TYPE, html, headers);
    }

    /**
     * 直接输出XML.
     */
    public static void renderXml(HttpServletResponse response, final String xml, final String... headers) {
        render(response, XML_TYPE, xml, headers);
    }

    /**
     * 直接输出JSON.
     */
    public static void renderJson(HttpServletResponse response, final String jsonString, final String... headers) {
        render(response, JSON_TYPE, jsonString, headers);
    }

    /**
     * 直接输出JSON,使用Jackson转换Java对象.
     */
    public static void renderJson(HttpServletResponse response, final Object data, final String... headers) {
        response = initResponseHeader(response, JSON_TYPE);
        try {
            mapper.writeValue(response.getWriter(), data);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static HttpServletResponse initResponseHeader(HttpServletResponse response, final String contentType, final String... headers) {
        //设置headers参数
        String fullContentType = contentType + "; charset=" + Constants.ENCODING;
        response.setContentType(fullContentType);
        setNoCacheHeader(response);
        return response;
    }

    /**
     * 设置客户端无缓存Header.
     */
    public static void setNoCacheHeader(HttpServletResponse response) {
        // Http 1.0 header
        response.setDateHeader("Expires", 0);
        response.addHeader("Pragma", "no-cache");
        // Http 1.1 header
        response.setHeader("Cache-Control", "no-cache");
    }

    /**
     * 获取客户端IP
     */
    public static final String getHost(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if ("127.0.0.1".equals(ip)) {
            InetAddress inet = null;
            try { // 根据网卡取本机配置的IP
                inet = InetAddress.getLocalHost();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            ip = inet.getHostAddress();
        }
        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ip != null && ip.length() > 15) {
            if (ip.indexOf(",") > 0) {
                ip = ip.substring(0, ip.indexOf(","));
            }
        }
        return ip;
    }

}
