<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/6/11
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>游客查看博客列表界面</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.3.1/jquery-3.3.1.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/blog/tSearch" method="post">
    <label>查询博客</label>
    <br>
    <input type="text" name="blogTitle" placeholder="请输入博客标题">
    <br>
    <input type="text" name="blogAuthor" placeholder="请输入博主名称">
    <input type="submit" value="查询">
</form>
<table>
    <thead>
    <tr>
        <th>博客标题</th>
        <th>博客简介</th>
        <th>博主名称</th>
        <th>博客内容</th>
        <th>博客发表时间</th>
        <th>博客是否原创</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${BlogList}" var="BlogList">
        <tr>
            <td>${BlogList.blogTitle}</td>
            <td>${BlogList.blogDesc}</td>
            <td>${BlogList.blogAuthor}</td>
            <td>${BlogList.blogContent}</td>
            <td>${BlogList.blogPublishTimeToStr}</td>
            <td>${BlogList.blogOriginToStr}</td>
            <td><a href="${pageContext.request.contextPath}/blog/tView?id=${BlogList.id}">查看</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="/basic.jsp">返回游客界面</a>
</body>
</html>
