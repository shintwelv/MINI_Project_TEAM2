<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- login modal start -->
        <div class="login-modal hidden">
            <div class="login-modal-wrapper">
                <div class="login-modal-contens">
                    <div class="login-modal-head">
                        <h3>로그인</h3>
                        <img src="./resources/img/logo-dk-2.png" alt="modal-img" class="img-fluid">
                    </div>
                    <form action="loginCheck.do" class="login-modal-form" method="post">
                        <div class="login-modal-input">
                            <label for="userId">아이디</label>
                            <br>
                            <input type="text" name="userId">
                        </div>
                        <div class="login-modal-input">
                            <label for="userPw">비밀번호</label>
                            <br>
                            <input type="password" name="userPw">
                        </div>
                        <div class="login-modal-button-wrapper">
                            <div class="login-signup">
                                <input type="submit" value="로그인" id="loginSuccess-button"></input>
                                <button onclick="fn_signUp()">회원가입</button>
                            </div>
                            <div class="login-modal-close">
                                <button type="button" onclick="fn_closeLoginModal()">닫기</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
<!-- login modal end -->
</body>
</html>