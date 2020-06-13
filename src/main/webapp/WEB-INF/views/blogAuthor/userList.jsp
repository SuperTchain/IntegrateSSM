<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/6/12
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>博主列表界面</title>
    <script type="text/javascript" src="../../../static/js/jquery-3.3.1/jquery-3.3.1.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/searchByBlogAuthor" method="post">
    <label>查询博主</label>
    <br>
    <input type="text" name="name" placeholder="请输入博主姓名">
    <br>
    <input type="text" name="phonenumber" placeholder="请输入博主电话">
    <input type="submit" value="查询">
</form>
<table>
    <thead>
    <tr>
        <th>用户姓名</th>
        <th>用户个人简介</th>
        <th>用户工作住址</th>
        <th>用户电话</th>
        <th>用户邮件</th>
        <th>用户爱好</th>
        <th>用户性别</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${list}" var="user">
        <tr>
            <td>${user.name}</td>
            <td>${user.userdesc}</td>
            <td>${user.addressesList.workaddress}</td>
            <td>${user.phonenumber}</td>
            <td>${user.emailaddress}</td>
            <td>${user.hobbys}</td>
            <td>${user.gender}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/user/returnBlogAuthor">返回主界面</a>
</body>
</html>
