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
    <title>查看成绩</title>
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
                <h2>📊 成绩查询</h2>
                <a href="<%=request.getContextPath()%>/main" class="back-link">返回主页</a>
            </div>
            
            <table class="grade-table">
                <thead>
                    <tr>
                        <th>课程名称</th>
                        <th>课程类型</th>
                        <th>学分</th>
                        <th>成绩</th>
                        <th>绩点</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>高等数学</td>
                        <td>必修</td>
                        <td>4.0</td>
                        <td class="grade-85">85</td>
                        <td>3.5</td>
                    </tr>
                    <tr>
                        <td>Java程序设计</td>
                        <td>必修</td>
                        <td>3.0</td>
                        <td class="grade-90">92</td>
                        <td>4.0</td>
                    </tr>
                    <tr>
                        <td>数据结构</td>
                        <td>必修</td>
                        <td>3.0</td>
                        <td class="grade-85">88</td>
                        <td>3.7</td>
                    </tr>
                    <tr>
                        <td>计算机网络</td>
                        <td>必修</td>
                        <td>3.0</td>
                        <td class="grade-85">82</td>
                        <td>3.3</td>
                    </tr>
                    <tr>
                        <td>操作系统</td>
                        <td>必修</td>
                        <td>3.0</td>
                        <td class="grade-90">90</td>
                        <td>4.0</td>
                    </tr>
                    <tr>
                        <td>线性代数</td>
                        <td>必修</td>
                        <td>3.0</td>
                        <td class="grade-85">86</td>
                        <td>3.6</td>
                    </tr>
                    <tr>
                        <td>大学英语</td>
                        <td>必修</td>
                        <td>2.0</td>
                        <td class="grade-85">78</td>
                        <td>2.8</td>
                    </tr>
                    <tr>
                        <td>体育</td>
                        <td>必修</td>
                        <td>1.0</td>
                        <td class="grade-90">95</td>
                        <td>4.0</td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="2"><strong>平均绩点</strong></td>
                        <td><strong>19.0</strong></td>
                        <td colspan="2"><strong>3.56</strong></td>
                    </tr>
                </tfoot>
            </table>
        </div>
        
        <div class="footer">
            <p>JavaEE Web项目 - Servlet + JSP + Session + Cookie + Filter</p>
        </div>
    </div>
</body>
</html>
