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
	
			계정을 삭제하시겠습니까?
		<input type="submit" value="삭제">
		<a href="goMain.do">[취소]</a>
	</form>
</body>
</html>