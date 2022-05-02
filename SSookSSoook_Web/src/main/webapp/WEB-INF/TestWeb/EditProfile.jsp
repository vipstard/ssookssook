<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원정보 수정</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style>
body {
	min-height: 100vh;
	background: -webkit-gradient(linear, left bottom, right top, from(#92b5db),
		to(#1d466c));
	background: -webkit-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
	background: -moz-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
	background: -o-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
	background: linear-gradient(to top right, #92b5db 0%, #1d466c 100%);
}

.input-form {
	max-width: 680px;
	margin-top: 80px;
	padding: 32px;
	background: #fff;
	-webkit-border-radius: 10px;
	-moz-border-radius: 10px;
	border-radius: 10px;
	-webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
	-moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
	box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
}

.id_ok, .email_ok{
color:#008000;
display: none;
}

.id_already, .email_already{
color:#6A82FB; 
display: none;
}

</style>
</head>
<body>
	<div class="container">
		<div class="input-form-backgroud row">
			<div class="input-form col-md-12 mx-auto">
				<h4 class="mb-3">회원정보 수정</h4>
				
				<!-- 회원가입 폼 -->
				<form class="validation-form" action="/TEST/memberUpdate" method="post">
				
				<div class="mb-3">
					<label for="address2">아이디<span class="text-muted">
							</span></label> 
							<input type="hidden" class="form-control" id="idx" name="idx" value=${LoginVo.idx }>
							<input type="text" class="form-control" id="id" name="id" value=${LoginVo.id } oninput = "checkId()" readonly>
							
							<!-- id ajax 중복체크 -->
							<span class="id_ok">사용 가능한 아이디입니다.</span>
							<span class="id_already">누군가 이 아이디를 사용하고 있어요.</span>
				</div>
				
				<div class="mb-3">
						<label for="email">이메일</label> <input type="email"
							class="form-control" id="email" name="email" value=${LoginVo.email }
							required oninput = "checkEmail()">
							
							<!-- email ajax 중복체크 -->
							<font id="checkId" size="2"></font>
							<span class="email_ok">사용가능한 이메일 입니다.</span>
							<span class="email_already">누군가 이 이메일을 사용하고 있어요.</span>
					</div>
					
				<div class="mb-3">
					<label for="address2">비밀번호<span class="text-muted">
							</span></label> <input type="text" class="form-control" id="pw" name="pw"
							value="${LoginVo.pw }" required>
				</div>
				
				<div class="mb-3">
					<label for="address2">전화번호<span class="text-muted">
							</span></label> <input type="text" class="form-control" id="phone" name="phone"
							value="${LoginVo.phone }" required>
				</div>
				
					<div class="row">
						<div class="col-md-6 mb-3">
							<label for="name">이름</label> <input type="text"
								class="form-control" id="name" name="name" placeholder="" value="${LoginVo.name }" readonly>
							<div class="invalid-feedback">이름을 입력해주세요.</div>
						</div>
						<div class="col-md-6 mb-3">
							<label for="nickname">별명</label> <input type="text"
								class="form-control" id="nickname" name="nick" placeholder="" value="${LoginVo.nick }" readonly>
							<div class="invalid-feedback">별명을 입력해주세요.</div>
						</div>
					</div>
					
					<div class="mb-3">
						<label for="address">주소</label> 
						<input type="text" class="form-control" id="address" name="address" value="${LoginVo.address }" required>
						<div class="invalid-feedback">주소를 입력해주세요.</div>
					</div>
				
					<button class="btn btn-primary btn-lg btn-block" type="submit">수정 완료</button>
				</form><!-- 폼 끝 -->
				
			</div>
		</div>
		<footer class="my-3 text-center text-small">
			<p class="mb-1">&copy; 2022 YD</p>
		</footer>
	</div>
	<script> window.addEventListener('load', () => { 
		const forms = document.getElementsByClassName('validation-form'); 
		
		Array.prototype.filter.call(forms, (form) => { 
			form.addEventListener('submit', function (event) { 
				if (form.checkValidity() === false) 
				{ 
					event.preventDefault(); 
					event.stopPropagation(); 
				} 
				form.classList.add('was-validated'); 
				}, false); }); }, false); 
	
	</script>

<!--  아이디 실시간 중복체크 (Ajax) -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">

    function checkId(){
        var id = $('#id').val(); //email값이 "email"인 입력란의 값을 저장
        $.ajax({
            url:'./idCheck', //Controller에서 요청 받을 주소
            type:'post', //POST 방식으로 전달
            data:{id:id},
            success:function(cnt){ //컨트롤러에서 넘어온 cnt값을 받는다 
                if(cnt == 0){ //cnt가 1이 아니면(=0일 경우) -> 사용 가능한 아이디 
                    $('.id_ok').css("display","inline-block"); 
                    $('.id_already').css("display", "none");
                } else { // cnt가 1일 경우 -> 이미 존재하는 아이디
                    $('.id_already').css("display","inline-block");
                    $('.id_ok').css("display", "none");
                    alert("아이디를 다시 입력해주세요");
                    $('#id').val('');
                }
            },
            error:function(){
                alert("에러입니다");
            }
        });
        };

        
<!-- 이메일 정규식 체크 --> 
function EmailCheck(str){                                                 
	var reg_email = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
	
	if(!reg_email.test(str)) {                            
	return false;         
	}else {                       
	return true;         
  }                            
}

<!--  이메일 실시간 중복체크 (Ajax) -->
    function checkEmail(){
        var email = $('#email').val(); //email값이 "email"인 입력란의 값을 저장
        
        if(email==""){
  			$('#checkId').html('이메일을 입력 해 주세요.');
			$("#checkId").attr('color', 'red');
			$('.email_ok').css("display", "none");
			$('.email_already').css("display", "none");
			
  		}else if(!EmailCheck(email)){
  			$('#checkId').html('Example@naver.com 형식에 맞게 입력해 주세요.');
			$("#checkId").attr('color', 'red');
			$('.email_ok').css("display", "none");
			$('.email_already').css("display", "none");
  		
  		
  		}else{
  			$('#checkId').html('');
  		
        $.ajax({
            url:'./emailCheck', //Controller에서 요청 받을 주소
            type:'post', //POST 방식으로 전달
            data:{email:email},
            success:function(cnt){ //컨트롤러에서 넘어온 cnt값을 받는다 
                if(cnt == 0){ //cnt가 1이 아니면(=0일 경우) -> 사용 가능한 아이디 
                    $('.email_ok').css("display","inline-block"); 
                    $('.email_already').css("display", "none");
                } else { // cnt가 1일 경우 -> 이미 존재하는 아이디
                    $('.email_already').css("display","inline-block");
                    $('.email_ok').css("display", "none");
                    alert("이메일을 다시 입력해주세요");
                    $('#email').val('');
                    
                }
            },
            error:function(){
                alert("에러입니다");
            }
        });
  		}
        };
</script>
</body>
</html>
