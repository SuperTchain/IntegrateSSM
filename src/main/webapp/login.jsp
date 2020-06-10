<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/4/22
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录</title>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/js/jquery-3.3.1/jquery-3.3.1.js"></script>
    <script type="text/javascript">
        $(function () {
            //获取提交按钮
            $("#bt1").click(function () {
                //判断用户名是否合法
                var uname = $("#uname").val();
                //校验规则 字母数字下划线
                var obj = /^\w{5,12}$/;
                //进行比较
                if (!obj.test(uname)) {
                    //获取提示标签
                    $("#errorMsg").text("用户名不合法").css("backgroundColor", "red");
                    return false;
                }

                //判断密码是否合法
                //判断用户名是否合法
                var upassword = $("#upassword").val();
                //校验规则 字母数字下划线
                var obj = /^\w{5,12}$/;
                //进行比较
                if (!obj.test(upassword)) {
                    //获取提示标签
                    $("#errorMsg").text("密码不合法").css("backgroundColor", "red");
                    return false;
                }

                //清除错误信息
                $("#errorMsg").text("");
            })
        })
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post" autocomplete="off">
    <label>用户名:</label>
    <input type="text" name="username" id="uname"><span id="errorMsg"></span>
    <br>
    <label>密码:</label>
    <input type="password" name="password" id="upassword">
    <br>
    <button type="submit" id="bt1">登录</button>
</form>
<br>
<span>
        <a href="/register">注册</a>
        <a>忘记密码？</a>
    </span>
</body>
</html>
