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
		<div id="contents" class="wrap" style="height: 1750px;">
			<div class="visu_area">
				<img alt="" src="${pageContext.request.contextPath}/resources/bodyimgs/visu_information.jpg">
			</div>
			<div class="visu_cont" id="information">
				<div class="visu_menu">
					<ul>
						<li style="font-size: 15px;font-weight: bold;">
							<a>INFOMATION</a>
						</li>
					</ul>
				</div>
				<div class="visu_box">
					<h3>공개 오디션 안내</h3>
					<div class="section">
						<h4>오디션 일정</h4>
						<p>매월 둘째 주 일요일 1시 ※내부사정으로 인한 날짜 변동 가능</p>
					</div>
					<div class="section">
						<h4>지원 자격</h4>
						<p>국적, 성별, 학력, 나이제한 없음</p>
					</div>
					<div class="section">
						<h4>접수기간 및 방법</h4>
						<p>
							오디션 당일 현장 접수만 가능합니다. 오후 12시부터<br>
							(시간 엄수 * 현장 상황에 따라 접수마감 시간이 당겨질수 있으므로 가급적 1시 이전에 접수
							하시기 바랍니다. 또한, 시간과 관계없이 오디션 마감 이후에 오실 경우 접수가 되지 않으니 이점 
							유의 바랍니다.)
						</p>
					</div>
					<div class="section">
						<h4>장소</h4>
						<p>FNC Entertainment 본사 [서울시 강남구 청담동 111번지]</p>
					</div>
					<div class="section">
						<h4>지원 분야</h4>
						<div class="table_wrap">
							<table>
								<colgroup>
									<col style="width:110px">
									<col>
								</colgroup>
								<tbody>
									<tr>
										<td class="th">보컬</td>
										<td>무반주로 1분 가량 기요로 준비</td>
									</tr>
									<tr>
										<td class="th">연주</td>
										<td>
											이메일로만 지원 가능, 파이노, 드럼, 기타, 베이스 등 연주 영상을 찍어서 이메일로 보내주시면 됩니다<br>
											(FNC 오디션 이메일 계정 : audition@fncent.com)
										</td>
									</tr>
									<tr>
										<td class="th">연기, 개그</td>
										<td>자유연기 1개 이상 준비 (1분30초 이내), 지정 대본 없음</td>
									</tr>
									<tr>
										<td class="th">모델,MC</td>
										<td>(광고, 패션 모델/외모) 워킹, 포즈, 개인기, 자기  PR 등 준비</td>
									</tr>
									<tr>
										<td class="th">댄스</td>
										<td>랜덤으로 음악 진행 [1분가량 평가]</td>
									</tr>
									
								</tbody>
							</table>
						</div>
					</div>
					<div class="section">
						<h4>진행방법</h4>
						<p>현장 스텝의 안내에 따라 오디션 장에 10명씩 입장. 개별 오디션 진행</p>
					</div>
					<div class="section">
						<h4>합격자 발표</h4>
						<p>합격자에 한하여 개인 이메일 및 연락처로 개별 통보</p>
					</div>
					<div class="tipbox section">
						<ul>
							<li>심사의 내용과 진행 방법은 진행 사정에 의해 다소 변경될 수 있습니다.</li>
							<li>본 오디션의 촬영/녹음에 발생되는 컨텐츠의 저작권은 FNC에 귀속됩니다.</li>
							<li>오디션 응모와 신인기회에 제반되는 모든 비용은 100% FNC에서 투자합니다.</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

<c:import url="../jsp/footer.jsp"></c:import>
</body>
</html>