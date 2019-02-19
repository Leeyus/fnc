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
			<ul class="singer_list" style="height: 942px;">
			<c:forEach items="${list }" var="dto">
				<li>
					<div class="pic">
						<a href="${board}Select?num=${dto.num}">${dto.sub_img }</a>
					</div>
					<div class="add">
						<div class="add_tit">
							${dto.subject }
						</div>
					</div>
				</li>
			</c:forEach>
			</ul>
					<div class="pagebox01" style="margin-top: 20px; text-align: center; ">
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

<c:import url="../jsp/footer.jsp"></c:import>
</body>
</html>