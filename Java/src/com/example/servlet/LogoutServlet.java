package com.example.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        
        Cookie autoLoginCookie = new Cookie("autoLoginToken", "");
        autoLoginCookie.setMaxAge(0);
        autoLoginCookie.setPath("/");
        response.addCookie(autoLoginCookie);
        
        Cookie savedUsernameCookie = new Cookie("savedUsername", "");
        savedUsernameCookie.setMaxAge(0);
        savedUsernameCookie.setPath("/");
        response.addCookie(savedUsernameCookie);
        
        Cookie savedPasswordCookie = new Cookie("savedPassword", "");
        savedPasswordCookie.setMaxAge(0);
        savedPasswordCookie.setPath("/");
        response.addCookie(savedPasswordCookie);
        
        response.sendRedirect(request.getContextPath() + "/login");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
