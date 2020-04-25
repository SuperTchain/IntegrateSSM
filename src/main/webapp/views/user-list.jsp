<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/3/4
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户列表界面t</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>用户ID</th>
        <th>用户姓名</th>
        <th>用户密码</th>
        <th>用户个人简介</th>
        <th>用户住址</th>
        <th>用户电话</th>
        <th>用户邮件</th>
        <th>用户爱好</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${user}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.password}</td>
            <td>${user.userdesc}</td>
            <td>${user.address}</td>
            <td>${user.phonenumber}</td>
            <td>${user.emailaddress}</td>
            <td>${user.hobbys}</td>
            <td><a href="${pageContext.request.contextPath}/user/edit?id=${user.id}">修改</a></td>
            <td><a href="${pageContext.request.contextPath}/user/delete?id=${user.id}">删除</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<button onclick="location.href='${pageContext.request.contextPath}/views/addUser.jsp'">添加用户</button>
<button onclick="location.href='${pageContext.request.contextPath}/views/main.jsp'">返回主界面</button>

</body>
</html>
