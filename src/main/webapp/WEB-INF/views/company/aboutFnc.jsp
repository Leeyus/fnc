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
	<div id="container" class="type02">
		<div id="contents" class="wrap" style="height: 855px;">
			<div class="visu_area">
				<img alt="" src="${pageContext.request.contextPath}/resources/bodyimgs/visu_about.jpg">
			</div>
			<div class="visu_cont">
				<div class="visu_menu">
					<ul>
						<li style="font-size: 15px;font-weight: bold;">ABOUT FNC</li>
					</ul>
				</div>
				<div class="visu_box" id="about_fnc">
					<div class="leftbox">
						<p class="para">
						세상이 빠르게 변해 음반 사업이 사양길로 접어들자 사람 들은 
						음악으로 돈벌이하기가 참으로 힘든 세상이 되었다고 합니다. 
						하지만 세상을 살펴보면 음악을 싫어하는 사람은 극히 드문것 같습니다. 
						인류가 사라지지 않는 한 음악은 언제나 존재하는 감성의 소구이니까요.
						</p>
						<p class="para">
						음악이 없는 영화, 드라마, 게임, 방송, 광고... 상상이 되시는지요?
						 지금 이 글을 보고 계신 지금도 어디선가 음악소리가 들리진 않으신가요?
						 우리는 분명 보이지 않지만 음악을 소비하고 있으며 미디어가 발달할 때마다 우리의 귀,
						 그리고 음악 또한새롭게 변화하고 발전 할 것 입니다.
						</p>
					</div>
					<div class="rightbox">
						<p class="para">
						변화에 대한 염려가 당신을 책임지진 않습니다. 많은 이들이 지금보다 새롭고 아름다운 선율을 기대합니다. 보다 긍정적인 고민이 필요할 시점입니다.
						 세상에 아름다운 음악이 울려 퍼지도록 FNC 엔터테인먼트는 
						최고의 음반 프로듀서를 주축으로 아티스트 육성, 매니지먼트, 영화, 드라마와 OST 제작, 
						공연 기획 등 최고의 전문 인력과 제작시스템이 아니면 할 수 없는 다양하고
						 수준 높은 엔터테인먼트 서비스를 여러분들께 제공 하겠습니다.
						<br>
						<br>
						감사합니다.
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>

<c:import url="../jsp/footer.jsp"></c:import>
</body>
</html>