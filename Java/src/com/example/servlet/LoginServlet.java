package com.example.servlet;

import com.example.dao.UserDao;
import com.example.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    
    private static final int MAX_USERNAME_LENGTH = 50;
    private static final int MAX_PASSWORD_LENGTH = 100;
    private static final long CAPTCHA_EXPIRE_TIME = 5 * 60 * 1000;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String captcha = request.getParameter("captcha");
        String rememberMe = request.getParameter("rememberMe");
        String autoLogin = request.getParameter("autoLogin");
        
        if (username == null || username.trim().isEmpty() || 
            password == null || password.trim().isEmpty()) {
            request.setAttribute("error", "用户名和密码不能为空");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        
        if (username.length() > MAX_USERNAME_LENGTH || password.length() > MAX_PASSWORD_LENGTH) {
            request.setAttribute("error", "用户名或密码过长");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        
        username = username.trim();
        
        HttpSession session = request.getSession();
        String sessionCaptcha = (String) session.getAttribute("captcha");
        Long captchaTime = (Long) session.getAttribute("captchaTime");
        
        if (captchaTime != null && (System.currentTimeMillis() - captchaTime) > CAPTCHA_EXPIRE_TIME) {
            request.setAttribute("error", "验证码已过期，请刷新");
            session.removeAttribute("captcha");
            session.removeAttribute("captchaTime");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        
        if (captcha == null || sessionCaptcha == null || !captcha.equalsIgnoreCase(sessionCaptcha)) {
            request.setAttribute("error", "验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        
        User user = UserDao.login(username, password);
        if (user == null) {
            request.setAttribute("error", "用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        
        session.setAttribute("user", user);
        session.removeAttribute("captcha");
        session.removeAttribute("captchaTime");
        
        if ("on".equals(rememberMe)) {
            String encodedUsername = Base64.getEncoder().encodeToString(username.getBytes(StandardCharsets.UTF_8));
            String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes(StandardCharsets.UTF_8));
            
            Cookie usernameCookie = new Cookie("savedUsername", URLEncoder.encode(encodedUsername, "UTF-8"));
            Cookie passwordCookie = new Cookie("savedPassword", URLEncoder.encode(encodedPassword, "UTF-8"));
            
            usernameCookie.setMaxAge(7 * 24 * 60 * 60);
            passwordCookie.setMaxAge(7 * 24 * 60 * 60);
            usernameCookie.setPath("/");
            passwordCookie.setPath("/");
            
            response.addCookie(usernameCookie);
            response.addCookie(passwordCookie);
        } else {
            Cookie usernameCookie = new Cookie("savedUsername", "");
            Cookie passwordCookie = new Cookie("savedPassword", "");
            usernameCookie.setMaxAge(0);
            passwordCookie.setMaxAge(0);
            usernameCookie.setPath("/");
            passwordCookie.setPath("/");
            response.addCookie(usernameCookie);
            response.addCookie(passwordCookie);
        }
        
        if ("on".equals(autoLogin)) {
            String token = Base64.getEncoder().encodeToString((username + ":" + password).getBytes(StandardCharsets.UTF_8));
            Cookie autoLoginCookie = new Cookie("autoLoginToken", URLEncoder.encode(token, "UTF-8"));
            autoLoginCookie.setMaxAge(7 * 24 * 60 * 60);
            autoLoginCookie.setPath("/");
            response.addCookie(autoLoginCookie);
        } else {
            Cookie autoLoginCookie = new Cookie("autoLoginToken", "");
            autoLoginCookie.setMaxAge(0);
            autoLoginCookie.setPath("/");
            response.addCookie(autoLoginCookie);
        }
        
        response.sendRedirect(request.getContextPath() + "/main");
    }
}
