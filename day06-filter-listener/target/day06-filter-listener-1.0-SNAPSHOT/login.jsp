<%@ page import="jakarta.servlet.http.HttpSession" %><%--
  Created by IntelliJ IDEA.
  User: test
  Date: 2022/3/4
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<h2>登录页面，可以显示过滤器转发过来的"用户未登录"的提示信息</h2>
<%
    String msg = (String) request.getAttribute("msg");
%>
<h3>
    ${msg}
</h3>
</body>
</html>