<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="./resources/img/favicon.ico" type="image/x-icon">

    <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
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
<jsp:include page="../common/navBar.jsp"></jsp:include>

    <!-- write section start-->
    <div class="main-contents">
        <section class="write-article-wrapper">
             <!-- banner section start-->
             <div class="sideBanner">
                <img src="./resources/img/banner.gif" alt="배너이미지" srcset="">
            </div>
            <!-- banner section end-->
            <div class="write-article">
                <div class="board-head">
                    <h3>게시글 작성</h3>
                </div>

                <br>
                <br>
               <form action="createNewsArticleAction.do" class="write-article-head" method="post" enctype="multipart/form-data">
                    <div class="write-title">
                        <div class="writer">
                            <label for="title">작성자</label>
                            <br>
                            <input type="text" name="writer" value="${sessionScope.userId }" readonly></input>
                        </div>
                        <br>
                        <label for="title">제목</label>
                        <br>
                        <input type="text" name="title" class="input-title" required></input>
                    </div>
                    <br>
                    <div class="note-wrap">
                    	<textarea rows="10" cols="10" name="content" id="summernote"></textarea>
                    </div>
                    <div>
                    	<input type="file" name="imgLoc">
                    </div>
                 	<div class="write-article-button-wrapper">
                     	<div class="article-cotroller">
                         	<button type="submit">게시글 등록</button>
                   		</div>
                 	</div>
                </form>

               <button type="button" onclick="location.href='pageNationNewsArticle.do'" id="board-list">목록</button>
            </div>
    </section>
    </div>
    <!-- write section end-->

<jsp:include page="../common/footer.jsp"></jsp:include>
        <!-- Vendor JS Files -->
        <script src="./resources/vendor/aos/aos.js"></script>
        <script src="./resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="./resources/vendor/bootstrap/js/bootstrap.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="./resources/vendor/summernote/js/summernote-ko-KR.js"></script>
        <script src="./resources/vendor/summernote/js/summernote-lite.js"></script>
        <script src="./resources/vendor/summernote/js/summer.js"></script>

        <!-- Devtopia JS -->
        <script src="./resources/js/banner.js"></script>

</body>


</html>