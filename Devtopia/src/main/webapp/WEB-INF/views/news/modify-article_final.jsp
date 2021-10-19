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
    <link rel="stylesheet" href="./resources/vendor/aos/aos.css">
    <link rel="stylesheet" href="./resources/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="./resources/vendor/bootstrap-icon/bootstrap-icons.css">
    <link rel="stylesheet" href="./resources/vendor/summernote/css/summernote-lite.css">

    <!-- Devtopia css -->
    <link rel="stylesheet" href="./resources/css/read-article.css">
    <title>게시글 확인</title>
</head>

<body>
 <jsp:include page="../common/navBar.jsp"></jsp:include>

    <div class="main-contents">
        <section class="write-article-wrapper">
            <div class="write-article">
                <div class="board-head">
                    <h3>게시글 수정</h3>
                </div>
            </div>
            <br>
            <br>
			<form action="modifyNewsArticleAction.do" class="write-article-head" method="post">
            	<input type="hidden" name="postNo" value="${Article.postNo }">			
                <div class="write-title">
                    <div class="writer">
                        <label for="title">작성자</label>
                        <br>
                        <input type="text" name="writer" value="${Article.writer }" readonly></input>
                    </div>
                    <br>
                    <div class="title">
                        <label for="title">제목</label>
                        <br>
                  		<input type="text" name="title" value="${Article.title }" class="input-title" required></input>
                    </div>
                </div>
                <br>
                <div class="note-wrap">
                    	<textarea rows="10" name="content" id="summernote">${Article.content }</textarea>
                        <!-- <div id="summernote" >
                        </div> -->
                    </div>
                    <c:if test="${Article.writer == sessionScope.userId }">
	                    <div class="write-article-button-wrapper">
	                        <div class="article-cotroller">
	                            <button type="submit">게시글 수정</button>
	                            <button type="button" onclick="location.href='deleteNewsArticleAction.do?postNo=${Article.postNo }'">게시글 삭제</button>
	                            <!-- <button>수정</button>
	                            <button>삭제</button> -->
	                        </div>
	                    </div>
                    </c:if>
                    <button type="button" onclick="location.href='pageNationNewsArticle.do'" id="board-list">목록</button>
            </form>
        </section>
    </div>




    <div class="banner">
        <img id="banner" src="./resources/img/banner.png" alt="배너이미지" srcset="">
    </div>


<jsp:include page="../common/loginModal.jsp"></jsp:include>

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