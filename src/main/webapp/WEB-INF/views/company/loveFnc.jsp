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
		<h2 id="page_title">LOVE FNC</h2>
		<div id="contents" class="wrap" style="height: 708px;">
			<div id="online_tab">
				<a>
					<span>LOVE FNC</span>
				</a>
				<a>
					<span>LOVE FNC 스토리</span>
				</a>
			</div>
			<div class="love_fnc">
				<div class="simbol">
					<div class="simbol_pic">
						<img alt="" src="${pageContext.request.contextPath}/resources/bodyimgs/simbol.png">
					</div>
					<div class="simbol_txt">LOVE FNC 심볼 마크</div>
				</div>
				<div class="simbol_detail">
					<div class="detail_tit">
						2014년 FNC ENTERTAINMENT의<br>
						사회 공헌 브랜드
						<em>'LOVE FNC'</em>
					</div>
					<dl>
						<dt>ABOUT LOVE FNC</dt>
						<dd>
							<p class="para">소속 아티스트와 배우 뿐만 아니라 동료 연예인, 기업들과 함께 FNC는 나눔을 실천하고 있습니다.
‘LOVE FNC’는 아프리카 지역 외에 소외되고 도움이 필요한 나라를 후원하며 소속 아티스트들의 공연수익금 일부와 모금활동(기아대책), 자선경매, 기부 등을 통해 필요한 재정을 계속해서 마련해 나갈 것입니다.</p>
							<p class="para">‘LOVE FNC’는 지속적인 나눔 실천을 통해 국내외 사회소외계층, 빈곤국가의 교육시설지원, 긴급구호자금 등을 앞으로도 지원할 것입니다.</p>
							<p class="para">FNC ENTERTAINMENT를 사랑하시는 팬 여러분들의 관심과 격려 부탁 드립니다. 
							<br>
							<br>
							감사합니다.</p>
						</dd>
						<dt>LOVE FNC LOGO</dt>
						<dd>
							<p class="para">
								서로 마주잡고 있는 손을 하트로 표현하였으며, 간결하면서도 강렬하게 의미전달을 할 수 있도록 픽토그램화 하였습니다. 사회와 이웃의 손을 함께 잡고 아름다운 세상을 만들어 나가자는 의미를 담고 있습니다.
							</p>
						</dd>
					</dl>
				</div>
			</div>
		</div>
	</div>
<c:import url="../jsp/footer.jsp"></c:import>
</body>
</html>