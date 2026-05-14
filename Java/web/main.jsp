<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.entity.User" %>
<%
    User user = (User) session.getAttribute("user");
    boolean isLoggedIn = (user != null);
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>主页</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
    <div class="main-container">
        <div class="header">
            <h1>学生信息管理系统</h1>
            <div class="user-info">
                <% if (isLoggedIn) { %>
                    <span>欢迎您，<%= user.getNickname() %>（<%= user.getUsername() %>）</span>
                    <a href="<%=request.getContextPath()%>/logout" class="logout-btn">退出登录</a>
                <% } else { %>
                    <span>您尚未登录</span>
                    <a href="<%=request.getContextPath()%>/login" class="login-btn">登录</a>
                <% } %>
            </div>
        </div>
        
        <div class="content">
            <div class="welcome-section">
                <h2>欢迎使用学生信息管理系统</h2>
                <p>本系统提供以下功能：</p>
            </div>
            
            <div class="menu-section">
                <div class="menu-item">
                    <div class="menu-icon">📅</div>
                    <h3>查看课表</h3>
                    <p>查看本学期课程安排</p>
                    <% if (isLoggedIn) { %>
                        <a href="<%=request.getContextPath()%>/schedule.jsp" class="menu-link">进入</a>
                    <% } else { %>
                        <span class="menu-link disabled">请先登录</span>
                    <% } %>
                </div>
                
                <div class="menu-item">
                    <div class="menu-icon">📊</div>
                    <h3>查看成绩</h3>
                    <p>查看考试成绩信息</p>
                    <% if (isLoggedIn) { %>
                        <a href="<%=request.getContextPath()%>/grade.jsp" class="menu-link">进入</a>
                    <% } else { %>
                        <span class="menu-link disabled">请先登录</span>
                    <% } %>
                </div>
            </div>
        </div>
        
        <div class="footer">
            <p>JavaEE Web项目 - Servlet + JSP + Session + Cookie + Filter</p>
        </div>
    </div>
</body>
</html>
