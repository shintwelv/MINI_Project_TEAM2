<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

    <!-- vendor css -->
    <link rel="stylesheet" href="vendor/aos/aos.css">
    <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="vendor/bootstrap-icon/bootstrap-icons.css">


    <!-- Devtopia css -->
    <link rel="stylesheet" href="css/board-job.css">

    <title>Devtopiaㅣ구인&구직</title>
</head>

<body>
    <!-- nav start -->
    <nav class="sidebar-wrapper">
        <div class="sidebar">
            <div class="logo-wrapper">
                <div class="logo">
                    <img src="/img/logo2.png" alt="logo" class="img-fluid" onclick="location.href='index.html'">
                </div>
            </div>
            <div class="member-box">
                <p>뉴비 개발자들의 유토피아
                    <br>함께 성장 성장해봐요!
                </p>
                <br>
                <!-- <div class="user-status">
                    <p>${userId}님 반가워요! </p>
                </div> -->
                <div class="login">
                    <button id="open">로그인</button>
                </div>
                <div class="button-wrapper">
                    <div class="sign-up">
                        <button onclick="location.href='sign-up.html'"><i class=" bi bi-box-arrow-right"></i>
                            회원가입</button>
                    </div>
                    <div class="member-info">
                        <button class="member-info-button" onclick="fn_openuserinfoPopup()"><i
                                class="bi bi-person-fill"></i>회원정보</button></a>
                    </div>
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

    <!-- board-job start-->
    <div class="board-wrapper">
        <div class="board-contents">

            <div class="board-title-wrapper">
                <div class="board-title">
                    <h3><i class="bi bi-briefcase"></i> 구인 & 구직 게시판</h3>
                </div>
            </div>

            <div class="board-best-wrap">
                <h3>| 최다 조회 게시물</h3>
                <div class="board-best">
                    <div class="best-list">
                        <a href="">- 자바 재밌나요?</a>
                        <br>
                        <a href="">- 파이썬 재밌나요?</a>
                        <br>
                        <a href="">- C++ 재밌나요?</a>
                        <br>
                        <a href="">- 한국소프트인재 개발원 구인</a>
                        <br>
                        <a href="">- jsp는 백앤드다 ^~^</a>
                    </div>
                </div>
            </div>
            <br>
            <div class="write-button">
                <button onclick="location.href='write-article.html'">글쓰기</button>
            </div>
            <div class="main-contents">
                <div class="table-wrapper">
                    <table>
                        <thead>
                            <tr>
                                <th scope="col">번호</th>
                                <th scope="col">제목</th>
                                <th scope="col">글쓴이</th>
                                <th scope="col">등록일</th>
                                <th scope="col">조회수</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="number">
                                    <span>10</span>
                                </td>
                                <td class="title">
                                    <div class="text-wrap">
                                        <div>
                                            <a href="">카카오 프렌즈 골프 프론트엔드 개발자 구인 [긴급]</a>
                                        </div>
                                    </div>
                                </td>
                                <td class="user">
                                    <span>Bobby</span>
                                </td>
                                <td class="date">2021-10-10</td>
                                <td class="view">150</td>
                            </tr>
                            <tr>
                                <td class="number">
                                    <span>9</span>
                                </td>
                                <td class="title">
                                    <div class="text-wrap">
                                        <div>
                                            <a href="">새로운 프로젝트에 참여할 개발자를 모십니다.</a>
                                        </div>
                                    </div>
                                </td>
                                <td class="user">
                                    <span>servlet666</span>
                                </td>
                                <td class="date">2011-10-10</td>
                                <td class="view">21</td>
                            </tr>
                            <tr>
                                <td class="number">
                                    <span>8</span>
                                </td>
                                <td class="title">
                                    <div class="text-wrap">
                                        <div>
                                            <a href="">유니콘 기업 선정 개발자 신입 및 경력직 모집</a>
                                        </div>
                                    </div>
                                </td>
                                <td class="user">
                                    <span>JavaAngel</span>
                                </td>
                                <td class="date">2011-10-10</td>
                                <td class="view">150</td>
                            </tr>
                            <tr>
                                <td class="number">
                                    <span>7</span>
                                </td>
                                <td class="title">
                                    <div class="text-wrap">
                                        <div>
                                            <a href="">한국 소프트웨어 인재개발원 개발 강사 모집</a>
                                        </div>
                                    </div>
                                </td>
                                <td class="user">
                                    <span>Nullhater</span>
                                </td>
                                <td class="date">2021-10-09</td>
                                <td class="view">98</td>
                                </tr>
                            </tr>
                            <tr>
                                <td class="number">
                                    <span>6</span>
                                </td>
                                <td class="title">
                                    <div class="text-wrap">
                                        <div>
                                            <a href="">다양한 프로젝트 경험 및 각종 복지 제공</a>
                                        </div>
                                    </div>
                                </td>
                                <td class="user">
                                    <span>paypay1004</span>
                                </td>
                                <td class="date">2021-10-08</td>
                                <td class="view">40</td>
                                </tr>
                            </tr>
                            <tr>
                                <td class="number">
                                    <span>5</span>
                                </td>
                                <td class="title">
                                    <div class="text-wrap">
                                        <div>
                                            <a href="">웹 에이전시 프론트엔드 개발자 및 퍼블리셔 모집</a>
                                        </div>
                                    </div>
                                </td>
                                <td class="user">
                                    <span>Bigjamcss</span>
                                </td>
                                <td class="date">2021-10-08</td>
                                <td class="view">320</td>
                                </tr>
                            </tr>
                            <tr>
                                <td class="number">
                                    <span>4</span>
                                </td>
                                <td class="title">
                                    <div class="text-wrap">
                                        <div>
                                            <a href="">리액트 개발자를 모십니다.</a>
                                        </div>
                                    </div>
                                </td>
                                <td class="user">
                                    <span>Jsluv</span>
                                </td>
                                <td class="date">2021-10-08</td>
                                <td class="view">86</td>
                                </tr>
                            </tr>
                            <tr>
                                <td class="number">
                                    <span>3</span>
                                </td>
                                <td class="title">
                                    <div class="text-wrap">
                                        <div>
                                            <a href="">인디 게임 개발자 및 디자이너 모집</a>
                                        </div>
                                    </div>
                                </td>
                                <td class="user">
                                    <span>G식</span>
                                </td>
                                <td class="date">2021-10-07</td>
                                <td class="view">55</td>
                                </tr>
                            </tr>
                            <tr>
                                <td class="number">
                                    <span>2</span>
                                </td>
                                <td class="title">
                                    <div class="text-wrap">
                                        <div>
                                            <a href="">심미안이 뛰어나신 웹 퍼블리셔 모십니다.</a>
                                        </div>
                                    </div>
                                </td>
                                <td class="user">
                                    <span>designUp</span>
                                </td>
                                <td class="date">2021-10-07</td>
                                <td class="view">61</td>
                                </tr>
                            <tr>
                                <td class="number">
                                    <span>1</span>
                                </td>
                                <td class="title">
                                    <div class="text-wrap">
                                        <div>
                                            <a href="">자바 개발자(재택근무자 가능자, 겸업 가능) 및 서버관리자 모집 </a>
                                        </div>
                                    </div>
                                </td>
                                <td class="user">
                                    <span>BanBan</span>
                                </td>
                                <td class="date">2021-10-06</td>
                                <td class="view">49</td>
                                </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <br>
            <div class="write-button">
                <button onclick="location.href='write-article.html'">글쓰기</button>
            </div>
            <div class="paigination-wrapper">
                <ul class="pagination">
                    <li id="Previous-page">
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&#60;</span>
                            <span class="sr-only">이전</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">1</a>
                    </li>
                    <li>
                        <a href="#">2</a>
                    </li>
                    <li>
                        <a href="#">3</a>
                    </li>
                    <li>
                        <a href="#">4</a>
                    </li>
                    <li>
                        <a href="#">5</a>
                    </li>
                    <li id="next-page">
                        <a href="#" aria-label="Next">
                            <span class="sr-only">다음</span>
                            <span aria-hidden="true">&#62;</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <!-- board-job end-->

        <!-- modal start -->
        <div class="login-modal hidden " >
            <div class="login-modal-wrapper">
                <div class="login-modal-contens">
                    <div class="login-modal-head">
                        <h3>로그인</h3>
                        <img src="./img/logo-dk-2.png" alt="modal-img" class="img-fluid">
                    </div>
                    <form action="" class="login-modal-form">
                        <div class="login-modal-input">
                            <label for="userId">아이디</label>
                            <br>
                            <input type="text">
                        </div>
                        <div class="login-modal-input">
                            <label for="userPw">비밀번호</label>
                            <br>
                            <input type="password">
                        </div>
                        <div class="login-modal-button-wrapper">
                            <div class="login-signup">
                                <button onclick="window.open('login.html')">로그인</button>
                                <button onclick="window.open('sign-up.html')">회원가입</button>
                            </div>
                            <div class="login-modal-close">
                                <button>닫기</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- modal end -->


    <!-- banner section start-->
    <img id="banner" src="img/banner.png" alt="배너이미지" class="img-fluid">
    <!-- banner section end-->

    <!-- vendoer css-->
    <script src="./vendor/aos/aos.js"></script>
    <script src="./vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <!-- Devtopia Js-->
    <script src="./js/main.js"></script>
</body>

</html>