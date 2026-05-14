<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<%@ page import="java.util.Base64" %>
<%
    String savedUsername = "";
    String savedPassword = "";
    boolean rememberMeChecked = false;
    boolean autoLoginChecked = false;
    
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("savedUsername".equals(cookie.getName())) {
                try {
                    String encoded = URLDecoder.decode(cookie.getValue(), "UTF-8");
                    savedUsername = new String(Base64.getDecoder().decode(encoded), StandardCharsets.UTF_8);
                    rememberMeChecked = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if ("savedPassword".equals(cookie.getName())) {
                try {
                    String encoded = URLDecoder.decode(cookie.getValue(), "UTF-8");
                    savedPassword = new String(Base64.getDecoder().decode(encoded), StandardCharsets.UTF_8);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if ("autoLoginToken".equals(cookie.getName()) && cookie.getValue() != null && !cookie.getValue().isEmpty()) {
                autoLoginChecked = true;
            }
        }
    }
    
    String error = (String) request.getAttribute("error");
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户登录</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
    <div class="login-container">
        <div class="login-box">
            <h2>用户登录</h2>
            <% if (error != null && !error.isEmpty()) { %>
                <div class="error-message"><%= error %></div>
            <% } %>
            <form action="<%=request.getContextPath()%>/login" method="post">
                <div class="form-group">
                    <label for="username">用户名</label>
                    <input type="text" id="username" name="username" value="<%= savedUsername %>" required>
                </div>
                <div class="form-group">
                    <label for="password">密码</label>
                    <input type="password" id="password" name="password" value="<%= savedPassword %>" required>
                </div>
                <div class="form-group captcha-group">
                    <label for="captcha">验证码</label>
                    <div class="captcha-wrapper">
                        <input type="text" id="captcha" name="captcha" required>
                        <img id="captchaImg" src="<%=request.getContextPath()%>/captcha" alt="验证码" onclick="refreshCaptcha()" title="点击刷新">
                    </div>
                </div>
                <div class="form-group checkbox-group">
                    <label class="checkbox-label">
                        <input type="checkbox" name="rememberMe" <%= rememberMeChecked ? "checked" : "" %>>
                        记住登录信息
                    </label>
                </div>
                <div class="form-group checkbox-group">
                    <label class="checkbox-label">
                        <input type="checkbox" name="autoLogin" <%= autoLoginChecked ? "checked" : "" %>>
                        自动登录
                    </label>
                </div>
                <button type="submit" class="login-btn">登 录</button>
            </form>
        </div>
    </div>
    <script>
        function refreshCaptcha() {
            var img = document.getElementById('captchaImg');
            img.src = '<%=request.getContextPath()%>/captcha?t=' + new Date().getTime();
        }
    </script>
</body>
</html>
