<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	$(function() {
		$("#save").click(function() {
			$("#frm").submit();
		});
	});
</script>
</head>
<body>
	<h1>${board} Write</h1>
	
	<form action="./${board}Write" method="post" id="frm">
		<input type="text" name="subject">
		<input type="text" value="${member.name }" name="writer">
		<textarea name="contents" id="contents" rows="" cols=""></textarea>
		
		<input type="button" id="save" value="WRITE">
	</form>
	<a href="./${board }List">list</a>
	

</body>
</html>