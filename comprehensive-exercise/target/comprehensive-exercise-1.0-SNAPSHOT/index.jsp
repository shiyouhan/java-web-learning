<%@ page import="top.syhan.web.exercise.entity.Brand" %>
<%@ page import="java.util.List" %>
<%@ page import="top.syhan.web.exercise.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>品牌主页</title>
    <link href="style.css" rel="stylesheet">
</head>
<body>
<%
    User user = (User) request.getSession().getAttribute("user");
    if(user == null) {
        {%><h1>未登录！</h1>3秒后跳转到登录页面
        <p>如果没有跳转，请点<a href="login.html">这里</a></p>
        <%
        response.setHeader("refresh", "3;URL=login.html");
        return;
        }
    }
    List<Brand> brands = (List<Brand>) request.getAttribute("brands");
%>
<div class="bootstrap-frm" style="max-width: none;">
    <h1><%=user.getUsername()%>
        <span>欢迎您！</span>
    </h1>
    <input type="button" class="button" value="新增" id="add" style="margin-bottom: 20px">
    <table class="pure-table">
        <tr style="border:1px solid #ccc;">
            <th>序号</th>
            <th>品牌名称</th>
            <th>企业名称</th>
            <th>排序</th>
            <th>品牌介绍</th>
            <th>状态</th>
            <th>操作</th>
        </tr>

        <%
            for (Brand brand : brands) {
        %>
        <tr style="border:1px solid #ccc;">
            <td><%=brand.getId()%>
            </td>
            <td><%=brand.getBrandName()%>
            </td>
            <td><%=brand.getCompanyName()%>
            </td>
            <td><%=brand.getOrdered()%>
            </td>
            <td><%=brand.getDescription()%>
            </td>
            <td><%=brand.getStatus()%>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/selectById?id=<%=brand.getId()%>">修改</a>
                <a href="${pageContext.request.contextPath}/deleteById?id=<%=brand.getId()%>">删除</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</div>
<script>
    document.getElementById("add").onclick = function () {
        location.href = "/addBrand.jsp";
    }
</script>
</body>
</html>