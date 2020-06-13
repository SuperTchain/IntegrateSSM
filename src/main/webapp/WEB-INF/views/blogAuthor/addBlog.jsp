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
    <script type="text/javascript" src="../../../static/js/jquery-3.3.1/jquery-3.3.1.js"></script>
    <%--在页面中引入CKEditor：--%>
    <script type="text/javascript" src="<%=request.getContextPath() %>/static/ckeditor/ckeditor.js"> </script>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/blog/addBlog" autocomplete="on" enctype="multipart/form-data">
    <input type="hidden" name="blogAuthor" value="${username}">
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
    <textarea id="blogContent" name="blogContent" rows="8" cols="30" class="ckeditor">开始编辑</textarea></td>
    <br>
    <label>是否原创</label>
    <br>
    原创<input type="radio" name="blogOrigin"  value="1">
    转载<input type="radio" name="blogOrigin"  value="0">
    <br>
    <button type="submit" id="bt1">提交</button>
</form>
<br>
<a href="/user/returnBlogAuthor">返回主界面</a>
</body>
</html>
