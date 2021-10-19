<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>navbar</title>
</head>
<body>
<!-- nav start -->
    <nav class="sidebar">
        <div class="details">
            <i class="bi bi-justify" id="btn" onclick="menuBtnChange()"></i>
        </div>
        <div class="logo">
            <img src="./resources/img/logo2.png" alt="" class="img fluid" width="90%">
        </div>
        <br>

        <div class="profile">
            <div class="profile-details">
            	<c:choose>
		           <c:when test="${empty sessionScope.userId}">
		                <div class="welcome-text">
                    		<p>뉴비 개발자들의 유토피아
                        		<br>함께 성장 성장해봐요!
                    		</p>
                		</div>
		                <div class="login">
		                    <button id="open" type="button">로그인</button>
		                </div>
		           </c:when>
		           <c:otherwise>
		           		<div class="user-status">
                    		<p><b>${userId }</b>님 반갑습니다!</p>
                		</div>
		           </c:otherwise>
            	</c:choose>
                
                
                <div class="button-wrapper">
                <c:choose>
                		<c:when test="${empty sessionScope.userId}">
		                    <div class="sign-up">
		                        <button onclick="location.href='writeUser.do'"><i id="signup" class=" bi bi-box-arrow-right"></i>
		                            회원가입</button>
		                    </div>
                		</c:when>
                		<c:otherwise>
		                    <div class="member-info">
		                        <button class="member-info-button" onclick="fn_openuserinfoPopup()"><i id="memberinfo"
		                                class="bi bi-person-fill"></i>회원정보</button>
		                    </div>
		                    <div class="member-info">
		                        <button class="member-info-button" onclick="fn_logout()"><i
		                                class="bi bi-person-fill"></i>로그아웃</button>
		                    </div>
                		</c:otherwise>
                	</c:choose>
                </div>
            </div>
        </div>
        <div class="menu-wrapper">
                <div class="menu">
                    <ul>
                       <li><a href="pageNationNewsArticle.do"><i class="bi bi-globe2"></i><span class="links_name">개발자 뉴스</span></a></li>
                        <li><a href="pageNationFreeArticle.do"><i class="bi bi-share"></i><span class="links_name">자유게시판</span></a></li>
                        <li><a href="pageNationTipArticle.do"><i class="bi bi-info-circle"></i><span class="links_name">팁과 노하우</span></a></li>
                        <li><a href="pageNationJobArticle.do"><i class="bi bi-briefcase"></i><span class="links_name">구인 &amp; 구직</span></a></li>
                        <li><a href="pageNationQnaArticle.do"><i class="bi bi-question-circle"></i><span class="links_name">Q &amp; A</span></a></li>
                        <li><a href="https://github.com/shintwelv/MINI_Project_TEAM2" target="_blank"><i class="bi bi-github"></i><span class="links_name">Github</span></a></li>
                    </ul>
                </div>
            </div>
    </nav>
    <!-- nav end-->
    
    <script>
    let sidebar = document.querySelector(".sidebar");
    let closeBtn = document.querySelector("#btn");

    closeBtn.addEventListener("click", () => {
        sidebar.classList.toggle("open");
        menuBtnChange();// 함수 호출
    });

    // 사이드바 변경 스크립트
    function menuBtnChange() {
        if (sidebar.classList.contains("open")) {
            closeBtn.classList.replace("bi-justify", "bi-justify-right");//아이콘 수정
        } else {
            closeBtn.classList.replace("bi-justify-right", "bi-justify");//아이콘 롤백
        }
    }
    
    </script>
</body>
</html>