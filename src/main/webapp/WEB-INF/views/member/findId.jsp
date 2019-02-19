<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		$("#findId").click(function() {
			alert("${member}");
			$(".findId").submit();
		});
	});
</script>
</head>
<body>
<form action="./findId" method="post" class="findId">

	이름 : <input type="text" name="name">
	이메일 : <input type="email" name="email">
	
	<button id="findId">확인</button>
	
</form>

</body>
</html>