<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jjs.service.L_BoardVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
function L_update() {
    var Id = $('#userId').val();
    var boardNo = $('#LBoardNo').val();
    var boardtype = $('#LBoardType').val();
    var title = $('#LTitle').val();
    var content = $('#LContent').val();
    
    $.ajax({
       url:'LboardUpdate.do',
       type:'GET',
       data:{
          userId:Id,
          LBoardNo:boardNo,
          LBoardType:boardtype,
          LTitle:title,
          LContent:content
       },
       datatype:'JSON',
       
       success: function(data) {
          if(data == "fail") {
             alert("게시글 수정권한이 없습니다.");
          } else if(data == "success") {
             alert("게시글이 수정 되었습니다.");
             location = "Llist.do"
          }
          
       }
    });
    }
 
 function L_deleteb() {
    var boardNo = $('#LBoardNo').val(); 
    var Id = $('#userId').val();
    
    $.ajax({
       url:'LboardDelete.do',
       type:'GET',
       data:{
          LBoardNo:boardNo,
          userId:Id 
       },
       datatype:'JSON',
       
       success: function(data) {
          if(data =="fail") {
             alert("게시글 삭제권한이 없습니다.");
          } else if(data == "success") {
             alert("게시글이 삭제 되었습니다.");
             location = "Llist.do"
          }
          
       }
    });
    }
</script>
<title>자유게시판</title>
<body>
<div id="con">
      <div id="login">
         <div id="login_form">
<br><br><br>
    <div class="container">
        <div class="page-header"  style="color: #FDF5DC; font-size: 50px; text-align:left;">
             게시글 보기
        <br>
        </div>
        <br/>
        <input id="userId" value="${LBoard.userId}" type="hidden" />
        <input id="LBoardNo" value="${LBoard.LBoardNo}" type="hidden" />
        <input id="LCreateDate" type="hidden" />
        <table class="table">
            <tr>
                <th style="padding:13px 0 0 15px; color: #FDF5DC; font-size: 17px;" >게시판 선택</th>
                <td>
                    <div class="pull-left">     
                  <select class="form-control input-sm" id="LBoardType" >
                     <option>--분류--</option>
                     <option value="공지사항" selected="${LBoard.LBoardType == '공지사항'}">공지사항</option>
                     <option value="자유게시판" selected="${LBoard.LBoardType == '자유게시판'}">자유게시판</option>
                  </select>       
                    </div>
                </td>
            </tr>            
            <tr>
                <th style="padding:13px 0 0 15px; color: #FDF5DC; font-size: 17px;">제목</th>
                <td><input id="L_Title" type="text" class="col-md-1 form-control input-sm" value="${LBoard.LTitle}" /></td>
                <th style="padding:13px 0 0 15px; color: #FDF5DC; font-size: 17px;">제목</th>
                <td><input id="L_Title" type="text" class="col-md-1 form-control input-sm" value="${LBoard.LTitle}" readonly/></td>            
            </tr>
            <tr>
                <th style="padding:13px 0 0 15px; color: #FDF5DC; font-size: 17px;">내용</th>
                <td><textarea id="L_Content" class="col-md-1 form-control input-sm" maxlength="140" rows="7" style="height: 200px;">${L_Board.L_Content}</textarea><span class="help-block"></span>
                </td>
               <th style="padding:13px 0 0 15px; color: #FDF5DC; font-size: 17px;">내용</th>
                <td><textarea id="L_Content" class="col-md-1 form-control input-sm" maxlength="140" rows="7" style="height: 200px;"readonly>${L_Board.L_Content}</textarea><span class="help-block"></span>
            </tr>
            <tr>
                <td></td>
                <td></td>
            </tr>
        </table>       
        <div class="pull-left">
            <button type="submit" onclick="location.href='L_list.do'" class="btn2">목록으로</button>         
        </div>
        <div class="pull-right">
            <input type="button" class="btn2" id="update" onclick="L_update()" value="수정" />
            <input type="button" class="btn2" id="delete" onclick="L_deleteb()" value="삭제" />
        </div> 
    </div>
</div>
</div>
</div> 
</body>
</html>