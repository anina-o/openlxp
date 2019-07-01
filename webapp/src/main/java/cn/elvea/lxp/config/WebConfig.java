package cn.elvea.lxp.config;

import cn.elvea.lxp.common.web.jackson.CustomJsonModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * WebConfig
 *
 * @author elvea
 */
@Configuration
@EnableSpringDataWebSupport
public class WebConfig implements WebMvcConfigurer {

    /**
     * @see WebMvcConfigurer#addArgumentResolvers(List)
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {

    }

    /**
     * 增加自定义的JSON转换器
     *
     * @see WebMvcConfigurer#extendMessageConverters(List)
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        for (HttpMessageConverter<?> converter : converters) {
            if (converter instanceof MappingJackson2HttpMessageConverter) {
                MappingJackson2HttpMessageConverter jsonMessageConverter = (MappingJackson2HttpMessageConverter) converter;
                ObjectMapper objectMapper = jsonMessageConverter.getObjectMapper();
                objectMapper.registerModule(new CustomJsonModule());
                break;
            }
        }
    }

}
