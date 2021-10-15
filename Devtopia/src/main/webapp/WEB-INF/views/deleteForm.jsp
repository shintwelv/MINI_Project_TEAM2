<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 삭제</title>
</head>
<body>
	[최근 게시글 삭제]
	<form action="deleteAction.do" method="post">
		<p>
			제목: <br><input type="text" value="${article.ARTICLE_TITLE}">
		</p>
		<p>
			내용:<br>
			<textarea rows="5" cols="30">${article.ARTICLE_CONTENT}</textarea>
		</p>
		<input type="submit" value="게시글 삭제">
		<a href="goMain.do">[취소]</a>
	</form>
</body>
</html>