<%--
  Created by IntelliJ IDEA.
  User: NEWSTART
  Date: 2019/3/4
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/UploadFiles" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/><br/>
    <input type="submit" name="Upload" value="上传"/>
</form>
下载资料:
<a href="DownloadFiles?name=1.docx">文档</a>
<a href="DownloadFiles?name=2.png">图片</a>
</body>
</body>
</html>
