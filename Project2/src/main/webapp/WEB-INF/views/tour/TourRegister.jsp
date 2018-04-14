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
 
<script
   src="../resources/theme/js/vendor/modernizr-2.6.1-respond-1.1.0.min.js"></script>
 
<script type="text/javascript"
   src="../resources/smarteditor/js/HuskyEZCreator.js" charset="utf-8"></script>
 
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
 
	<%@ include file="../main-header2.jsp"%>
 
 
	<div class="site-main" id="sTop">
		<div class="site-slider">
			<div class="slider">
				<div class="flexslider">
					<ul class="slides">
						<li>
							<div></div><img src="../resources/theme/images/mainindex3.png" alt="" style="margin-top: 10.8%;">
							<div class="slider-caption visible-md visible-lg">
								<h2>같이가자</h2>
							</div>
						</li>
						<li>
							<div></div><img src="../resources/theme/images/mainindex2.png" alt="" style="margin-top: 10.8%;">
							<div class="slider-caption visible-md visible-lg" style="text-align: center; top: 40%;">
								<img style="width: 40%; height: 30%; vertical-align: middle; display: inline-block;" src="../resources/theme/images/main_string.png" alt=""/>
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
	
	
	<div style="text-align: center; vertical-align: middle; background-color: #f25454; height: 100%">
	<div style="display: inline-block; vertical-align: middle; background-color: white; width: 50%; height: 100%"><br/>


	<div class="content-section" id="services">
		<div class="container">
        	<div class="row">
         
            <!-- /.heading-section -->
            <div class="heading-section" style="margin-left: 5%; margin-right: 5%; text-align: left;" >
            	<h2>여행 등록</h2>
            </div>
 
				<div class="wrap">
		
					<form action="TourRegisterInsert" method="post" id="frm" enctype="multipart/form-data">
			
						<div style="margin-left: 5%; margin-right: 5%; text-align: left; " >
						
							<label for="imageFile">썸네일 이미지</label><br/>       
						    <input type="file" id="imageFile" name="imageFile" value="<img src='${pageContext.request.contextPath}/image/${imageFile.id}' width='100' height='100'>"><br>
						            
						    <div id="image_preview">
						    	<img src="#" id="profile-image" style="display: none;" /><br/>
						    	<a href="#" id="btn_profile-image_remove" style="display: none;">Remove</a>
						    </div><br/>      
						
							<input type="hidden" name="mno" value="${mno}" readonly="readonly" /> 
							
							<input type="text" name="title" style="width: 70%; border: 2px solid #f45c3a; border-radius: 10px; " placeholder="제목"/><br /> <br /> 
						
								
							<div id="region_plus">
								<table id="regionTable">
									<tr>
										<td>
											<input type="text" name="region_name" placeholder="지역" />
											<input id="addButton" name="addButton" type="button" style="cursor:hand;" onClick="insRow()" value="추가">
										</td>
									</tr>
								</table>						
							</div> <br /> 
							<div style="width: 40%; height: 5.5%; border: 2px solid #f45c3a; border-radius: 10px; padding: 2px; ">
							<input type="text" id="start_date" name="start_date" placeholder="시작일" style="border:none;"> 
							~ 
							<input type="text" id="end_date" name="end_date" placeholder="종료일" style="border:none;"> <br /> <br />
							</div> <br/>
							<div style="display: inline-block;">
								성별 조건: <br />
								남자 <input type="radio" name="condition_sex" value="1" /> 
								여자 <input type="radio" name="condition_sex" value="0" /> 
								조건없음 <input type="radio" name="condition_sex" value="2" />
							</div> 
							
							<div style="display: inline-block;">
								
							</div> 
						
							<div style="display: inline-block;">
								연령 조건: <br />
								20대 <input type="radio" name="condition_age" value="1" /> 
								30대 <input type="radio" name="condition_age" value="2" /> 
								40대 <input type="radio" name="condition_age" value="3" /> 
								조건없음 <input type="radio" name="condition_age" value="4" />
							 </div><br /><br />		 
							 
							
							<textarea name="content" id="smarteditor" rows="10"
								cols="100" style="width: 766px; height: 412px;">	
							</textarea><br /><br />	
							
						</div>	
						
						<div style="text-align: left;" >
							<button type="button" id="savebutton" style="margin-left: 5%; text-align: left;">작성</button>
							<button type="button" id="cancelbutton" style="text-align: left;">취소</button>
							<button type="button" id="homebutton" style="text-align: left;">홈으로</button>
						</div>								
					</form>	
 
		
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
	
	</div>
	</div>
	
	<script>
	
		// Region Table
		var oTbl;
	
		//Row 추가
		function insRow() {
		  oTbl = document.getElementById("regionTable");
		  var oRow = oTbl.insertRow();
		  oRow.onmouseover=function(){oTbl.clickedRowIndex=this.rowIndex}; //clickedRowIndex - 클릭한 Row의 위치를 확인;
		  var oCell = oRow.insertCell();
		  
		  //삽입될 Form Tag
		  var frmTag = "<input type=text name=region_name placeholder=지역>";
		  frmTag += " <input type=button value='삭제' onClick='removeRow()' style='cursor:hand'>";
		  oCell.innerHTML = frmTag;
		}
	
		//Row 삭제
		function removeRow() {
		  oTbl.deleteRow(oTbl.clickedRowIndex);
		}

		$(function() { //전역변수선언
			
			$("#start_date, #end_date").datepicker({
				dateFormat : 'yy-mm-dd'
			});
			
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
			        $('#image_preview img').attr('width', '300px');
			        $('#image_preview img').attr('height', '300px');
			        document.getElementById("btn_profile-image_remove").style.display = "inline";
			        //$('#image_preview').slideDown(); //업로드한 이미지 미리보기
			        $('#image_preview').show(); //업로드한 이미지 미리보기
		     	}
			});
			
			/**
			onclick event handler for the delete button.
			It removes the image, clears and unhides the file input field.
			*/
			$('#image_preview a').bind('click', function() {
			   resetFormElement($('#imageFile'));
			   //$('#image').slideDown(); //파일 양식 보여줌
			   $(this).parent().slideUp(); //미리 보기 영역 감춤
			   //return false; //기본 이벤트 막지
			});
			      

			/** 
			* 폼요소 초기화 
			* Reset form element
			* 
			* @param e jQuery object
			*/
			function resetFormElement(e) {
			   e.wrap('<form>').closest('form').get(0).reset(); 
			   //리셋하려는 폼양식 요소를 폼(<form>) 으로 감싸고 (wrap()) , 
			   //감싼 폼 ( closest('form')) 에서 Dom요소를 반환받고 ( get(0) ),
			   //DOM에서 제공하는 초기화하는 메서드 reset()을 호출
			   e.unwrap(); //감싼 <form> 태그를 제거
			}
 
			//전송버튼 클릭이벤트
			$("#savebutton").click(function() {
				//id가 smarteditor인 textarea에 에디터에서 대입
				editor_object.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);
				// 이부분에 에디터 validation 검증
				
				//폼 submit
				$("#frm").submit();
			})
			
			$("#cancelbutton").click(function() {
				location = 'cancelTourRegister';
			})
			
			$("#homebutton").click(function() {
				location = '../index';
			})
 
	        $('#addOption').click(function() {
	            $('#regionTable > tbody:last').append('<tr><td><input type="text" name="region_name" style="width: 100%" placeholder="지역"/></td></tr>');
	        });
 
	        $('#delOption').click(function() {
	        	$('#regionTable > tbody:last > tr:last').remove();
	        });
 
		})
	</script>
 
 
 
	<script src="../resources/theme/js/bootstrap.js"></script>
	<script src="../resources/theme/js/plugins.js"></script>
	<script src="../resources/theme/js/main.js"></script>
	
 
</body>
</html>