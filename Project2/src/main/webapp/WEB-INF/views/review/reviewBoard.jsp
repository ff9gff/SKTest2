<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<title>같이가자</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 
Flex Template 
http://www.templatemo.com/tm-406-flex
-->
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
<script src="../resources/theme/js/vendor/modernizr-2.6.1-respond-1.1.0.min.js"></script>
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
.portfolio-thumb{
	width: 297.5px;
	height: 240px;
	vertical-align: middle;
	margin-bottom: 5px;

}
.tour_title{
	font-size: 20px;
	font-weight: bold;
	color: #4e4e4f;
	margin-left: 10px;
	font-family:monospace;
	text-align: left;
}

.tour_region{
	font-size: 15px;
	color: ligthgray;
	margin-left: 10px;
	font-family:monospace;
	text-align: left;
}
.tour_hist{
 display: inline-block;
 font-size: 10px;
 font-weight: normal;
 color: #878484;
 float: right;
}
#select_search{
	float: right;
	display: inline-block;
	width: 90px;
	border: 0;
	background-color: #ff5028;
	color: #FFFFFF;
	font-weight: bold;
}
#region_select{
	width: 700px;
	border: 1px solid #ff5028;
}
#region_name{
	width: 600px;
	border: 0;
}
#btn_create_review{
	width: 100%;
	height: 100%;
	background-color: #ff5028;
	color: #FFFFFF;
	font-weight: bold;
	border: none;
	font-size: 20px;
}
.inside_div_conditon{
	width: 180px;
	margin: 10px;
}
#condition_box{
	 position: fixed;
  margin: 0 auto;
  top: 400px;
  right: 20px;
}
.like_img{
	width: 15px;
	height: 15px;
	vertical-align: middle;
	display: inline-block;
}
</style>

</head>
<body>

	<%@ include file="../main-header2.jsp"%>
	
	<div class="site-main" id="sTop">
		
		<div class="site-slider">
			<div class="slider">
				<div class="flexslider">
					<ul class="slides">
						<li>
							<div></div>
							<img src="../resources/theme/images/mainindex3.png" alt="" style="margin-top: 10.8%;">
							<div class="slider-caption visible-md visible-lg" style="text-align: center; top: 40%;">
								<img style="width: 40%; height: 30%; vertical-align: middle; display: inline-block;" src="../resources/theme/images/review-main.png" alt=""/>
							</div>
						</li>
						<li>
							<div></div>
							<img src="../resources/theme/images/mainindex2.png" alt="" style="margin-top: 10.8%;">
							<div class="slider-caption visible-md visible-lg" style="text-align: center; top: 40%;">
								<img style="width: 40%; height: 30%; vertical-align: middle; display: inline-block;" src="../resources/theme/images/main_string.png" alt=""/>
							</div>
						</li>
						<!-- <li>
							<div class="overlay"></div> <img
							src="../resources/theme/images/backimage2.png" alt="">
							<div class="slider-caption visible-md visible-lg">
								<h2>후기를 적어 공유해봅시다</h2>
							</div>
						</li> -->
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
		<div class="container" style="width: 1300px; text-align: center; margin: 0 auto;">
			<div>
				<div style="width: 800px; margin: 0 auto;">
					<div id="region_select" style="display: inline-block;">
						<input type="text" id="region_name" name="region_name" placeholder="지역">
						<button type="button" id="select_search">장소 검색</button>
					</div>
					<input hidden type="text" id="nickname" name="nickname" placeholder="닉네임">
				</div>

				<div id="condition_box" style="width: 200px; height: 70px; border: 1px dotted gray; z-index:200; background-color: #FFFFFF">
						<div class="inside_div_conditon" style="height: 50px;">
							<button type="button" id="btn_create_review"><img style="width: 30px; height: 30px; vertical-align: middle; display: inline-block;" src="../resources/theme/images/review-btn.png" alt=""/>후기  등록</button>
						</div>	
				</div>
				<div style="height: 100px;"></div>
				<div class="row" id="reviewDetail" style="width: 1300px;">
				</div>
				<!-- /.row -->
			</div>
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
	
	<script>
	
	$(document).ready(function() {
		// 디폴트로 나오는 게시글 함수 실행	
		getThumnails_By_Default_REVIEW();
		getThumnails_By_Region_REVIEW();
		

	
	// 디폴트로 나오는 게시글
	function getThumnails_By_Default_REVIEW() {
		
		// wm_image 리스트
		imageList = [];
		// wm_tour 리스트(제목)
		titleList = [];
		// wm_tour_region 리스트(지역)
		regionList = [];
		
		var url1 = '/project/review/defaultimage';
		$.getJSON(url1, function(data1) {
			$(data1).each(function() {
				imageList.push({img_url: this.img_url, content_no: this.content_no, tour: {}, city: {}, countofbest: {}});	
			});
			
			var url2 = '/project/review/defaulttitle';
			$.getJSON(url2, function(data2) {
				$(data2).each(function() {
					titleList.push({review_no: this.review_no, title: this.title, condition_sex: this.condition_sex, condition_age: this.condition_age, countofbest: this.countofbest});	
				});
				console.log(titleList);
				
				var url3 = '/project/review/defaultregion';
				$.getJSON(url3, function(data3) {
					$(data3).each(function() {
						var name = this.region_name.split(",");
						var tagname = '';
						for(var i=0; i<name.length; i++){
							tagname +="#"+name[i]+" ";
						}
						
						regionList.push({region_name: tagname, review_no: this.review_no});	
					});
				
					for (var i = 0; i < imageList.length; i++) {
						for (var j = 0; j < titleList.length; j++) {
							if (imageList[i].content_no == titleList[j].review_no) {
								imageList[i].tour = titleList[j].title;
								imageList[i].countofbest = titleList[j].countofbest;
							} 
							for (var k = 0; k < regionList.length; k++) {
								if (imageList[i].content_no == regionList[k].review_no) {
									imageList[i].city = regionList[k].region_name;
								} 
							}	
						}	
					}	
					
					getAllThumnail_REVIEW();
				});

			});

		});// end getJSON()

	};//end of getThumnails()
	

		// 지역 검색: 해당 지역의 여행정보 썸네일들을 읽어오는 함수 정의 
		function getThumnails_By_Region_REVIEW() {
			
			// wm_image 리스트
			ReviewImage = [];
			// wm_review 리스트(제목)
			ReviewTitle = [];
			// wm_review_region 리스트(지역)
			ReviewRegion = []; 
			
			// ReviewSearchController의 review/defaultimage 메소드 실행
			var url1 = '/project/review/defaultimage';
			$.getJSON(url1, function(data1) {
				$(data1).each(function() {
					// 데이터들을 배열에 저장
					ReviewImage.push({img_url: this.img_url, content_no: this.content_no, tour: {}, city: {}, hits: {}, countofbest: {}});	
				});
				
				var url2 = '/project/review/defaulttitle';
				$.getJSON(url2, function(data2) {
					$(data2).each(function() {
						ReviewTitle.push({review_no: this.review_no, title: this.title, hits: this.hits, countofbest: this.countofbest});	
					});
					console.log(ReviewTitle);
					
					var url3 = '/project/review/defaultregion';
					$.getJSON(url3, function(data3) {
						$(data3).each(function() {
							var name = this.region_name.split(",");
							var tagname = '';
							for(var i=0; i<name.length; i++){
								tagname +="#"+name[i]+" ";
							}
							
							ReviewRegion.push({region_name: tagname, review_no: this.review_no});	
						});
					
						for (var i = 0; i < ReviewImage.length; i++) {
							for (var j = 0; j < ReviewTitle.length; j++) {
								if (ReviewImage[i].content_no == ReviewTitle[j].review_no) {
									ReviewImage[i].tour = ReviewTitle[j].title;
									ReviewImage[i].hits = ReviewTitle[j].hits;
									ReviewImage[i].countofbest = ReviewTitle[j].countofbest;
								} 
								for (var k = 0; k < ReviewRegion.length; k++) {
									if (ReviewImage[i].content_no == ReviewRegion[k].review_no) {
										ReviewImage[i].city = ReviewRegion[k].region_name;
									} 
								}	
							}	
						}	
						
						getAllThumnail_REVIEW();
					});
	
				});
	
			});// end getJSON()
	
		};//end of getThumnails()
		
		// 장소/닉네임  선택 검색: 닉네임 검색 후 리뷰 썸네일들을 읽어오는 함수 정의 
		function getThumnails_By_Nickname_REVIEW() {
			
			var region_name =  $('#region_name').val();
			var nickname =  $('#nickname').val();
			
			if (region_name == "") {
				region_name = "없음";
			}
			
			if (nickname == "") {
				nickname = "없음";
			}
			
			// wm_image 리스트
			SelectSearchReview = [];
			// wm_review 리스트(제목)
		
			// ReviewSearchController의 review/defaultimage 메소드 실행
			var url1 = '/project/review/nickname/' + region_name + '/' + nickname;
			$.getJSON(url1, function(data1) {
				$(data1).each(function() {
					// 데이터들을 배열에 저장
					var name = this.region_name.split(",");
					var tagname = '';
					for(var i=0; i<name.length; i++){
						tagname +="#"+name[i]+" ";
					}
					SelectSearchReview.push({img_url: this.img_url, title: this.title, region_name: tagname, review_no: this.review_no, hits: this.hits, countofbest: this.countofbest});			
				});
				getAllThumnail_Nickname_REVIEW()
				
			});// end getJSON()
		
	
		};//end of getThumnails()
		
		
		function getAllThumnail_REVIEW() {
			
			var list = '';
			
			for(var i = 0; i<ReviewImage.length; i++){

				list += '<div class="portfolio-item col-md-3 col-sm-6">'
					+ '<a href="../review/review_detail?review_no=' + ReviewImage[i].content_no + '">'	
					+ '<div class="portfolio-thumb">'
						+'<img src="../' + ReviewImage[i].img_url + '" class="img_view" width="300" height="240">'
					+ '</div>'
					+ '<div class="tour_title">' + ReviewImage[i].tour + '</div>'
					+ '<div class="tour_region">'  + ReviewImage[i].city +  '<p class="tour_hist">|&nbsp;조회수: ' + ReviewImage[i].hits + '&nbsp;| <img src="../resources/theme/images/likebtn.jpg" class="like_img"/>' + ReviewImage[i].countofbest	 + '&nbsp;</p></div>'	
					//+ '<div>' + imageList[i].condition_sex +  '&nbsp;&nbsp; / &nbsp;&nbsp;' + imageList[i].condition_age + '</div>'
					+'</a>'
					+ '</div>';
			}

			$('#reviewDetail').html(list);

			//end of getThumnails()
		};
		
		function getAllThumnail_Nickname_REVIEW() {
			
			var list = '';
			
			for(var i = 0; i < SelectSearchReview.length; i++){
		
				list += '<div class="portfolio-item col-md-3 col-sm-6">'
						+ '<a href="../review/review_detail?review_no=' + SelectSearchReview[i].review_no + '">'
						+ '<div class="portfolio-thumb">'
								+'<img src="../' + SelectSearchReview[i].img_url + '" class="img_view" width="300" height="240"><br/>'
						+ '</div>'
						+ '<div class="tour_title">' + SelectSearchReview[i].title + '</div>'
						+ '<div class="tour_region">'  + SelectSearchReview[i].region_name + '<p class="tour_hist">|&nbsp;조회수: ' + SelectSearchReview[i].hits + '&nbsp;| <img src="../resources/theme/images/likebtn.jpg" class="like_img"/>' + SelectSearchReview[i].countofbest + '&nbsp; </p></div>'	
						//+ '<div>' + imageList[i].condition_sex +  '&nbsp;&nbsp; / &nbsp;&nbsp;' + imageList[i].condition_age + '</div>'
						+'</a>'
						+ '</div>';
			}

			$('#reviewDetail').html(list);
		}
		
		// 지역 / 닉네임 선택 검색
		$('#select_search').click(function() {
			getThumnails_By_Nickname_REVIEW();		
		});
		
		$('#btn_create_review').click(function() {
			location ='../review/review_register';
		});
		
	});
			
	</script>
</body>
</html>