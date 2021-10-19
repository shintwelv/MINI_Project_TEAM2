<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

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
	<div class="main-conents">
		<div class="board-news-wrapper">
			<div class="board-title-wrapper">
				<div class="board-title">
					<h3>
						<i class="bi bi-globe2"></i> 개발자 뉴스
					</h3>
				</div>
			</div>
			<div class="main-content">
				<div class="container">
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
					<!-- 				<div class="row">
					<div class="col-xs-10 col-sm-10 col-md-3 col-lg-2 news-img">
						<img src="img/news1.png" alt="..." class="img-fluid">
					</div>
					<div class="col-xs-10 col-sm-10 col-md-7 col-lg-8 caption">
						<a
							href="https://www.donga.com/news/It/article/all/20211008/109620166/2">
							<span id="news-title">병리 인공지능 모델 개발 데이터톤 ‘NPHD 2021’ 개최 </span>
						</a>
						<p>병리 인공지능 모델 개발 데이터톤 ‘National Pathology Health Datathon
							2021(이하, NPHD 2021)’이 오는 11월 18일~19일 온라인에서 개최된다. NPHD 2021은 인공지능
							학습용 데이터 구축사업을 통해 구축한 학습용 병리 이미지 데이터를 활용하여 실제 구현 가능한 인공지능 학습 모델을
							기획하고 개발하는 경연대회다. 과학기술정보통신부와 한국지능정보사회진흥원(이하, 지능정보원)이 주최하고,
							국립암센터(총괄 유종우 교수)가 주관한다.</p>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-10 col-sm-10 col-md-3 col-lg-2 news-img">
						<img src="img/news2.png" alt="..." class="img-fluid">
					</div>
					<div class="col-xs-10 col-sm-10 col-md-7 col-lg-8 caption">
						<a
							href="https://www.codingworldnews.com/news/articleView.html?idxno=5777">
							<span id="news-title">웹디자이너·개발자가 놓쳐서는 안 될 2021 트렌드 6가지 </span>
						</a>
						<p>웹 개발 트렌드는 빠르게 변한다. 언어가 변하는 것처럼 디자인 접근 방식, 소비자 취향 등 고객 선호가
							변화하기 마련이다. 웹 디자이너 및 개발자는 소비자의 선호에 맞춰 최신 트렌드를 따라야 하는데, 올 하반기 놓치지
							말아야 할 웹 디자인 및 개발 트렌드에 어떤 것이 있을까? CIO 리뷰가 소개한 웹 개발 동향 6가지를 참고해보자.
						</p>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-10 col-sm-10 col-md-3 col-lg-2 news-img">
						<img src="img/news3.png" alt="..." class="img-fluid">
					</div>
					<div class="col-xs-10 col-sm-10 col-md-7 col-lg-8 caption">
						<a
							href="https://www.codingworldnews.com/news/articleView.html?idxno=5776">
							<span id="news-title">[코딩 트렌드] 파이썬, PyPL 9월 랭킹 1위 ... 티오베는
								3위 </span>
						</a>
						<p>파이썬(Python)이 9월 PyPL(PYPL PopularitY of Programming
							Language) 인기도순에서 지난달에 이어 1위를 차지했다. 8월 티오베 지수(TIOBE Index)에서는 3위를
							기록했다. 파이썬은 플랫폼 독립적, 객체 지향적인 고급 프로그래밍 언어로 동적 타이핑 대화형 언어이다. 비영리 재단인
							파이썬 소프트웨어 재단이 관리하며 개방형, 공동체 기반 개발 모델을 가진다. 파이썬은 초보자부터 전문가까지 넓은
							사용자층을 보유하고 있는데, 초보자도 쉽게 배울 수 있으며 풍부한 라이브러리를 갖춰 확장성이 높다는 장점이 있다.
							대학, 교육 기관, 연구 기관 및 산업계에서 널리 사용되고 있다. .</p>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-10 col-sm-10 col-md-3 col-lg-2 news-img">
						<img src="img/news4.png" alt="..." class="img-fluid">
					</div>
					<div class="col-xs-10 col-sm-10 col-md-7 col-lg-8 caption">
						<a
							href="https://ichi.pro/ko/2021-nyeon-e-baewoya-hal-10-gaji-peulogeulaeming-eon-eo-146605993084825">
							<span id="news-title">2021 년에 배워야 할 10 가지 프로그래밍 언어. </span>
						</a>
						<p>업계의 증가하는 수요로 인해 혼란 스러울 수 있으며 따라야 할 가장 유망한 프로그래밍 언어를 찾는 것이
							어려울 수 있습니다. 그렇기 때문에이 기사에서는 Google 트렌드 데이터를 기반으로 한 PYPL
							(PopularitY Programming Language index) 보고서 2020에 따르면 2021 년에 가장
							유망한 10 대 프로그래밍 언어에 대한 전체 요약을 제공합니다. 이 기사와 함께 급여 기대치와 관련된 정보는 미국 및
							인도 시장 에 중점을 둡니다 .요점으로 바로 가서이 목록을 10 번으로 시작해 보겠습니다. 작년 Google 트렌드
							조사에서 거의 2 %의 시장 점유율을 차지한 Kotlin입니다.</p>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-10 col-sm-10 col-md-3 col-lg-2 news-img">
						<img src="img/news5.png" alt="..." class="img-fluid">
					</div>
					<div class="col-xs-10 col-sm-10 col-md-7 col-lg-8 caption">
						<a href="https://www.boannews.com/media/view.asp?idx=101419">
							<span id="news-title">게임보다 재미있는 ‘2021 온라인 코딩파티 시즌2’ 개최 </span>
						</a>
						<p>‘온라인 코딩파티’는 2015년부터 매년 2회씩 온라인으로 개최해 오고 있는 대국민 체험 행사로, 누구나
							쉽고 재미있게 소프트웨어와 인공지능이 만들어지는 원리를 게임처럼 체험해 볼 수 있도록 매년 새롭고 다양한 프로그램으로
							구성해 진행한다.</p>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-10 col-sm-10 col-md-3 col-lg-2 news-img">
						<img src="img/news6.png" alt="..." class="img-fluid">
					</div>
					<div class="col-xs-10 col-sm-10 col-md-7 col-lg-8 caption">
						<a
							href="https://www.korea.kr/news/reporterView.do?newsId=148889261">
							<span id="news-title">코딩이 어렵다고? 온라인 코딩파티에 참여해 봐!</span>
						</a>
						<p>실제로 몇 년 전부터 우리 학교를 포함한 많은 대학교들이 소프트웨어 관련 수업을 교양필수 과목으로 지정하고
							있다. 이런 추세에 맞춰 나도 코딩을 배워보고 싶다는 생각을 종종 했었지만, 어려울 것 같다는 부담감 때문인지 쉽사리
							도전해 보지 못했다. 그런데 나처럼 코딩에 문외한인 사람들도 재미있게 코딩을 접하고 배울 수 있는 행사가 진행되고
							있다고 한다. 바로 2021 온라인 코딩파티이다.</p>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-10 col-sm-10 col-md-3 col-lg-2 news-img">
						<img src="img/news7.png" alt="..." class="img-fluid">
					</div>
					<div class="col-xs-10 col-sm-10 col-md-7 col-lg-8 caption">
						<a
							href="https://www.codingworldnews.com/news/articleView.html?idxno=3352">
							<span id="news-title">코딩 vs 프로그래밍, 무엇이 다를까? </span>
						</a>
						<p>코딩은 코드를 작성한다는 뜻이다. 조금 더 쉬운 말로 바꿔보자면, 코딩은 우리가 이해하는 언어에서 컴퓨터가
							이해할 수 있는 언어로 바꾸는 것을 말한다. 코딩의 다른 뜻은 부호화(符號化)로, 주어진 데이터를 컴퓨터가 이해할 수
							있는 형태로 바꾸는 것을 의미한다. 그리고, 프로그래밍은 프로그램을 작성하는 일이라는 뜻이다. 프로그램을 작성하는
							과정에는 설계와 코딩, 에러 수정 등의 단계를 거친다. 다시 말해, 프로그래밍은 프로그램을 작성하는 과정이고, 그
							과정에 코딩이 포함되어 있다.</p>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-10 col-sm-10 col-md-3 col-lg-2 news-img">
						<img src="img/news8.png" alt="..." class="img-fluid">
					</div>
					<div class="col-xs-10 col-sm-10 col-md-7 col-lg-8 caption">
						<a href="https://zdnet.co.kr/view/?no=20210525200310"> <span
							id="news-title">마이크로소프트, 진짜 '입코딩' 시대 열었다 </span></a>
						<p>말만으로 코딩할 수 있는 시대가 열렸다. 영화 아이언맨의 인공지능(AI) 비서 자비스처럼 대화하듯
							애플리케이션을 개발하는 것이다. 마이크로소프트는 인공지능(AI)을 활용해 자연어를 이해하고, 소스코드로 전환하는
							기술을 공개했다. 이 기술을 통해 프로그래밍을 배우지 않은 사람도 개발에 참여하고, 전문개발자도 번거로운 코딩 작업을
							줄여 생산성을 높일 수 있도록 지원한다는 계획이다.</p>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-10 col-sm-10 col-md-3 col-lg-2 news-img">
						<img src="img/news9.png" alt="..." class="img-fluid">
					</div>
					<div class="col-xs-10 col-sm-10 col-md-7 col-lg-8 caption">
						<a href="https://www.bbc.com/korean/features-58511232"> <span
							id="news-title">깃허브 '코파일럿': 인공지능이 개발자를 대체할 수 있을까? </span></a>
						<p>런던에서 일하는 소프트웨어 개발자 재닌 룩(26)은 "코딩을 시작하면 마치 영화 '매트릭스' 주인공처럼
							똑똑해지는 기분이 든다"고 말했다. 홍콩에서 태어난 룩은 프랑스 남부에서 요트 마케팅 일을 시작했지만, 자신의 직업이
							"다소 반복적이고 피상적"이라는 생각이 들었다. 결국 퇴근 후 코딩 공부를 시작했고, 15주간의 코딩 연수 과정을
							이수했다..</p>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-10 col-sm-10 col-md-3 col-lg-2 news-img">
						<img src="img/news10.png" alt="..." class="img-fluid">
					</div>
					<div class="col-xs-10 col-sm-10 col-md-7 col-lg-8 caption">
						<a href="https://www.mk.co.kr/news/world/view/2021/06/538164/">
							<span id="news-title">"IT회사로 옮기면 연봉 2배"…코딩학원마다 '직딩' 북적이는
								호찌민 </span>
						</a>
						<p>베트남 젊은이들 사이에서 '코딩(컴퓨터 프로그래밍) 배우기 열풍'이 불고 있다. 강좌당 수강료가
							200만원을 훌쩍 넘지만 정보기술(IT) 분야로 전직하려는 새내기 직장인들이 줄을 잇고 있다. 호찌민에 위치한 코딩
							교육 업체 코더스쿨(Corderschool)은 설립 5년 만에 졸업생 1500여 명을 배출하면서 이직 시장에 입소문이
							나 있다. 특히 코로나19 팬데믹 기간에 온라인 수업을 개설해 기존보다 10배 많은 수강생을 끌었다. 코더스쿨은
							오프라인 5500만동(약 266만원), 온라인 3500만동(약 169만원)의 수강료를 받는다.</p>
					</div>
				</div> -->
				</div>
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

	<!-- banner section start-->
	<div class="sideBanner">
		<img src="./resources/img/banner.png" alt="배너이미지" srcset="">
	</div>
	<!-- banner section end-->

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