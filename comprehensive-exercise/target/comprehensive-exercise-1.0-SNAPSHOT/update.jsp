<%@ page import="top.syhan.web.exercise.entity.Brand" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>修改品牌</title>
  <link href="style.css" rel="stylesheet">
</head>
<body>
<%
  Brand brand = (Brand) request.getAttribute("brand");
%>
<form action="${pageContext.request.contextPath}/updateBrand" method="post" class="bootstrap-frm">
  <h1>修改品牌
    <span>请输入修改内容！</span>
  </h1>
  <%--隐藏域，提交id--%>
  <input type="hidden" name="id" value="<%=brand.getId()%>">
  <label>
    <span>品牌名称:</span>
    <input type="text" name="brandName" value="<%=brand.getBrandName()%>" />
  </label>
  <label>
    <span>企业名称:</span>
    <input type="text" name="companyName" value="<%=brand.getCompanyName()%>" />
  </label>
  <label>
    <span>排序:</span>
    <input type="number" name="ordered" value="<%=brand.getOrdered()%>" />
  </label>
  <label>
    <span>描述信息:</span>
    <textarea rows="5" cols="20" name="description"><%=brand.getDescription()%></textarea>
  </label>
  <label>
    <span>状态:</span>
    <select name="status">
      <option value="0">禁用</option>
      <option value="1">启用</option>
    </select>
  </label>
  <label>
    <span>&nbsp;</span>
    <input type="submit" class="button" value="提交" />
  </label>
</form>
</body>
</html>