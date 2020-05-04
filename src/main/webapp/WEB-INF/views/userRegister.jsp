<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/5/3
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>注册界面</title>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/js/jquery-3.3.1/jquery-3.3.1.js"></script>
    <script type="text/javascript">
        $(function () {
            //获取提交按钮
            $("#bt1").click(function () {
                //判断用户名是否合法
                var registerName = $("#registerName").val();
                //校验规则 字母数字下划线
                var obj = /^\w{5,12}$/;
                //进行比较
                if (!obj.test(registerName)) {
                    //获取提示标签
                    $("#errorMsg").text("用户名不合法").css("backgroundColor", "red");
                    return false;
                }

                //判断密码是否合法
                //判断用户名是否合法
                var registerPassword = $("#registerPassword").val();
                //校验规则 字母数字下划线
                var obj = /^\w{5,12}$/;
                //进行比较
                if (!obj.test(registerPassword)) {
                    //获取提示标签
                    $("#errorMsg").text("密码不合法").css("backgroundColor", "red");
                    return false;
                }

                //判断两次输入的密码是否一致
                var registerPassword2 = $("#registerPassword2").val();
                if (registerPassword != registerPassword2) {
                    //获取提示标签
                    $("#errorMsg").text("两次输入的密码不一致").css("backgroundColor", "red");
                    return false;
                }

                //判断邮箱是否为空
                var reg = /[A-z]+[A-z0-9_-]*\@[A-z0-9]+\.[A-z]+\S/;
                var email = $("#email").val();
                if (!reg.test(email)) {
                    $("#errorMsg").text("邮箱不合法").css("backgroundColor", "red");
                    return false;
                }

                //清除错误信息
                $("#errorMsg").text("");
            })
        })
    </script>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/user/register" autocomplete="on" enctype="multipart/form-data">
    <label>用户名:</label>
    <br>
    <input type="text" name="name" id="registerName"><span id="errorMsg"></span>
    <br>
    <label>密码:</label>
    <br>
    <input type="password" name="password" id="registerPassword">
    <br>
    <label>确认密码:</label>
    <br>
    <input type="password" name="password2" id="registerPassword2">
    <br>
    <label>邮箱:</label>
    <br>
    <input type="email" name="emailaddress" id="email">
    <br>
    <label>添加头像:</label><input type="file" name="file">
    <br>
    <button type="submit" id="bt1">注册</button>
</form>
<a href="/user/returnMain">返回主界面</a>
</body>
</html>
