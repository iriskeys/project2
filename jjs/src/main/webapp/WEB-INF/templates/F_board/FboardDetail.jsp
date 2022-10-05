<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jjs.service.F_BoardVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
function F_update() {
    var Id = $('#userId').val();
    var boardNo = $('#FBoardNo').val();
    var boardtype = $('#FBoardType').val();
    var title = $('#FTitle').val();
    var content = $('#FContent').val();
    
    $.ajax({
       url:'FboardUpdate.do',
       type:'GET',
       data:{
          userId:Id,
          FBoardNo:boardNo,
          FBoardType:boardtype,
          FTitle:title,
          FContent:content
       },
       datatype:'JSON',
       
       success: function(data) {
          if(data == "fail") {
             alert("게시글 수정권한이 없습니다.");
          } else if(data == "success") {
             alert("게시글이 수정 되었습니다.");
             location = "Flist.do"
          }
          
       }
    });
    }
 
 function F_deleteb() {
    var boardNo = $('#FBoardNo').val(); 
    var Id = $('#userId').val();
    
    $.ajax({
       url:'FboardDelete.do',
       type:'GET',
       data:{
          FBoardNo:boardNo,
          userId:Id 
       },
       datatype:'JSON',
       
       success: function(data) {
          if(data =="fail") {
             alert("게시글 삭제권한이 없습니다.");
          } else if(data == "success") {
             alert("게시글이 삭제 되었습니다.");
             location = "Flist.do"
          }
          
       }
    });
    }
</script>
<title>게시글보기</title>
<body>
<jsp:include page="/WEB-INF/templates/header.jsp"></jsp:include>
<div id="con">
      <div id="login">
         <div id="login_form">
<br><br><br>
    <div class="container">
        <div class="page-header"  style="color: #000000; font-size: 50px; text-align:left;">
             게시글 보기
        <br>
        </div>
        <br/>
        <input id="userId" value="${FBoard.userId}" type="hidden" />
        <input id="FBoardNo" value="${FBoard.FBoardNo}" type="hidden" />
        <input id="FCreateDate" type="hidden" />
        <table class="table">
            <tr>
                <th style="padding:13px 0 0 15px; color: #000000; font-size: 17px;" >게시판 선택</th>
                <td>
                    <div class="pull-left">     
                  <select class="form-control input-sm" id="FBoardType" >
                     <option>--분류--</option>
                     <option value="공지사항" selected="${FBoard.FBoardType == '공지사항'}">공지사항</option>
                     <option value="자유게시판" selected="${FBoard.FBoardType == '자유게시판'}">자유게시판</option>
                  </select>       
                    </div>
                </td>
            </tr>            
            <tr>
                <th style="padding:13px 0 0 15px; color: #000000; font-size: 17px;">제목</th>
                <td><input id="FTitle" type="text" class="col-md-1 form-control input-sm" value="${FBoard.FTitle}" /></td>            
            </tr>
            <tr>
                <th style="padding:13px 0 0 15px; color: #000000; font-size: 17px;">내용</th>
                <td><textarea id="FContent" class="col-md-1 form-control input-sm" maxlength="140" rows="7" style="height: 200px;">${FBoard.FContent}</textarea><span class="help-block"></span>
                </td>
            </tr>
            <tr>
                <td></td>
                <td></td>
            </tr>
        </table>       
        <div class="pull-left">
            <button type="submit" onclick="location.href='Flist.do'" class="btn2">목록으로</button>         
        </div>
        <div class="pull-right">
            <input type="button" class="btn2" id="update" onclick="F_update()" value="수정" />
            <input type="button" class="btn2" id="delete" onclick="F_deleteb()" value="삭제" />
        </div> 
    </div>
</div>
</div>
</div> 
</body>
</html>