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
		var check = false;
		
		/* var msg = '${msg}';
		if(msg != ''){
			alert(msg);
		} */
		
		
		$("#id").blur(function() {
			var id = $(this).val();
			$.get("./idCheck?id="+id, function(result) {
				result = result.trim();//공백제거
				var msg = '사용할수 없는 아이디입니다.';
				if(result != 0){
					msg='사용가능한 아이디입니다.';
					check=true;
				} else{
					check=false;
					$("#id").val('');
				} 
				$("#result").html(msg);
			});
		});
		
		
		$("#joinBtn").click(function() {
			/* if(check){
				$("#frm").submit();
			}else{
				alert("정보를 정확히 입력하세요")
			} */
			if(document.frm.id.value==""){
				alert("아이디를 입력하세요");
				document.frm.id.focus();
			}else if(document.frm.pw_1.value==""){
				alert("비밀번호를 입력하세요");
				check=false;
				document.frm.pw_1.focus();
			}else if(document.frm.name.value==""){
				alert("이름를 입력하세요");
				document.frm.name.focus();
			}else if(document.frm.num_address.value==""){
				alert("우편주소를 입력하세요");
				document.frm.num_address.focus();
			}else if(document.frm.phone2.value==""){
				alert("핸드폰번호를 입력하세요");
				document.frm.phone2.focus();
			}else if(document.frm.email.value==""){
				alert("이메일을 입력하세요");
				document.frm.email.focus();
				check=true;
			}if(check){
				alert("가입에 성공했습니다.")
				$('#frm').submit();
			}
		});

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
	});
</script>
</head>
<body>
<c:import url="../jsp/head.jsp"></c:import>

<div id="container">
	<h2 id="page_title">Join</h2>
	<div id="contents" class="wrap">
		<div id="pages_join">
			<div class="tab section">
				<h3>회원 가입</h3>
			</div>
			<form action="./memberJoin" name="frm" method="post" id="frm">
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
									<input type="text" name="id"  id="id" style="width:240px;">
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
									<input type="text" name="name" style="width:240px;">
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
											<!-- <input type="text" size="10" style="margin-bottom: 5px" name="num_address"id="sample6_postcode"> <input type="button" onclick="sample6_execDaumPostcode()" value="우편번호"><br>
											<input type="text" size="30" style="margin-bottom: 5px" name="main_address"id="sample6_address" ><br>
											<input type="text" size="30" name="sub_address"id="sample6_detailAddress">
											<input type="text" id="sample6_extraAddres"> -->
												<input type="text" name="num_address" style="margin-bottom: 5px" id="sample6_postcode" placeholder="우편번호"> <input type="button" onclick="sample6_execDaumPostcode()"
													value="우편번호 찾기"><br> <input type="text"
													id="sample6_address" name="main_address" size="42.5" style="margin-bottom: 5px" placeholder="주소"><br> <input
													type="text" id="sample6_detailAddress" name="sub_address" placeholder="상세주소"> <input type="text" id="sample6_extraAddress"
													placeholder="참고항목">
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
									<input type="text" maxlength="8" size="25" name="phone2" placeholder=" - 는 생략해주세요">
								</td>
							</tr>
							<tr>
								<td class="th">
									이메일
									<span class="th_dot"></span>
								</td>
								<td colspan="3">
									<input type="email" name="email" style="width:240px;">
									<!-- <input type="hidden" name = "kind"> -->
								</td>
							</tr>
							
						</tbody>
					</table>
				</div>
				<div class="submitbox">
					<input type="button" id="joinBtn" class="orange_btn" value="가입완료">
					<!-- <button type="button" class="orange_btn" id="btn">
						<span>가입완료</span>
					</button> -->
					<!-- <button class="gray_btn">
						<span>취소</span>
					</button> -->
					<input type="button" class="gray_btn" id="joinBtn2" value="취소">
				</div>
			 </form>
		</div>
	</div>
</div>

<c:import url="../jsp/footer.jsp"></c:import>


</body>
</html>