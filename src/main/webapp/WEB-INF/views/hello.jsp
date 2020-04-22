<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/3/4
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>hello</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>用户ID</th>
        <th>用户姓名</th>
        <th>数量</th>
        <th>用户密码</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${user}" var="user">
    <tr>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.number}</td>
        <td>${user.password}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
