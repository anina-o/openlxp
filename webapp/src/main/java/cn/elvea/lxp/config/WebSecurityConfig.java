package cn.elvea.lxp.config;

import cn.elvea.lxp.core.type.RoleType;
import cn.elvea.lxp.security.*;
import cn.elvea.lxp.security.filter.SecurityAuthenticationFilter;
import cn.elvea.lxp.security.service.SecurityService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
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
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private SecurityAuthenticationProvider authenticationProvider;

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider)
                .userDetailsService(securityService)
                .passwordEncoder(passwordEncoder());
    }

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
     * API
     */
    @Configuration
    @Order(1)
    public static class ApiSecurityConfigAdapter extends WebSecurityBaseConfig {

        @Autowired
        private SecurityAuthenticationDetailsSource securityAuthenticationDetailsSource;

        @Autowired
        private SecurityAuthenticationFailureHandler authenticationFailureHandler;

        @Autowired
        private SecurityAuthenticationSuccessHandler authenticationSuccessHandler;

        @Bean
        public SecurityAuthenticationFilter securityAuthenticationFilter() {
            SecurityAuthenticationFilter authenticationFilter = new SecurityAuthenticationFilter();
            authenticationFilter.setPostOnly(false);
            authenticationFilter.setAuthenticationManager(authenticationManager());
            authenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandler);
            authenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
            authenticationFilter.setAuthenticationDetailsSource(securityAuthenticationDetailsSource);
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
                    .formLogin().disable()
                    .authorizeRequests()
                    .antMatchers("/admin/**").hasAnyRole(RoleType.SYSTEM_ADMINISTRATOR.getCode(), RoleType.ADMINISTRATOR.getCode())
                    .anyRequest().authenticated();
        }
    }

    /**
     * xAPI
     */
    @Configuration
    @Order(2)
    public static class XApiSecurityConfigAdapter extends WebSecurityBaseConfig {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher(SecurityConstants.XAPI_REQUEST_URL)
                    .csrf().disable()
                    .cors()
                    .and()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .authorizeRequests()
                    .antMatchers("/xAPI/about").permitAll()
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
