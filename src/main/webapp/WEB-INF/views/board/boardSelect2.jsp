<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../jsp/b.jsp"></c:import>
<script type="text/javascript">
$(function() {
	$("#del2").click(function() {
		$("#frm").submit();
})
	
});
</script>
</head>
<body>
<c:import url="../jsp/head.jsp"></c:import>

	<div id="container">
		<h2 id="page_title">${board }</h2>
		<div id="contents" class="wrap">
			
			<div id="mini_cont" class="actors">
				<div id="actor_box">
					 <h3 class="mini_title">${dto.subject }</h3>
					 <div id="test">
					 	${dto.contents }
					 </div>
				</div>
			</div>
			<div id="filmography" class="sub_cont">
				
				${dto.sub_contents }
				
			</div>
			<c:if test="${member.kind eq 'm' }">				
						<a href="./${board}Update?num=${dto.num}">update</a>
						<span id="del2">delete</span>
						<form id="frm" action="./${board}Delete" method="post">
							<input type="hidden" name="num" value="${dto.num}">
						</form>
					</c:if>
		</div>
	</div>

<c:import url="../jsp/footer.jsp"></c:import>
</body>
</html>