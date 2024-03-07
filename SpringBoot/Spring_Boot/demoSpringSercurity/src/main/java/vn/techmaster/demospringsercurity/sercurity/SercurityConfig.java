package vn.techmaster.demospringsercurity.sercurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.security.Security;

@Configuration
public class SercurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        String[] publicPaths = {"/phim-bo","/phim-le","/tin-tuc"};
        //Cấu hình đường dẫn (401 -chưa xác thực, 403- chưa có quyền)
        httpSecurity.authorizeHttpRequests(authorizeRequests -> {
            authorizeRequests.requestMatchers("/").permitAll();
            authorizeRequests.requestMatchers("/css/**","/js/**","/image/**").permitAll();
            authorizeRequests.requestMatchers(publicPaths).permitAll();
            authorizeRequests.requestMatchers("/profile").hasRole("USER");
            authorizeRequests.requestMatchers("/admin").hasRole("ADMIN");
            authorizeRequests.requestMatchers("/author").hasAnyRole("ADMIN","AUTHOR");
            authorizeRequests.requestMatchers("/users","movies").hasAuthority("ROLE_ADMIN");

            authorizeRequests.requestMatchers("GET","/aa/**").hasRole("ADMIN");
            authorizeRequests.anyRequest().authenticated();
        });

        //Cấu hình form login
        httpSecurity.formLogin(formLogin -> {
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
        return httpSecurity.build();
    }

}
