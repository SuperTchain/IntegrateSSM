<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/6/12
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>博主查看博客界面</title>
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
<%--添加评论--%>
<form action="${pageContext.request.contextPath}/comments/addComment" method="post">
    <input type="hidden" name="critics" value="${username}">
    <input type="hidden" name="commentArticle" value="${Blog.id}">
    <textarea name="comment"></textarea>
    <input type="submit" value="评论">
</form>

<%--遍历该文章评论--%>
<c:forEach items="${comments}" var="comments">
     ${comments.critics}在${comments.commentTimeToStr}评论了你的文章：${comments.comment}
    <br>
</c:forEach>
<br>
<a href="/user/returnBlogAuthor">返回主界面</a>
</body>
</html>
