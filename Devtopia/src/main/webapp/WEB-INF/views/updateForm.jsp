<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	[회원정보수정]
	<form action="update.do" method="post">
		<p>
			아이디: <br><input type="text" name="userId" value="${User.userId}">
		</p>
		<p>
			비밀번호: <br><input type="password" name="userPw" value="${User.userPw}">
		</p>
		<p>
			이름: <br><input type="text" name="userName" value="${User.userName}">
		</p>
		<p>
			네임: <br><input type="text" name="nickName" value="${User.nickName}">
		</p>
		<p>
			이메일: <br><input type="text"  name="email" value="${User.emali}">
		</p>
		<p>
			핸드폰: <br><input type="text" name="phoneNumber" value="${User.phoneNumber}">
		</p>
	<!-- 
			업로드 <input type="file" name="profileImgLoc">
	 -->	<p>
		
		<p> 주소검색:<br>&nbsp;<input type="text" id="adr" name="address"value="${user.address}"><br><br>
					
		</p>

		<input type="submit" value="수정">
		<a href="goMain.do">[취소]</a>
	</form>
</body>

</html>