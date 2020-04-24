<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/4/22
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>添加用户界面</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/user/addUser" >
    用户名<input type="text" name="name">
    <br>
    密码<input type="password" name="password">
    <br>
    个人简介<input type="text" name="userdesc">
    <br>
    住址<input type="text" name="address">
    <br>
    电话号码<input type="text" name="phonenumber">
    <br>
    邮箱<input type="email" name="emailaddress">
    <br>
    爱好<br>
    <input type="checkbox" name="hobbys" value="听歌">听歌
    <input type="checkbox" name="hobbys" value="玩游戏">玩游戏
    <input type="checkbox" name="hobbys" value="看电视">看电视
    <input type="checkbox" name="hobbys" value="其他">其他
    <br>
    <button type="submit">提交</button>
</form>
<button onclick="location.href='${pageContext.request.contextPath}/views/main.jsp'">返回主界面</button>
</body>
</html>
