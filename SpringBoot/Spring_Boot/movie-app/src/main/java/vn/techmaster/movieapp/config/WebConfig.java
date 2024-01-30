package vn.techmaster.movieapp.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    AuthenticationInterceptor authenticationInterceptor;
    @Autowired
    RoleBasedAuthInterceptor roleBasedAuthInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor)
                //chỉ áp dụng cho các request tới các đường dẫn bên dưới
                .addPathPatterns("/api/reviews/**");
        registry.addInterceptor(roleBasedAuthInterceptor)
                .addPathPatterns("/admin","/admin/**","/api/admin/**");
    }
}
