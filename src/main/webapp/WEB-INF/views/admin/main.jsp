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
    <title>管理员界面</title>
</head>
<body>
<img src="${userHead}" width="100px" height="100px">
<br>
<h2>亲爱的 ${username} :</h2>
<h2>欢迎来到主界面</h2>
<br>
<h2>在此界面你可以：</h2>
<button onclick="location.href='${pageContext.request.contextPath}/user/findAll'">查看博主</button>
<button onclick="location.href='${pageContext.request.contextPath}/log/findAllLog'">查看日志</button>
<button onclick="location.href='${pageContext.request.contextPath}/blog/findAllBlog'">查看博客</button>
<button onclick="location.href='${pageContext.request.contextPath}/logout'">退出</button>
<%--<form action="${pageContext.request.contextPath}/user/findAll" method="post">--%>
<%--    <input type="submit" value="查看所有用户">--%>
<%--</form>--%>
</body>
</html>
