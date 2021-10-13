<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>

<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Pagenation test</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <style>
        .paginationNum,
        .paginationArrow {
            list-style-type: none;
            float: left;
            margin-left: 5px;
        }

        table {
            width: 100%;
            text-align: center;
        }
    </style>
    <script>
         $(".paginationNum").on("click", function () {
        	var pageNum = $(this).html();
            console.log("HHH:" + pageNum);
        })

        $(".paginationArrow").on("click", function () {
            var direction = $(this).find("span").html();
            var operator = "+";
            if (direction === "«") {
                operator = "-";
            }
            pageNum = eval(pageNum + operator + 1);
            if (pageNum < 0) {
                pageNum = 0;
            } else if (pageNum > 3) {
                pageNum = 3;
            }
            changeArticle(pageNum);
        })

        function changeArticle() {
        	pageNum = $(this).attr("value");
        	console.log("pageNum : " + pageNum);
            /* return "pageNationArticle.do?pageNum="+pageNum; */
        }
    </script>
</head>

<body>
	<a href="goMain.do">[Main]</a>
	<hr>
    <table>
        <tr>
            <th>POSTNO</th>
            <th>WRITER</th>
            <th>TITLE</th>
            <th>CONTENT</th>
            <th>WRITEDATE</th>
            <th>VIEWCOUNT</th>
        </tr>
       <c:forEach items="${ArticleList }" var="Article">
        <tr>
            <td>${Article.postNo}</td>
            <td>${Article.writer}</td>
            <td>${Article.title}</td>
            <td>${Article.content}</td>
            <td>${Article.writeDate}</td>
            <td>${Article.viewCount}</td>
        </tr>
       </c:forEach>
    </table>
    <hr>
    <ul class="pagination">
        <li class="paginationArrow">
            <a href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <li class="paginationNum"><button type="submit">1</button></li>
        <li class="paginationNum"><button type="submit">2</button></li>
        <li class="paginationNum"><button type="submit">3</button></li>
        <li class="paginationNum"><button type="submit">4</button></li>
        <li class="paginationNum"><button type="submit">5</button></li>
        <!-- <li class="paginationNum"><a href="#">5</a></li> -->
        <li class="paginationArrow">
            <a href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</body>

</html>