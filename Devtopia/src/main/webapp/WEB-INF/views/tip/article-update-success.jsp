<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- vendor css -->
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">

    <link rel="stylesheet" href="./resources/css/success.css">

    <title>게시글 수정 성공</title>
</head>

<body>
    <div class="success">
        <div class="img-wrapper">
            <img src="./resources/img/logo-dk-2.png" alt="" class="img fluid">
        </div>
        <br>
        <h1>
            게시글 수정 성공!
        </h1>
        <p>
            <span>*</span> 수정전 다시한번 게시물을 확인해주세요!
        </p>
        <button onclick="location.href='pageNationTipArticle.do'">게시판으로</button>
    </div>

        <!-- Vendor JS Files -->
        <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>

        <!-- Devtopia JS -->
        <script src="./resources/js/main.js"></script>
</body>

</html>
