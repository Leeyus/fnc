<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../jsp/b.jsp"></c:import>
</head>
<body>
<c:import url="../jsp/head.jsp"></c:import>
	<div id="container">
		<h2 id="page_title">${board }</h2>
		<div id="contents" class="wrap">
			<div id="bbslist">
				<table>
					<colgroup>
						<col style="width:90px;">
						<col>
						<col style="width:110px">
						<col style="width:80px">
						<col style="width:90px">
					</colgroup>
					<thead>
						<tr>
							<th scope="col">NO</th>
							<th scope="col">SUBJECT</th>
							<th scope="col">NAME</th>
							<th scope="col">DATE</th>
							<th scope="col">HIT</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${list }" var="dto">
						<tr>
							<td class="num">${dto.num }</td>
							<td class="sbj" style="text-align: left;"><a href="${board}Select?num=${dto.num}">${dto.subject }</a></td>
							<td class="name"><span class="hand">${dto.writer }</span></td>
							<td class="date">${dto.reg_date }</td>
							<td class="hit"><span class="num">${dto.hit}</span></td>
						</tr>
					</c:forEach>
						
					</tbody>
				</table>
				<div class="pagenate">
					<div class="pagebox01">
					<a href="./${board}List?curPage=1"><span>&lt;&lt;</span></a>
						<c:if test="${pager.curBlock>1}">
							<a href="./${board}List?curPage=${pager.startNum-1}">[이전]</a>
						</c:if>
						<c:forEach begin="${pager.startNum}" end="${pager.lastNum}"
							var="i">
							<a href="./${board}List?curPage=${i}">${i}</a>
						</c:forEach>
						<c:if test="${pager.curBlock<pager.totalBlock}">
							<a href="./${board}List?curPage=${pager.lastNum+1}">[다음]</a>
						</c:if>
						<a href="./${board}List?curPage=${pager.lastNum}"><span>&gt;&gt;</span></a>
					</div>
				</div>
				<c:if test="${member.kind eq 'm' }">
				<a href="./${board }Write">writer</a>
				</c:if>
			</div>
		</div>
	</div>
<c:import url="../jsp/footer.jsp"></c:import>
</body>
</html>