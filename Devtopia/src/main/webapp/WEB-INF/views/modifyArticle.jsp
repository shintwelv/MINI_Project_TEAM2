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
	<form action="modifyArticleAction.do">
		<input type="text" name="writer" value="${writer }">
		<input type="text" name="title" value="${title }">
		<input type="text" name="content" value="${content }">
	</form>
</body>
</html>