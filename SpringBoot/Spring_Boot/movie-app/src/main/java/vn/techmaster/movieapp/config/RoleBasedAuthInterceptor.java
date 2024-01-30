package vn.techmaster.movieapp.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import vn.techmaster.movieapp.entity.User;

@Component
public class RoleBasedAuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Lấy thông tin user từ session vs key currentUser
        User user = (User) request.getSession().getAttribute("currentUser");
        //Nếu currentUser ko tồn tại hoặc null thì báo lỗi 401(UNAUTHORIZED)
        if (user == null){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        //Lấy role của user
        String role = String.valueOf(user.getRole());

        String path = request.getRequestURI();

        if(path.startsWith("/admin") || path.startsWith("/api/admin")){
            //nếu role của user ko phải admin thì báo lỗi 403(forbidden)
            if (!role.equals("ADMIN")){
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                return false;
            }
        }
        return true;
    }
}
