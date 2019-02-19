<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); response.setCharacterEncoding("UTF-8"); %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!--head -->
	<div id="hd_wrap">
		<div id="header">
			<div id="hdTop" class="wrap">
				<h1 id="logo">
					<a href="${pageContext.request.contextPath}/"> <img alt="FNC" src="${pageContext.request.contextPath}/resources/images/logo.png">
					</a>
				</h1>
				<ul id="topmenu">
				<c:choose>
				<c:when test="${not empty member }">
					<li>						
						<a href="${pageContext.request.contextPath}/member/logOut">LOGOUT</a>
						<a href="${pageContext.request.contextPath}/member/myPage">My PAGE</a>
					</li>
				</c:when>
				<c:otherwise>
					<li>						
						<a style="cursor: pointer;" onclick="window.open('${pageContext.request.contextPath}/member/login','test','width=460,height=268');">LOGIN</a> 
						<a href="${pageContext.request.contextPath}/member/consent">JOIN</a>
					</li>
				</c:otherwise>
				</c:choose>
						
					<li style="color: #a2a1a1;">|</li>
					<li><a>KO</a> <a>EN</a> <a>JP</a> <a>CN</a></li>
				</ul>
			</div>
			<div id="nav">
				<div id="gnbMenu">
					<div class="inner">
						<ul id="gnb" class="test">
							<li >
								<a href="#" >COMPANY</a>
								<div class="sub" id="sub1">
									<ul class="t1">
										<li><a href="${pageContext.request.contextPath}/company/aboutFnc">ABOUT FNC</a></li>
										<li><a href="${pageContext.request.contextPath}/company/business">BUSINESS</a></li>
										<li><a href="${pageContext.request.contextPath}/company/loveFnc">LOVE FNC</a></li>
									</ul>
								</div>
							</li>
							<li>
								<a href="#">ARTISTS</a>
								<div class="sub" id="sub2">
									<ul class="t1">
										<li><a href="${pageContext.request.contextPath}/singer/singerList">SINGER</a></li>
										<li><a href="${pageContext.request.contextPath}/actor/actorList">ACTOR</a></li>
										<li><a href="${pageContext.request.contextPath}/entertainer/entertainerList">ENTERTAINER</a></li>
									</ul>
								</div>
							</li>
							<li>
								<a href="#">PR CENTER</a>
								<div class="sub" id="sub3">
									<ul class="t1">
										<li><a href="${pageContext.request.contextPath}/fncTalk/fncTalkList">FNC TALK</a></li>
										<li><a href="${pageContext.request.contextPath}/release/releaseList">NEW RELEASE</a></li>
										<li><a href="${pageContext.request.contextPath}/notice/noticeList">NOTICE</a></li>
										<li><a href="${pageContext.request.contextPath}/fmedia/fmediaList">F`MEDIA</a></li>
									</ul>
								</div>
							</li>
							<li>
								<a href="#">AUDITION</a>
								<div class="sub" id="sub4">
									<ul class="t1">
										<li><a href="${pageContext.request.contextPath}/company/information">INFORMATION</a></li>
										
										<li><a href="${pageContext.request.contextPath}/company/faq">FAQ</a></li>
										<li><a href="${pageContext.request.contextPath}/auNotice/AuditionNoticeList">AUDITION NOTICE</a></li>
										
									</ul>
								</div>	
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--head END  -->