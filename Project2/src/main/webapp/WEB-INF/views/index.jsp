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
<link rel="stylesheet" href="<c:url value="/resources/theme/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/theme/css/font-awesome.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/theme/css/animate.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/theme/css/templatemo_misc.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/theme/css/templatemo_style.css"/>">
<link rel="stylesheet" href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script src="resources/theme/js/vendor/modernizr-2.6.1-respond-1.1.0.min.js"></script>
<style>
.portfolio-item{
	height: 320px;
	width: 302px;
	margin: 5px;
	padding: 0;
	border: 1px solid lightgray;
}
.portfolio-item:hover{
	border: 3px solid #ff5028;
}
#TourDetail,#TopReview, #RecentReview{
	width: 1330px; 	
}

.portfolio-thumb{
	width: 297.5px;
	height: 240px;
	vertical-align: middle;
	margin-bottom: 5px;

}

#condition_age{
	display: inline-block;
	z-index:100; 
	width:40px; 
	height:40px;
	background-color: #4e4e4f;
	font-weight: 600;
	font-size: 25px;
	color: #FFFFFF;
	text-align: center;
	vertical-align: top;
}

.tour_title{
	font-size: 20px;
	font-weight: bold;
	color: #4e4e4f;
	margin-left: 10px;
	font-family:monospace
}

.tour_region{
	font-size: 15px;
	color: ligthgray;
	margin-left: 10px;
	font-family:monospace
}
.tour_hist{
 display: inline-block;
 font-size: 10px;
 font-weight: normal;
 color: #878484;
 float: right;
}


</style>
</head>
<body>

	<%-- <%@ include file="top_header.jspf"%> --%>

	<div class="site-main" id="sTop">
		<div class="site-header" >
			<div class="main-header" style="top: 0.5%;">
				<div class="container">
					<div id="menu-wrapper">
						<div class="row">
							<div class="logo-wrapper col-md-2 col-sm-2">
								<h1> <a href="#"><img alt="" src="resources/theme/images/mainlogo2.jpg" style="width: 240px; height: 100px;"></a> </h1>
							</div>
							<!-- /.logo-wrapper -->
							<div class="col-md-10 col-sm-10 main-menu text-right">
								<div class="toggle-menu visible-sm visible-xs">
									<i class="fa fa-bars"></i>
								</div>
								<ul class="menu-first">
									<li class="active"><a href="#">MAIN</a></li>
									<li><a href="#services1">TOP REVIEWS</a></li>
									<li><a href="#services2">LATEST REVIEWS</a></li>
									<li><a href="#portfolio">TRAVEL LIST</a></li>
									<c:if test="${not empty mno}">
										<li><a href="mypage/MyPage">MYPAGE</a></li>
									</c:if>
									<c:if test="${authority eq 3}">
										<li><a href="admin/admin">ADMIN</a></li>
									</c:if>
									<c:if test="${empty mno}">
										<li><a href="member/member_register01">Sign in</a></li>
										<li><a href="member/login">LOGIN</a></li>
									</c:if>
									<c:if test="${not empty mno}">
										<li><a href="member/logout">LOGOUT</a></li>
									</c:if>
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
							<div></div>
							<img src="resources/theme/images/mainindex3.png" alt="" style="margin-top: 10.8%;">
							<div class="slider-caption visible-md visible-lg" style="text-align: center; top: 40%;">
								<img style="width: 40%; height: 30%; vertical-align: middle; display: inline-block;" src="resources/theme/images/main_string.png" alt=""/>
							</div>
						</li>
						<li>
							<div></div>
							<img src="resources/theme/images/mainindex2.png" alt="" style="margin-top: 10.8%;">
							<div class="slider-caption visible-md visible-lg" style="text-align: center; top: 40%;">
								<img style="width: 40%; height: 30%; vertical-align: middle; display: inline-block;" src="resources/theme/images/main_string.png" alt=""/>
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

	<br /><br /><br /><br />
	

	<div class="content-section" id="services1">
		<img src="resources/theme/images/top4reviews.png" alt="" style="width: 100%">
		<br /><br />
		<div class="container">
			<div class="heading-section col-md-12 text-center">
				<h2>최고의 후기를 살펴보세요</h2><br/>
			</div>

			<!-- /.row -->
			<br />
		
			<div class="row" id="TopReview">

			</div>
			<!-- /.row -->
		</div>
		<!-- /.container -->
	</div>
	
	<br /><br /><br /><br /><br /><br /><br /><br />
	
	<div class="content-section" id="services2">
		<!-- <br /><br />	
		<div class="container">
			<div class="row">
				<div class="heading-section col-md-12 text-center">
					<h2>Recent Review</h2><br/><br/>
					<h1>최신 후기를 살펴보세요</h1>
				</div>
				<div class="heading-section col-md-12 text-center">
					<h2><a href="review/reviewBoard">전체보기</a></h2>
				</div>
			</div>  -->
		<img src="resources/theme/images/latestreviews.png" alt="" style="width: 100%">
		<br /><br />
		<div class="container">
			<div class="heading-section col-md-12 text-center">
				<h2>최신 후기를 살펴보세요</h2><br/><br/>
				<h2><a href="review/reviewBoard">전체보기</a></h2>
			</div>	
			
			<br />
			
			<div class="row" id="RecentReview">
			
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container -->
	</div>
	<!-- /#services -->
	
	<br /><br /><br /><br />
	
	<div class="content-section" id="portfolio">
		<!-- <div class="container">
			<div class="row">
				<div class="heading-section col-md-12 text-center">
					<h2>여행 리스트</h2><br/><br/>
					<h1>함께 여행할 사람들을 찾아보세요</h1>
				</div>
				<div class="heading-section col-md-12 text-center"> 
					<h2><a href="tour/tourBoard">전체보기</a></h2>
					<br /><br />
					<h2><a href="tour/GoRegister">여행 등록하러 가기</a></h2>
				</div>
				/.heading-section
			</div> -->
		<img src="resources/theme/images/travellists.png" alt="" style="width: 100%">
		<br /><br />
		<div class="container">
			<div class="heading-section col-md-12 text-center">
				<h2>함께 여행할 사람들을 찾아보세요</h2><br/><br/>
				<h2><a href="tour/tourBoard">전체보기</a></h2>
			</div>	
			
			<br />
			
			<div class="row" id="TourDetail">

			</div>

			<!-- /.row -->
		</div>
		<!-- /.container -->
	</div>
	<!-- /#portfolio -->

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
		
		getThumnails_By_Default_TOUR();
		getThumnails_By_Default_TOPREVIEW();
		getThumnails_By_Default_RECENTREVIEW();
		
		// 디폴트로 나오는 후기 게시글 데이터를 가져오기
		function getThumnails_By_Default_TOPREVIEW() {
			
			// wm_image 배열
			TopReviewImage = [];
			// wm_review 배열(제목)
			TopReviewTitle = [];
			// wm_review_region 배열(지역)
			TopReviewRegion = [];
			
			var url1 = '/project/review/Topdefaultimage';
			$.getJSON(url1, function(data1) {
				$(data1).each(function() {
					TopReviewImage.push({img_url: this.img_url, content_no: this.content_no, tour: {}, city: {}, hits: {}, countofbest: {}});	
				});
				
				var url2 = '/project/review/Topdefaulttitle';
				$.getJSON(url2, function(data2) {
					$(data2).each(function() {
						TopReviewTitle.push({review_no: this.review_no, title: this.title, hits: this.hits, countofbest: this.countofbest});	
					});
					console.log(TopReviewTitle);
					
					var url3 = '/project/review/Topdefaultregion';
					$.getJSON(url3, function(data3) {
						$(data3).each(function() {
							var name = this.region_name.split(",");
							var tagname = '';
							for(var i=0; i<name.length; i++){
								tagname +="#"+name[i]+" ";
							}
							
							TopReviewRegion.push({region_name: tagname, review_no: this.review_no});	
						});
					
						for (var i = 0; i < TopReviewImage.length; i++) {
							for (var j = 0; j < TopReviewTitle.length; j++) {
								if (TopReviewImage[i].content_no == TopReviewTitle[j].review_no) {
									TopReviewImage[i].tour = TopReviewTitle[j].title;
									TopReviewImage[i].hits = TopReviewTitle[j].hits;
									TopReviewImage[i].countofbest = TopReviewTitle[j].countofbest;
								} 
								for (var k = 0; k < TopReviewRegion.length; k++) {
									if (TopReviewImage[i].content_no == TopReviewRegion[k].review_no) {
										TopReviewImage[i].city = TopReviewRegion[k].region_name;
									} 
								}	
							}	
						}	
						
						getAllThumnail_TOPREVIEW();
					});
	
				});
	
			});// end getJSON()
	
		};//end of getThumnails()
		
		// 디폴트로 나오는 후기 게시글 데이터를 가져오기
		function getThumnails_By_Default_RECENTREVIEW() {
			
			// wm_image 배열
			RecentReviewImage = [];
			// wm_review 배열(제목)
			RecentReviewTitle = [];
			// wm_review_region 배열(지역)
			RecentReviewRegion = [];
			
			var url1 = '/project/review/defaultimage';
			$.getJSON(url1, function(data1) {
				$(data1).each(function() {
					RecentReviewImage.push({img_url: this.img_url, content_no: this.content_no, tour: {}, city: {}, hits: {}, countofbest: {}});	
				});
				
				var url2 = '/project/review/defaulttitle';
				$.getJSON(url2, function(data2) {
					$(data2).each(function() {
						RecentReviewTitle.push({review_no: this.review_no, title: this.title, hits: this.hits, countofbest: this.countofbest});	
					});
					console.log(RecentReviewTitle);
					
					var url3 = '/project/review/defaultregion';
					$.getJSON(url3, function(data3) {
						$(data3).each(function() {
							var name = this.region_name.split(",");
							var tagname = '';
							for(var i=0; i<name.length; i++){
								tagname +="#"+name[i]+" ";
							}
							
							RecentReviewRegion.push({region_name: tagname, review_no: this.review_no});	
						});
					
						for (var i = 0; i < RecentReviewImage.length; i++) {
							for (var j = 0; j < RecentReviewTitle.length; j++) {
								if (RecentReviewImage[i].content_no == RecentReviewTitle[j].review_no) {
									RecentReviewImage[i].tour = RecentReviewTitle[j].title;
									RecentReviewImage[i].hits = RecentReviewTitle[j].hits;
									RecentReviewImage[i].countofbest = RecentReviewTitle[j].countofbest;

								} 
								for (var k = 0; k < RecentReviewRegion.length; k++) {
									if (RecentReviewImage[i].content_no == RecentReviewRegion[k].review_no) {
										RecentReviewImage[i].city = RecentReviewRegion[k].region_name;
									} 
								}	
							}	
						}	
						
						getAllThumnail_RECENTREVIEW();
					});
	
				});
	
			});// end getJSON()
	
		};//end of getThumnails()
		
		// 디폴트로 나오는 여행 게시글 데이터를 가져오기
		function getThumnails_By_Default_TOUR() {
			
			// wm_image 배열
			TourImage = [];
			// wm_tour 배열(제목)
			TourTitle = [];
			// wm_tour_region 배열(지역)
			TourRegion = [];

			var url1 = '/project/index/defaultimage';
			$.getJSON(url1, function(data1) {
				$(data1).each(function() {
					TourImage.push({img_url: this.img_url, content_no: this.content_no, tour: {}, city: {}, condition_sex: {}, condition_age: {}, expire: {}});	
				});
				console.log(TourImage);
				
				var url2 = '/project/index/defaulttitle';
				$.getJSON(url2, function(data2) {
					$(data2).each(function() {
						TourTitle.push({trip_no: this.trip_no, title: this.title, condition_sex: this.condition_sex, condition_age: this.condition_age, expire: this.expire});	
					});	
					
					var url3 = '/project/index/defaultregion';
					$.getJSON(url3, function(data3) {
						$(data3).each(function() {
							var name = this.region_name.split(",");
							var tagname = '';
							for(var i=0; i<name.length; i++){
								tagname +="#"+name[i]+" ";
							}
							
							TourRegion.push({region_name: tagname, trip_no: this.trip_no});	
						});
					
						for (var i = 0; i < TourImage.length; i++) {
							for (var j = 0; j < TourTitle.length; j++) {
								if (TourImage[i].content_no == TourTitle[j].trip_no) {
									TourImage[i].tour = TourTitle[j].title;
									TourImage[i].condition_sex = TourTitle[j].condition_sex;
									TourImage[i].condition_age = TourTitle[j].condition_age;
									TourImage[i].expire = TourTitle[j].expire;
								} 
								for (var k = 0; k < TourRegion.length; k++) {
									if (TourImage[i].content_no == TourRegion[k].trip_no) {
										TourImage[i].city = TourRegion[k].region_name;
									} 
								}	
							}	
						}		
						
						getAllThumnail_TOUR();
					});
				});
			});// end getJSON()	
		};//end of getThumnails()
		
		
		// 가져온 TOP후기 데이터를 뿌려주자
		function getAllThumnail_TOPREVIEW() {
			var list = '';
			
			var length = 0;
			
			if (TopReviewImage.length < 4) {
				length = TopReviewImage.length;
			} else {
				length = 4;
			}
			// 무조건 4개만 뿌린다!
			
			for(var i = 0; i < length; i++){
		
				list += '<div class="portfolio-item col-md-3 col-sm-6">'
						+ '<a href="review/review_detail?review_no=' + TopReviewImage[i].content_no + '">'
							+ '<div class="portfolio-thumb">'
								+'<img src="' + TopReviewImage[i].img_url + '" class="img_view" width="300" height="240">'
								+'<div style="position: absolute; height:40px; z-index:100; top:0; left:0;">';
										switch(i){
											case 0: list+='<img src="resources/theme/images/king_review.png" style="display: inline-block;z-index:100; width:80px; height:80px;">';
												break;
											case 1: list+='<p id="condition_age">2</p>';
												break;
											case 2: list+='<p id="condition_age">3</p>';
												break;
											case 3: list+='<p id="condition_age">4</p>';
												break;
											default: break;
										}	
							
							list+= '</div></div>'
							+ '<div class="tour_title">' + TopReviewImage[i].tour + '</div>'
							+ '<div class="tour_region">' + TopReviewImage[i].city + '<p class="tour_hist">|&nbsp;조회수: ' + TopReviewImage[i].hits + '&nbsp;| 좋아요: ' + TopReviewImage[i].countofbest + '&nbsp;|</p></div>'	
						+ '</a>'
						+ '</div>';
			}

			$('#TopReview').html(list);
		};
		
		// 가져온 최신후기 데이터를 뿌려주자
		function getAllThumnail_RECENTREVIEW() {	
			var list = '';
			
			var length = 0;
			
			if (RecentReviewImage.length < 4) {
				length = RecentReviewImage.length;
			} else {
				length = 4;
			}
			
			for(var i = 0; i < length; i++){
		
				list += '<div class="portfolio-item col-md-3 col-sm-6">'
						+ '<a href="review/review_detail?review_no=' + RecentReviewImage[i].content_no + '">'
						+ '<div class="portfolio-thumb">'
							+'<img src="' + RecentReviewImage[i].img_url + '" class="img_view" width="300" height="240">'
						+ '</div>'
						+ '<div class="tour_title">' + RecentReviewImage[i].tour + '</div>'
						+ '<div class="tour_region">' + RecentReviewImage[i].city + '<p class="tour_hist">|&nbsp;조회수: ' + RecentReviewImage[i].hits + '&nbsp;| 좋아요: ' + RecentReviewImage[i].countofbest + '&nbsp;|</p></div>'							
						+'</a>'
						+ '</div>';
			}

			$('#RecentReview').html(list);

		};

		// 가져온 여행 데이터를 뿌려주자
		function getAllThumnail_TOUR() {
			var list = '';
			
			var length = 0;
			
			if (TourImage.length < 8) {
				length = TourImage.length;
			} else {
				length = 8;
			}
			// 무조건 4개만 뿌린다!
			
			for(var i = 0; i < length; i++){
				/* console.log(TourImage[i].content_no); */
				if (TourImage[i].expire == 0) {
				list += '<div class="portfolio-item col-md-3 col-sm-6">'
						+ '<a href="tour/detail?trip_no=' + TourImage[i].content_no + '">'
							+ '<div class="portfolio-thumb">'
							
								+'<img src="' + TourImage[i].img_url + '" id="img_tour" style="position: absolute; width: 297.5px; height:240px; z-index:99;">'
								+'<div style="position: absolute; height:40px; z-index:100; bottom:0; right:0;">';
									switch(TourImage[i].condition_sex){
										case 0: list+='<img src="resources/theme/images/main_female.png" style="display: inline-block;z-index:100; width:40px; height:40px;">';
											break;
										case 1: list+='<img src="resources/theme/images/main_male.png" style="display: inline-block;z-index:100; width:40px; height:40px;">';
											break;
										case 2: list+='<img src="resources/theme/images/main_all.png" style="display: inline-block;z-index:100; width:40px; height:40px;">';
											break;
										default: break;
									}	
									switch(TourImage[i].condition_age){
										case 1: list+='<p id="condition_age">20</p>';
											break;
										case 2: list+='<p id="condition_age">30</p>';
											break;
										case 3: list+='<p id="condition_age">40↑</p>';
											break;
										case 4: list+='<p id="condition_age">All</p>';
											break;
										default: break;	
									}
								
									list+='</div>'
								
								+ '</div>'
								+ '<div class="tour_title">' + TourImage[i].tour + '</div>'
								+ '<div class="tour_region">' + TourImage[i].city + '</div>'	
							
			
							+'</a>'
							
						+ '</div>';
				}
			}

			$('#TourDetail').html(list);
		};

	});

	</script>

	<script src="resources/theme/js/bootstrap.js"></script>
	<script src="resources/theme/js/plugins.js"></script>
	<script src="resources/theme/js/main.js"></script>

</body>
</html>