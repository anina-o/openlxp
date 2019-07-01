package cn.elvea.lxp.config;

import cn.elvea.lxp.security.SecurityAuthenticationFailureHandler;
import cn.elvea.lxp.security.SecurityAuthenticationProvider;
import cn.elvea.lxp.security.SecurityAuthenticationSuccessHandler;
import cn.elvea.lxp.security.SecurityConstants;
import cn.elvea.lxp.security.filter.SecurityAuthenticationFilter;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * WebSecurityConfig
 *
 * @author elvea
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 密码加密
     *
     * @return PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * @see WebSecurityConfigurerAdapter#configure(HttpSecurity)
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll();
    }

    /**
     * API
     * <p>
     * 用于做接口方面相关控制
     */
    @Configuration
    @Order(1)
    public static class ApiSecurityConfigAdapter extends WebSecurityBaseConfig {

        @Autowired
        private SecurityAuthenticationFailureHandler authenticationFailureHandler;

        @Autowired
        private SecurityAuthenticationSuccessHandler authenticationSuccessHandler;

        @Bean
        public SecurityAuthenticationFilter securityAuthenticationFilter() {
            SecurityAuthenticationFilter authenticationFilter = new SecurityAuthenticationFilter();
            // 接口登录不限定请求提交方式
            authenticationFilter.setPostOnly(false);
            // 设置AuthenticationManager
            authenticationFilter.setAuthenticationManager(authenticationManager());
            // 验证失败回调
            authenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandler);
            // 验证成功回调
            authenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
            return authenticationFilter;
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher(SecurityConstants.API_REQUEST_URL)
                    .addFilterBefore(securityAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                    .csrf().disable()
                    .cors()
                    .and()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .authorizeRequests()
                    .anyRequest().authenticated();
        }
    }

}

abstract class WebSecurityBaseConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityAuthenticationProvider authenticationProvider;

    @Override
    protected AuthenticationManager authenticationManager() {
        return new ProviderManager(Lists.newArrayList(authenticationProvider));
    }

}
