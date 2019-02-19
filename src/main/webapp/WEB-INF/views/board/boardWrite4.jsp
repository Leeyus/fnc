<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript" src="../resources/SE2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
var oEditors = [];
$(function(){
      nhn.husky.EZCreator.createInIFrame({
          oAppRef: oEditors,
          //testarea의 ID
          elPlaceHolder: "sub_img",
          //SmartEditor2Skin.html 파일이 존재하는 경로
          sSkinURI: "${pageContext.request.contextPath}/resources/SE2/SmartEditor2Skin.html",  
          htParams : {
              // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
              bUseToolbar : true,             
              // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
              bUseVerticalResizer : true,     
              // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
              bUseModeChanger : true,         
              fOnBeforeUnload : function(){
               	   
              }
          }
      });
      nhn.husky.EZCreator.createInIFrame({
          oAppRef: oEditors,
          //testarea의 ID
          elPlaceHolder: "main_img",
          //SmartEditor2Skin.html 파일이 존재하는 경로
          sSkinURI: "${pageContext.request.contextPath}/resources/SE2/SmartEditor2Skin.html",  
          htParams : {
              // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
              bUseToolbar : true,             
              // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
              bUseVerticalResizer : true,     
              // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
              bUseModeChanger : true,         
              fOnBeforeUnload : function(){
               	   
              }
          }
      });
     
      nhn.husky.EZCreator.createInIFrame({
          oAppRef: oEditors,
          //testarea의 ID
          elPlaceHolder: "contents",
          //SmartEditor2Skin.html 파일이 존재하는 경로
          sSkinURI: "${pageContext.request.contextPath}/resources/SE2/SmartEditor2Skin.html",  
          htParams : {
              // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
              bUseToolbar : true,             
              // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
              bUseVerticalResizer : true,     
              // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
              bUseModeChanger : true,         
              fOnBeforeUnload : function(){
               	   
              }
          }
      });
      nhn.husky.EZCreator.createInIFrame({
          oAppRef: oEditors,
          //testarea의 ID
          elPlaceHolder: "sub_contents",
          //SmartEditor2Skin.html 파일이 존재하는 경로
          sSkinURI: "${pageContext.request.contextPath}/resources/SE2/SmartEditor2Skin.html",  
          htParams : {
              // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
              bUseToolbar : true,             
              // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
              bUseVerticalResizer : true,     
              // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
              bUseModeChanger : true,         
              fOnBeforeUnload : function(){
               	   
              }
          }
      });
      
      
      
      //저장버튼 클릭시 form 전송
      $("#save").click(function(){
          oEditors.getById["sub_img"].exec("UPDATE_CONTENTS_FIELD", []);
          oEditors.getById["main_img"].exec("UPDATE_CONTENTS_FIELD", []);
          oEditors.getById["contents"].exec("UPDATE_CONTENTS_FIELD", []);
          oEditors.getById["sub_contents"].exec("UPDATE_CONTENTS_FIELD", []);
          $("#frm").submit();
      });    
});



</script>
</head>
<body>
	<h1>${board} Write</h1>
	
	<form action="./${board}Write" method="post" enctype="multipart/form-data" id="frm">
		
		<textarea name="sub_img" id="sub_img" rows="" cols=""></textarea>
		
		<textarea name="main_img" id="main_img" rows="" cols=""></textarea>
		
		<input type="text" name="subject">
		<input type="text" value="${member.name }" name="writer">
		<textarea name="contents" id="contents" rows="" cols=""></textarea>
		<textarea name="sub_contents" id="sub_contents" rows="" cols=""></textarea>
			
		
		<input type="button" id="save" value="WRITE">
	</form>
	<a href="./${board }List">list</a>
	

<script type="text/javascript" src="../resources/js/fileAdd.js"></script>

</body>
</html>