<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify Article</title>
</head>
<body>
	modify Article
	<br>
	<form action="modifyArticleAction.do" method="post">
		<%-- writer: <br>
		<input type="text" name="writer" value="${Article.writer }"> <br> --%>
		title: <br>
		<input type="text" name="title" value="${Article.title }"> <br>
		content: <br>
		<input type="text" name="content" value="${Article.content }"> <br>
		<br>
		<input type="submit" value="작성">
	</form> <br>
	<a href="goMain.do">[Main]</a>
</body>
</html>