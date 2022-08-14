package com.example.irrigation2.config;

import com.example.irrigation2.model.entity.enums.RoleEnum;
import com.example.irrigation2.repository.UserRepository;
import com.example.irrigation2.service.CurrentUserDetailService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class SecurityConfiguration {

    //Here we have to expose:
//    1. PasswordEncoder
//    2. SecurityFilterChain
//    3. UserDetailsService

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new Pbkdf2PasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                // define which requests are allowed and which not
                .authorizeRequests()
                //everyone can download static resources (css, js, images)
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                // everyone can have access to login and register
                .antMatchers("/", "/users/login", "/users/register","/products/**","/pages/home/**").permitAll()
                // pages available only for admins
                .antMatchers("/admin/**", "/admin").hasRole(RoleEnum.ADMIN.name())
                //all other pages are available for logger in users
//                .anyRequest()
                .antMatchers("/products/sprinkler/**").authenticated()
                .antMatchers("/products/drip/**").authenticated()
             .and()
                // configuration of form login
                .formLogin()
                //the custom login form
                .loginPage("/users/login")
                .successHandler(successHandler()).permitAll()
                //the name of the username form field
                .usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                //the name of the password form field
                .passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY)
                //where to go in case that login is successful
                .defaultSuccessUrl("/")
                //where to go in case that login is failed
                .failureForwardUrl("/users/login-error")
//            .and()
//                .csrf()
//                .csrfTokenRepository(new HttpSessionCsrfTokenRepository())
            .and()
                // configure logout
                .logout()
                // which is the logout url
                .logoutUrl("/users/logout")
                // invalidate the session and delete the cookies
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and()
                .csrf().disable();

        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository){
    return new CurrentUserDetailService(userRepository);
    }

    @Bean
    public AuthenticationSuccessHandler successHandler() {
        SimpleUrlAuthenticationSuccessHandler handler = new SimpleUrlAuthenticationSuccessHandler();
        handler.setUseReferer(true);
        return handler;
    }

}
