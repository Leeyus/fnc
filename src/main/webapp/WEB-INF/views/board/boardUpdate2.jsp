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
		$("#save").click(function() {
			$("#frm").submit();
		});
	});
</script>
</head>
<body>
	<h1>${board} Update</h1>
	
	<form action="./${board}Update" method="post" id="frm">
		<input type="hidden" name="num" value="${dto.num}">
		<input type="text" name="subject" value="${dto.subject}">
		<input type="text" name="writer" value="${dto.writer}">
		<textarea name="contents" id="contents" style="width: 300px;height: 400px;">${dto.contents}</textarea>
		
			
		
		
		<input type="button" id="save" value="WRITE">
	</form>
	<a href="${board}Select?num=${dto.num}">취소</a>

</body>
</html>