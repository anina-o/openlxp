package cn.elvea.lxp.config;

import cn.elvea.lxp.security.SecurityAuthenticationDetailsSource;
import cn.elvea.lxp.security.SecurityAuthenticationFailureHandler;
import cn.elvea.lxp.security.SecurityAuthenticationProvider;
import cn.elvea.lxp.security.SecurityAuthenticationSuccessHandler;
import cn.elvea.lxp.security.filter.SecurityAuthenticationFilter;
import cn.elvea.lxp.security.service.SecurityService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

import static cn.elvea.lxp.security.SecurityConstants.API_REQUEST_URL;
import static cn.elvea.lxp.security.SecurityConstants.XAPI_REQUEST_URL;

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
    private SecurityAuthenticationDetailsSource securityAuthenticationDetailsSource;

    @Autowired
    private SecurityAuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private SecurityAuthenticationSuccessHandler authenticationSuccessHandler;


    @Override
    protected AuthenticationManager authenticationManager() {
        return new ProviderManager(Lists.newArrayList(authenticationProvider));
    }

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
        http.csrf().disable()
                .cors().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests()
                .antMatchers("/druid/*").permitAll()
                .antMatchers("/actuator").permitAll()
                .antMatchers("/actuator/**").permitAll()
                .antMatchers(API_REQUEST_URL).permitAll()
                .antMatchers(XAPI_REQUEST_URL).permitAll()
                .anyRequest().permitAll();
    }

}
