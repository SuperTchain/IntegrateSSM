<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/6/11
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>游客界面</title>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/js/jquery-3.3.1/jquery-3.3.1.js"></script>
</head>
<body>
<h2>欢迎来到游客界面:</h2>
<h2>在此界面你可以：</h2>
<br>
<button onclick="location.href='${pageContext.request.contextPath}/blog/tFindAllBlog'">浏览博文</button>
<button onclick="location.href='${pageContext.request.contextPath}/user/tFindAll'">查看博主</button>
<br>
<span>
        <a href="/userRegister.jsp">点此注册账号</a>
        <a href="/login.jsp">点我登录</a>

    </span>
</body>
</html>
