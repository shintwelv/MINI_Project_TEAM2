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
    <link rel="stylesheet" href="vendor/isotope-layout/">


    <!-- Devtopia css -->
    <link rel="stylesheet" href="css/board-news.css">

    <title>개발자 뉴스</title>
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


<div class="board-news-wrapper">
    <div class="board-title-wrapper">
        <div class="board-title">
            <h3><i class="bi bi-globe2"></i> 개발자 뉴스</h3>
        </div>
    </div>
    <div class="main-content">
      <div class="container"> 
        <div class="row">
                <div class="col-xs-10 col-sm-10 col-md-3 col-lg-2 news-img">
                   <img src="img/test2.png" alt="..." class="img-fluid">
                </div>
                <div class="col-xs-10 col-sm-10 col-md-7 col-lg-8 caption">
                    <span id="news-title">개발자 이대로 괜찮은가 </span>
                    <p>2K와 HB 스튜디오(HB Studios)는 PGA TOUR 2K21의 새로운 ‘볼러(Baller) 에디션’을 출시했다고 밝혔다. PGA TOUR 2K21 볼러 에디션은 기본 게임을 비롯해 이전에 출시된 모든 DLC 코스 및 게임 모드, 클럽하우스 패스 시즌 1에서 선보인 다양한 인기 아이템, 홀리데이 아이템, 신규 퍼터, 황금 퍼터와 드라이버가 담긴 황금...</p>
                </div>
        </div>
        <div class="row">
          <div class="col-xs-10 col-sm-10 col-md-3 col-lg-2 news-img">
             <img src="img/test2.png" alt="..." class="img-fluid">
          </div>
          <div class="col-xs-10 col-sm-10 col-md-7 col-lg-8 caption">
              <span id="news-title">개발자 이대로 괜찮은가 </span>
              <p>2K와 HB 스튜디오(HB Studios)는 PGA TOUR 2K21의 새로운 ‘볼러(Baller) 에디션’을 출시했다고 밝혔다. PGA TOUR 2K21 볼러 에디션은 기본 게임을 비롯해 이전에 출시된 모든 DLC 코스 및 게임 모드, 클럽하우스 패스 시즌 1에서 선보인 다양한 인기 아이템, 홀리데이 아이템, 신규 퍼터, 황금 퍼터와 드라이버가 담긴 황금...</p>
          </div>
        </div>
        <div class="row">
          <div class="col-xs-10 col-sm-10 col-md-3 col-lg-2 news-img">
             <img src="img/test2.png" alt="..." class="img-fluid">
          </div>
          <div class="col-xs-10 col-sm-10 col-md-7 col-lg-8 caption">
              <span id="news-title">개발자 이대로 괜찮은가 </span>
              <p>2K와 HB 스튜디오(HB Studios)는 PGA TOUR 2K21의 새로운 ‘볼러(Baller) 에디션’을 출시했다고 밝혔다. PGA TOUR 2K21 볼러 에디션은 기본 게임을 비롯해 이전에 출시된 모든 DLC 코스 및 게임 모드, 클럽하우스 패스 시즌 1에서 선보인 다양한 인기 아이템, 홀리데이 아이템, 신규 퍼터, 황금 퍼터와 드라이버가 담긴 황금...</p>
          </div>
        </div>
        <div class="row">
          <div class="col-xs-10 col-sm-10 col-md-3 col-lg-2 news-img">
             <img src="img/test2.png" alt="..." class="img-fluid">
          </div>
          <div class="col-xs-10 col-sm-10 col-md-7 col-lg-8 caption">
              <span id="news-title">개발자 이대로 괜찮은가 </span>
              <p>2K와 HB 스튜디오(HB Studios)는 PGA TOUR 2K21의 새로운 ‘볼러(Baller) 에디션’을 출시했다고 밝혔다. PGA TOUR 2K21 볼러 에디션은 기본 게임을 비롯해 이전에 출시된 모든 DLC 코스 및 게임 모드, 클럽하우스 패스 시즌 1에서 선보인 다양한 인기 아이템, 홀리데이 아이템, 신규 퍼터, 황금 퍼터와 드라이버가 담긴 황금...</p>
          </div>
        </div>
        <div class="row">
          <div class="col-xs-10 col-sm-10 col-md-3 col-lg-2 news-img">
             <img src="img/test2.png" alt="..." class="img-fluid">
          </div>
          <div class="col-xs-10 col-sm-10 col-md-7 col-lg-8 caption">
              <span id="news-title">개발자 이대로 괜찮은가 </span>
              <p>2K와 HB 스튜디오(HB Studios)는 PGA TOUR 2K21의 새로운 ‘볼러(Baller) 에디션’을 출시했다고 밝혔다. PGA TOUR 2K21 볼러 에디션은 기본 게임을 비롯해 이전에 출시된 모든 DLC 코스 및 게임 모드, 클럽하우스 패스 시즌 1에서 선보인 다양한 인기 아이템, 홀리데이 아이템, 신규 퍼터, 황금 퍼터와 드라이버가 담긴 황금...</p>
          </div>
        </div>
        <div class="row">
          <div class="col-xs-10 col-sm-10 col-md-3 col-lg-2 news-img">
             <img src="img/test2.png" alt="..." class="img-fluid">
          </div>
          <div class="col-xs-10 col-sm-10 col-md-7 col-lg-8 caption">
              <span id="news-title">개발자 이대로 괜찮은가 </span>
              <p>2K와 HB 스튜디오(HB Studios)는 PGA TOUR 2K21의 새로운 ‘볼러(Baller) 에디션’을 출시했다고 밝혔다. PGA TOUR 2K21 볼러 에디션은 기본 게임을 비롯해 이전에 출시된 모든 DLC 코스 및 게임 모드, 클럽하우스 패스 시즌 1에서 선보인 다양한 인기 아이템, 홀리데이 아이템, 신규 퍼터, 황금 퍼터와 드라이버가 담긴 황금...</p>
          </div>
        </div>
        <div class="row">
          <div class="col-xs-10 col-sm-10 col-md-3 col-lg-2 news-img">
             <img src="img/test2.png" alt="..." class="img-fluid">
          </div>
          <div class="col-xs-10 col-sm-10 col-md-7 col-lg-8 caption">
              <span id="news-title">개발자 이대로 괜찮은가 </span>
              <p>2K와 HB 스튜디오(HB Studios)는 PGA TOUR 2K21의 새로운 ‘볼러(Baller) 에디션’을 출시했다고 밝혔다. PGA TOUR 2K21 볼러 에디션은 기본 게임을 비롯해 이전에 출시된 모든 DLC 코스 및 게임 모드, 클럽하우스 패스 시즌 1에서 선보인 다양한 인기 아이템, 홀리데이 아이템, 신규 퍼터, 황금 퍼터와 드라이버가 담긴 황금...</p>
          </div>
        </div>
        <div class="row">
          <div class="col-xs-10 col-sm-10 col-md-3 col-lg-2 news-img">
             <img src="img/test2.png" alt="..." class="img-fluid">
          </div>
          <div class="col-xs-10 col-sm-10 col-md-7 col-lg-8 caption">
              <span id="news-title">개발자 이대로 괜찮은가 </span>
              <p>2K와 HB 스튜디오(HB Studios)는 PGA TOUR 2K21의 새로운 ‘볼러(Baller) 에디션’을 출시했다고 밝혔다. PGA TOUR 2K21 볼러 에디션은 기본 게임을 비롯해 이전에 출시된 모든 DLC 코스 및 게임 모드, 클럽하우스 패스 시즌 1에서 선보인 다양한 인기 아이템, 홀리데이 아이템, 신규 퍼터, 황금 퍼터와 드라이버가 담긴 황금...</p>
          </div>
        </div>
        <div class="row">
          <div class="col-xs-10 col-sm-10 col-md-3 col-lg-2 news-img">
             <img src="img/test2.png" alt="..." class="img-fluid">
          </div>
          <div class="col-xs-10 col-sm-10 col-md-7 col-lg-8 caption">
              <span id="news-title">개발자 이대로 괜찮은가 </span>
              <p>2K와 HB 스튜디오(HB Studios)는 PGA TOUR 2K21의 새로운 ‘볼러(Baller) 에디션’을 출시했다고 밝혔다. PGA TOUR 2K21 볼러 에디션은 기본 게임을 비롯해 이전에 출시된 모든 DLC 코스 및 게임 모드, 클럽하우스 패스 시즌 1에서 선보인 다양한 인기 아이템, 홀리데이 아이템, 신규 퍼터, 황금 퍼터와 드라이버가 담긴 황금...</p>
          </div>
        </div>
        <div class="row">
          <div class="col-xs-10 col-sm-10 col-md-3 col-lg-2 news-img">
             <img src="img/test2.png" alt="..." class="img-fluid">
          </div>
          <div class="col-xs-10 col-sm-10 col-md-7 col-lg-8 caption">
              <span id="news-title">개발자 이대로 괜찮은가 </span>
              <p>2K와 HB 스튜디오(HB Studios)는 PGA TOUR 2K21의 새로운 ‘볼러(Baller) 에디션’을 출시했다고 밝혔다. PGA TOUR 2K21 볼러 에디션은 기본 게임을 비롯해 이전에 출시된 모든 DLC 코스 및 게임 모드, 클럽하우스 패스 시즌 1에서 선보인 다양한 인기 아이템, 홀리데이 아이템, 신규 퍼터, 황금 퍼터와 드라이버가 담긴 황금...</p>
          </div>
        </div>
        
        
    </div> <!-- container 끝 -->
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
<section class="banner-place-wrapper">
    <div class="banner-place">
        <img id="banner" src="img/banner.png" alt="배너이미지">
    </div>
</section>
</body>

</html>