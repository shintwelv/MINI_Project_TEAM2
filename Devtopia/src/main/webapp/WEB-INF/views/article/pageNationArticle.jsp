<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Pagenation test</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
.paginationNum, .paginationArrow {
	list-style-type: none;
	float: left;
	margin-left: 5px;
}

table {
	width: 100%;
	text-align: center;
}
</style>
<c:set var="totalPage" value="${totalPage}"/>
<c:set var="startPoint" value="${startPoint }"/>
<c:set var="endPoint" value="${endPoint }"/>
</head>

<body>
	<a href="goMain.do">[Main]</a>
	<hr>
	<table>
		<tr>
			<th>POSTNO</th>
			<th>WRITER</th>
			<th>TITLE</th>
			<th>CONTENT</th>
			<th>WRITEDATE</th>
			<th>VIEWCOUNT</th>
		</tr>
		<c:forEach items="${ArticleList }" var="Article">
			<tr>
				<td>${Article.postNo}</td>
				<td>${Article.writer}</td>
				<td>${Article.title}</td>
				<td>${Article.content}</td>
				<td>${Article.writeDate}</td>
				<td>${Article.viewCount}</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<ul class="pagination">
		<li class="paginationArrow">
			<a href="pageNationArticleAction.do?arrowDirection=left" aria-label="Previous">
				<span aria-hidden="true">&laquo;</span>
			</a>
		</li>
		<c:forEach begin="${startPoint }" end="${endPoint }" var="pageNum">
			<li class="paginationNum"><a href="pageNationArticleAction.do?pageNum=${pageNum }">[${pageNum }]</a></li>
		</c:forEach>
		<li class="paginationArrow">
			<a href="pageNationArticleAction.do?arrowDirection=right" aria-label="Next"> 
				<span aria-hidden="true">&raquo;</span>
			</a>
		</li>
	</ul>
</body>

</html>