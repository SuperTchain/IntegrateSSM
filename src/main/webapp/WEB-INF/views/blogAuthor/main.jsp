<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/6/12
  Time: 9:52
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
    <title>博主界面</title>
</head>
<body>
<img src="${userHead}" width="100px" height="100px">
<br>
<h2>亲爱的 ${username} :</h2>
<h2>欢迎来到博主界面</h2>
<br>
<h2>在此界面你可以：</h2>
<button onclick="location.href='${pageContext.request.contextPath}/user/findAllByBlogAuthor'">查看博主</button>
<button onclick="location.href='${pageContext.request.contextPath}/blog/toAddBlog'">写博客</button>
<button onclick="location.href='${pageContext.request.contextPath}/blog/findAllBlogByBlogAuthor'">查看博客</button>
<button onclick="location.href='${pageContext.request.contextPath}/blog/toMyBlog'">我的博客</button>
<button onclick="location.href='${pageContext.request.contextPath}/comments/toMyComments'">参与的评论</button>
<button onclick="location.href='${pageContext.request.contextPath}/logout'">退出</button>
<%--<form action="${pageContext.request.contextPath}/user/findAll" method="post">--%>
<%--    <input type="submit" value="查看所有用户">--%>
<%--</form>--%>
</body>
</html>

