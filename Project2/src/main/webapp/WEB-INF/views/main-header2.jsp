<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
   <div class="main-header" style="top: 0.5%;">
      <div class="container">
         <div id="menu-wrapper">
            <div class="row">
            
               <div class="logo-wrapper col-md-2 col-sm-2">
                  <h1>
                   		<a href="../index" id="#btnHome"><img alt="" src="../resources/theme/images/mainlogo2.jpg" style="width: 240px; height: 100px;"></a>	
                  </h1>
               </div>
               
               
               <div class="col-md-10 col-sm-10 main-menu text-right" style="width: 70%; float: right;">
                   <div class="toggle-menu visible-sm visible-xs">
                     <i class="fa fa-bars"></i>
                  </div>

                  <ul class="menu-first" id="menumm">
                     <li><a href="#this" id="btnHome">Main</a></li> 
                     <li><a href="#this" id="tourBoard">Tour</a></li>
                     <li><a href="#this" id="reviewBoard">Review</a></li>
                    <!--  <li><a href="../index">메인</a></li>
                     <li><a href="../tour/tourBoard">여행</a></li>
                     <li><a href="../review/reviewBoard">후기</a></li>  -->
                     
                     <%-- 세션에 로그인 정보가 없는 경우 --%>
                     <c:if test="${empty login_id }">
                        <li><a href="#this" id="btnLogin">Sign in</a></li>                        
                        <li><a href="#this" id="btnMemberRegister">Sign up</a></li>
<!--                         <li><a href="#this" id="btnLogin">로그인</a></li>                        
                        <li><a href="#this" id="btnMemberRegister">회원가입</a></li>    -->                     
                     </c:if>
                     
                     <%-- 세션에 로그인 정보가 있는 경우 --%>
                     <c:if test="${not empty login_id }">
                     
                        <%-- 세션에 로그인 정보가 있고, 권한이 3인 경우 --%>   
                        <c:if test="${authority == 3 }">
                           <li><a href="#this" id="btnAdministrator">Admin</a></li>
                           <!-- <li><a href="#this" id="btnAdministrator">관리자</a></li> -->
                        </c:if>
                        
                        <li><a href="#this" id="btnMypage">MyPage</a></li>                        
                        <li><a href="#this" id="btnLogout">Sign out</a></li>
                        <!-- <li><a href="#this" id="btnMypage">마이페이지</a></li>
                        <li><a href="#this" id="btnLogout">로그아웃</a></li> -->
                     </c:if>
                  </ul>
               </div>
            </div>
         </div>
      </div>
   </div>

<script>
$('#btnMemberRegister').click(function() {
   location = '/project/member/member_register01';
});

$('#btnLogin').click(function() {
   location = '/project/member/login?url=' + location.href;
});

$('#btnAdministrator').click(function() {
   location = '/project/admin/admin';
});

$('#btnMypage').click(function() {
   location = '/project/mypage/MyPage';
});   

$('#btnLogout').click(function() {
   location = '/project/member/logout'; //logout 이라는 컨트롤러로 가겠다.
});


// home으로 가는 버튼
$('#menumm').on('click',' li #btnHome',function(){
	location = '/project/';
});

$('#tourBoard').click(function() {
   location = '/project/tour/tourBoard';
});

$('#reviewBoard').click(function() {
   location = '/project/review/reviewBoard';
});
</script>

</body>
</html>