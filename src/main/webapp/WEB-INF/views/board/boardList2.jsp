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
			<div id="bbslist" style="padding-top: 100px;">
				<div id="isotopeGallery" class="photos clear isotope"
				style="position: relative; overflow: hidden;"
				>
				<c:forEach items="${list}" var="dto">
				<div class="photo">
				<c:if test="${board == 'release' }">
					<div class="pt_pic">
						${dto.sub_img }
					</div>
				</c:if>
				<c:if test="${board == 'fmedia' }">
					<div class="pt_pic">
						${dto.sub_img }
					</div>
				</c:if>
					<div class="pt_overview">
					<c:if test="${board eq 'fncTalk' }">
						<div class="pt_num" style="">${dto.num }</div>
					</c:if>
						<div class="pt_title" 
							style="overflow-x: hidden;max-width: 185px;text-overflow: ellipsis;max-height: 20px;overflow-y: hidden;"
						>
							<a href="${board}Select?num=${dto.num}">${dto.subject} </a>
						</div>
						<div class="pt_add" style="white-space: nowrap;overflow-x: hidden; max-width: 185px; text-overflow: ellipsis;max-height: 20px;overflow-y: hidden;">
						${dto.contents }</div>
						<div class="pt_date">${dto.reg_date }</div>
					</div>
				</div>
				</c:forEach>
				</div>
				<c:if test="${board != 'fncTalk' }">
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
				</c:if>
				<c:if test="${member.kind eq 'm' }">
				<a href="./${board }Write">writer</a>
				</c:if>
			</div>
		</div>
	</div>
	
<c:import url="../jsp/footer.jsp"></c:import>
</body>
</html>