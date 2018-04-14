<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>같이 가자</title>
<link rel="stylesheet" href="<c:url value="/resources/theme/css/mystyle1.css"/>">


<style type="text/css">
@import url(http://fonts.googleapis.com/earlyaccess/jejuhallasan.css);
#top{
		color: white;
		background-image: url("../resources/theme/images/slide1.jpg");
		background-size: 100%;
		background-repeat: no-repeat;
		padding: 15px;
}

#form-main{	
	padding-left:35px;
	padding-right:35px;
	padding-top:35px;
	padding-bottom:50px;
	float: left;
	left: 50%;
	position: absolute;
  margin-top:30px;
	margin-left: -500px;
  -moz-border-radius: 7px;
  -webkit-border-radius: 7px;	
}

#dropDownType {
	width: 50px
}

#selectOption {
	padding-left: 655px
}

table, th, td {
   border: 1px solid #e65b05;
   border-collapse: collapse;
   text-align: center;
   vertical-align: middle;
}

.message{
display: inline;
}

.menuItem{
 	background-color: lightblue;
 	font-family: 'Jeju Hallasan', serif;
 }
 
 #msgAdminMSG{
 	font-family: 'Jeju Hallasan', serif;
 }
 .span_notice{
 font-family: 'Jeju Hallasan', serif;
 }
 
 #hi{
 	font-family: 'Jeju Hallasan', serif;
 }
 
</style>



</head>

<body>
	<header id="top">
			<div>&nbsp;</div>	
			<div>&nbsp;</div>
		<h1 id="hi">&nbsp;관리자님 안녕하세요</h1>
		<div>&nbsp;</div>
		<p id="dpTime">&nbsp;&nbsp;</p>
		</header>

		<div Class="wrapper">
		<nav id="menuBar">
		
			<ul id="menuList">
				<li Class="menuItem"><a Class="mylink" href="callbackAdmin"><img  src="../resources/theme/images/why2.png" style="width: 40px; height: 40px; display: inline; text-align: center; vertical-align: middle;"/>가입승인</a>
				</li>


			<li Class="menuItem" ><a Class="mylink" href="AllAdminMSG" style="text-align: center; vertical-align: middle;"><img  src="../resources/theme/images/gongji.png" style="width: 40px; height: 40px; display: inline; text-align: center; vertical-align: middle;"/> 공지 사항</a>
				</li>
				
				<li Class="menuItem"><a Class="mylink" href="MyUserInfo" style="text-align: center; vertical-align: middle;"><img  src="../resources/theme/images/test.png" style="width: 40px; height: 40px; display: inline; text-align: center; vertical-align: middle;"/> 유저  등급</a></li>

				
					
					<li Class="menuItem"><a Class="mylink" href="AllMyUser" style="text-align: center; vertical-align: middle;"><img  src="../resources/theme/images/allperson.png" style="width: 40px; height: 40px; display: inline; text-align: center; vertical-align: middle;"/> 전체 유저</a>
				</li>
				
					<li Class="menuItem"><a Class="mylink" href="AllMySubAdmin" style="text-align: center; vertical-align: middle;"><img  src="../resources/theme/images/new4.png" style="width: 40px; height: 40px; display: inline; text-align: center; vertical-align: middle;"/> 회원 관리</a>
				</li>
				
				<li Class="menuItem"><a Class="mylink" href="../index" style="text-align: center; vertical-align: middle;"><img  src="../resources/theme/images/house.png" style="width: 40px; height: 40px; display: inline; vertical-align: middle;"/> 메인&nbsp;가자 </a>
				</li>  
			</ul>
			
		</nav>
		<section id="main">

	<div style="display: inline-block; margin-bottom: 15px;">
	<div class="message" onclick="OpenPop('', '', '', '')">
	<form action="MiniSendToAllMyUser" method="get" id="form2" name="form2" style="display: inline-block; border: 2px solid yellow ; background-color:#FF5A00 ">
			<img  src="../resources/theme/images/shout.png" style="width: 40px; height: 40px; 
					display: inline; text-align: center; vertical-align: middle;"/>
	<span class="span_notice">공지 보내기</span>
	</form>
	</div>
	

	<div class="message" onclick="OpenPop2('', '', '', '')" style= "margin-left: 10px;">
		<form action="MiniMSGpageU" method="get" id="formName" name="formName" style="display: inline-block; border: 2px solid yellow; background-color: #FF5A00">
		<img  src="../resources/theme/images/please.png" style="width: 40px; height: 40px; 
		display: inline; text-align: center; vertical-align: middle;" />

		<span class="span_notice">쪽지보내기</span>
		</form>
		</div>

		
		</div>

	<div style="width: 100%">
	<table id="msgAdminMSG" style="width: 100%" >
		<caption style="border-top:  1px solid orange; border-left:  1px solid gray; border-right:  1px solid gray; border-radius: 99px 0px 0px 0px; border: 2px solid #e65b05; background-color : orange;">관리자 지난 공지함 </caption>
		<colgroup>
		<col width="20px">
		<col width="40px">
		<col width="500px">

		</colgroup>

	<tr>
		<th><input type="checkbox" name="rowCheck"></th>
		<th>번호</th>
		<th>공지사항</th>
	</tr>
	


	<c:forEach var="bo" items="${msgList }">
	<tr>
			<td><input type="checkbox" name="rowCheck" value="${bo.msg_no }"></td>
			<td>${x= x+1}</td>
			<td style="text-align: left;">${bo.msg_content }</td>
	</tr>
	</c:forEach>



</table>
	
<form id="formAllmin">
	<div style="text-align: right;">
	<input type="image" src="../resources/theme/images/close1.png" style="width: 30px; display:inline; margin-top: 15px;" id="deleteMSGbtn" value="삭제"> 
	</div>
</form>
</div>

	</section>


	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 	
	<script type="text/javascript">
	
		

		
		// 실시간 시간 보내는  모습입니다. 
		 setInterval("dpTime()",1000);
		    function dpTime(){
		       var now = new Date();
		        hours = now.getHours();
		        minutes = now.getMinutes();
		        seconds = now.getSeconds();
		 
		        if (hours > 12){
		            hours -= 12;
		        ampm = "오후 ";
		        }else{
		            ampm = "오전 ";
		        }
		        if (hours < 10){
		            hours = "0" + hours;
		        }
		        if (minutes < 10){
		            minutes = "0" + minutes;
		        }
		        if (seconds < 10){
		            seconds = "0" + seconds;
		        }
				document.getElementById("dpTime").innerHTML = ampm + hours + ":" + minutes + ":" + seconds ;
		    };
		
		
		
			var f = $("#form2"); 
		    function OpenPop(url,name,width,height)
		    {
		   		
		    	
		        window.open("", "pop", "width=760, height=650"); // 먼저 빈 창을 pop 라는 이름으로 열어놓고
		        document.form2.target = "pop"; // 이 부분이 핵심! 열어놓은 빈 창(pop)을 form2가 날아갈 target으로 정한다.
		        document.form2.method = "get"; // target에 submit할 방식을 post 방식으로 지정한다.
		        document.form2.submit(); // target에 쏜다.
		        
		         
		        
		    };
		    
		  
		    function OpenPop2(url,name,width,height)
		    {
		   		
		    	
		        window.open("", "pop", "width=800, height=800"); // 먼저 빈 창을 pop 라는 이름으로 열어놓고
		        document.formName.target = "pop"; // 이 부분이 핵심! 열어놓은 빈 창(pop)을 form2가 날아갈 target으로 정한다. 
		        document.formName.method = "get"; // target에 submit할 방식을 post 방식으로 지정한다.
		        document.formName.submit(); // target에 쏜다.
   
		    };
		    
		    
		    
		    
		    
		    
		    
		    var tbl = $("#msgAdminMSG");
		
	      
	        $(":checkbox:first", tbl).click(function(){
	            // 클릭한 체크박스가 체크상태인지 체크해제상태인지 판단
	            if( $(this).is(":checked") ){
	                $(":checkbox", tbl).attr("checked", "checked");
	            }
	            else{
	                $(":checkbox", tbl).removeAttr("checked");
	            }

	            // 모든 체크박스에 change 이벤트 발생시키기                
	            $(":checkbox", tbl).trigger("change");
	        });
	         
	        // 헤더에 있는 체크박스외 다른 체크박스 클릭시
	        $(":checkbox:not(:first)", tbl).click(function(){
	            var allCnt = $(":checkbox:not(:first)", tbl).length;
	            var checkedCnt = $(":checkbox:not(:first)", tbl).filter(":checked").length;
	             
	            // 전체 체크박스 갯수와 현재 체크된 체크박스 갯수를 비교해서 헤더에 있는 체크박스 체크할지 말지 판단
	            if( allCnt==checkedCnt ){
	                $(":checkbox:first", tbl).attr("checked", "checked");
	            }
	            else{
	                $(":checkbox:first", tbl).removeAttr("checked");
	            }
	        }).change(function(){
	            if( $(this).is(":checked") ){
	                // 체크박스의 부모 > 부모 니까 tr 이 되고 tr 에 selected 라는 class 를 추가한다.
	                $(this).parent().parent().addClass("selected");
	            }
	            else{
	                $(this).parent().parent().removeClass("selected");
	            }
	        });
				
			
	        
	        

		/////////////////////////////ajax 
		 $('#deleteMSGbtn').click(function(){

	var oTbl = document.getElementById("msgAdminMSG");
	var chkObj = document.getElementsByName("rowCheck");
	var rowCnt = chkObj.length - 1;
	//alert('rowCnt' + chkObj.length);  //21로 출력 된다 .
	var success= false;
	var fail = 0;
	//var numbers  = [];
	for(var i=0 ; i <= rowCnt; i++){
		if(chkObj[i].checked == true){
		var no = chkObj[i].value;
		

		 $.ajax({
			 type:"delete",
				url:'/project/msg/numText/' +no,
				headers:{
					'Content-Type':'application/json',
					'X-Http-Method-Ovveride':'DELETE'
				}//headers
				
			 
		 })//end ajax
		
		}//end if	
	}; //end for 
	
	getAll();
 });//end 
 	var frm = $("#formAllmin");
 	function getAll(){
	
 		
		event.preventDefault(); // 기본 이벤트 처리 방식을 방지(막음)
		// pageForm 안에 있는 name="page"인 요소를 찾아서
		// 이동할 페이지 번호를 세팅
		var targetPage = $(this).attr('href');
		frm.find('[name="page"]').val(targetPage);
		// 페이징 화면으로 보내기 위한 action 정보
		frm.attr('action', 'AllAdminMSG');
		// 페이징 화면을 처리하는 Controller의 method(요청 처리 방식)
		frm.attr('method', 'get');
		// 폼 양식을 서버로 전송
		frm.submit();
	}; //end getAll(); 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
		
		
		
		
	        
		
	</script>



</body>
</html>