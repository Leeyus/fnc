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
	var msg = '${param.msg}';
	if(msg != ''){
		alert(msg);
	}
	
	$("#del").click(function() {
		$("#frm").submit();
	});
});
</script>
</head>
<body>
<c:import url="../jsp/head.jsp"></c:import>
	
	<div id="container">
		<h2 id="page_title">${board }</h2>
		<div id="contents" class="wrap">
			<div id="bbsview">
				<table>
					<colgroup>
						<col style="width:80px;">
						<col>
						<col style="width:110px;">
						<col style="width:80px;">
						<col style="width:80px;">
					</colgroup>
					<thead>
						<tr>
							<th scope="col"></th>
							<th scope="col" style="text-align: center;">SUBJECT</th>
							<th scope="col" style="text-align: center;">NAME</th>
							<th scope="col" style="text-align: center;">DATE</th>
							<th scope="col" style="text-align: center;">HIT</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="sbj" colspan="2" style="text-align: left; padding-left: 40px;">${dto.subject }</td>
							<td class="name">
								<span class="hand">${dto.writer }</span>
							</td>
							<td class="date">${dto.reg_date }</td>
							<td class="hit">
								<span class="num">${dto.hit }</span>
							</td>
						</tr>
						<tr>
							<td colspan="5">
								<div id="vContent" class="content">
									${dto.contents }
								</div>
							</td>
						</tr>
					</tbody>
				</table>
				<div class="admin_box">
					<div class="btnbox1">
					<c:if test="${member.kind eq 'm' }">				
						<a href="./${board}Update?num=${dto.num}">update</a>
						<span id="del">delete</span>
						<form id="frm" action="./${board}Delete" method="post">
							<input type="hidden" name="num" value="${dto.num}">
						</form>
					</c:if>
					</div>
					<div class="btnbox2">
						<a href="./${board }List" class="basic_btn">
						
							<span>LIST</span>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>

<c:import url="../jsp/footer"></c:import>
</body>
</html>