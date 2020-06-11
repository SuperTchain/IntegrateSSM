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
    <label>用户描述:</label>
    <br>
    <input type="text" name="userdesc" >
    <br>
    <label>电话号码:</label>
    <br>
    <input type="text" name="phonenumber" >
    <br>
    <label>爱好</label>
    <br>
    <input type="checkbox" name="hobbys" value="听歌">听歌
    <input type="checkbox" name="hobbys" value="玩游戏">玩游戏
    <input type="checkbox" name="hobbys" value="看电视">看电视
    <input type="checkbox" name="hobbys" value="其他">其他
    <br>
    <label>性别</label>
    <br>
    <input type="radio" value="男" name="gender">男
    <input type="radio" value="女" name="gender">女
    <br>
    <label>邮箱:</label>
    <br>
    <input type="email" name="emailaddress" id="email">
    <br>
    <label>用户居住地址</label>
    <input name="addressesList.homeaddress" >
    <br>
    <label>用户工作地址</label>
    <input name="addressesList.workaddress" >
    <br>
    <label>添加头像:</label><input type="file" name="file">
    <br>
    <button type="submit" id="bt1">注册</button>
</form>
<a href="/basic.jsp">返回游客界面</a>
</body>
</html>
