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
    <title>用户列表界面</title>
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
        <th>用户ID</th>
        <th>用户姓名</th>
        <th>用户密码</th>
        <th>用户个人简介</th>
        <th>用户注册时间</th>
        <th>用户住址</th>
        <th>用户电话</th>
        <th>用户邮件</th>
        <th>用户爱好</th>
        <th>用户性别</th>
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
            <td>${user.address}</td>
            <td>${user.phonenumber}</td>
            <td>${user.emailaddress}</td>
            <td>${user.hobbys}</td>
            <td>${user.gender}</td>
            <td><a href="${pageContext.request.contextPath}/user/edit?id=${user.id}">修改</a></td>
            <td><a href="${pageContext.request.contextPath}/user/delete?id=${user.id}">删除</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div>
    总共${pageInfo.pages} 页，共${pageInfo.total}条数据。
    <select id="changePageSize" onchange="changePageSize()">
        <option>请选择每页显示页数</option>
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
    </select> 条
</div>

<div>
    <span>
        <a href="${pageContext.request.contextPath}/user/findAll?page=1&size=${pageInfo.pageSize}"
           aria-label="Previous">首页</a></li>
        <a href="${pageContext.request.contextPath}/user/findAll?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}">上一页</a>
    <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum" >
        <a href="${pageContext.request.contextPath}/user/findAll?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a>
    </c:forEach>
    <a href="${pageContext.request.contextPath}/user/findAll?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}">下一页</a>
    <a href="${pageContext.request.contextPath}/user/findAll?page=${pageInfo.pages}&size=${pageInfo.pageSize}"
       aria-label="Next">尾页</a>
    </span>
</div>
<button onclick="location.href='${pageContext.request.contextPath}/user/addUser'">添加用户</button>
</body>
</html>
