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

    <title>Devtopiaㅣ개발자들의 유토피아</title>
</head>

<body>
<jsp:include page="./common/navBar.jsp"></jsp:include>

    <section class="main-contents">
        <div class="main-img-wrapper">
            <img src="./resources/img/main-them.png" alt="main-img" class="img-fluid animated">
        </div>
        <div class="table-wrapper">
            <table class="table" data-aos="fade-left" data-aos-delay=400>
                <thead>
                        <div class="table-head">
                            <div class="board-title" data-aos="fade-right" data-aos-delay=400>
                                <H1><a href="pageNationNewsArticle.do"><i class="bi bi-globe2"></i> 개발자 뉴스</a>
                                </H1>
                            </div>
                            <div class="board-list" data-aos="fade-left" data-aos-delay=400>
                                <a href="pageNationNewsArticle.do">
                                    <span><i class="bi bi-plus-lg"></i></span>
                                </a>
                            </div>
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
            <table class="table" data-aos="fade-right" data-aos-delay=400>
                <thead>
                    <div class="table-head">
                        <div class="board-title" data-aos="fade-right" data-aos-delay=400>
                            <H3><a href="pageNationFreeArticle.do"><i class="bi bi-share"></i> 자유게시판</a>
                            </H3>
                        </div>
                        <div class="board-list" data-aos="fade-right" data-aos-delay=400><a
                                href="board-free.html"><span><i class="bi bi-plus-lg"></i></span></a></div>
                    </div>
                    <tr>
                        <th scope="col"> </th>
                        <th scope="col"> </th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <a href="./board-news.html">
                            <td>AI가 나 대신 코딩을 ? 깃헙 'Copilot'을 사용 해 봤다!</td>
                            <td id="writer">servelt1004</td>
                        </a>
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
            <table class="table" data-aos="fade-left" data-aos-delay=400>
                <thead>
                    <div class="table-head">
                        <div class="board-title" data-aos="fade-left" data-aos-delay=400>
                            <H3><a href="pageNationTipArticle.do"><i class="bi bi-info-circle"></i> 팁과
                                    노하우</a></H3>
                        </div>
                        <div class="board-list" data-aos="fade-left" data-aos-delay=400><a
                                href="pageNationTipArticle.do"><span><i class="bi bi-plus-lg"></i></span></a></div>
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
    </section>

    <footer class="footer-contents">
        <h1><img src="./resources/img/font-logo.png" alt="" class="img-fluid"><a href=""></a></h1>
    </footer>

<jsp:include page="./common/loginModal.jsp"></jsp:include>

    <!-- Vendor JS Files -->
    <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
    <script src="./resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- main JS Files -->
    <script src="./resources/js/main.js"></script>
    <script src="./resources/js/banner.js"></script>

</body>

</html>