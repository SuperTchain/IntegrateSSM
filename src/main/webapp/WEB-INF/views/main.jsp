<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/4/22
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>主界面</title>
</head>
<body>
<img src="${userHead}" width="100px" height="100px">
<br>
<h2>欢迎你,${username}</h2>
<button onclick="location.href='${pageContext.request.contextPath}/user/findAll'">查看所有用户</button>
<button onclick="location.href='${pageContext.request.contextPath}/log/findAllLog'">查看所有日志</button>
<button onclick="location.href='${pageContext.request.contextPath}/blog/findAllLog'">查看所有博客</button>
<button onclick="location.href='${pageContext.request.contextPath}/logout'">退出</button>
<%--<form action="${pageContext.request.contextPath}/user/findAll" method="post">--%>
<%--    <input type="submit" value="查看所有用户">--%>
<%--</form>--%>
</body>
</html>
