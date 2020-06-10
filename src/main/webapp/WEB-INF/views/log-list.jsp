<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/6/10
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>日志列表界面</title>
    <script type="text/javascript" src="../../static/js/jquery-3.3.1/jquery-3.3.1.js"></script>
    <script type="text/javascript">
        function changePageSize() {
            //获取下拉框的值
            var pageSize = $("#changePageSize").val();

            //向服务器发送请求，改变没页显示条数
            location.href = "${pageContext.request.contextPath}/user/findAll?page=1&size="
                + pageSize;
        }
    </script>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>日志ID</th>
        <th>用户姓名</th>
        <th>用户操作</th>
        <th>操作地址</th>
        <th>操作时间</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${allLogByPage}" var="allLogByPage">
        <tr>
            <td>${allLogByPage.id}</td>
            <td>${allLogByPage.userName}</td>
            <td>${allLogByPage.operation}</td>
            <td>${allLogByPage.operationUrl}</td>
            <td>${allLogByPage.operationTimeToStr}</td>
            <td><a href="${pageContext.request.contextPath}/log/deleteById?id=${allLogByPage.id}">删除</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/user/returnMain">返回主界面</a>
</body>
</html>