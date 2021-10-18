<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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

    <!-- Devtopia css -->
    <link rel="stylesheet" href="./resources/css/index.css">
    
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <title>Devtopiaㅣ개발자들의 소소한 유토피아</title>
</head>

<body>
    <!-- nav start -->
    <nav class="sidebar-wrapper">
        <div class="sidebar">
            <div class="logo-wrapper">
                <div class="logo">
                    <img src="./resources/img/logo2.png" alt="logo" class="img-fluid" onclick="location.href='index.html'">
                </div>
            </div>
            <div class="member-box">
            	<c:choose>
		           <c:when test="${empty sessionScope.userId}">
		                <p>뉴비 개발자들의 유토피아
		                    <br>함께 성장 성장해봐요!
		                </p>
		                <div class="login">
		                    <button id="open" type="button">로그인</button>
		                </div>
		           </c:when>
		           <c:otherwise>
		           		<p>
							${userId }님, 환영합니다!           		
		           		
		           		</p>
		           </c:otherwise>
            	</c:choose>
                <br>
                <!-- <div class="user-status">
                    <p>${userId}님 반가워요! </p>
                </div> -->
                <div class="button-wrapper">
                	<c:choose>
                		<c:when test="${empty sessionScope.userId}">
		                    <div class="sign-up">
		                        <button onclick="location.href='./writeUser.do'"><i class=" bi bi-box-arrow-right"></i>
		                            회원가입</button>
		                    </div>
                		</c:when>
                		<c:otherwise>
		                    <div class="member-info">
		                        <button class="member-info-button" onclick="fn_openuserinfoPopup()"><i
		                                class="bi bi-person-fill"></i>회원정보</button></a>
		                    </div>
		                    <div class="member-info">
		                        <button class="member-info-button" onclick="fn_logout()"><i
		                                class="bi bi-person-fill"></i>로그아웃</button></a>
		                    </div>
                		</c:otherwise>
                	</c:choose>
                </div>
            </div>
            <div class="menu-wrapper">
                <div class="menu">
                    <ul>
                        <li><a href="board-news.html"><i class="bi bi-globe2"></i> 개발자 뉴스</a></li>
                        <li><a href="board-free.html"><i class="bi bi-share"></i> 자유게시판</a></li>
                        <li><a href="board-tip.html"><i class="bi bi-info-circle"></i> 팁과 노하우</a></li>
                        <li><a href="board-job.html"><i class="bi bi-briefcase"></i> 구인 & 구직</a></li>
                        <li><a href="board-qna.html"><i class="bi bi-question-circle"></i> Q & A</a></li>
                    </ul>
                </div>
            </div>
            <div class="social-wrapper">
                <div class="social-github">
                    <h1><a href=""><i class="bi bi-github"></i></a></h1>
                </div>
            </div>
        </div>
    </nav>
    <!-- nav end -->

    <!-- main contents start -->
    <div class="main-contents-wrapper" data-aos="zoom-in">
        <div class="main-contents">
            <div class="main-them-img-wrapper">
                <div class="main-them-img">
                    <img src="./resources/img/main-them.png" alt="main-img" class="img-fluid animated">
                </div>
            </div>
            <div class="table-wrapper">
                <table class="table"  data-aos="fade-left" data-aos-delay=400>
                    <thead>
                        <div class="table-head">
                            <div class="board-title" data-aos="fade-left" data-aos-delay=400>
                                <H1><a href="board-news.html"><i class="bi bi-globe2"></i> 개발자 뉴스</a>
                                </H1>
                            </div>
                            <div class="board-list" data-aos="fade-left" data-aos-delay=400><a href="board-news.html"><span><i
                                            class="bi bi-plus-lg"></i></span></a></div>
                        </div>
                        <tr>
                            <th scope="col"> </th>
                            <th scope="col"> </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>AI가 나 대신 코딩을 ? 깃헙 'Copilot'을 사용 해 봤다!</td>
                            <td id="writer">운영자</td>

                        </tr>
                        <tr>
                            <td>인터넷 익스프롤러! 처참한 몰락의 이유는</td>
                            <td id="writer">운영자</td>
                        </tr>
                        <tr>
                            <td>머신러닝 vs 딥러닝 vs 인공지능? </td>
                            <td id="writer">운영자</td>
                        </tr>
                        <tr>
                            <td>지금 당장 알아둬야 하는 JS 신박한 기능 10가지 !</td>
                            <td id="writer">운영자</td>
                        </tr>
                        <tr>
                            <td>SonarQube와 Github Action으로 수행하는 정적 분석</td>
                            <td id="writer">운영자</td>
                        </tr>
                    </tbody>
                </table>
                <br>
                <table class="table" data-aos="fade-right" data-aos-delay=500>
                    <thead>
                        <div class="table-head">
                            <div class="board-title" data-aos="fade-right" data-aos-delay=400>
                                <H1><a href="board-free.html"><i class="bi bi-share"></i> 자유게시판</a>
                                </H1>
                            </div>
                            <div class="board-list" data-aos="fade-right" data-aos-delay=400><a href="board-free.html"><span><i
                                            class="bi bi-plus-lg"></i></span></a></div>
                        </div>
                        <tr>
                            <th scope="col"> </th>
                            <th scope="col"> </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <a href="./resources/board-news.html">                            <td>AI가 나 대신 코딩을 ? 깃헙 'Copilot'을 사용 해 봤다!</td>
                                <td id="writer">servelt1004</td></a>
                        </tr>
                        <tr>
                            <td>인터넷 익스프롤러! 처참한 몰락의 이유는</td>
                            <td id="writer">servelt1004</td>
                        </tr>
                        <tr>
                            <td>머신러닝 vs 딥러닝 vs 인공지능? </td>
                            <td id="writer">servelt1004</td>
                        </tr>
                        <tr>
                            <td>지금 당장 알아둬야 하는 JS 신박한 기능 10가지 !</td>
                            <td id="writer">servelt1004</td>
                        </tr>
                        <tr>
                            <td>SonarQube와 Github Action으로 수행하는 정적 분석</td>
                            <td id="writer">servelt1004</td>
                        </tr>
                    </tbody>
                </table>
                <br>
                <table class="table" data-aos="fade-left" data-aos-delay=600>
                    <thead>
                        <div class="table-head">
                            <div class="board-title" data-aos="fade-left" data-aos-delay=600>
                                <H1><a href="board-tip.html"><i class="bi bi-info-circle"></i> 팁과
                                        노하우</a></H1>
                            </div>
                            <div class="board-list" data-aos="fade-left" data-aos-delay=600><a href="board-tip.html"><span><i
                                            class="bi bi-plus-lg"></i></span></a></div>
                        </div>
                        <tr>
                            <th scope="col"> </th>
                            <th scope="col"> </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>AI가 나 대신 코딩을 ? 깃헙 'Copilot'을 사용 해 봤다!</td>
                            <td id="writer">servelt1004</td>
                        </tr>
                        <tr>
                            <td>인터넷 익스프롤러! 처참한 몰락의 이유는</td>
                            <td id="writer">servelt1004</td>
                        </tr>
                        <tr>
                            <td>머신러닝 vs 딥러닝 vs 인공지능? </td>
                            <td id="writer">servelt1004</td>
                        </tr>
                        <tr>
                            <td>지금 당장 알아둬야 하는 JS 신박한 기능 10가지 !</td>
                            <td id="writer">servelt1004</td>
                        </tr>
                        <tr>
                            <td>SonarQube와 Github Action으로 수행하는 정적 분석</td>
                            <td id="writer">servelt1004</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <!-- main contents end -->

    <div class="footer-wrapper">
        <div class="footer-contents">
            <h1><img src="./resources/img/font-logo.png" alt="" class="img-fluid"><a href=""></a></h1>
        </div>
    </div>

    <!-- modal start -->
    <div class="login-modal hidden " >
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
                            <!-- <button onclick="window.open('login.html')">로그인</button> -->
                            <button type="submit">로그인</button>
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
    <!-- modal end -->

    <!-- Vendor JS Files -->
    <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
    <script src="./resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    
    <!-- main JS Files -->
    <script src="./resources/js/main.js"></script>

</body>

</html>