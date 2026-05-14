package com.example.filter;

import com.example.dao.UserDao;
import com.example.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@WebFilter("/*")
public class AutoLoginFilter implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        HttpSession session = httpRequest.getSession(false);
        
        if (session != null && session.getAttribute("user") != null) {
            chain.doFilter(request, response);
            return;
        }
        
        Cookie[] cookies = httpRequest.getCookies();
        if (cookies != null) {
            String autoLoginToken = null;
            
            for (Cookie cookie : cookies) {
                if ("autoLoginToken".equals(cookie.getName())) {
                    autoLoginToken = cookie.getValue();
                    break;
                }
            }
            
            if (autoLoginToken != null && !autoLoginToken.isEmpty()) {
                try {
                    String decodedToken = URLDecoder.decode(autoLoginToken, "UTF-8");
                    String credentials = new String(Base64.getDecoder().decode(decodedToken), StandardCharsets.UTF_8);
                    
                    String[] parts = credentials.split(":");
                    if (parts.length == 2) {
                        String username = parts[0];
                        String password = parts[1];
                        
                        User user = UserDao.login(username, password);
                        if (user != null) {
                            session = httpRequest.getSession(true);
                            session.setAttribute("user", user);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        
        chain.doFilter(request, response);
    }
    
    @Override
    public void destroy() {
    }
}
