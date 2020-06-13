<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/6/13
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>博主修改博客界面</title>
    <script type="text/javascript" src="../../../static/js/jquery-3.3.1/jquery-3.3.1.js"></script>
    <%--在页面中引入CKEditor：--%>
    <script type="text/javascript" src="<%=request.getContextPath() %>/static/ckeditor/ckeditor.js"> </script>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/blog/updateBlog" autocomplete="on" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${Blog.id}" >
    <label>博客标题:</label>
    <br>
    <input type="text" name="blogTitle" id="blogTitle" value="${Blog.blogTitle}" >
    <br>
    <label>博客简介:</label>
    <br>
    <input type="text" name="blogDesc" id="blogDesc" value="${Blog.blogDesc}" >
    <br>
    <label>博客内容:</label>
    <br>
    <textarea id="blogContent" name="blogContent" rows="8" cols="30" class="ckeditor" >${Blog.blogContent}</textarea></td>
    <label>博客发布时间:</label>
    <br>
    <input type="text" name="blogPublishTimeToStr" id="blogPublisTime" value="${Blog.blogPublishTimeToStr}" readonly="readonly">
    <br>
    <label>博客是否原创:</label>
    <br>
    <input type="text" name="blogOriginToStr" id="blogOrigin" value="${Blog.blogOriginToStr}" readonly="readonly">
    <br>
    <label>博客作者:</label>
    <br>
    <input type="text" name="blogAuthor" id="blogAuthor" value="${Blog.blogAuthor}" readonly="readonly">
    <br>
    <input type="submit" value="修改">
</form>
<br>
<a href="/user/returnBlogAuthor">返回主界面</a>
</body>
</html>
