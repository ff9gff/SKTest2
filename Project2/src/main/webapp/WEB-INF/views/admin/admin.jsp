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
 
 .menuItem{
 	
 	background-color: lightblue;
 	font-family: 'Jeju Hallasan', serif;
 }
 #checkboxTestTbl{
 	font-family: 'Jeju Hallasan', serif;
 }
 
 #hi{
 	font-family: 'Jeju Hallasan', serif;
 }

 #checkboxTestTbl tbody tr:hover {background:#F3F5BB}
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
				<li Class="menuItem"><a Class="mylink" href="callbackAdmin"style="text-align: center; vertical-align: middle;"><img  src="../resources/theme/images/why2.png" style="width: 40px; height: 40px; display: inline; text-align: center; vertical-align: middle;"/>가입승인</a>
				</li>
				
						
				
				<li Class="menuItem" ><a Class="mylink" href="AllAdminMSG" style="text-align: center; vertical-align: middle;"><img  src="../resources/theme/images/gongji.png" style="width: 40px; height: 40px; display: inline; text-align: center; vertical-align: middle;"/> 공지 사항</a>
				</li>
				
				<li Class="menuItem"><a Class="mylink" href="MyUserInfo" style="text-align: center; vertical-align: middle;"><img  src="../resources/theme/images/test.png" style="width: 40px; height: 40px; display: inline; text-align: center; vertical-align: middle;"/> 유저 등급</a></li>


					<li Class="menuItem"><a Class="mylink" href="AllMyUser" style="text-align: center; vertical-align: middle;"><img  src="../resources/theme/images/allperson.png" style="width: 40px; height: 40px; display: inline; text-align: center; vertical-align: middle;"/> 전체 유저</a>
				</li>
				
					<li Class="menuItem"><a Class="mylink" href="AllMySubAdmin" style="text-align: center; vertical-align: middle;"><img  src="../resources/theme/images/new4.png" style="width: 40px; height: 40px; display: inline; text-align: center; vertical-align: middle;"/> 회원 관리</a>
				</li>
				
				<li Class="menuItem"><a Class="mylink" href="../index" style="text-align: center; vertical-align: middle;"><img  src="../resources/theme/images/house.png" style="width: 40px; height: 40px; display: inline; vertical-align: middle;"/> 메인&nbsp;가자 </a>
				</li>  
			</ul>
		</nav>
		
		<section id="main">
	
	
	<form id="form-main">
		<div>
			<table id="checkboxTestTbl" style="width: 100%" >
				<caption style="border-top:  1px solid orange; border-left:  1px solid gray; border-right:  1px solid gray; border-radius: 99px 0px 0px 0px; border: 2px solid #e65b05; background-color : orange;">회원 정보 확인</caption>
				<colgroup>
					<col width="40px">
					<col width="100px">
					<col width="200px">
					<col width="200px;" />
					<col width="200px;" />

				</colgroup>
	
			
			
				
				<tr>
					<th>번호</th>
					<th>회원 번호</th>
					<th>아이디(ID)</th>
					<th>연락처(PHONE)</th>
					<th>이메일(E-MAIL)</th>
					<th>가입날짜(DATE)</th>
				</tr>
				
		 	<tbody>
				<c:forEach var="vo" items="${newMemberList}">
				
					<tr class= "select0">
						<td >${x=x+1 }</td>
						<td>${vo.mno }</td>
						<td>${vo.userid }</td>
						<td>${vo.phone }</td>
						<td>${vo.email }</td>
					        <td>
	       						 <fmt:formatDate value="${vo.joindate }" 
	          						  pattern="yyyy-MM-dd HH:mm:ss"/>
        					</td>
			
					</tr>
			
				
				</c:forEach>
			
			</tbody>

		</table>
  				<div style="text-align: right;">  					
					<input type="image" src="../resources/theme/images/check.png"  id="image_btn" 
					style="width: 30px; display:inline; margin-top: 15px;" >
				
				</div>
				</div>
					</form>
					
					
		</section>


	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 	
	<script type="text/javascript">
	
		$('#image_btn').click(ace);
		function ace(){
		
			event.preventDefault();
			$.ajax({
				type:'put',
				url:'/project/users/updateLevelOne',
				headers:{
					'Content-Type':'application/json',
					'X-Http-Method-Ovveride':'PUT'
				},
				success: function(data) {
					console.log('data: ' + data);
				}
				
			});
			
	
			$('.select0').empty();
			
			
		};

		
		
		
		
		
	
		
		
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
		
		
		
		
		
		
		
		
		
		
	</script>



</body>
</html>
