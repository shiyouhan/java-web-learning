<%--
  Created by IntelliJ IDEA.
  User: test
  Date: 2022/3/4
  Time: 8:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<h1>index动态页面</h1>


<h3>
    <%=request.getAttribute("msg")%>

</h3>
</body>
</html>
