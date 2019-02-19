<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<c:import url="./jsp/b.jsp"></c:import>
<style type="text/css">
	.date{
		color: #9d9d9d;
		font-size: 10px;
	}
</style>

</head>
<body>
	<!--head -->
	<c:import url="./jsp/head.jsp"></c:import>
	
	<!--head END  -->

	<!-- body -->
	<div id="container" class="mainbody">
		<div id="mcontents" class="wrap">
			<div id="visual">
				<div class="gallert_wrap" id="gallery_visual">
					<div class="inner">
						<div>
							<div id="demo" class="carousel slide" data-ride="carousel">
								<ul class="gallery carousel-indicators">
									<li data-target="#demo" data-slide-to="0" class="active"></li>
									<li data-target="#demo" data-slide-to="1">
									<li data-target="#demo" data-slide-to="2"></li>
									<li data-target="#demo" data-slide-to="3"></li>
								</ul>
								<div class="carousel-inner">
									<div class="carousel-item active">
										<a href="${pageContext.request.contextPath}/singer/singerSelect?num=12"><img alt="" src="./resources/bodyimgs/p1.jpg">
										</a>
										<div class="txt">N.Flying [FLY HIGH PROJECT #2] (옥탑방)
											:2019.01.02</div>
									</div>
									<div class="carousel-item">
										<a href="#"><img alt="" src="./resources/bodyimgs/p2.jpg">
										</a>
										<div class="txt">N.Flying [FLY HIGH PROJECT #2] FNC ARTIST - lt`s Christmas
											</div>
									</div>
									<div class="carousel-item">
										<a href="${pageContext.request.contextPath}/singer/singerSelect?num=13"><img alt="" src="./resources/bodyimgs/p3.jpg">
										</a>
										<div class="txt">FNC new GIRL GROUP'Cherry Bullet' New Character Open</div>
									</div>
									<div class="carousel-item">
										<a href="${pageContext.request.contextPath}/singer/singerSelect?num=13"><img alt="" src="./resources/bodyimgs/p4.jpg">
										</a>
										<div class="txt">FNC new GIRL GROUP'Cherry Bullet' New Character Open</div>
									</div>
									<a class="carousel-control-prev" href="#demo" data-slide="prev">
										<span class="carousel-control-prev-icon"></span>
									</a> <a class="carousel-control-next" href="#demo"
										data-slide="next"> <span
										class="carousel-control-next-icon"></span>
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="mcont" class="weap clear">
				<div id="notice" class="mpost leftCont">
					<h3>NOTICE</h3>
					<ul style="white-space: nowrap;">
						<li>
							<a href="${pageContext.request.contextPath}/notice/noticeList">[예약판매] CherrtBullet 1ST</a>
							<span class="date">19-01-21</span>
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/notice/noticeList">[예약판매] SF9 6TH MNI ALBUM</a>
							<span class="date">19-01-21</span>
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/notice/noticeList">[팬미팅] 2019 곽동연 팬미</a>
							<span class="date">19-01-21</span>
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/notice/noticeList">[안내] 배우 성혁 OCN ‘트랩’ </a>
							<span class="date">19-01-21</span>
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/notice/noticeList">[예약판매] CherrtBullet 1ST4</a>
							<span class="date">19-01-21</span>
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/notice/noticeList">[예약판매] CherrtBullet 1ST4</a>
							<span class="date">19-01-21</span>
						</li>
						
					</ul>
					<a href="${pageContext.request.contextPath}/notice/noticeList" class="more">+</a>
				</div>
				<div id="press" class="mpost leftCont">
				<h3>NEW RELEASE</h3>
					<ul style="white-space: nowrap;">
						<li>
							<a href="${pageContext.request.contextPath}/release/releaseList">체리블렛 1st SINGLE [Let’s Pl</a>
							<span class="date">19-01-21</span>
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/release/releaseList">N.Flying FLY HIGH PROJECT</a>
							<span class="date">19-01-21</span>
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/release/releaseList">FNC ARTIST – It’s Christm</a>
							<span class="date">19-01-21</span>
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/release/releaseList">2018 JUNG YONG HWA LIVE </a>
							<span class="date">19-01-21</span>
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/release/releaseList">N.Flying FLY HIGH PROJECT</a>
							<span class="date">19-01-21</span>
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/release/releaseList">이홍기 2ND MINI ALBUM </a>
							<span class="date">19-01-21</span>
						</li>
						
					</ul>
				</div>
				<div class="leftCont">
					<div id="mv">
						<div class="mv_pic">
							<a href="https://youtu.be/_u0rbNyosB8"> <img alt=""
								src="./resources/bodyimgs/mv1.jpg">
							</a>
						</div>
						<dl>
							<dt>
								<a href="https://youtu.be/_u0rbNyosB8"> 옥탑방 M/V </a>
							</dt>
							<dd class="date" style="color: #9d9d9d;font-size: 10px;">
							19/01/02 update
							</dd>
						</dl>
					</div>
					<div id="fnc_store">
						<div class="gallery_wrap" id="gallery_store">
							<img alt="" src="./resources/bodyimgs/store.jpg">
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

	<!-- footer -->
	
	<c:import url="./jsp/footer.jsp"></c:import>

</body>
</html>
