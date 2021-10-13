<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>select Article</title>
</head>
<body>
	select Article <br>
	postNo : ${Article.postNo} <br>
	writer : ${Article.writer} <br>
	title : ${Article.title} <br>
	content : ${Article.content} <br>
	writeDate : ${Article.writeDate} <br>
	viewCount : ${Article.viewCount} <br>
	<a href="goMain.do">[Main]</a>
</body>
</html>