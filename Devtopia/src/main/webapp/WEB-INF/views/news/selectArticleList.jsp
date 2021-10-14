<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Article List</title>
</head>
<body>
	<a href="goMain.do">[Main]</a><br>
	<c:forEach items="${ArticleList}" var="Article">
		postNo : ${Article.postNo} <br>
		writer : ${Article.writer} <br>
		title : ${Article.title} <br>
		content : ${Article.content} <br>
		writeDate : ${Article.writeDate} <br>
		viewCount : ${Article.viewCount} <br>
		imgLoc : ${Article.imgLoc } <br>
		<hr>
	</c:forEach>
</body>
</html>