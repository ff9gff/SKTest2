<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<%-- 이것은 쪽지 보내기 디자인 입니다.  --%>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

@import url(http://fonts.googleapis.com/css?family=Montserrat:400,700);

#feedback-page{
	text-align:center;
}

#form-main{
	width:100%;
	float:left;
	padding-top:0px;
}

#form-div {
	background-color:rgba(72,72,72,0.4);
	padding-left:35px;
	padding-right:35px;
	padding-top:35px;
	padding-bottom:50px;
	width: 450px;
	float: left;
	left: 50%;
	position: absolute;
  margin-top:30px;
	margin-left: -260px;
  -moz-border-radius: 7px;
  -webkit-border-radius: 7px;
}

.feedback-input {
	color:#3c3c3c;
	font-family: Helvetica, Arial, sans-serif;
  font-weight:500;
	font-size: 18px;
	border-radius: 0;
	line-height: 22px;
	background-color: #fbfbfb;
	padding: 13px 13px 13px 54px;
	margin-bottom: 10px;
	width:100%;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	-ms-box-sizing: border-box;
	box-sizing: border-box;
  border: 3px solid rgba(0,0,0,0);
}

.feedback-input:focus{
	background: #fff;
	box-shadow: 0;
	border: 3px solid #3498db;
	color: #3498db;
	outline: none;
  padding: 13px 13px 13px 54px;
}

.focused{
	color:#30aed6;
	border:#30aed6 solid 3px;
}

/* Icons ---------------------------------- */
#name{
	background-image: url(http://rexkirby.com/kirbyandson/images/name.svg);
	background-size: 30px 30px;
	background-position: 11px 8px;
	background-repeat: no-repeat;
}

#name:focus{
	background-image: url(http://rexkirby.com/kirbyandson/images/name.svg);
	background-size: 30px 30px;
	background-position: 8px 5px;
  background-position: 11px 8px;
	background-repeat: no-repeat;
}

#email{
	background-image: url(http://rexkirby.com/kirbyandson/images/email.svg);
	background-size: 30px 30px;
	background-position: 11px 8px;
	background-repeat: no-repeat;
}

#email:focus{
	background-image: url(http://rexkirby.com/kirbyandson/images/email.svg);
	background-size: 30px 30px;
  background-position: 11px 8px;
	background-repeat: no-repeat;
}

#msg_content{
	background-image: url(http://rexkirby.com/kirbyandson/images/comment.svg);
	background-size: 30px 30px;
	background-position: 11px 8px;
	background-repeat: no-repeat;
}

textarea {
    width: 100%;
    height: 150px;
    line-height: 150%;
    resize:vertical;
}

input:hover, textarea:hover,
input:focus, textarea:focus {
	background-color:white;
}

#sendBtn{
	font-family: 'Montserrat', Arial, Helvetica, sans-serif;
	float:left;
	width: 100%;
	border: #fbfbfb solid 4px;
	cursor:pointer;
	background-color: #3498db;
	color:white;
	font-size:24px;
	padding-top:22px;
	padding-bottom:22px;
	-webkit-transition: all 0.3s;
	-moz-transition: all 0.3s;
	transition: all 0.3s;
  margin-top:-4px;
  font-weight:700;
}

#sendBtn:hover{
	background-color: rgba(0,0,0,0);
	color: #0493bd;
}
	
.submit:hover {
	color: #3498db;
}
	
.ease {
	width: 0px;
	height: 74px;
	background-color: #fbfbfb;
	-webkit-transition: .3s ease;
	-moz-transition: .3s ease;
	-o-transition: .3s ease;
	-ms-transition: .3s ease;
	transition: .3s ease;
}

.submit:hover .ease{
  width:100%;
  background-color:white;
}


@media only screen and (max-width: 580px) {
	#form-div{
		left: 3%;
		margin-right: 3%;
		width: 88%;
		margin-left: 0;
		padding-left: 3%;
		padding-right: 3%;
	}
}s


</style>
</head>
<body>

<div id="form-main">
  <div id="form-div">
  
  
     <form class="form" name="form1" id="form1" action="sendAllMyUser" method="post">
      
      <p class="name">
        <input name="name" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" placeholder="관리자" id="adminId" readonly="readonly" />
      </p>
      
      <p class="allMyUser">
        <input name="text" type="text" class="validate[required,custom[email]] feedback-input" id="email" placeholder="모든 사용자" readonly="readonly" />
       
      </p>
      
      <p class="text">
        <textarea name="text" class="validate[required,length[6,300]] feedback-input" id="msg_content"   placeholder="Comment"></textarea>
     	<input type="hidden" id="value" name="value">
      </p>
      
      
      <div class="submit">
        <input type="button" value="SEND" id="sendBtn"/> <%-- submit 에서 버튼으로 바꿈  --%>
        <div class="ease"></div>
      </div>
    </form>
  </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 	
<script type="text/javascript">
$(document).ready(function(){
	
		var frm = $('#form1');
		
		$('#sendBtn').click(function(){//sendBtn
		var sendText = $('#msg_content').val(); 
		alert('공지사항 전송 성공'); //+ sendText
		//<input type="hidden" id="value" name="value">
		$("#value").val(sendText);
		frm.submit();
		
		
		
		
		/*	
				alert(sendText);
		frm.attr('action','sendAllMyUser');
		frm.attr('method','post');
		frm.submit();
		
		
		
		
		$('#btnUpdate').click(function() {
		frm.attr('action', 'update'); // attr('속성이름', '속성값')
		frm.attr('method', 'post');
		frm.submit();
		
		
	
	});
		*/
	});
	
	
	
});

//comment




</script>



</body>
</html>