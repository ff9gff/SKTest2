<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>같이 가자</title>

<link rel="stylesheet" href="<c:url value="/resources/theme/css/mystyle1.css"/>">


</head>
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
 
 #tableTest2{
 	font-family: 'Jeju Hallasan', serif;
 }
 
 #hi{
 	font-family: 'Jeju Hallasan', serif;
 }
</style>







<body>
	<header id="top">
		<div>&nbsp;</div>
		<div>&nbsp;</div>
		<h1 id="hi">&nbsp;관리자님 안녕하세요</h1>
		<div>&nbsp;</div>
		<p id="dpTime">&nbsp;&nbsp;</p>
	</header>
	


	

		<nav id="menuBar">
			<ul id="menuList">
				<li Class="menuItem"><a Class="mylink" href="callbackAdmin"><img  src="../resources/theme/images/why2.png" style="width: 40px; height: 40px; display: inline; text-align: center; vertical-align: middle;"/>가입승인</a>
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



	<div style="vertical-align: middle;">
		<input type="text" name="userid" id="userid" form="btnList" placeholder="찾을 유저검색" style="display: inline; vertical-align: middle;">
		<input type="image" src="../resources/theme/images/search.png" style="width: 30px; display:inline; vertical-align: middle;"  id="btnList" value="유저 검색">
	</div>
	<br/>
	<table id="tableTest2" >
		<!--<caption>유저 찾기</caption>-->
		<colgroup>
			<col width="100px">
			<col width="100px">
			<col width="110px">
		</colgroup>


		<tr>
			<th>유저 번호</th>
			<th>유저 아이디</th>
			<th>구분</th>


		</tr>

		<tbody id="c">

		</tbody>


	</table>

	
		</section>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script type="text/javascript">
$(document).ready(function(){
	
		//var table= $('#tableTest2');
	   // var tabel_len =(table.rows.length)-1;
		//alert(table_len)
	
	var table=document.getElementById("tableTest2");
 	var table_len=(table.rows.length)-1;
 	//alert(table_len); //-> 기본으로 1이므로 -1 했으므로 0 이 alert 창에 나온다. 
		

		$('#btnUpdate').click(function(){
			
			
			
			upgrade_member();
			
			
		});
 	
 	
 	
 	
 	
 	
 	
 	
 	   $('#btnList').click(function() {
 	
 	    			
 	    	
 	    var userid = $('#userid').val();		
 
 		
 		
		getMyUser();
		
 	  });

 	  
 	   
 
 	   
 	   function getMyUser(){
 		 
 		    //alert('메소드 호출 ');
 		   
 		   var url =
 			   '/project/users/all/'+$('#userid').val();
 		 
 		   $.getJSON(url,function(data){
				 			

 			  var list= '';
 			  
 			  $(data).each(function(){
 				
 				table_len += 1;
 			   	<%--$('#c').append(--%>
 			   	 list+= '<tr class= "select0">'
 		 			    	+'<td id="mno_id('+table_len+')" value='+this.mno+'>' +this.mno+'</td>'
 		 			    	+'<td id="userid_id('+table_len+')">' +this.userid+'</td>'
 			   	 			+'<td><input type="button" id="upgrade" value="관리자" onclick="upgrade_row('+table_len+')"/>'
 			   	 			+'<input type="button" id="delete('+table_len+')" value="강퇴" onclick="delete_row('+table_len+')"/></td>'	
 		 			    +'</tr>';
 			  }); /*반복문 끝 */
 			
 			$('#c').html(list);
 			  
 			  
 		   });// end getJSON()


 		   
 	   };//end of getMyUser()
 	   


 	});//end docu
 	

 	
 	</script>



	
 	<script type="text/javascript">
 	
 	
 	function delete_row(no){
		 	
	
		 var url1 =
			   '/project/users/deluser/'+no;
//url: '/ex03/replies/' + rno,
		 
		 $.ajax({
			 type:'get',
			 url : url1,
			 headers:{
				 'Content-Type': 'application/json',
					'X-HTTP-Method-Override': 'GET'
			 },
			 data: JSON.stringify({
					no: no,
				})
			 
			 
			 
			 
			 
		 });
		 
		 alert('선택하신 유저를 강퇴했습니다.');
		 $('.select0').empty();
	 }//end delete _ row 
 	   
 	
 	
	 function upgrade_row(no){
		 
		 var url1 =
			   '/project/users/num/'+no;
//url: '/ex03/replies/' + rno,
		 
		 $.ajax({
			 type:'get',
			 url : url1,
			 headers:{
				 'Content-Type': 'application/json',
					'X-HTTP-Method-Override': 'GET'
			 },
			 data: JSON.stringify({
					no: no,
				})
			 
			 
			 
			 
			 
		 });
			
		alert('선택하신 유저를 관리자로 임명하셨습니다.');
		 
		$('.select0').empty();
		
	 }//end delete _ row 
 	   
 	

 	
 	</script>
	
 

</body>
</html>