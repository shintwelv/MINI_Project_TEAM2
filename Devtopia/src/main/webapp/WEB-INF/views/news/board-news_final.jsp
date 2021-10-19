<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="./resources/img/favicon.ico"
	type="image/x-icon">

<!-- Google Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">

<!-- vendor css -->
<link rel="stylesheet" href="./resources/vendor/aos/aos.css">
<link rel="stylesheet"
	href="./resources/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="./resources/vendor/bootstrap-icon/bootstrap-icons.css">


<!-- Devtopia css -->
<link rel="stylesheet" href="./resources/css/board-news.css">

<title>개발자 뉴스</title>
</head>

<body>
	<jsp:include page="../common/navBar.jsp"></jsp:include>

	<!-- main-contents start -->
	<div class="main-contents">
		<div class="board-news-wrapper">
		<div class="board-title-wrapper">
			<div class="board-title">
				<h3>
					<i class="bi bi-globe2"></i> 개발자 뉴스
				</h3>
			</div>
		</div>
		<!-- banner section start-->
		<div class="sideBanner" style="top: 168px;">
			<img src="./resources/img/banner.gif" alt="배너이미지" srcset="">
		</div>
		<!-- banner section end-->
		<div class="board-news-contents">
			<div class="board-news">
				<c:forEach items="${ArticleList }" var="Article">
					<div class="row">
						<div class="col-xs-10 col-sm-10 col-md-3 col-lg-2 news-img">
							<img src="${Article.imgLoc }" alt="..." class="img-fluid">
						</div>
						<div class="col-xs-10 col-sm-10 col-md-7 col-lg-8 caption">
							<a
								href="https://www.donga.com/news/It/article/all/20211008/109620166/2">
								<span id="news-title">${Article.title } </span>
							</a>
							<p>${Article.content }</p>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="write-button">
			<button onclick="loation.href='write-article.html'">게시글 작성</button>
		</div>
		</div>
	</div>
	<!-- main-contents end-->

	<div class="paigination-wrapper">
		<ul class="pagination">
			<li id="Previous-page"><a
				href="pageNationNewsArticleAction.do?arrowDirection=left"
				aria-label="Previous"> <span aria-hidden="true">&#60;</span> <span
					class="sr-only">이전</span>
			</a></li>
			<c:forEach begin="${startPoint }" end="${endPoint }" var="pageNum">
				<li><a
					href="pageNationNewsArticleAction.do?pageNum=${pageNum }">${pageNum }</a></li>
			</c:forEach>
			<li id="next-page"><a
				href="pageNationNewsArticleAction.do?arrowDirection=right"
				aria-label="Next"> <span class="sr-only">다음</span> <span
					aria-hidden="true">&#62;</span>
			</a></li>
		</ul>
	</div>

	<jsp:include page="../common/footer.jsp"></jsp:include>
	<jsp:include page="../common/loginModal.jsp"></jsp:include>

	<!-- vendoer css-->
	<script src="./resources/vendor/aos/aos.js"></script>
	<script src="./resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

	<!-- Devtopia Js-->
	<script src="./resources/js/banner.js"></script>
	<script src="./resources/js/main.js"></script>
</body>

</html>