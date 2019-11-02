package cn.elvea.lxp.core.system.interceter;

import lombok.extern.slf4j.Slf4j;
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
public class ActionLogInterceptor implements HandlerInterceptor {

    /**
     * 访问结束时间
     */
    private Long actionStartTime;

    /**
     * 访问结束时间
     */
    private Long actionEndTime;

    /**
     * @see HandlerInterceptor#preHandle(HttpServletRequest, HttpServletResponse, Object)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        this.actionStartTime = System.currentTimeMillis();
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
        this.actionEndTime = System.currentTimeMillis();
        //
        log.debug("{} - {}", request.getRequestURI(), this.actionEndTime - this.actionStartTime);
    }

}
