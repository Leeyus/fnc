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
		var msg = '${msg}';
		if(msg != ''){
			alert(msg);
		}
		
		
		$("#findtest").click(function() {
			opener.location.href="./findId";
			window.close();
		});
		 /* function login(result) {
			if(result == 1){
				window.close();
			}else{
				$("#id").val('');
				$("#pw").val('');
				alert("로그인실패");
			}
		};  */
		
		$(".gray_btn").click(function() {
			/* opener.location.reload(); */
			var id=$("#id").val();
			var pw=$("#pw").val();
			$.ajax({
				url:"/member/login",
				data:{'id':id,'pw':pw},
				type:"POST",
				success:function(data){
					alert(data);
					//login(result.trim());
					/* if(data!=null){
						//opener.location.href=data;
						window.close();
					}else{
						$("#id").val('');
						$("#pw").val('');
						alert("로그인실패");
					} */
				},
				error:function(){
				}
			});
			
			
			/* window.close(); */
		});
		
	});
</script>
</head>
<body>
	<div id="pages_login">
		<div class="form_wrap">
			<form action="./login" method="post" id="loginfrm">
					<div id="loginbox">
						<div class="title"> MEMBER LOGIN</div>
						<div class="loginform">
							<table>
								<colgroup>
									<col style="width:50px;">
									<col>
									<col style="width:100px;">
								</colgroup>
								<tbody>
									<tr>
										<td class="th">
											<label>ID</label>
										</td>
										<td>
											<input type="text" name="id" id="id" style="width: 90%" tabindex="1">
										</td>
										<td rowspan="2">
											<button class="gray_btn" tabindex="3">
												<span>LOGIN</span>
											</button>
										</td>
									</tr>
									<tr>
										<td class="th">
											<label>PW</label>
										</td>
										<td>
											<input type="password" name="pw" id="pw" style="width: 90%" tabindex="2">
										</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="login_bot">
							<a style="cursor: pointer;" id="findtest"> find id / password</a>
						</div>
					</div>
			</form>
		</div>
	</div>
</body>
</html>