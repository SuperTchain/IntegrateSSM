<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/6/13
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查看评论界面</title>
    <script type="text/javascript" src="../../../static/js/jquery-3.3.1/jquery-3.3.1.js"></script>
    <%--在页面中引入CKEditor：--%>
    <script type="text/javascript" src="<%=request.getContextPath() %>/static/ckeditor/ckeditor.js"> </script>
</head>
<body>

<h2>我参与的评论</h2>
<%--遍历我参与的文章评论--%>
<c:forEach items="${myJoinComments}" var="myJoinComments">
    你在   ${myJoinComments.blog.blogTitle}  下的评论:
     ${myJoinComments.critics}在${myJoinComments.commentTimeToStr}评论：${myJoinComments.comment}
    <br>
</c:forEach>
<br>


<a href="/user/returnBlogAuthor">返回主界面</a>
</body>
</html>
