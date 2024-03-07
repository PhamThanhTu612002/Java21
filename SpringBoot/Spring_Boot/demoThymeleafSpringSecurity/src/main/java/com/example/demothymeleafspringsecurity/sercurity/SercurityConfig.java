package com.example.demothymeleafspringsecurity.sercurity;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(
        jsr250Enabled = true,
        securedEnabled = true
)
@RequiredArgsConstructor
public class SercurityConfig {
    @Autowired
    CustomUserDetailsService customUserDetailsService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
        dao.setPasswordEncoder(passwordEncoder);
        dao.setUserDetailsService(customUserDetailsService);
        return dao;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        String[] publicPaths = {"/phim-bo","/phim-le","/tin-tuc"};
        //Cấu hình đường dẫn (401 -chưa xác thực, 403- chưa có quyền)
        httpSecurity.authorizeHttpRequests(authorizeRequests -> {
//            authorizeRequests.requestMatchers("/").permitAll();
//            authorizeRequests.requestMatchers("/css/**","/js/**","/image/**").permitAll();
//            authorizeRequests.requestMatchers(publicPaths).permitAll();
//            authorizeRequests.requestMatchers("/profile").hasRole("USER");
//            authorizeRequests.requestMatchers("/admin").hasRole("ADMIN");
//            authorizeRequests.requestMatchers("/author").hasAnyRole("ADMIN","AUTHOR");
//            authorizeRequests.requestMatchers("/users","movies").hasAuthority("ROLE_ADMIN");
//
//            authorizeRequests.requestMatchers("GET","/aa/**").hasRole("ADMIN");
//            authorizeRequests.anyRequest().authenticated();
            authorizeRequests.anyRequest().permitAll();
        });

        //Cấu hình form login
        httpSecurity.formLogin(formLogin -> {
            formLogin.loginPage("/login"); //Đường dẫn trang login
            formLogin.defaultSuccessUrl("/",true);
            formLogin.permitAll();
        });
        httpSecurity.logout(logout -> {
            logout.logoutSuccessUrl("/");
            logout.deleteCookies("JSESSIONID");
            logout.invalidateHttpSession(true);
            logout.clearAuthentication(true);
            logout.permitAll();
        });

        //Cấu hình logout

        // Cấu hình xác thực
        httpSecurity.authenticationProvider(authenticationProvider());
        return httpSecurity.build();
    }

}
