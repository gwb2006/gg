<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.entity.User" %>
<%
    User user = (User) session.getAttribute("user");
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>查看课表</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
    <div class="main-container">
        <div class="header">
            <h1>学生信息管理系统</h1>
            <div class="user-info">
                <span>欢迎您，<%= user.getNickname() %>（<%= user.getUsername() %>）</span>
                <a href="<%=request.getContextPath()%>/logout" class="logout-btn">退出登录</a>
            </div>
        </div>
        
        <div class="content">
            <div class="page-title">
                <h2>📅 本学期课表</h2>
                <a href="<%=request.getContextPath()%>/main" class="back-link">返回主页</a>
            </div>
            
            <table class="schedule-table">
                <thead>
                    <tr>
                        <th>节次/星期</th>
                        <th>星期一</th>
                        <th>星期二</th>
                        <th>星期三</th>
                        <th>星期四</th>
                        <th>星期五</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td class="period">第1-2节<br>8:00-9:40</td>
                        <td class="course">高等数学</td>
                        <td></td>
                        <td class="course">高等数学</td>
                        <td></td>
                        <td class="course">线性代数</td>
                    </tr>
                    <tr>
                        <td class="period">第3-4节<br>10:00-11:40</td>
                        <td class="course">Java程序设计</td>
                        <td class="course">大学英语</td>
                        <td></td>
                        <td class="course">Java程序设计</td>
                        <td class="course">大学英语</td>
                    </tr>
                    <tr>
                        <td class="period">第5-6节<br>14:00-15:40</td>
                        <td></td>
                        <td class="course">数据结构</td>
                        <td class="course">计算机网络</td>
                        <td class="course">数据结构</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td class="period">第7-8节<br>16:00-17:40</td>
                        <td class="course">体育</td>
                        <td></td>
                        <td class="course">操作系统</td>
                        <td></td>
                        <td class="course">操作系统</td>
                    </tr>
                    <tr>
                        <td class="period">第9-10节<br>19:00-20:40</td>
                        <td></td>
                        <td class="course">选修课</td>
                        <td></td>
                        <td class="course">选修课</td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
        </div>
        
        <div class="footer">
            <p>JavaEE Web项目 - Servlet + JSP + Session + Cookie + Filter</p>
        </div>
    </div>
</body>
</html>
