<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/6/11
  Time: 15:48
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
<form method="post" action="" autocomplete="on" enctype="multipart/form-data">
    <label>博客标题:</label>
    <br>
    <input type="text" name="blogTitle" id="blogTitle" value="${Blog.blogTitle}" readonly="readonly">
    <br>
    <label>博客简介:</label>
    <br>
    <input type="text" name="blogDesc" id="blogDesc" value="${Blog.blogDesc}" readonly="readonly">
    <br>
    <label>博客内容:</label>
    <br>
    <textarea id="content" name="content" rows="8" cols="30" class="ckeditor" readonly="readonly">${Blog.blogContent}</textarea></td>
    <label>博客发布时间:</label>
    <br>
    <input type="text" name="blogPublishTime" id="blogPublisTime" value="${Blog.blogPublishTimeToStr}" readonly="readonly">
    <br>
    <label>博客是否原创:</label>
    <br>
    <input type="text" name="blogOrigin" id="blogOrigin" value="${Blog.blogOriginToStr}" readonly="readonly">
    <br>
    <label>博客作者:</label>
    <br>
    <input type="text" name="blogAuthor" id="blogAuthor" value="${Blog.blogAuthor}" readonly="readonly">
    <br>
</form>
<br>
<a href="/basic.jsp">返回游客界面</a>
</body>
</html>
