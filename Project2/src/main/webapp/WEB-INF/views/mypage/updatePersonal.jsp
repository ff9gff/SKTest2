<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div style="text-align: center; vertical-align: middle; background-color: #ffffcc; height: 100%"><!-- #ffffcc -->

	<div style="display: inline-block; vertical-align: middle; background-color: white; width: 50%"><br/><!-- white -->
	
	
	<h2>프로필 수정</h2>
	<form id ="updateProfile_form" action="profile_update" method="post" enctype="multipart/form-data" >
		
		<div style="margin-left: 5%; margin-right: 5%; text-align: left;" >
		
			<input type="hidden" id="mno" name="mno" value="${mno}"> 
		
			<label for="sex">성별</label><br> 
			<input type="checkbox" id="male" name="sex" value="1"> 
			<label for="male">남자 </label> 
			<input type="checkbox" id="female" name="sex" value="0"> 
			<label for="female">여자 </label> <br><br>
			 
			<label for="age">나이</label><br> 
			<input type="text" pattern="[0-9]*" id="age" name="age" value="${vo.age }" /><br><br>
			 
			<label for="nickname">넥네임이름</label><br> 
			<input type="text" id="nickname" name="nickname" placeholder="닉네임을 입력해 주세요" value="${vo.nickname }">
			<div id="result_nick"></div><br/><br/>
					 
			<label for="phone">핸드폰 번호</label><br> 
			<input type="text" id="phone" name="phone" placeholder="핸드폰 번호" value="${vo.phone }"><br><br> 
			
			<input type="text" id="postcode" name="postcode"class="postcodify_postcode5" placeholder="우편번호" value="${vo.postcode }"> 
			<input type="button" id="postcodify_search_button" value="우편번호 찾기"><br>
			<input type="text" id="address1" name="address1" class="postcodify_address" placeholder="지번/도로명 " value="${vo.address1 }"><br> 
			<input type="text" id="address2" name="address2" placeholder="상세주소" value="${vo.address2 }">
			<br>
			<br> 
			<label for="email">이메일</label><br /> 
			<input type="email" id="email" name="email" placeholder="이메일 입력" value="${vo.email }"/>
			
			<br/>
			<br/> 
			<br/> <label for="introduce">자기소개</label><br />
			<textarea id="introduce" name="introduce" cols="" rows="15" style="width: 100%;">${vo.introduce }</textarea>
			<br>
			<br>
	
			<button type="button" id="submit_OK">프로필 수정</button>
			<button type="button" id="submit_Cancel">취소</button>
		
		</div>
	</form>
	
	</div>


</div>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
	
	<script>
$(document).ready(function() {
         
    //라디오 요소처럼 동작시킬 체크박스 그룹 셀렉터
    $('input[type="checkbox"][name="sex"]').click(function(){
        //클릭 이벤트 발생한 요소가 체크 상태인 경우
        if ($(this).prop('checked')) {
            //체크박스 그룹의 요소 전체를 체크 해제후 클릭한 요소 체크 상태지정
            $('input[type="checkbox"][name="sex"]').prop('checked', false);
            $(this).prop('checked', true);
        }
    });
    
   // 닉네임 중복 체크
   $('#nickname').change(function() {   
      $.ajax({
         type: 'post',
         url: 'checknick',
         headers: {
            'Content-Type': 'application/json',
            'X-HTTP-Method-Override': 'POST'
         },
         data: JSON.stringify({
            nickname: $('#nickname').val()
         }),
         success: function(response) {
            if (response == 'NOK') {
               $('#result_nick').html('이미 사용 중인 nick입니다.');
               $('#result_nick').css('color', 'red');   
            } else {               
               $('#result_nick').html('사용 가능한 nick입니다.');
               $('#result_nick').css('color', 'blue');   
            }
         }
      
      });
      
   }); 
   
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
   
   // 우편번호 API : https://postcodify.poesis.kr
   // 우편번호 API 다음 서비스 : http://postcode.map.daum.net/guide#sample
   $("#postcodify_search_button").postcodifyPopUp();
   
   
   $("#submit_Cancel").click(function() {
      location = '../MyPage';
   });
   
   /** 
   onchange event handler for the file input field.
   It emplements very basic validation using the file extension.
   If the filename passes validation it will show the image using it's blob URL and will hide the input field and show a delete button to allow the user to remove the image
   */
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
         $('#image_preview img').attr('height', '400px');
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
   
   $('#submit_OK').click(function() {
	   $('#updateProfile_form').submit(); 
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

   
   
   
});
</script>


</body>
</html>