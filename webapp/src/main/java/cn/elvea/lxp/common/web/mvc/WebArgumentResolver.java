package cn.elvea.lxp.common.web.mvc;

import cn.elvea.lxp.common.web.WebRequest;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import static org.springframework.web.bind.support.WebArgumentResolver.UNRESOLVED;

/**
 * WebArgumentResolver
 *
 * @author elvea
 */
public class WebArgumentResolver implements HandlerMethodArgumentResolver {

    /**
     * @see HandlerMethodArgumentResolver#supportsParameter(MethodParameter)
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        if (parameter.getParameterType().equals(WebRequest.class)) {
            return true;
        }
        return false;
    }

    /**
     * @see HandlerMethodArgumentResolver#resolveArgument(MethodParameter, ModelAndViewContainer, NativeWebRequest, WebDataBinderFactory)
     */
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory binderFactory) throws Exception {
        if (parameter.getParameterType().equals(WebRequest.class)) {
            return new WebRequest(nativeWebRequest);
        }
        return UNRESOLVED;
    }

}
