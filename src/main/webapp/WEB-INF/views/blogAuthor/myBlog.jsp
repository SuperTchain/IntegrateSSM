<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/6/13
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>我的博客界面</title>
    <script type="text/javascript" src="../../../static/js/jquery-3.3.1/jquery-3.3.1.js"></script>
</head>
<body>
<%--<a href="${pageContext.request.contextPath}/blog/viewOriginByBlogAuthor?id=${BlogList.id}">查看原创</a>--%>
<%--<a href="${pageContext.request.contextPath}/blog/viewCollectionByBlogAuthor?id=${BlogList.id}">查看收藏</a>--%>
<table>
    <thead>
    <tr>
        <th>博客标题</th>
        <th>博客简介</th>
        <th>博主名称</th>
        <th>博客发表时间</th>
        <th>博客是否原创</th>
        <th>博客作者</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${BlogList}" var="BlogList">
        <tr>
            <td>${BlogList.blogTitle}</td>
            <td>${BlogList.blogDesc}</td>
            <td>${BlogList.blogAuthor}</td>
            <td>${BlogList.blogPublishTimeToStr}</td>
            <td>${BlogList.blogOriginToStr}</td>
            <td>${BlogList.blogAuthor}</td>
            <td><a href="${pageContext.request.contextPath}/blog/viewByBlogAuthor?id=${BlogList.id}">查看内容</a></td>
            <td><a href="${pageContext.request.contextPath}/blog/toEditByBlogAuthor?id=${BlogList.id}">编辑博客</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="/user/returnBlogAuthor">返回主界面</a>
</body>
</html>
