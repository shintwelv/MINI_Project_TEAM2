<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PageNation</title>

<script>
	



</script>
</head>
<body>
	<a href="goMain.do">[Main]</a>
	<br>
	<c:forEach items="${ArticleList}" var="Article">
		postNo : ${Article.postNo} <br>
		writer : ${Article.writer} <br>
		title : ${Article.title} <br>
		content : ${Article.content} <br>
		writeDate : ${Article.writeDate} <br>
		viewCount : ${Article.viewCount} <br>
		<hr>
	</c:forEach>
	
	<a href="">[prev]</a>
	<a class="pageNum"></a>
	<a class="pageNum"></a>
	<a class="pageNum"></a>
	<a class="pageNum"></a>
	<a class="pageNum"></a>
	<a href="">[next]</a>
</body>
</html>