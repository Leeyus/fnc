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
	//var check =false;
	
	
	$('#pw2').blur(function() {
		if ($('#pw').val() != $('#pw2').val()) {
			$('font[name=check]').text('');
			$('font[name=check]').html("비밀번호가 일치하지 않습니다.");
		} else {
			$('font[name=check]').text('');
			$('font[name=check]').html("비밀번호가 일치합니다");
		} 
	});  
	
	$("#joinBtn2").click(function() {
		location.href="../"
	});	
	
	$("#joinBtn").click(function() {
		 if(document.frm.pw_1.value==""){
			alert("비밀번호를 입력하세요");
			document.frm.pw_1.focus();
		}else if(document.frm.num_address.value==""){
			alert("우편주소를 입력하세요");
			document.frm.num_address.focus();
		}else if(document.frm.phone2.value==""){
			alert("핸드폰번호를 입력하세요");
			document.frm.phone2.focus();
		}else if(document.frm.email.value==""){
			alert("이메일을 입력하세요");
			document.frm.email.focus();
		}/* if(check== false) */else{
			$('#frm').submit();
			alert("업데이트 성공");
		}
	});
	$("#del").click(function() {
		var d = confirm("정말로 탈퇴 하시겠습니까?");
		if(d==true){
			$("#frm2").submit();			
		}
	});
});
</script>
<style type="text/css">
	#frm2{
		text-align: center;
    	margin-top: 10px;
	}
	#del{
		width: 164px;
		height: 38px;
		background: black;
		border: 1px solid black;
		color: white;
		font-weight: bold;
	}
</style>
</head>
<body>
<c:import url="../jsp/head.jsp"></c:import>
	<div id="container">
		<h2 id="page_title">MY PAGE</h2>
		<div id="contents" class="wrap">
			<div id="pages_join">
				<div class="tab_section">
					<h3>내 정보</h3>
				</div>
				<form action="./myPage" name="frm" method="post" id="frm">
			<!-- <input type="hidden" name="kind" > -->
				<div class="section">
					<div class="tb_head">
						<h5>회원 정보 입력</h5>
						<div>
							<samp class="cFont02">*</samp>
							필수 입력 사항입니다.
						</div>
					</div>
					<table class="dtable">
						<colgroup>
							<col style="width:150px">
							<col>
							<col style="width:150px">
							<col>
						</colgroup>
						
						<tbody>
							<tr>
								<td class="th">
									아이디
									<span class="th_dot"></span>
								</td>
								
								<td colspan="3">
									<input type="text" value="${member.id }" readonly="readonly" name="id"  id="id" style="width:240px;">
									<span id="result" class="txt01"></span>
								</td>
							</tr>
							<tr>
								<td class="th">
									비밀번호
									<span class="th_dot"></span>
								</td>
								<td colspan="3">
									<input type="password" name="pw_1" id="pw" style="width:240px;">
									<span class="txt01">8~15자의 영소문자와 숫자조합</span>
								</td>
							</tr>
							<tr>
								<td class="th">
									비밀번호 확인
									<span class="th_dot"></span>
								</td>
								<td colspan="3">
									<input type="password" name="pw" id="pw2" style="width:240px;">
									<font name = "check" size="2" class="txt01" color="black"></font>
								</td>
							</tr>
							<tr>
								<td class="th">
									이름
									<span class="th_dot"></span>
								</td>
								<td colspan="3">
									<input type="text" readonly="readonly" name="name" value="${member.name }" style="width:240px;">
								</td>
							</tr>
							<tr>
								<td class="th">
									주소
									<span class="th_dot"></span>
								</td>
								<td colspan="3">
									<div id="addrbox">
										<div>
											<input type="text" size="10" style="margin-bottom: 5px" value="${member.num_address }" name="num_address"id="num_address"> <input type="button" onclick="sample6_execDaumPostcode()" value="우편번호"><br>
											<input type="text" size="30" style="margin-bottom: 5px" value="${member.main_address }"  name="main_address"id="main_address" ><br>
											<input type="text" size="30" name="sub_address"id="sub_address" value="${member.sub_address }">
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td class="th">
									휴대전화
									<span class="th_dot"></span>
								</td>
								<td colspan="3">
									<select name="phone1">
										<option>010</option>
										<option>011</option>
										<option>016</option>
										<option>017</option>
										<option>018</option>
										<option>019</option>
									</select>
									-
									<input type="text" maxlength="8" size="25" name="phone2" value="${member.phone2 }" placeholder=" - 는 생략해주세요">
								</td>
							</tr>
							<tr>
								<td class="th">
									이메일
									<span class="th_dot"></span>
								</td>
								<td colspan="3">
									<input type="email" value="${member.email }" name="email" style="width:240px;">
									<!-- <input type="hidden" name = "kind"> -->
								</td>
							</tr>
							
						</tbody>
					</table>
				</div>
				<div class="submitbox">
					<input type="button" id="joinBtn" class="orange_btn" value="정보수정">
					
					<input type="button" class="gray_btn" id="joinBtn2" value="취소">
				</div>
			 </form>
			<form id="frm2" action="./delete" method="post">
				<input type="button" id="del" name="id" value="회원탈퇴">
			</form>
		</div>
	</div>
</div>

<c:import url="../jsp/footer.jsp"></c:import>
</body>
</html>