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
		$(".tab_cont").on("click",".list_faq",function() {
			
			$(this).find('dd').toggle();
		});
	});
</script>
</head>
<body>
<c:import url="../jsp/head.jsp"></c:import>

	<div id="container">
		<h2 id="page_title">FAQ</h2>
		<div id="contents" class="wrap">
			<div id="faq">
				<div class="section">
					<div class="tab_cont">
					
						<dl class="list_faq">
							<dt>
								<em class="qa">Q</em>
								<a href="#">두 명 혹은 여러 명이 함께 오디션을 볼 수 있나요?</a>
							</dt>
							<dd>
								<em>A</em>
								<span>
									<p>네 가능합니다.</p>
									<p>우선 공개오디션의 경우 각각 신청서를 작성하시어 번호표를 배부 받으신 뒤 현장 스텝에게 듀엣, 그룹 오디션 응시자라고 얘기해주시면 되고, 온라인 오디션의 경우 양식에 맞춰 신청을 하시고 듀엣 혹은 단체, 합주라고 작성하시면 됩니다. 다만 합격여부는 팀 전원이 합격 할 수도, 전원이 탈락 할 수도 있으며 개별 합겨자가 생길 수도 있사오니 이 점 참고하시기 바랍니다.</p>
								</span>
							</dd>
							</dl>
							<dl class="list_faq">
							<dt>
								<em class="qa">Q</em>
								<a href="#">비공개오디션 2차 합격 연락은 언제쯤 오나요?</a>
							</dt>
							<dd>
								<em>A</em>
								<span>
									
									<p>E-mail 확인 후 일주일 내로 연락이 갑니다. 연락이 없을 경우 탈락한 것이며, 합격자가 연락을 받지 않을 경우 신인기획팀에서 다른 일자에 다시 연락 드리오니 이 점 참고하시기 바랍니다.</p>
								</span>
							</dd>
						</dl>
						<dl class="list_faq">
							<dt>
								<em class="qa">Q</em>
								<a href="#">악기만으로 오디션을 볼 수 있나요?</a>
							</dt>
							<dd>
								<em>A</em>
								<span>
									
									<p>악기 지원 오디션은 이메일로만 지원 가능합니다. 피아노, 드럼, 기타, 베이스 등 실용음악에 관련된 모든 악기로 지원 가능하며,

연주 영상을 찍어서 이메일로 보내주시면 됩니다. (FNC 오디션 이메일 계정 : audition@fncent.com)</p>
								</span>
							</dd>
						</dl>
						<dl class="list_faq">
							<dt>
								<em class="qa">Q</em>
								<a href="#">연기자도 모집하나요?</a>
							</dt>
							<dd>
								<em>A</em>
								<span>
									<p>네, 물론입니다.</p>
									<p>FNC Entertainment에서는 가수, 연기자, 모델 등 여러 분야에서 활동 할 인재를 찾고 있습니다.</p>
								</span>
							</dd>
						</dl>
						<dl class="list_faq">
							<dt>
								<em class="qa">Q</em>
								<a href="#">공개오디션과 온라인 오디션의 차이점이 무엇인가요?</a>
							</dt>
							<dd>
								<em>A</em>
								<span>
									
									<p>공개오디션은 여러 명의 심사위원과 참가자들 앞에서 심사를 공개적으로 진행하며, 온라인 오디션은 1차로 FNC공식 홈페이지 내 온라인 오디션 페이지에서 신청하신 분들 중 합격자에 한하여 본사에서 1:1 비공개 오디션을 진행하게 됩니다.</p>
								</span>
							</dd>
						</dl>
						<dl class="list_faq">
							<dt>
								<em class="qa">Q</em>
								<a href="#">트레이닝 비용이 따로 드나요?</a>
							</dt>
							<dd>
								<em>A</em>
								<span>
									<p>오디션 최종합격 연예활동 개발 및 제반비용은 100% 전액 FNC Entertainment에서 투자합니다.</p>
									
								</span>
							</dd>
						</dl>
						<dl class="list_faq">
							<dt>
								<em class="qa">Q</em>
								<a href="#">작곡,작사 오디션 절차를 알려주세요.</a>
							</dt>
							<dd>
								<em>A</em>
								<span>
									
									<p>작곡, 작사 오디션은 공개 오디션이 어려우니 우편 또는 이메일로 신청해 주시면 FNC Entertainment A&R팀에 인계하여 검토한 뒤 개별연락 드립니다. 이 점 참고하시기 바랍니다.</p>
								</span>
							</dd>
						</dl>
						<dl class="list_faq">
							<dt>
								<em class="qa">Q</em>
								<a href="#">연습생 선발 기준은 무엇인가요?</a>
							</dt>
							<dd>
								<em>A</em>
								<span>
									
									<p>연습생 선발 기준은 매우 폭넓고 다양하기 때문에 정의를 내리기 어렵습니다만 선발 당시의 실력이나 외모보다 끼와 재능, 열정을 중심으로 향후 발전 가능성을 가장 큰 기준으로 두고 있습니다.</p>
								</span>
							</dd>
						</dl>
					</div>
				</div>
			</div>
		</div>
	</div>

<c:import url="../jsp/footer.jsp"></c:import>
</body>
</html>