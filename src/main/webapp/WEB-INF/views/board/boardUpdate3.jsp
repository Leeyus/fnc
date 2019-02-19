<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="../resources/SE2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript">
	$(function() {
		var oEditors = [];
		$(function(){
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
		          oEditors.getById["contents"].exec("UPDATE_CONTENTS_FIELD", []);
		          oEditors.getById["sub_contents"].exec("UPDATE_CONTENTS_FIELD", []);
		          $("#frm").submit();
		      });    
		});
		
		
		
		
		$(".files").click(function() {
			var id=$(this).attr("id");
			var del=$(this).attr("title");
			$.ajax({
				url:"../file/delete",
				type:"GET",
				data:{
					fnum:id
				},
				success:function(data){
					data=data.trim();
					if(data==1){
						$("#"+del).remove();
						count--;
					}else {
						alert("File Delete Fail");
					}
				}
			});
		});
	});
</script>
<style type="text/css">
	.files, .del{
		color:red;
		cursor: pointer;
	}
	#f{
		display: none;
	}
</style>
</head>
<body>
	<h1>${board} Update</h1>
	
	<form action="./${board}Update" method="post" enctype="multipart/form-data" id="frm">
		<input type="hidden" name="num" value="${dto.num}">
		<textarea name="sub_img" id="sub_img" rows="" cols="">${dto.sub_img }</textarea>
		<input type="text" name="subject" value="${dto.subject}">
		<input type="text" name="writer" value="${dto.writer}">
		<textarea name="contents" id="contents" rows="" cols="">${dto.contents}</textarea>
		<textarea name="sub_contents" id="sub_contents" rows="" cols="">${dto.sub_contents}</textarea>
			
		
		
		<input type="button" id="save" value="WRITE">
	</form>
	<a href="${board}Select?num=${dto.num}">취소</a>
<script type="text/javascript" src="../resources/js/fileAdd.js"></script>
<script type="text/javascript">
	count=${dto.files.size()};
</script>
</body>
</html>