<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.slim.js" integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY=" crossorigin="anonymous"></script>
<script type="text/javascript">
function fn_prev(page,range,rangeSize,listSize,searchType,keyword) {
   var page = ((range - 2)*rangeSize)+1;
   var range = range -1;
   
   var url = "/jjs/L_list.do";
   url += "?page="+page;
   url += "&range=" + range;
   url += "&listSize=" + listSize;
   url += "&searchType=" + searchType;
   url += "&keyword=" + keyword;
   location.href=url;
}

function fn_pagination(page, range, rangeSize, listSize, searchType, keyword) {
   var url = "/jjs/L_list.do";
   url += "?page=" + page;
   url += "&range=" + range;
   url += "&listSize=" + listSize;
   url += "&searchType=" + searchType;
   url += "&keyword=" + keyword;
   location.href=url;
}

function fn_next(page, range, rangeSize, listSize, searchType, keyword){
   var page = parseInt((range * rangeSize)) +1;
   var range = parseInt(range) +1;
   var url = "/jjs/L_list.do";
   url += "?page=" + page;
   url += "&range=" + range;
   url += "&listSize=" + listSize;
   url += "&searchType=" + searchType;
   url += "&keyword=" + keyword;
   location.href = url;
}

$(document).on('click','#btnSearch',function(e){
   e.preventDefault();
   var url = "/jjs/L_list.do";
   url += "?searchType=" + $('#searchType').val();
   url += "&keyword=" + $('#keyword').val();
   location.href = url;
   console.log(url);
});
</script>
<title>자유게시판 리스트</title>
</head>
<body>
<div id="con">
      <div id="login">
         <div id="login_form">
<br><br>
<div class="container">
<br><br>
   <div class="page-header" style="color: #FDF5DC; font-size: 50px; text-align:left;">
      <h1>게시판</h1>
   </div>
   <br/>
   <div id="mainHide">
      <table class="table table-hover"  id="table">
         <thead style="background-color:#fff7c4">
            <tr>
               <th scope="col">글번호</th>
               <th scope="col">게시판 종류</th>
               <th scope="col">제목</th>
               <th scope="col">작성자</th>
               <th scope="col">작성일</th>
            </tr>
         </thead>
         <c:forEach var="L_Board" items="${L_list}">
            <tr>
               <td>${L_Board.F_BoardNo}</td>
               <td>${L_Board.F_BoardType}</td>
               <td><a href="L_boardDetail.do?L_BoardNo=${L_Board.L_BoardNo}" >${L_Board.L_Title}</a></td>
               <td>${L_Board.userId}</td>
               <td>${L_Board.L_CreateDate}</td>
            </tr>
         </c:forEach>
      </table>
            
   </div>
   <div class="pull-right" style="width: 100px; margin: 10px 0;">
      <input type="button" onclick="location.href='Lboardinsertform.do'" value="등록" class="btn5"></input> 
   </div>
   <br/>
   <br/>
   <br/>
   <!--페이징 처리  -->
   <div id="paginationBox" class="pagination1">
      <ul class="pagination" style="text-align: center;">
         <c:if test="${pagination.prev}">
            <li class="page-item"><a class="page-link" href="#" onclick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}', '${pagination.listSize}','${search.searchType}', '${search.keyword}')">이전</a></li>
         </c:if>
         <c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="L_BoardNo">
            <li class="page-item">
            <a class="page-link" href="#" onclick="fn_pagination('${L_BoardNo}', '${pagination.range}', '${pagination.rangeSize}', '${pagination.listSize}', '${search.searchType}', '${search.keyword}')">${L_BoardNo }</a></li>
         </c:forEach>
         <c:if test="${pagination.next}">
            <li class="page-item"><a class="page-link" href="#" onclick="fn_next('${pagination.range}', '${pagination.range}', '${pagination.rangeSize}', '${pagination.listSize}', '${search.searchType}', '${search.keyword}')">다음</a></li>
         </c:if>
      </ul>
   </div>
   <br/>
      <!--검색기능  -->
   <div class="big-width2" style="text-align: center">
         <select  name="searchType" id="searchType" >
            <option value="fullSearch">전체 검색</option>
            <option value="L_Title">제목 </option>
            <option value="L_Content">내용 </option>
            <option value="userId">작성자 </option>
         </select>
         <input  type="text" name="keyword" id="keyword" >
         <button type="submit" class="btn6" name="btnSearch" id="btnSearch" >검색</button>
   </div>
   <br/>
</div>
</body>
</html>