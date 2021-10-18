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
    <link rel="stylesheet" href="./vendor/aos/aos.css">
    <link rel="stylesheet" href="./vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="./vendor/bootstrap-icon/bootstrap-icons.css">
    <link rel="stylesheet" href="./vendor/summernote/css/summernote-lite.css">

    <!-- Devtopia css -->
    <link rel="stylesheet" href="css/write-article.css">
    <title>글작성</title>
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

    <section class="write-article-wrapper">
        <div class="write-article">
            <div class="board-head">
                <h3>게시글 작성</h3>
            </div>

            <br>
            <br>
            <form action="" class="write-article-head">
                <div class="write-title">
                    <div class="writer">
                        <label for="title">작성자</label>
                        <br>
                        <input type="text" placeholder="${userID}" readonly></input>
                    </div>
                    <br>
                    <label for="title">제목</label>
                    <br>
                    <input type="text" class="input-title" required></input>
                </div>
                <br>
                <form class="form-horizontal">
                    <div class="note-wrap">
                        <div id="summernote">
                        </div>
                    </div>
                    <div class="write-article-button-wrapper">
                        <div class="article-cotroller">
                            <button type="submit">게시글 수정</button>
                            <button type="submit">게시글 삭제</button>
                            <!-- <button>수정</button>
                            <button>삭제</button> -->
                        </div>
                </form>
            </form>

                <button onclick="location.href='#'" id="board-list">목록</button>
        </div>
        </div>
    </section>


    <div class="banner">
        <img id="banner" src="img/banner.png" alt="배너이미지" srcset="">


        <!-- Vendor JS Files -->
        <script src="vendor/aos/aos.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="./vendor/summernote/js/summernote-ko-KR.js"></script>
        <script src="./vendor/summernote/js/summernote-lite.js"></script>
        <script src="./vendor/summernote/js/summer.js"></script>

        <!-- Devtopia JS -->
        <script src="js/main.js"></script>

</body>


</html>