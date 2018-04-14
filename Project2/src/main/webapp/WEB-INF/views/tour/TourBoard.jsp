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
	#hiddenSearch {
		display: none;
		z-index: 100;
	}
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
#TourDetail,#TopReview{
	width: 1330px;
}

.portfolio-thumb{
	width: 298px;
	height: 240px;
	vertical-align: middle;
	margin-bottom: 5px;

}

#img_age{
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
#region_select{
	width: 700px;
	border: 1px solid #ff5028;
}
#region_name{
	width: 600px;
	border: 0;
}
#region_search{
	float: right;
	display: inline-block;
	width: 90px;
	border: 0;
	background-color: #ff5028;
	color: #FFFFFF;
	font-weight: bold;
}
.inside_div_conditon{
	width: 280px;
	margin: 10px;
}
#btn_create_tour{
	width: 100%;
	height: 100%;
	background-color: #ff5028;
	color: #FFFFFF;
	font-weight: bold;
	border: none;
	font-size: 20px;
}
.date{
	width: 133px;
	display: inline-block;
}
#period_search{
	width: 280px;
	height: 25px;
	padding: 0;
	background-color: #ff5028;
	color: #FFFFFF;
	border: none;
	font-size: 15px;
}
#condition_table tr{
	height: 40px;
}
#condition_table th{
	width: 40px;
}
#do_detail_search{
	width: 100%;
	height: 100%;
	padding: 0;
	background-color: #848484;
	color: #FFFFFF;
	border: none;
	font-size: 15px;
}
#show_detail_search{
	
	display: inline-block;
	width: 90px;
	height: 42px;
	background-color: #ff5028;
	color: #FFFFFF;
	font-weight: bold;
}
#condition_box{
	 position: fixed;
  margin: 0 auto;
  top: 400px;
  right: 20px;
}

</style>


</head>
<body>

	<%@ include file="../main-header2.jsp"%>

	<div class="site-main" id="sTop">

		<!-- /.site-header -->
		<div class="site-slider">
			<div class="slider">
				<div class="flexslider">
					<ul class="slides">
						<li style="z-index: 300;">
							<div></div><img src="../resources/theme/images/mainindex3.png" alt="" style="margin-top: 10.8%;">
							<div class="slider-caption visible-md visible-lg" style="text-align: center; top: 40%;">
								<img style="width: 40%; height: 30%; vertical-align: middle; display: inline-block;" src="../resources/theme/images/tour-main.png" alt=""/>
							</div>
						</li>
						<li>
							<div></div><img src="../resources/theme/images/mainindex2.png" alt="" style="margin-top: 10.8%;">
							<div class="slider-caption visible-md visible-lg" style="text-align: center; top: 40%;">
								<img style="width: 40%; height: 30%; vertical-align: middle; display: inline-block;" src="../resources/theme/images/main_string.png" alt=""/>
							</div>
						</li>
						<!-- <li>
							<div class="overlay"></div> <img
							src="../resources/theme/images/slide2.jpg" alt="">
							<div class="slider-caption visible-md visible-lg">
								<h2>참여하고 싶은 여행을 검색해보세요</h2>
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
							<input type="text" id="region_name" name="region_name" placeholder="지역이름">
							<button type="button" id="region_search">장소 검색</button>
						</div>
						<button type="button" id="show_detail_search">기간 검색</button>
					</div>
					<div style="height: 100px;">
					</div>
					<div id='hiddenSearch' hidden="hidden" style="border: 1px solid #ff5028; width: 300px; position: absolute;">
						<div class="inside_div_conditon" style="heigth: 100px;">
							<input type="text" id="start_date" name="start_date" class="date" placeholder="시작일"><p style="font-size: 20px; width: 10px; display: inline-block;">~</p> 
							<input type="text" id="end_date" name="end_date"  class="date" placeholder="종료일">
							<button type="button" id="period_search">검색</button>
						</div>
					</div>
					
					
					<div id="condition_box" style="width: 300px; height: 310px; border: 1px solid gray; z-index:200; background-color: #FFFFFF">
						<div class="inside_div_conditon" style="height: 50px;">
							
							<button id="btn_create_tour"><img style="width: 30px; height: 30px; vertical-align: middle; display: inline-block;" src="../resources/theme/images/tour-btn.png" alt=""/>여행 등록</button>
						</div>
						<div class="inside_div_conditon" style="height: 30px; border-top: 1px dotted gray;">
							<p style="font-size: 16px; font-weight: bold;">상세검색</p>
						</div>
						<div class="inside_div_conditon" style="height: 150px;">
							<table id="condition_table">
								<tr>
									<th>지역</th>
									<td><input type="text" id="region_name2" name="region_name2" placeholder="지역이름" style="height: 30px; width:230px; border-left: none; border-right: none; border-top: none; border-bottom: 1px solid gray;"></td>
								</tr>
								<tr>
									<th>기간</th>
									<td><input type="text" id="start_date2" name="start_date2" placeholder="시작일" style="height: 30px; width:230px; border-left: none; border-right: none; border-top: none; border-bottom: 1px solid gray;"></td>
								</tr>
								<tr>		
									<th>성별</th>						
									<td>
									<input type="radio" name="condition_sex" id="condition_sex" value="1" />남자  
									<input type="radio" name="condition_sex" id="condition_sex" value="0" />여자  
									<input type="radio" name="condition_sex" id="condition_sex" value="2" checked="checked" />조건없음 
									</td>
								</tr>
								<tr>
									<th>연령</th>
									<td>
									<input type="radio" name="condition_age" id="condition_age" value="1" />20대  
									 <input type="radio" name="condition_age" id="condition_age" value="2" />30대 
									<input type="radio" name="condition_age" id="condition_age" value="3" />40대 이상  
									 <input type="radio" name="condition_age" id="condition_age"  value="4" checked="checked" />조건없음
									</td>
								 </tr>		 
						</table>
						</div>
						<div class="inside_div_conditon" style="height: 30px;">
							<button type="button" id="do_detail_search">상세 검색</button>
						</div>
						
					</div>
					
					
				
						
				</div>
				
				<div class="row" id="tourDetailSearch">
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
	
	<script>
	
		$(document).ready(function() {
			
			getThumnails_By_Default();
			
			// 디폴트로 나오는 게시글
			function getThumnails_By_Default() {
				
				// wm_image 리스트
				imageList = [];
				// wm_tour 리스트(제목)
				titleList = [];
				// wm_tour_region 리스트(지역)
				regionList = [];
				
				var url1 = '/project/index/defaultimage';
				$.getJSON(url1, function(data1) {
					$(data1).each(function() {
						imageList.push({img_url: this.img_url, content_no: this.content_no, tour: {}, city: {}, condition_sex: {}, condition_age: {}, expire: {}});	
					});
					
					var url2 = '/project/index/defaulttitle';
					$.getJSON(url2, function(data2) {
						$(data2).each(function() {
							titleList.push({trip_no: this.trip_no, title: this.title, condition_sex: this.condition_sex, condition_age: this.condition_age, expire: this.expire});	
						});
						console.log(titleList);
						
						var url3 = '/project/index/defaultregion';
						$.getJSON(url3, function(data3) {
							$(data3).each(function() {
								var name = this.region_name.split(",");
								var tagname = '';
								for(var i=0; i<name.length; i++){
									tagname +="#"+name[i]+" ";
								}
								
								regionList.push({region_name: tagname, trip_no: this.trip_no});	
							});
						
							for (var i = 0; i < imageList.length; i++) {
								for (var j = 0; j < titleList.length; j++) {
									if (imageList[i].content_no == titleList[j].trip_no) {
										imageList[i].tour = titleList[j].title;
										imageList[i].condition_sex = titleList[j].condition_sex;
										imageList[i].condition_age = titleList[j].condition_age;
										imageList[i].expire = titleList[j].expire;
									} 
									for (var k = 0; k < regionList.length; k++) {
										if (imageList[i].content_no == regionList[k].trip_no) {
											imageList[i].city = regionList[k].region_name;
										} 
									}	
								}	
							}	
							
							getAllThumnail();
						});

					});
		
				});// end getJSON()
		
			};//end of getThumnails()
		
	
			// 지역 검색: 해당 지역의 여행정보 썸네일들을 읽어오는 함수 정의 
			function getThumnails_By_Region() {
				
				// wm_image 리스트
				imageList = [];
				// wm_tour 리스트(제목)
				titleList = [];
				// wm_tour_region 리스트(지역)
				regionList = [];
				
				var url1 = '/project/index/regionimage/' + $('#region_name').val();
				$.getJSON(url1, function(data1) {
					$(data1).each(function() {
						imageList.push({img_url: this.img_url, content_no: this.content_no, tour: {}, city: {}, condition_sex: {}, condition_age: {}, expire: {}});	
					});
					
					var url2 = '/project/index/regiontitle/' + $('#region_name').val();
					$.getJSON(url2, function(data2) {
						$(data2).each(function() {
							titleList.push({trip_no: this.trip_no, title: this.title, condition_sex: this.condition_sex, condition_age: this.condition_age, expire: this.expire});	
						});
						console.log(titleList);
						
						var url3 = '/project/index/regionregion/' + $('#region_name').val();
						$.getJSON(url3, function(data3) {
							$(data3).each(function() {
								var name = this.region_name.split(",");
								var tagname = '';
								for(var i=0; i<name.length; i++){
									tagname +="#"+name[i]+" ";
								}
								
								regionList.push({region_name: tagname, trip_no: this.trip_no});	
							});
						
							for (var i = 0; i < imageList.length; i++) {
								for (var j = 0; j < titleList.length; j++) {
									if (imageList[i].content_no == titleList[j].trip_no) {
										imageList[i].tour = titleList[j].title;
										imageList[i].condition_sex = titleList[j].condition_sex;
										imageList[i].condition_age = titleList[j].condition_age;
										imageList[i].expire = titleList[j].expire;
									} 
									for (var k = 0; k < regionList.length; k++) {
										if (imageList[i].content_no == regionList[k].trip_no) {
											imageList[i].city = regionList[k].region_name;
										} 
									}	
								}	
							}		

							getAllThumnail();
						});
								
					});

				});// end getJSON()

			};//end of getThumnails()
			
			
			
			// 기간 검색: 해당 기간의 여행정보 썸네일들을 읽어오는 함수 정의 
			function getThumnails_By_Period() {
				
				// wm_image 리스트
				imageList = [];
				// wm_tour 리스트(제목)
				titleList = [];
				// wm_tour_region 리스트(지역)
				regionList = [];
				
				var url1 = '/project/index/periodimage/' + $('#start_date').val() + "/" + $('#end_date').val();
				$.getJSON(url1, function(data1) {
					$(data1).each(function() {
						imageList.push({img_url: this.img_url, content_no: this.content_no, tour: {}, city: {}, condition_sex: {}, condition_age: {}, expire: {}});	
					});
					
					var url2 = '/project/index/periodtitle/' + $('#start_date').val() + "/" + $('#end_date').val();
					$.getJSON(url2, function(data2) {
						$(data2).each(function() {
							titleList.push({trip_no: this.trip_no, title: this.title, condition_sex: this.condition_sex, condition_age: this.condition_age, expire: this.expire});	
						});
						console.log(titleList);
						
						var url3 = '/project/index/periodregion/' + $('#start_date').val() + "/" + $('#end_date').val();
						$.getJSON(url3, function(data3) {
							$(data3).each(function() {
								var name = this.region_name.split(",");
								var tagname = '';
								for(var i=0; i<name.length; i++){
									tagname +="#"+name[i]+" ";
								}
								
								regionList.push({region_name: tagname, trip_no: this.trip_no});	
							});
						
							for (var i = 0; i < imageList.length; i++) {
								for (var j = 0; j < titleList.length; j++) {
									if (imageList[i].content_no == titleList[j].trip_no) {
										imageList[i].tour = titleList[j].title;
										imageList[i].condition_sex = titleList[j].condition_sex;
										imageList[i].condition_age = titleList[j].condition_age;
										imageList[i].expire = titleList[j].expire;
									} 
									for (var k = 0; k < regionList.length; k++) {
										if (imageList[i].content_no == regionList[k].trip_no) {
											imageList[i].city = regionList[k].region_name;
										} 
									}	
								}	
							}
							
							getAllThumnail();
						});
					
					});

				});// end getJSON()

			};//end of getThumnails()
			
			
			// 상세 검색
			function getThumnails_By_Detail_Search() {
				
				// wm_image 리스트
				imageList = [];
				
				var region_name = $('#region_name2').val();
				var start_date = $('#start_date2').val();
				var condition_sex = $('input:radio[name=condition_sex]:checked').val();
				var condition_age = $('input:radio[name=condition_age]:checked').val();
				
				if (region_name == '') {
					region_name = '없음';
				}
				
				if (start_date == '') {
					start_date = '없음';
				}
				
				var url1 = '/project/index/detailsearchImage/' + region_name + "/" + start_date + "/" + condition_sex + "/" + condition_age;
				$.getJSON(url1, function(data1) {
					$(data1).each(function() {
						var name = this.region_name.split(",");
						var tagname = '';
						for(var i=0; i<name.length; i++){
							tagname +="#"+name[i]+" ";
						}
						imageList.push({img_url: this.img_url, trip_no: this.trip_no, title: this.title, region_name: tagname, condition_sex: this.condition_sex, condition_age: this.condition_sex, expire: this.expire});	
						console.log(data1);
					});
								
					getAllThumnail_detail_search();
	
				});// end getJSON()

			};//end of getThumnails()
			
			
			
			
			
			
			function getAllThumnail() {
				
				var list = '';
				
				
				
				for(var i = 0; i<imageList.length; i++){
					
				
					if (imageList[i].expire == 0) {
						
				
						list += '<div class="portfolio-item col-md-3 col-sm-6">'
							+'<a href="../tour/detail?trip_no=' + imageList[i].content_no + '">'
								+ '<div class="portfolio-thumb">'
									+'<img src="../' + imageList[i].img_url + '" id="img_tour" style="position: absolute; width: 300px; height:240px; z-index:99;">'
									+'<div style="position: absolute; height:40px; z-index:100; bottom:0; right:0;">';
									switch(imageList[i].condition_sex){
										case 0: list+='<img src="../resources/theme/images/main_female.png" style="display: inline-block;z-index:100; width:40px; height:40px;">';
											break;
										case 1: list+='<img src="../resources/theme/images/main_male.png" style="display: inline-block;z-index:100; width:40px; height:40px;">';
											break;
										case 2: list+='<img src="../resources/theme/images/main_all.png" style="display: inline-block;z-index:100; width:40px; height:40px;">';
											break;
										default: break;
									}	
									switch(imageList[i].condition_age){
									case 1: list+='<p id="img_age">20</p>';
										break;
									case 2: list+='<p id="img_age">30</p>';
										break;
									case 3: list+='<p id="img_age">40↑</p>';
										break;
									case 4: list+='<p id="img_age">All</p>';
										break;
									default: break;
								}
										
									list+='</div>'
								+ '</div>'
									+ '<div class="tour_title">' + imageList[i].tour + '</div>'
									+ '<div class="tour_region">' + imageList[i].city + '</div>'			
							+'</a>'
	
							+ '</div>';
					}
				}

				$('#tourDetailSearch').html(list);
	
				//end of getThumnails()
			};
			
			function getAllThumnail_detail_search(){
				
				var list = '';

			
				
				for(var i = 0; i<imageList.length; i++){
					
					if (imageList[i].expire == 0) {
						
					list += '<div class="portfolio-item col-md-3 col-sm-6">'
							+'<a href="../tour/detail?trip_no=' + imageList[i].trip_no + '">'
							+ '<div class="portfolio-thumb">'
								+'<img src="../' + imageList[i].img_url + '" id="img_tour" style="position: absolute; width: 300px; height:240px; z-index:99;">'
								+'<div style="position: absolute; height:40px; z-index:100; bottom:0; right:0;">';
								switch(imageList[i].condition_sex){
									case 0: list+='<img src="../resources/theme/images/main_female.png" style="display: inline-block;z-index:100; width:40px; height:40px;">';
										break;
									case 1: list+='<img src="../resources/theme/images/main_male.png" style="display: inline-block;z-index:100; width:40px; height:40px;">';
										break;
									case 2: list+='<img src="../resources/theme/images/main_all.png" style="display: inline-block;z-index:100; width:40px; height:40px;">';
										break;
									default: break;
								}	
								switch(imageList[i].condition_age){
								case 1: list+='<p id="img_age">20</p>';
									break;
								case 2: list+='<p id="img_age">30</p>';
									break;
								case 3: list+='<p id="img_age">40↑</p>';
									break;
								case 4: list+='<p id="img_age">All</p>';
									break;
								default: break;
							}
									
								list+='</div>'
							+ '</div>'
								+ '<div class="tour_title">' + imageList[i].title + '</div>'
								+ '<div class="tour_region">' + imageList[i].region_name + '</div>'			
						+'</a>'

						+ '</div>';
					}
					
					$('#tourDetailSearch').html(list);
				}
				//end of getThumnails()
			};
						

			// 지역 검색 버튼 처리
			$('#region_search').click(function() {
	
				var region_name = $('#region_name').val();
	
				if (region_name == "") {
					alert('검색할 지역을 입력하세요');
				} else {
					alert('지역 검색 메소드 호출 ');
					getThumnails_By_Region();
				}
	
			});
		

			// 기간 검색 버튼 처리			
			$('#period_search').click(function(){
				
				var start_date = $('#start_date').val();
				var end_date = $('#end_date').val();
				
				if (start_date == "" || end_date == "") {
					alert('검색할 기간을 선택하세요');		
				} else {				
					alert('기간 검색 메소드 호출');
					getThumnails_By_Period();			
				}
				$('#show_detail_search').hide();
			}); 
			
			
			var show = true;
			// 상세 검색 보여주기 버튼 처리			
			$('#show_detail_search').click(function() {
				if(show){
					var buttonOffset = $(this).offset();
					console.log(buttonOffset);
					$('#hiddenSearch').css("left", (buttonOffset.left+30)+"px");
					$('#hiddenSearch').css("top", (buttonOffset.top+50)+"px");
					$('#hiddenSearch').show();
					show=false;
				}else{
					$('#hiddenSearch').hide();
					show=true;
				}
			
			});
			
			$('#do_detail_search').click(function() {	
				getThumnails_By_Detail_Search();
			});
			
			
			$("#start_date, #end_date").datepicker({
				dateFormat : 'yy-mm-dd'
			});
			
			$("#start_date2").datepicker({
				dateFormat : 'yy-mm-dd'
			});
			
			$('#btn_create_tour').click(function() {
				location = '../tour/GoRegister';
			});
			
		});
	</script>
</body>
</html>