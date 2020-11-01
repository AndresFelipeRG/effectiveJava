package com.effectivejava.items.config;

import com.effectivejava.items.utility.security.Endpoints;
import com.effectivejava.items.utility.security.RoleNames;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
import org.springframework.security.web.csrf.CsrfTokenRepository;

import javax.servlet.Filter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationSuccessHandler
            customAuthenticationSuccessHandler;

    private final Filter jwtAuthenticationFilter;

    private final Filter loginAttemptCountFilter;

    private final LogoutSuccessHandler customLogoutSuccessHandler;

    private final CsrfTokenRepository customCsrfTokenRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, Endpoints.LOGIN_URL).permitAll()
                .antMatchers(Endpoints.REGISTRATION_URL).permitAll()
                .antMatchers(Endpoints.REGISTRATION_URL + "/**")
                .permitAll()
                .antMatchers(Endpoints.ADMIN_BASE_PATH + "**")
                .hasRole(RoleNames.ADMIN.getValue())
                .antMatchers("/**")
                .hasRole(RoleNames.USER.getValue())
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage(Endpoints.LOGIN_URL)
                .successHandler(customAuthenticationSuccessHandler)
                .permitAll()
                .and()
                .logout()
                .logoutUrl(Endpoints.LOGOUT_URL)
                .logoutSuccessHandler(customLogoutSuccessHandler)
                .permitAll()
                .and()
                .requiresChannel().anyRequest().requiresSecure()
                .and()
                .csrf()
                .csrfTokenRepository(customCsrfTokenRepository)
                .ignoringAntMatchers(
                        Endpoints.LOGIN_URL,
                        Endpoints.REGISTRATION_URL
                )
                .sessionAuthenticationStrategy(
                        new NullAuthenticatedSessionStrategy()
                )
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterAfter(
                        jwtAuthenticationFilter,
                        UsernamePasswordAuthenticationFilter.class
                )
                .addFilterBefore(
                        loginAttemptCountFilter,
                        UsernamePasswordAuthenticationFilter.class
                );
    }

    @Autowired
    public void configureGlobal(
            AuthenticationManagerBuilder auth
    ) throws Exception
    {
        auth.userDetailsService(userService)
                .passwordEncoder(passwordEncoder);
    }


}
