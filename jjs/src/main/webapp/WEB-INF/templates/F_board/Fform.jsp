<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.js" ></script>
<script type="text/javascript">
   function F_insert() {
      var Id = $('#userId').val();
      var title = $('#FTitle').val();
      var content = $('#FContent').val();
      var boardtype = $('#FBoardType').val();
       
      if (title == "") {
         alert("제목을 입력해주세요.");
         return false;
      }
      else if (content == "") {
         alert("내용을 입력해주세요.");
         return false;
      }
      else {
      $.ajax({
         url:'FboardSuccess.do',
         type:'GET',
         data:{
            FTitle:title,
            FContent:content,
            FBoardType:boardtype
         },         
         datatype:'JSON',
         
         success: function(data) {
            alert("게시글이 등록 되었습니다.");
            location = "Flist.do"
            
         }
         
      });
   }
}
</script>
<title>자유게시판</title>
</head>
<body>
<div id="con">
     <div id="login">
        <div id="login_form">
 
<br><br>
    <div class="container">
        <div class="page-header" text-align="left" style="color: #FDF5DC; font-size: 50px; text-align:left;">
              게시글 등록
        </div>
        <br/>
        <input id="userId" value="${FBoard.userId}" type="hidden" />
        <input id="FCreateDate" type="hidden" />
        <table class="table">
            <tr>
                <th style="padding:13px 0 0 15px; color: #FDF5DC; font-size: 17px;">게시판 선택</th>
                <td>
                    <div class="pull-left">
                        <select class="form-control input-sm" id="FBoardType">
                            <option>--분류--</option>
                            <option value="공지사항" selected="${FBoard.FBoardType == '공지사항'}">공지사항</option>                         
                            <option value="자유게시판" selected="${FBoard.FBoardType == '자유게시판'}">자유게시판</option>
                        </select>
                    </div>
                </td>
            </tr>            
            <tr>
                <th style="padding:13px 0 0 15px; color: #FDF5DC; font-size: 17px;">제목</th>
                <td><input id="FTitle" type="text" class="col-md-1 form-control input-sm" required="required" placeholder="제목을 입력하세요"/></td>
            </tr>
            <tr>
                <th style="padding:13px 0 0 15px; color: #FDF5DC; font-size: 17px;">내용</th>
                <td><textarea id="FContent" class="col-md-1 form-control input-sm" maxlength="140" rows="7" style="height: 200px;" required="required" placeholder="내용을 입력하세요"></textarea><span class="help-block"></span>
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
            <input type="button" class="btn2" id="insert" onclick="F_insert()" value="저장 " />
        </div>
    </div>
   </div>
   </div>
   </div>
</body>
</html>