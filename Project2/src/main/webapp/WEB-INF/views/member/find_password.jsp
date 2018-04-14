<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<title>아이디 찾기 홈</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 
Flex Template 
http://www.templatemo.com/tm-406-flex
-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="<c:url value="../resources/theme/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="../resources/theme/css/font-awesome.css"/>">
<link rel="stylesheet" href="<c:url value="../resources/theme/css/animate.css"/>">
<link rel="stylesheet" href="<c:url value="../resources/theme/css/templatemo_misc.css"/>">
<link rel="stylesheet" href="<c:url value="../resources/theme/css/templatemo_style.css"/>">

<link rel="stylesheet" href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />
<script src="../resources/theme//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="../resources/theme//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<script src="../resources/theme/js/vendor/modernizr-2.6.1-respond-1.1.0.min.js"></script>


<style>
.searchRegion {
	display: none;
}

        a:link {
            color: red;
            text-decoration: none;
        }       
        a:visited {
            color: black;
            text-decoration: none;
        }        
        a:hover {
            color: blue;
            text-decoration: underline;
        }        
        <!-- a:link: 클릭하지 않은 링크 a:visited: 한번 클릭했던 혹은 다녀갔던 링크 a:hover: 링크를 클릭하려고 마우스를 가져갔을 때 decoration: 밑줄 none: 없는 상태 underline: 있는 상태 -->

</style>
</head>
<body>
	<!--[if lt IE 7]>
            <p class="chromeframe">You are using an outdated browser. <a href="http://browsehappy.com/">Upgrade your browser today</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to better experience this site.</p>
        <![endif]-->

<div style="text-align: center; vertical-align: middle; background-color: #f25454; height: 100%" ><!-- #ffffcc -->
<div style="display: inline-block; vertical-align: middle; background-color: white; width: 50%; height: 100%; text-align: center;"><br/><!-- white -->
 
	<div class="content-section" id="services" style="margin: 0; border: 0; width: 100%;text-align: center; display: inline-block;">
		<div class="container" style="margin: 0; border: 0; width: 100%; text-align: center; display: inline-block;">
			<div class="row" style="width: 100%; margin: 0; text-align: center; display: inline-block;">
				<div class="heading-section col-md-12 text-center" style="width: 100%; margin: 0; text-align: center; display: inline-block;">
					
					<div style="width: 50%; margin: 0; text-align: center; display: inline-block;">
						<img src="../resources/theme/images/why2.png" style="width: 100%; display: inline-block;"/>					
					</div>
					
					<br/><br/>
					
					<div style="width: 100%; text-align: center;">
					<h2>내 정보에 등록된 아이디/이름/휴대폰 /이메일로 비밀번호 찾기</h2>
					<br/><br/>
					
					<form action="find_password" method="post" id="frm">
						<div style="margin: 5px;">
							<input type="text" name="userid" id="userid" placeholder="아이디를 입력해 주세요." required />
						</div>
						<div style="margin: 5px;">
							<input type="text" name="name" id="name" placeholder="이름을 입력해 주세요." required />
						</div>
						<div style="margin: 5px;">
							<input type="text" name="phone" id="phone" placeholder="핸드폰 번호를 입력해 주세요." required />
						</div>
						<div style="margin: 5px;">
							<input type="email" name="email" id="email" placeholder="이메일 주소를 입력해 주세요." required />
						</div>
						<br/><br/>
						<input type="submit" value="비밀번호 찾기" /><br/><br/>
					</form>
					
					<!-- <button type="button" id="pwdSearch">비밀번호 찾기</button> <br/> -->
					
					<a href="member_register01">회원가입</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="footer">
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-xs-12 text-left" style="text-align: right;">
					<span>Copyright &copy; 2016 With Me</span>
				</div>				
			</div>
		</div>
	</div>
</div>
</div>	

<script type="text/javascript">
	
	// 휴대폰 번호
    function autoHypenPhone(str){
         str = str.replace(/[^0-9]/g, '');
         var tmp = '';
         if( str.length < 4){
             return str;
         }else if(str.length < 7){
             tmp += str.substr(0, 3);
             tmp += '-';
             tmp += str.substr(3);
             return tmp;
         }else if(str.length < 11){
             tmp += str.substr(0, 3);
             tmp += '-';
             tmp += str.substr(3, 3);
             tmp += '-';
             tmp += str.substr(6);
             return tmp;
         }else{              
             tmp += str.substr(0, 3);
             tmp += '-';
             tmp += str.substr(3, 4);
             tmp += '-';
             tmp += str.substr(7);
             return tmp;
         }
         return str;
     }
    
 //   var cellPhone = $('#mobile'); // document.getElementById('mobile') 와 완벽한 같은 객체는 아니다.
    var cellPhone = document.getElementById('phone');
    cellPhone.onkeyup = function(event){
            event = event || window.event;
            var _val = this.value.trim();
            this.value = autoHypenPhone(_val) ;
    }   
    
    
    
   /*  $('#pwdSearch').click(function() {
    	
    	alert('입력하신 이메일로 비밀번호가 발송되었습니다');
  
    	$('#frm').submit();
    
    }); */
	
	
	
	
</script>

</body>
</html>