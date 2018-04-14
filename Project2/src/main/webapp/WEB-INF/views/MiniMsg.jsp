<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>        
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>같이 가자</title>
<style type="text/css">

html{
	background-color: lightgreen;
}

#textArea{

  padding: 10px;
margin-left: 12px;
}

#confirm{
margin-top :5px;
margin-left: 490px;
padding: 10px;
}

#sendMen{

margin-left: 10px;

}

</style>
</head>
<body>
<form action="">
<p id="sendMen">
<c:if test="${empty sendPage }">
	보낸이 :
</c:if>
<c:if test="${!empty sendPage }">
${sendPage } :
</c:if>

 ${getname }
<!--  ${ value } 보낸 번호 -->
</p>
<textarea rows="15" cols="70" readonly id="textArea">${sendTxt }</textarea><br/>
</form>
<input type="button" id="confirm" value="확인">



<script
src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">

$("#confirm").click(function(){
	
	
	self.close();
	
	
});







</script>




</body>
</html>