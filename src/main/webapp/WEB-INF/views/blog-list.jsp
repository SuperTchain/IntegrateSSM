<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/6/10
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>博客列表界面</title>
    <script type="text/javascript" src="../../static/js/jquery-3.3.1/jquery-3.3.1.js"></script>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>博客ID</th>
        <th>博客标题</th>
        <th>博客简介</th>
        <th>博主名称</th>
        <th>博客发表时间</th>
        <th>博客是否原创</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${pageInfo.list}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.password}</td>
            <td>${user.userdesc}</td>
            <td>${user.registdateToStr}</td>
            <td>${user.addressesList.homeaddress}</td>
            <td>${user.addressesList.workaddress}</td>
            <td>${user.phonenumber}</td>
            <td>${user.emailaddress}</td>
            <td>${user.hobbys}</td>
            <td>${user.gender}</td>
            <td><a href="${pageContext.request.contextPath}/blog/view?id=${user.id}">查看</a></td>
            <td><a href="${pageContext.request.contextPath}/blog/edit?id=${user.id}">修改</a></td>
            <td><a href="${pageContext.request.contextPath}/blog/delete?id=${user.id}">删除</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="${pageContext.request.contextPath}/blog/view">查看</a>
<a href="/user/returnMain">返回主界面</a>
</body>
</html>
