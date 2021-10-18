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
	[회원가입]
	<form action="writeAction.do" method="post" >
		<p>
			아이디: <br><input type="text" name="userId">
		</p>
		<p>
			비밀번호: <br><input type="password" name="userPw">
		</p>
		<p>
			이름: <br><input type="text" name="userName">
		</p>
		<p>
			닉네임: <br><input type="text" name="nickName">
		</p>
		<p>
			이메일: <br><input type="text"  name="email">
		</p>
		<p>
			핸드폰: <br><input type="text" name="phoneNumber">
		</p>
	 
			업로드 <input type="file" name="profileImgLoc">
		<p>
		
		<p> 주소검색:<br>&nbsp;<input type="text" name="address"><br><br>
					
		</p>

		<input type="submit" value="가입">
		<a href="goMain.do">[취소]</a>
	</form>
</body>

</html>