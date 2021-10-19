<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- faviico -->
    <link rel="shortcut icon" href="./resources/img/favicon.ico" type="image/x-icon">

    <!-- vendor css -->
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">

    <link rel="stylesheet" href="./css/success.css">

    <title>로그인 성공</title>
</head>

<body>
    <div class="success" data-aos="fade-up"> 
        <div class="img-wrapper">
            <img src="./resources/img/logo-dk-2.png" alt="" class="img fluid">
        </div>
        <br>
        <h1>
            로그인 성공!
        </h1>
        <p>
            데브토피아에 돌아오셨군요!
        </p>
        <button onclick="location.href='goMain.do'">홈으로</button>
    </div>

    <!-- Vendor JS Files -->
    <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>

    <!-- Devtopia JS -->
    <script src="./resources/js/main.js"></script>
</body>

</html>