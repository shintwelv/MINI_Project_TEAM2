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
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
    <link rel="stylesheet" href="./resources/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="./resources/vendor/bootstrap-icon/bootstrap-icons.css">
    <link rel="stylesheet" href="./resources/vendor/isotope-layout/">

    <!-- Devtopia css -->
    <link rel="stylesheet" href="./resources/css/popup.css">
    <title>회원가입</title>
</head>

<body>
    <div class="container" style="margin-top: 25px;">
        <div id="memberSearchDiv" class="text-center">

            <form id="searchForm" name="searchForm" method="post" class="navbar-form navbar-left" role="search"
                onsubmit="event.preventDefault();">
                <input type="hidden" name="currentPage" value="1" /> <input type="hidden" name="countPerPage"
                    value="100" /> <input type="hidden" name="resultType" value="json" /> <input type="hidden"
                    id="confmKey" name="confmKey" value="devU01TX0FVVEgyMDIxMTAwMTE1MjIzNDExMTcxMDQ=" />

                <div class="form-group">
                    <input type="text" id="keyword" name="keyword" class="adderss-insert"
                        placeholder="도로명 + 건물번호, 건물명, 지번을 입력하세요." onkeypress="javascript:enterSearch();" />
                </div>
                <br>
                <button type="button" class="search-btn" onclick="javascript:fn_search();">검색</button>
            </form>
            <h2>tip</h2>
            <p>아래와 같은 조합으로 검색을 하시면 더욱더 정확한 결과가 검색 됩니다.
                <br>도로명 + 건물번호
                <br><span id="example">예) 판교역로 235, 제주 첨단로 452</span>
                <br>지역명(동/리) + 번지
                <br><span id="example">예) 삼평동 681, 제주 양평동 2181</span>
            </p>
        </div>

        <div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>주소</th>
                        <th>우편번호</th>
                    </tr>
                </thead>
                <tbody id="addressTableTbody">

                </tbody>
            </table>
        </div>
    </div>

    <!-- Vendor JS Files -->
    <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
    <script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="/vendor/isotope-layout/isotope.pkgd.js"></script>


    <!-- Devtopia JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="./resources/js/main.js"></script>



</body>

</html>