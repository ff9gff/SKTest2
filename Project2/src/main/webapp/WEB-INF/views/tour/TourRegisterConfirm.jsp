<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html class="no-js">

	<head>
		<meta charset="utf-8">
		<title>같이가자</title>
		<meta name="description" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" href="<c:url value="../resources/theme/css/bootstrap.min.css"/>">
		<link rel="stylesheet" href="<c:url value="../resources/theme/css/font-awesome.css"/>">
		<link rel="stylesheet" href="<c:url value="../resources/theme/css/animate.css"/>">
		<link rel="stylesheet" href="<c:url value="../resources/theme/css/templatemo_misc.css"/>">
		<link rel="stylesheet" href="<c:url value="../resources/theme/css/templatemo_style.css"/>">
		<link rel="stylesheet" href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />
		
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
		<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
		<script src="../resources/theme/js/vendor/modernizr-2.6.1-respond-1.1.0.min.js"></script>
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
		<%@ include file="../top_header.jspf"  %>

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
								<h2>여행 등록 정보 확인</h2>
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

	<div class="content-section" id="services">
		<div class="container">
			<div class="row">
			
				<!-- /.heading-section -->
				<div class="heading-section">
					<h2>여행 등록 정보</h2>
				</div>

				<div class="wrap">				
						
						<form action="TourRegisterComplete" method="post" id="frm" enctype="multipart/form-data">
						
							<c:choose>
								<c:when test="${imageFile != null }">
								<%-- 파일 업로드 완료
								<ul>
									<li>파일 ID : ${imageFile.id }</li>
									<li>저장된 파일 이름 : ${imageFile.fileName }</li>
									<li>파일 길이 : ${imageFile.contentLength }</li>
									<li>MIME 타입 : ${imageFile.contentType }</li>
								</ul>
								 --%>
								<img src="${pageContext.request.contextPath}/image/${imageFile.id}" width="100" height="100">
								
								</c:when>
							</c:choose><br /><br />
							
							<input type="file" name="imageFile" value="<img src='${pageContext.request.contextPath}/image/${imageFile.id}' width='100' height='100'	>" style="display: none"><br>
							
							<input type="hidden" name=img_url" value="${vo3.img_url }" readonly="readonly" />
						
							<input type="hidden" name="trip_no" value="${vo.trip_no}" readonly="readonly" /> 
								
							<input type="hidden" name="mno" value="${mno}" readonly="readonly" /> 
						
							<input type="text" name="title" style="width: 60%" value="${vo.title}" placeholder="제목" readonly="readonly"/><br /> <br /> 
						
							<input type="text" name="region_name" style="width: 60%" value="${vo2.region_name}" placeholder="지역" readonly="readonly"/><br /> <br />
				
							<input type="text" id="start_date" name="start_date" value="${vo.start_date}" placeholder="시작일" readonly="readonly"> 
							~ 
							<input type="text" id="end_date" name="end_date" value="${vo.end_date}" placeholder="종료일" readonly="readonly"> <br /> <br />
							
							성별 조건: 
							<c:if test="${vo.condition_sex eq 1}">
								<input type="text" id="condition_sex" name="condition_sex" value="남자" placeholder="성별조건" readonly="readonly"> <br /> <br />							
							</c:if>
							<c:if test="${vo.condition_sex eq 2}">
								<input type="text" id="condition_sex" name="condition_sex" value="여자" placeholder="성별조건" readonly="readonly"> <br /> <br />							
							</c:if>
						
							연령 조건: <input type="text" id="condition_age" name="condition_age" value="${vo.condition_age}" placeholder="나이조건" readonly="readonly"> <br /> <br />
							
				
							 <br />
							<textarea name="content"  rows="10"
							cols="100" style="width: 766px; height: 412px; display: none">
								${vo.content}		
							</textarea>
							${vo.content}	
							<br /><br />	
															
						</form>	
						
					<input type="button" id="updatebutton" value="수정" />
					<input type="button" id="cancelbutton" value="삭제" />
					<input type="button" id="okbutton" value="확인" />
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
	
	<script>

		
		$(document).ready(function() {
			
			//전송버튼 클릭이벤트
			$("#updatebutton").click(function() {			
				//폼 submit
				$("#frm").submit();
			})
			
			$("#homebutton").click(function() {
				location = '../index';
			})
			
			$("#cancelbutton").click(function() {
				
				var trip_no = ${vo.trip_no};
				alert("여행 번호: " + trip_no);
				getDeleteTour();
				location = '../index';
			})
			
			$("#okbutton").click(function() {
				location = '../tour/TourBoard';
			})

			// 지역 검색: 해당 지역의 여행정보 썸네일들을 읽어오는 함수 정의 
			function getDeleteTour() {
				
				var url = '/project/tour/TourRegisterInsert/' + ${vo.trip_no};

				$.getJSON(url, function(){
					alert("삭제되었습니다");
				});// end getJSON()

			};//end of getThumnails()
		
		});
	</script>


	<script src="../resources/theme/js/bootstrap.js"></script>
	<script src="../resources/theme/js/plugins.js"></script>
	<script src="../resources/theme/js/main.js"></script>

</body>
</html>