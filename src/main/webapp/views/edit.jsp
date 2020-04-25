<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/4/25
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改信息界面</title>
    <script type="text/javascript" src="../static/js/jquery-3.3.1/jquery-3.3.1.js"></script>
    <script type="text/javascript">
        $(function () {
            //获取传入的所有的值
            var allBoxObj = $("#allhobbys").val();
            //拆分字符串
            var checkArray = allBoxObj.split(',');
            //获取所有复选框的值
            var checkBoxAll = $("input[name='hobbys']");
            for (var i = 0; i < checkArray.length; i++) {
                //获取所有复选框对象的value属性，然后，用checkArray[i]和他们匹配，如果有，则说明他应被选中
                $.each(checkBoxAll, function (j, checkbox) {
                    //获取复选框的value属性
                    var checkValue = $(checkbox).val();
                    if (checkArray[i] == checkValue) {
                        $(checkbox).attr("checked", true);
                    }
                })
            }
        })
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/update" method="post">
    <label>用户ID</label>
    <input name="id" value="${user.id}">
    <br>
    <label>用户姓名</label>
    <input name="name" value="${user.name}">
    <br>
    <label>用户密码</label>
    <input name="password" value="${user.password}">
    <br>
    <label>用户个人简介</label>
    <input name="userdesc" value="${user.userdesc}">
    <br>
    <label>用户地址</label>
    <input name="address" value="${user.address}">
    <br>
    <label>用户电话号码</label>
    <input name="phonenumber" value="${user.phonenumber}">
    <br>
    <label>用户邮箱</label>
    <input name="emailaddress" value="${user.emailaddress}">
    <br>
    <label>用户爱好</label>
    <input type="hidden" id="allhobbys" value="${user.hobbys}">
    <br>
    <input type="checkbox" name="hobbys" value="听歌">听歌
    <input type="checkbox" name="hobbys" value="玩游戏">玩游戏
    <input type="checkbox" name="hobbys" value="看电视">看电视
    <input type="checkbox" name="hobbys" value="其他">其他
    <br>
    <button id="update" type="submit">修改</button>
</form>
<button onclick="location.href='${pageContext.request.contextPath}/views/main.jsp'">返回主界面</button>
</body>
</html>
