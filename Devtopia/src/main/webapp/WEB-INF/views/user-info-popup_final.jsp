<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

    <!-- vendor css -->
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
    <link rel="stylesheet" href="./resources/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="./resources/vendor/bootstrap-icon/bootstrap-icons.css">
    <link rel="stylesheet" href="./resources/vendor/isotope-layout/">

    <!-- Devtopia css -->
    <link rel="stylesheet" href="./resources/css/userinfopopup.css">
    <title>회원가입</title>
</head>

<body>

    <div class="container-lg">
        <div class="row">
            <div class="col-md-10 mx-auto" data-aos="fade-up">
                <div class="signup-form">
                    <h1>회원정보</h1>
                    <div class="profile-photo-wrapper">
                        <class class="profile-photo">
                            <img src="${User.profileImgLoc}" alt="Profile">
                        </class>
                    </div>

                    <br>
                    <form action="updateUserAction.do" method="post" enctype="multipart/form-data">
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="inputId">아이디</label>
                                    <input type="text" class="form-control" name="userId" id="inputId" readonly autocomplete="none" value="${User.userId }">
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <span>*</span>
                                    <label for="inputPassword">비밀번호</label>
                                    <input type="password" class="form-control" name="userPw" id="inputPassword" required value="${User.userPw }">
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <span>*</span>
                                    <label for="inputNickname">닉네임</label>
                                    <input type="text" class="form-control" name="nickName" id="inputNickname" value="${User.nickName }">
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="inputName">이름</label>
                                    <input type="text" class="form-control" name="userName" id="inputName" readonly value="${User.userName }">
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <span>*</span>
                                    <label for="inputPhone">전화번호</label>
                                    <input type="text" class="form-control" name="phoneNumber" id="inputPhone" required value="${User.phoneNumber }">
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <label for="inputPhone">이메일</label>
                                    <input type="email" class="form-control" name="email" id="inputPhone" value="${User.email }">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <span>*</span>
                            <label for="basic-address">주소</label>
                            <input type="text" class="form-control" name="address" id="basic-address" required
                                onclick="fn_openAddressPopup()">
                            <br>
                            <input type="text" class="form-control" id="detail-address" required>
                        </div>
                        <br>
                        <div class="file-upload">
                            <label for="profileImgLoc">프로필 사진</label>
                            <br>
                            <input type="file" name="profileImgLoc" id="file-upload">
                        </div>
                        <br>
                        <div class="button-wrapper">
                            <div class="submit">
                                <button type="submit">수정</button>
                            </div>
                            
                            <div class="cancel">
                                <button type="button" onclick="fn_userDelete()">탈퇴</button>
                            </div>

                            <div class="cancel">
                                <button type="button" onclick="window.close()">닫기</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    </div>

    <!-- signup right Start -->


    <!-- Vendor JS Files -->
    <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
    <script src="./resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="./resources/vendor/isotope-layout/isotope.pkgd.js"></script>


    <!-- main JS Files -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="./resources/js/main.js"></script>



    
</body>

</html>