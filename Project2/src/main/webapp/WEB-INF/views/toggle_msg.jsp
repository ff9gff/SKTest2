<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
#msg_header{
	color:  #ff5d3d;
	font-weight: bold; 
	font-size: 20px;
	height: 30px;
	padding-top: 10px;
	padding-left: 20px;
}
#msg_send{

	border-bottom: 1px dotted lightgray;
	height: 25px;
	padding-top: 10px;

}
span{
	padding-left: 25px;
	padding-top: 5px;
}
#msg_text{
	padding-left: 20px;
	padding-top: 20px;
}
textarea{
	 min-width:340px; 
	 max-width:340px; 
	 min-height:340px; 
	 max-height:340px
}
#msg_setter{
	border: 1px solid #FFFFFF;
	padding-left: 10px;
}
</style>
</head>
<body>

<div style="width: 380px; height: 480px;">

	<form id="msg_form" method="post" action="../sendMsgU">
		<div id="msg_header">
			<img src="../resources/theme/images/msg.PNG" style="width: 20px; height: 20px;">쪽지쓰기
		</div>
		<input type="hidden" name="sd_mno" value="${msg_setter }" />
		<input type="hidden" name="sd_url" value="${msg_address }" />
		<div id="msg_send">
			<span style="font-weight: 800;">받는사람</span>
			<c:forEach items="${msg_getnick }" var="nick">
				<input type="hidden" name="nickname"  value="${nick}"/>
			</c:forEach>
			<span id="msg_setter">받는사람</span>
		</div>
		<div id="msg_text">
			<textarea name="msg_content"></textarea>
		</div>
	</form>
	<button id="send_button">보내기</button>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(document).ready(function(){
	var nickname='';
	<c:forEach items="${msg_getnick}" var="nick">
		nickname += "${nick} &nbsp&nbsp";
	</c:forEach>
		$('#msg_setter').html(nickname);

	$('#send_button').click(function(){
		var f = document.getElementById('msg_form');
		f.submit();
	
		//self.close();
	});
	
	if ('${insert_result}' == 'success') {
		alert('쪽지 보내기 성공!');
		self.close();
		
	} else if ('${insert_result}' == 'fail') {
		alert('쪽지 보내기 실패!');
		self.close();
	}

});



</script>
</body>
</html>