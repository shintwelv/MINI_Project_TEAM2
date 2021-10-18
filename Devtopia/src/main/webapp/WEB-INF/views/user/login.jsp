<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<script src="resources/jQuery/jquery-3.4.1.min.js"></script>
</head>
<body>
	<h1>로그인 페이지</h1>
	<hr />
		<c:choose>
			<c:when test="${empty sessionScope.userId}">
			<!-- 로그인이 안되어 있으면 -->
				<form action="loginCheck.do" method="post">
					<table>
						<tr>
							<td>아이디</td>
							<td><input type="text" name="userId"></td>
						</tr>
						<tr>
							<td>패스워드</td>
							<td><input type="text" name="userPw"></td>
							<td><input type="submit" value="로그인"></td>
						</tr>
						
					</table>
				</form>
			</c:when>
			<c:otherwise>
				<h3>${sessionScope.userId}님 환영합니다.</h3>
				<a href="logout">로그아웃</a>
			</c:otherwise>
		</c:choose>

</html>