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
	<form action="writeAction.do" method="post" enctype="multipart/form-data">
			아이디: <input type="text" name="userId"><br>
			비밀번호: <input type="password" name="userPw"><br>
			이름: <input type="text" name="userName"><br>
			닉네임: <input type="text" name="nickName"><br>
			이메일: <input type="text"  name="email"><br>
			핸드폰: <input type="text" name="phoneNumber"><br>
			업로드 <input type="file" name="profileImgLoc"><br>
			주소검색:<br>&nbsp;<input type="text" name="address"><br><br>
		<input type="submit" value="가입">
		<a href="goMain.do">[취소]</a>
	</form>
</body>

</html>