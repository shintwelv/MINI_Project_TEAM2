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
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

    <!-- vendor css -->
    <link rel="stylesheet" href="./resources/vendor/aos/aos.css">
    <link rel="stylesheet" href="./resources/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="./resources/vendor/bootstrap-icon/bootstrap-icons.css">
    <link rel="stylesheet" href="./resources/vendor/summernote/css/summernote-lite.css">

    <!-- Devtopia css -->
    <link rel="stylesheet" href="./resources/css/write-article.css">
    <title>글작성</title>
</head>

<body>
    <!-- nav start -->
    <nav class="sidebar-wrapper">
        <div class="sidebar">
            <div class="logo-wrapper">
                <div class="logo">
                    <img src="./resources/img/logo2.png" alt="logo" class="img-fluid" onclick="location.href='goMain.do'">
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
		                        <button onclick="location.href='writeUser.do'"><i class=" bi bi-box-arrow-right"></i>
		                            회원가입</button>
		                    </div>
                		</c:when>
                		<c:otherwise>
		                    <div class="member-info">
		                        <button class="member-info-button" onclick="fn_openuserinfoPopup()"><i
		                                class="bi bi-person-fill"></i>회원정보</button>
		                    </div>
		                    <div class="member-info">
		                        <button class="member-info-button" onclick="fn_logout()"><i
		                                class="bi bi-person-fill"></i>로그아웃</button>
		                    </div>
                		</c:otherwise>
                	</c:choose>
                </div>
            </div>
            <div class="menu-wrapper">
                <div class="menu">
                    <ul>
                       <li><a href="pageNationNewsArticle.do"><i class="bi bi-globe2"></i> 개발자 뉴스</a></li>
                        <li><a href="pageNationFreeArticle.do"><i class="bi bi-share"></i> 자유게시판</a></li>
                        <li><a href="pageNationTipArticle.do"><i class="bi bi-info-circle"></i> 팁과 노하우</a></li>
                        <li><a href="pageNationJobArticle.do"><i class="bi bi-briefcase"></i> 구인 &amp; 구직</a></li>
                        <li><a href="pageNationQnaArticle.do"><i class="bi bi-question-circle"></i> Q &amp; A</a></li>
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
            <form action="modifyFreeArticleAction.do" class="write-article-head" method="post">
            	<input type="hidden" name="postNo" value="${Article.postNo }">
                <div class="write-title">
                    <div class="writer">
                        <label for="title">작성자</label>
                        <br>
                        <input type="text" name="writer" value="${Article.writer }" readonly></input>
                    </div>
                    <br>
                    <label for="title">제목</label>
                    <br>
                    <input type="text" name="title" value="${Article.title }" class="input-title" required></input>
                </div>
                <br>
                	<input type="text" name="content" value="${Article.content }">
                    <div class="note-wrap">
                        <div id="summernote">
                        </div>
                    </div>
                    <c:if test="${Article.writer == sessionScope.userId }">
	                    <div class="write-article-button-wrapper">
	                        <div class="article-cotroller">
	                            <button type="submit">게시글 수정</button>
	                            <button type="button" onclick="location.href='deleteFreeArticleAction.do?postNo=${Article.postNo }'">게시글 삭제</button>
	                            <!-- <button>수정</button>
	                            <button>삭제</button> -->
	                        </div>
	                    </div>
                    </c:if>
                <!-- <form class="form-horizontal">
                </form> -->
            </form>

                <button type="button" onclick="location.href='pageNationFreeArticle.do'" id="board-list">목록</button>
        </div>
    </section>


    <div class="banner">
        <img id="banner" src="./resources/img/banner.png" alt="배너이미지">
    </div>


        <!-- Vendor JS Files -->
        <script src="./resources/vendor/aos/aos.js"></script>
        <script src="./resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="./resources/vendor/bootstrap/js/bootstrap.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="./resources/vendor/summernote/js/summernote-ko-KR.js"></script>
        <script src="./resources/vendor/summernote/js/summernote-lite.js"></script>
        <script src="./resources/vendor/summernote/js/summer.js"></script>

        <!-- Devtopia JS -->
        <script src="./resources/js/main.js"></script>

</body>


</html>