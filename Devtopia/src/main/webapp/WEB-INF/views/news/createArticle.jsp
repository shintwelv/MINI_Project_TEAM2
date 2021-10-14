<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>create Article</title>
</head>
<body>
	create Article
	<br>
	<form action="createArticleAction.do" method="post" enctype="multipart/form-data">
		<!-- writer: <br>
		<input type="text" name="writer" value="writer area"> <br> -->
		title: <br>
		<input type="text" name="title" value="title area"> <br>
		content: <br>
		<input type="text" name="content" value="content area"> <br>
		<br>
		<input type="file" name="imgLoc">
		<br>
		<input type="submit" value="작성">
	</form><br>
	<a href="goMain.do">[Main]</a>
</body>
</html>