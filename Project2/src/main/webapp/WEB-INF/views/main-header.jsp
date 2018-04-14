<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" href="<c:url value="../resources/theme/css/bootstrap.min.css"/>">
		<link rel="stylesheet" href="<c:url value="../resources/theme/css/templatemo_style.css"/>">

		
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
		<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
		<script src="../resources/theme/js/vendor/modernizr-2.6.1-respond-1.1.0.min.js"></script>
		<script src="../resources/theme/js/bootstrap.js"></script>
		<script src="../resources/theme/js/plugins.js"></script>
		<script src="../resources/theme/js/main.js"></script>

</head>
<body>
	<div class="main-header" style="top: 0.5%;">
		<div class="container">
			<div id="menu-wrapper">
				<div class="row">
				
					<div class="logo-wrapper col-md-2 col-sm-2">
						<h1>
							<a href="../index" id="#btnHome"><img alt="" src="../resources/theme/images/mainlogo2.jpg" style="width: 240px; height: 100px;"></a>	
						</h1>
					</div>
					
					
					<div class="col-md-10 col-sm-10 main-menu text-right" style="width: 70%; float: right;">
 						<div class="toggle-menu visible-sm visible-xs">
							<i class="fa fa-bars"></i>
						</div>

						<ul class="menu-first">
							<li><a href="../index">Main</a></li>
							<li><a href="../tour/tourBoard">Tour</a></li>
							<li><a href="../review/reviewBoard">Review</a></li>
<!-- 							<li><a href="../index">메인</a></li>
							<li><a href="../tour/tourBoard">여행</a></li>
							<li><a href="../review/reviewBoard">후기</a></li> -->
							
							<%-- 세션에 로그인 정보가 없는 경우 --%>
							<c:if test="${empty login_id }">
								<li><a href="#this" id="btnLogin">Sign in</a></li>								
								<li><a href="#this" id="btnMemberRegister">Sign up</a></li>
<!-- 								<li><a href="#this" id="btnLogin">로그인</a></li>								
								<li><a href="#this" id="btnMemberRegister">회원가입</a></li>	 -->							
							</c:if>
							
							<%-- 세션에 로그인 정보가 있는 경우 --%>
							<c:if test="${not empty login_id }">
							
								<%-- 세션에 로그인 정보가 있고, 권한이 3인 경우 --%>	
								<c:if test="${authority == 3 }">
									<li><a href="#this" id="btnAdministrator">Admin</a></li>
									<!-- <li><a href="#this" id="btnAdministrator">관리자</a></li> -->
								</c:if>
								
								<li><a href="#this" id="btnMypage">MyPage</a></li>								
								<li><a href="#this" id="btnLogout">Sign out</a></li>
								<!-- <li><a href="#this" id="btnMypage">마이페이지</a></li>
								<li><a href="#this" id="btnLogout">로그아웃</a></li> -->
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

<script>
$('#btnMemberRegister').click(function() {
	location = '/project/member/member_register01';
});

$('#btnLogin').click(function() {
	location = '/project/member/login?url=' + location.href;
});

$('#btnAdministrator').click(function() {
	location = '/project/admin/admin';
});

$('#btnMypage').click(function() {
	location = '/project/mypage/MyPage';
});	

$('#btnLogout').click(function() {
	location = '/project/member/logout'; //logout 이라는 컨트롤러로 가겠다.
});

$('#btnHome').click(function() {
	location = '/project/';
});
</script>

</body>
</html>