package vn.techmaster.movieapp.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import vn.techmaster.movieapp.entity.User;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Lấy thông tin user từ session vs key currentUser
        User user = (User) request.getSession().getAttribute("currentUser");
        //Nếu currentUser ko tồn tại hoặc null thì báo lỗi 401(UNAUTHORIZED)
        if (user == null){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        return true;
    }
}
