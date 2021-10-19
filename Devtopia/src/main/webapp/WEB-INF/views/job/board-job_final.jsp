<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Google Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
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
<link rel="stylesheet" href="./resources/css/board-job.css">

<title>Devtopiaㅣ자유게시판</title>
</head>

<body>
	<jsp:include page="../common/navBar.jsp"></jsp:include>

	<!-- board-job start-->
	<div class="main-contents">
		<div class="board-wrapper">
			<div class="board-contents">
				<!-- banner section start-->
				<div class="sideBanner">
					<img src="./resources/img/banner.png" alt="배너이미지">
				</div>
				<!-- banner section end-->
				<div class="board-title-wrapper">
					<div class="board-title">
						<h3>
							<i class="bi bi-share"></i> 자유게시판
						</h3>
					</div>
				</div>
				<div class="board-best-wrap">
					<h3>&#124; 최다 조회 게시물</h3>
					<div class="board-best">
						<div class="best-list">
							<c:forEach items="${TopFive }" var="Article">
								<a href="#">${Article.title }</a>
								<br>
							</c:forEach>
						</div>
					</div>
				</div>
				<br>
				<c:if test="${sessionScope.userId != null }">
					<div class="write-button">
						<button onclick="location.href='createJobArticle.do'">글쓰기</button>
					</div>
				</c:if>

				<div class="table-contents">
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
								<c:forEach items="${ArticleList }" var="Article">
									<tr>
										<td class="number"><span> ${Article.postNo} </span></td>
										<td class="title">
											<div class="text-wrap">
												<a href="selectJobArticle.do?postNo=${Article.postNo }">
													${Article.title} </a>
											</div>
										</td>
										<td class="user"><span> ${Article.writer} </span></td>
										<td class="date">${Article.writeDate}</td>
										<td class="view">${Article.viewCount}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				</div>
				</div>
				</div>
				<div class="paigination-wrapper">
					<ul class="pagination">
						<li id="Previous-page"><a
							href="pageNationJobArticleAction.do?arrowDirection=left"
							aria-label="Previous"> <span aria-hidden="true">&#60;</span>
								<span class="sr-only">이전</span>
						</a></li>
						<c:forEach begin="${startPoint }" end="${endPoint }" var="pageNum">
							<li><a href="pageNationJobArticleAction.do?pageNum=${pageNum }">${pageNum }</a></li>
						</c:forEach>
						<li id="next-page"><a
							href="pageNationJobArticleAction.do?arrowDirection=right"
							aria-label="Next"> <span class="sr-only">다음</span> <span
								aria-hidden="true">&#62;</span>
						</a></li>
					</ul>
				</div>
				<!-- board-job end-->


				<jsp:include page="../common/loginModal.jsp"></jsp:include>

				<!-- vendoer css-->
				<script src="./resources/vendor/aos/aos.js"></script>
				<script
					src="./resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
				<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

				<!-- Devtopia Js-->
				<script src="./resources/js/banner.js"></script>
</body>

</html>