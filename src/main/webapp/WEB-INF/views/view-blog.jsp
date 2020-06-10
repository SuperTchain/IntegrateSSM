<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/6/10
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>博客详细界面</title>
    <script type="text/javascript" src="../../static/js/jquery-3.3.1/jquery-3.3.1.js"></script>
    <%--在页面中引入CKEditor：--%>
    <script type="text/javascript" src="<%=request.getContextPath() %>/static/ckeditor/ckeditor.js"> </script>
<%--    <script type="text/javascript">--%>
<%--        var editor = null;--%>
<%--        window.onload = function(){--%>
<%--            //参数‘content’是textarea元素的name属性值，而非id属性值--%>
<%--            editor = CKEDITOR.replace('content');--%>
<%--            editor.setData('这里是需要传递给CKEditor编辑器实例的值');--%>
<%--            editor.getData();--%>
<%--            editor.updateElement(); //非常重要的一句代码--%>
<%--        }--%>
<%--    </script>--%>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/blog/addBlog" autocomplete="on" enctype="multipart/form-data">
    <label>博客标题:</label>
    <br>
    <input type="text" name="blogTitle" id="blogTitle">
    <br>
    <label>博客简介:</label>
    <br>
    <input type="text" name="blogDesc" id="blogDesc">
    <br>
    <label>博客内容:</label>
    <br>
    <textarea id="content" name="content" rows="8" cols="30" class="ckeditor">开始编辑</textarea></td>
    <button type="submit" id="bt1">提交</button>
</form>

</body>
</html>
