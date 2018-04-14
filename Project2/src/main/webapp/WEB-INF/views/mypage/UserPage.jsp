<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<meta name="description" content="">
      <meta name="viewport" content="width=device-width, initial-scale=1">

<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="<c:url value="../../resources/theme/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="../../resources/theme/css/font-awesome.css"/>">
<link rel="stylesheet" href="<c:url value="../../resources/theme/css/animate.css"/>">
<link rel="stylesheet" href="<c:url value="../../resources/theme/css/templatemo_misc.css"/>">
<link rel="stylesheet" href="<c:url value="../../resources/theme/css/templatemo_style.css"/>">
<link rel="stylesheet" href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />

<script src="/resources/theme/js/vendor/modernizr-2.6.1-respond-1.1.0.min.js"></script>
<script src="/resources/theme/js/bootstrap.js"></script>
<script src="/resources/theme/js/plugins.js"></script>
<script src="/resources/theme/js/main.js"></script>


<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<style type="text/css">

.portfolio-item{
	height: 320px;
	width: 302px;
	margin: 5px;
	padding: 0;
	border: 1px solid lightgray;
}

.portfolio-item-ex{
	height: 320px;
	width: 302px;
	margin: 5px;
	padding: 0;
	border: 1px solid lightgray;
	opacity: 0.5;
}

.portfolio-thumb{
	width: 297.5px;
	height: 240px;
	vertical-align: middle;
	margin-bottom: 5px;

}

#dropDownType {
	width: 50px
}

#selectOption {
	padding-left: 655px
}

ul {
	list-style-type: none;
}
.personal {
	border:none;
	width: 300px;
	height: 50px;
}

.content_profile_img{
	width: 200px;
	height: 200px;
	vertical-align: middle;
	display: inline-block;
	border-radius: 70px;
	-moz-border-radius: 70px;
	-khtml-border-radius: 70px;
	-webkit-border-radius: 70px;
	margin: auto;
}

#tourchoose {
	
}

#profilemenu{
	width: 400px;
	height: 300px;
	position: absolute;
	background-color: #FFFFFF;
	border:solid 1px #ccc; 
	box-shadow: 0px 1px 20px #333;
	z-index:100; 
	text-align: center;
	vertical-align: middle;

}

#profilemenu table{
	width: 680px;
	height: 170px;
	margin: 10px;
	
}

#profile_image{
	width: 30%;
	padding-right: 5px;
	padding-bottom: 0;
	padding-left: 0;
	padding-top: 0;
	vertical-align: middle;
}

</style>

<link rel="stylesheet" href="<c:url value="../resources/theme/css/mystyle1.css"/>">

</head>

<body>

<%@ include file="../main-header3.jsp"  %>

<div id="profilemenu" hidden>
<form id ="profileimage_form" name="profileimage_form" action="MyPage" method="post" enctype="multipart/form-data">
	<input hidden type="number" name="mno" id="profile_mno"/>
	<div>
		
			<div style="width: "385px"><button id="profile_button1"  style="float: right;">X</button></div>
			<div id="image_preview"><img src="#" id="profile-image" style="display: none; width: 200px; height: 200px;" /></div>
			<div style="display: inline-block;">
							
		
				<input type="file" id="imageFile" name="imageFile" style="width: 325.6px;">
						 
				<button id="profile_button2" style="float: right; font-size: 10;">수정하기</button>
			</div>
			
		
	</div>
</form>
</div>


	<div class="site-header">
			<!-- <div class="main-header">
				<div class="container">
					<div id="menu-wrapper">
						<div class="row">
							<div class="logo-wrapper col-md-2 col-sm-2">
								<h1> <a href="#">같&nbsp;이&nbsp;가&nbsp;자</a> </h1>
							</div>
							/.logo-wrapper
							<div class="col-md-10 col-sm-10 main-menu text-right">
								<div class="toggle-menu visible-sm visible-xs">
									<i class="fa fa-bars"></i>
								</div>
								<ul class="menu-first">
									<li><a href="index">메인</a></li>
									<li><a href="#services">후기</a></li>
									<li><a href="tour/tourBoard">찾기</a></li>
									<li><a href="#">마이페이지</a></li>
									<li><a href="admin">관리자</a></li>
									<li><a href="member/login">로그인</a></li>
								</ul>
							</div>
							/.main-menu
						</div>
						/.row
					</div>
					/#menu-wrapper
				</div>
				/.container
			</div>
			/.main-header -->
		</div>




	<header style="height: 102px; width: 1330px; margin: auto; vertical-align: center;">
		<p style="font-weight: bold; color: white; font-size: 25px;"></p>
		<p><a href="../index" style="font-weight: bolder; color: white; font-size: 18px;"></a></p>
	</header>


	<div Class="wrapper">
		<div style="background-color: #f25454; height: 520px; width: 1330px; margin: auto; vertical-align: center;">
			<div
				style="width: 800px; height: 200px; text-align: center; vertical-align: center; margin: auto;">
				<div
					style="display: block; width: 100%; height: 100%; margin-top: 20px; margin: 10px; vertical-align: center; text-align: center;">

					<div id="content_profile"
						style="display: inline-block; text-align: center; vertical-align: middle; padding-top: 14px;">

					</div>
					
					
					<div id="contextmenu">
						<input hidden type="number" name="mno" id="context_mno"/>

					

						
					</div>
					

				</div>

			</div>



			<div
				style="display: block; width: 1026px; height: 260px; margin: auto; vertical-align: center; text-align: center; padding-top: 30px">
				<div>
					<input type="text" Class="personal" value="${pageVO.nickname }" readonly="readonly" style="background-color: transparent; color: white; font-size: 20px; font-weight: bold; text-align: center;" /> 
					<input type="text" Class="personal" value="${pageVO.age }세" readonly="readonly" style="background-color: transparent; color: white; font-weight: bold; text-align: center;"/>
				</div>
				<div>
					<input type="text" Class="personal" value="${pageVO.sex }" readonly="readonly" style="background-color: transparent; color: white; font-weight: bold; text-align: center;"/>
					<input type="text" Class="personal" value="${pageVO.email }" readonly="readonly" style="background-color: transparent; color: white; font-weight: bold; text-align: center;"/>
				</div>

				<textarea rows="" cols="" readonly="readonly" style="width: 600px; height: 120px; border: none; margin-top: 20px; background-color: #f25454; color: white; font-weight: bold; font-size: 25px">${pageVO.introduce }

				</textarea>
					
			</div>
			
			
			
				
		</div>	

			<div style="display: block; width: 1330px; margin-top: 16px; text-align: left; margin-left: auto; margin-right: auto">
				<p></p>
				<input type="hidden" id="mytour_mno" name="mytour_mno" value="${mno}" />
				<button type="button" id="mytour" style="font-weight: bold; background-color: transparent;">내 여행 리스트</button>
				<button type="button" id="mytourReview" style="font-weight: bold; background-color: transparent;">내 후기 리스트</button>
				<button type="button" id="tourchoose" style="font-weight: bold; background-color: transparent;">내 선택 리스트</button>
				
				<div class="row" id="toursearch" style="width: 1330px; margin-top: 30px; margin-left: auto; margin-right: auto"></div>
				


				</div>
		
			</div>


	<!-- <script type="text/javascript">
		$('#checkboxTestTbl > tr > th >input: checked').each(function(index) {
			alert($(this).val());
		})
	</script> -->

			<script
				src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	
	<script>
	var dddd = '${pageVO.mno}';
	var aa = '<%=(String)session.getAttribute("mno")%>';
	console.log("로그인:"+aa);
	console.log(dddd);
	
		$(document).ready(function() {
			
			
			getThumnails_By_Mno();

			// 지역 검색: 해당 지역의 여행정보 썸네일들을 읽어오는 함수 정의 
			function getThumnails_By_Mno() {
				
				// 등록된 게시물 리스트
				List = [];
				// wm_tour 리스트(제목)
				titleList = [];
				// wm_tour_region 리스트(지역)
				regionList = [];
				
				var url = '/project/mypage/MyPage/list/' + ${pageVO.mno};
				$.getJSON(url, function(datalist) {
					$(datalist).each(function() {
						List.push({img_url: this.img_url, content_no: this.content_no, tour: {}, expire:{}, city: {}})
							
					
						var urltitle = '/project/mypage/MyPage/title/' + ${pageVO.mno};
						$.getJSON(urltitle, function(datatitle) {
							$(datatitle).each(function() {
								titleList.push({trip_no: this.trip_no, title: this.title, expire: this.expire});
								
							});
							console.log(titleList);
							
							var urlregion = '/project/mypage/MyPage/region/' + ${pageVO.mno};
							$.getJSON(urlregion, function(dataregion) {
								$(dataregion).each(function() {
									var name = this.region_name.split(",");
									var tagname = '';
									for(var i=0; i<name.length; i++){
										tagname +="#"+name[i]+" ";
									}									
									regionList.push({region_name: tagname, trip_no: this.trip_no});	
								});
							
								for (var i = 0; i < List.length; i++) {
									for (var j = 0; j < titleList.length; j++) {
										if (List[i].content_no == titleList[j].trip_no) {
											List[i].tour = titleList[j].title;
											List[i].expire = titleList[j].expire;
										} 
										for (var k = 0; k < regionList.length; k++) {
											if (List[i].content_no == regionList[k].trip_no) {
												List[i].city = regionList[k].region_name;
											} 
										}	
									}	
								}
								getThumnail();
								
							});
								
							
						});
				
					});
					
					
				});// end getJSON()
			
			};//end of getThumnails()
			
			
			function getThumnails_By_ChooseMno() {
												
				// 선택한 게시물 리스트
				JoinList = [];
				// wm_tour 리스트(제목)
				titleList = [];
				// wm_tour_region 리스트(지역)
				regionList = [];

								
				var url2 = '/project/mypage/MyPage/joinlist/' + ${pageVO.mno};
				$.getJSON(url2, function(data2){
					
					$(data2).each(function() {
						
						JoinList.push({img_url: this.img_url, content_no: this.content_no, tour: {}, city: {}})
						
						var urltitle = '/project/mypage/MyPage/jointitle/' + ${pageVO.mno};
						$.getJSON(urltitle, function(datatitle) {
							$(datatitle).each(function() {
								titleList.push({trip_no: this.trip_no, title: this.title});
								
							});
							console.log(titleList);
							
							var urlregion = '/project/mypage/MyPage/joinregion/' + ${pageVO.mno};
							$.getJSON(urlregion, function(dataregion) {
								$(dataregion).each(function() {
									var name = this.region_name.split(",");
									var tagname = '';
									for(var i=0; i<name.length; i++){
										tagname +="#"+name[i]+" ";
									}									
									regionList.push({region_name: tagname, trip_no: this.trip_no});	
								});
							
								for (var i = 0; i < JoinList.length; i++) {
									for (var j = 0; j < titleList.length; j++) {
										if (JoinList[i].content_no == titleList[j].trip_no) {
											JoinList[i].tour = titleList[j].title;
										} 
										for (var k = 0; k < regionList.length; k++) {
											if (JoinList[i].content_no == regionList[k].trip_no) {
												JoinList[i].city = regionList[k].region_name;
											} 
										}	
									}	
								}
								getChooseThumnail();
							});
								
							
						});
				
					});
					
				
					
				});// end getJSON()
			
			};//end of 
			
			
			function getThumnails_By_Review() {
				
				// 선택한 게시물 리스트
				ReviewList = [];
				// wm_review 리스트(제목)
				titleList = [];
				// wm_review_region 리스트(지역)
				regionList = [];

								
				var url2 = '/project/mypage/MyPage/reviewlist/' + ${pageVO.mno};
				$.getJSON(url2, function(data2){
					
					$(data2).each(function() {
						alert("reviewlist 출력")	
						ReviewList.push({img_url: this.img_url, content_no: this.content_no, tour: {}, city: {}})
						
						var urltitle = '/project/mypage/MyPage/reviewtitle/' + ${pageVO.mno};
						$.getJSON(urltitle, function(datatitle) {
							$(datatitle).each(function() {
								titleList.push({review_no: this.review_no, title: this.title});
								
							});
							console.log(titleList);
							
							var urlregion = '/project/mypage/MyPage/reviewregion/' + ${pageVO.mno};
							$.getJSON(urlregion, function(dataregion) {
								$(dataregion).each(function() {
									var name = this.region_name.split(",");
									var tagname = '';
									for(var i=0; i<name.length; i++){
										tagname +="#"+name[i]+" ";
									}									
									regionList.push({region_name: tagname, review_no: this.review_no});	
								});
							
								for (var i = 0; i < ReviewList.length; i++) {
									for (var j = 0; j < titleList.length; j++) {
										if (ReviewList[i].content_no == titleList[j].review_no) {
											ReviewList[i].tour = titleList[j].title;
										} 
										for (var k = 0; k < regionList.length; k++) {
											if (ReviewList[i].content_no == regionList[k].review_no) {
												ReviewList[i].city = regionList[k].region_name;
											} 
										}	
									}	
								}
								getReviewThumnail();
							});
								
							
						});
				
					});
					
				
					
				});// end getJSON()
			
			};//end of 
			
			function getThumnail() {
				
				var list = '';
				
				
				for(var i = 0; i<List.length; i++){
					
				if(List[i].expire == 0){
					list += '<div class="portfolio-item col-md-3 col-sm-6">';
				}else{
					list += '<div class="portfolio-item-ex col-md-3 col-sm-6">';
				}

					
					
						list+= '<div class="portfolio-thumb">'
						+ '<figure>'						
						+ '<a href="../../tour/detail?trip_no=' + List[i].content_no + '"><img src="../../' + List[i].img_url + '" width="300" height="200">'
						+ '<div>제목: ' + List[i].tour + '</div>'
						+ '<div>지역: ' + List[i].city + '</div>'		
						+ '</figure>'
						+ '</div>'
						+ '</div>';
					
				}
				
				$('#toursearch').html(list);				
	
				//end of getThumnails()
			};
			
			function getChooseThumnail() {
				
				var list = '';
				
				for(var i = 0; i<JoinList.length; i++){
					
					list += '<div class="portfolio-item col-md-3 col-sm-6">'
						+ '<div class="portfolio-thumb">'
						+ '<figure>'
						+ '<a href="../../tour/detail?trip_no=' + JoinList[i].content_no + '"><img src="../../' + JoinList[i].img_url + '" width="300" height="200">'
						+ '<div>제목: ' + JoinList[i].tour + '</div>'
						+ '<div>지역: ' + JoinList[i].city + '</div>'			
						+ '</figure>'
						+ '</div>'
						+ '</div>';
				}
				
				
				$('#toursearch').html(list);				
	
				//end of getThumnails()
			};
			
			
			function getReviewThumnail() {
				
				var list = '';
				
				for(var i = 0; i<ReviewList.length; i++){
					
					list += '<div class="portfolio-item col-md-3 col-sm-6">'
						+ '<div class="portfolio-thumb">'
						+ '<figure>'
						+ '<a href="../../review/review_detail?review_no=' + ReviewList[i].content_no + '"><img src="../../' + ReviewList[i].img_url + '" width="300" height="200">'
						+ '<div>제목: ' + ReviewList[i].tour + '</div>'
						+ '<div>지역: ' + ReviewList[i].city + '</div>'			
						+ '</figure>'
						+ '</div>'
						+ '</div>';
				}
				
				
				$('#toursearch').html(list);				
	
				//end of getThumnails()
			};
			
			// mno 검색 버튼 처리
			$('#mytour').click(function() {

				$('#toursearch').html('');				
				getThumnails_By_Mno();
				
			});
			
			// 내가 신청한 게시물 보기 버튼
			$('#tourchoose').click(function() {

				$('#toursearch').html('');
				getThumnails_By_ChooseMno();
				
	
			});
			
			// 후기 게시글 보기 버튼
			$('#mytourReview').click(function() {

				$('#toursearch').html('');
				getThumnails_By_Review();
				
	
			});
			
			$('#updatePersonal').click(function() {
				var mno = ${mno};				
				location = 'updatePersonal/' + mno;
			});
			
			$('#goHome').click(function() {
				location = '../index';
			});
			
			
			
			$('#context_profile').on('click','.btn_context',function(){				
			
				var amno = ${mno};
				
				var mno_img = '${inserterImg}';
				
				$('#profile_image').html('<img src="../'+mno_img+'" id="profile_profile_img" style="width: 150px;"/>');
				
				
			/* 	$.ajax({
					type:'Get',
					url: '/project/mypage/profile/' + amno,
					headers:{
						'Content-Type':'application/json',
						'X-HTTP-Method-Override':'GET'
						},
						success: function(result){
								src = result;
								

								 $('#profile_image').html('<img src="../'+src+'" id="profile_profile_img"/>');

							
						}
				}); */
				

				$('#profilemenu').show();

				$('#profilemenu').css("top",  Math.max(0, (($(window).height() - $('#profilemenu').outerHeight()) / 2) + $(window).scrollTop())+ "px"); 
				$('#profilemenu').css("left", Math.max(0, (($(window).width() - $('#profilemenu').outerWidth()) / 2) + $(window).scrollLeft())+ "px");
				
				
			});
			
			
			// 프로필 창 닫기
			$('#profile_button1').click(function(e){ 
			    e.preventDefault(); 
			    $('#profilemenu').hide(); 
			});
			
			
			
			$('#imageFile').on('change', function() {
			      
			      ext = $(this).val().split('.').pop().toLowerCase(); //확장자
			      
			      //배열에 추출한 확장자가 존재하는지 체크
			      if($.inArray(ext, ['gif', 'png', 'jpg', 'jpeg']) == -1) {
			         resetFormElement($(this)); //폼 초기화
			         window.alert('이미지 파일이 아닙니다! (gif, png, jpg, jpeg 만 업로드 가능)');
			      } else {
			         file = $('#imageFile').prop("files")[0];
			         blobURL = window.URL.createObjectURL(file);
			         $('#image_preview img').attr('src', blobURL);
			         document.getElementById("profile-image").style.display = "inline";
			         $('#image_preview img').attr('width', '160px');
			         $('#image_preview img').attr('height', '160px');
			         document.getElementById("btn_profile-image_remove").style.display = "inline";
			         //$('#image_preview').slideDown(); //업로드한 이미지 미리보기
			         $('#image_preview').show(); //업로드한 이미지 미리보기
			      }
			   });
			
			 			 
			 $('#profile_button2').click(function() {	     
			         
			         $("#profileimage_form").submit();
			             
			   });
			
			
						
		});		
		
		var mno_img = '${inserterImg}';
		
		$('#content_profile').html('<img src="../../'+mno_img+'" class="content_profile_img"/>');
		
	</script>
	
	




		</body>
</html>