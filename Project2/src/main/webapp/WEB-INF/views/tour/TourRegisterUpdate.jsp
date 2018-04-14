<%@page import="com.sj.project.domain.TourRegisterVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html class="no-js">

<head>

<meta charset=UTF-8">
<title>여행 수정</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="<c:url value="../resources/theme/css/bootstrap.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="../resources/theme/css/font-awesome.css"/>">
<link rel="stylesheet"
	href="<c:url value="../resources/theme/css/animate.css"/>">
<link rel="stylesheet"
	href="<c:url value="../resources/theme/css/templatemo_misc.css"/>">
<link rel="stylesheet"
	href="<c:url value="../resources/theme/css/templatemo_style.css"/>">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script
	src="../resources/theme/js/vendor/modernizr-2.6.1-respond-1.1.0.min.js"></script>
<script src="../resources/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>

<style>
.searchRegion {
	display: none;
}

.wrap textarea {
	width: 100%;
}
</style>
</head>

<body>
<%@ include file="../main-header.jsp"%>

		<div class="site-main" id="sTop" style="background-color: green;">
			<div class="site-header">
				<!-- /.container -->
				<div class="main-header">
					<div class="container">
						<div id="menu-wrapper">
							<div class="row">
								<div class="logo-wrapper col-md-2 col-sm-2">
									<h1>
										<a href="#">hello </a>
									</h1>
								</div>
								<!-- /.logo-wrapper -->
								<div class="col-md-10 col-sm-10 main-menu text-right">
									<div class="toggle-menu visible-sm visible-xs">
										<i class="fa fa-bars"></i>
									</div>
									
									<ul class="menu-first">
										<li><a href="../index">메인</a></li>
										<li><a href="../admin">관리자</a></li>
										<li><a href="../login">로그인</a></li>
									</ul>
								</div>
								<!-- /.main-menu -->
							</div>
							<!-- /.row -->
						</div>
						<!-- /#menu-wrapper -->
					</div>
					<!-- /.container -->
				</div>
				<!-- /.main-header -->
			</div>
			
			<!-- /.site-header -->
			<div class="site-slider">
			
			<div class="slider">
				<div class="flexslider">
					<ul class="slides">
						<li>
							<div class="overlay"></div> <img
							src="../resources/theme/images/slide1.jpg" alt="">
							<div class="slider-caption visible-md visible-lg">
								<h2>여행 수정</h2>
								<br /> <br />
							</div>
						</li>
					</ul>
				</div>
				<!-- /.flexslider -->
			</div>
			<!-- /.slider -->
		</div>
		<!-- /.site-slider -->
	</div>
	<!-- /.site-main -->
	
	<script>
		$(function() {
			$("#start_date, #end_date").datepicker({
				dateFormat : 'yy-mm-dd'
			});
		});
	</script>
	
	<script>
		$(function() { //전역변수선언
			var editor_object = [];
			nhn.husky.EZCreator.createInIFrame({
				oAppRef : editor_object,
				elPlaceHolder : "smarteditor",
				sSkinURI : "../resources/smarteditor/SmartEditor2Skin.html",
				htParams : {
					// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
					bUseToolbar : true,
					// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
					bUseVerticalResizer : true,
					// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
					bUseModeChanger : true,
				}
									
			});

			//전송버튼 클릭이벤트
			$("#updatebutton").click(function() {
							
				//id가 smarteditor인 textarea에 에디터에서 대입
				editor_object.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);
				// 이부분에 에디터 validation 검증
				
				//폼 submit
				$("#frm").submit();
			})
			
			$("#cancelbutton").click(function() {
				location = '../index';
				history.back();
			})
			
			$("#homebutton").click(function() {
				location = '../index';
			})
		})
	</script>

	<div class="content-section" id="services">
		<div class="container">
			<div class="row">
			
				<!-- /.heading-section -->
				<div class="heading-section">
					<h2>여행 등록 정보</h2>
				</div>

				<div class="wrap">				
						
						<form action="TourRegisterCheck" method="post" id="frm" enctype="multipart/form-data">
						
							<c:choose>
								<c:when test="${imageFile != null }">
								
								<img src="${pageContext.request.contextPath}/image/${imageFile.id}" width="100" height="100" style="display: none">
								</c:when>
							</c:choose><br /><br />
							
							<input type="file" name="imageFile" value="<img src='${pageContext.request.contextPath}/image/${imageFile.id}' width='100' height='100'>"><br>
																											
							<input type="hidden" name="trip_no" value="${vo.trip_no}" readonly="readonly" /> 
								
							<input type="hidden" name="mno" value="${mno}" readonly="readonly" /> 
						
							<input type="text" name="title" style="width: 60%" value="${vo.title}" placeholder="제목" /><br /> <br /> 
						
							<input type="text" name="region_name" style="width: 60%" value="${vo2.region_name}" placeholder="지역" /><br /> <br />
				
							<input type="text" id="start_date" name="start_date" value="${vo.start_date}" placeholder="시작일" > 
							~ 
							<input type="text" id="end_date" name="end_date" value="${vo.end_date}" placeholder="종료일" > <br /> <br />
							
							<div>
							성별 조건: <br />
							남자 <input type="radio" name="condition_sex" value="1" /> 
							여자 <input type="radio" name="condition_sex" value="2" /> 
							조건없음 <input type="radio" name="condition_sex" value="3" />
						</div><br />
					
						<div>
							연령 조건: <br />
							20대 <input type="radio" name="condition_age" value="1" /> 
							30대 <input type="radio" name="condition_age" value="2" /> 
							40대 <input type="radio" name="condition_age" value="3" /> 
							50대 <input type="radio" name="condition_age" value="4" />
						 </div><br />		 
						 
						 <br/>
						<textarea name="content" id="smarteditor" rows="10"
							cols="100" style="width: 766px; height: 412px;">	
							${vo.content}
						</textarea>
						
						
						<br /><br />
							
															
						</form>	
						
					<!-- <input type="button" id="updatebutton" value="수정 완료" /> -->
					<button type="button" id="updatebutton">수정 완료</button>
					<input type="button" id="cancelbutton" value="취소" />
					<input type="button" id="homebutton" value="홈으로" />
					
				</div>
				
			
				
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container -->
	</div>
	<!-- /#services -->
	
	<div id="footer">
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-xs-12 text-left">
					<span>Copyright &copy; 2014 Company Name</span>
				</div>
				<!-- /.text-center -->
				<div class="col-md-4 hidden-xs text-right">
					<a href="#top" id="go-top">Back to top</a>
				</div>
				<!-- /.text-center -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container -->
	</div>
	<!-- /#footer -->



	<script src="../resources/theme/js/bootstrap.js"></script>
	<script src="../resources/theme/js/plugins.js"></script>
	<script src="../resources/theme/js/main.js"></script>

</body>
</html>