package com.ultravet.veterinaria.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AdminSessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        HttpSession session = request.getSession(false);
        Object rol = session == null ? null : session.getAttribute("usuarioRol");

        if ("ADMIN".equals(rol)) {
            return true;
        }

        response.sendRedirect(request.getContextPath() + "/");
        return false;
    }
}
