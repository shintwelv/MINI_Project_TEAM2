<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/jQuery/jquery-3.4.1.min.js"></script>
</head>
<body>
	<a href="article/goMain.do">article</a> <br>
	<a href="free/goMain.do">board_free</a> <br>
	<a href="job/goMain.do">board_job</a> <br>
	<a href="news/goMain.do">board_news</a> <br>
	<a href="qna/goMain.do">board_qna</a> <br>
	<a href="tip/goMain.do">board_tip</a> <br>
	<a href="../user/goMain.do">user</a> <br>
	
	<c:choose>
			<c:when test="${empty sessionScope.userId}">
			<!-- 로그인이 안되어 있으면 -->
				<form action="user/loginCheck.do" method="post">
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
							<a href="user/write.do">[회원가입]</a> <br>
				</form>
			</c:when>
			<c:otherwise>
				<h3>${sessionScope.userId}님 환영합니다.</h3>
				<a href="update.do">회원정보수정</a><br>				
				<a href="logout.do">로그아웃</a>
			</c:otherwise>
			
		</c:choose>
	
			
</body>
</html>