<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<button onclick='iamport()'>주문하기</button>
<!-- id는 check_module를 쓰겠습니다. -->
<button id="check_module" type="button">카카오페이</button>

<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<!-- 아래 제이쿼리는 1.0이상이면 원하는 버전을 사용하셔도 무방합니다. -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>

<script>
function iamport(){
		//가맹점 식별코드
		IMP.init('imp09311302');
		IMP.request_pay({
		    pg : 'kcp',
		    pay_method : 'card',
		    merchant_uid : 'merchant_' + new Date().getTime(),
		    name : '쑥쑥 스마트화분', //결제창에서 보여질 이름
		    amount : 79+','+900, //실제 결제되는 가격
		    buyer_email : 'iamport@siot.do',
		    buyer_name : '구매자이름',
		    buyer_tel : '010-1234-5678',
		    buyer_addr : '서울 강남구 도곡동',
		    buyer_postcode : '123-456'
		}, function(rsp) {
			console.log(rsp);
		    if ( rsp.success ) {
		    	var msg = '결제가 완료되었습니다.';
		        msg += '고유ID : ' + rsp.imp_uid;
		        msg += '상점 거래ID : ' + rsp.merchant_uid;
		        msg += '결제 금액 : ' + rsp.paid_amount;
		        msg += '카드 승인번호 : ' + rsp.apply_num;
		    } else {
		    	 var msg = '결제에 실패하였습니다.';
		         msg += '에러내용 : ' + rsp.error_msg;
		    }
		    alert(msg);
		});
	}
	
	
$("#check_module").click(function () {
	var IMP = window.IMP; // 생략가능
	IMP.init('imp09311302'); 
	// i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
	// ''안에 띄어쓰기 없이 가맹점 식별코드를 붙여넣어주세요. 안그러면 결제창이 안뜹니다.
	IMP.request_pay({
		pg: 'kakaopay',
		pay_method: 'card',
		merchant_uid: 'merchant_' + new Date().getTime(),
		/* 
		 *  merchant_uid에 경우 
		 *  https://docs.iamport.kr/implementation/payment
		 *  위에 url에 따라가시면 넣을 수 있는 방법이 있습니다.
		 */
		name: '주문명 : 아메리카노',
		// 결제창에서 보여질 이름
		// name: '주문명 : ${auction.a_title}',
		// 위와같이 model에 담은 정보를 넣어 쓸수도 있습니다.
		amount: 2000,
		// amount: ${bid.b_bid},
		// 가격 
		buyer_name: '이름',
		// 구매자 이름, 구매자 정보도 model값으로 바꿀 수 있습니다.
		// 구매자 정보에 여러가지도 있으므로, 자세한 내용은 맨 위 링크를 참고해주세요.
		buyer_postcode: '123-456',
		}, function (rsp) {
			console.log(rsp);
		if (rsp.success) {
			var msg = '결제가 완료되었습니다.';
			msg += '결제 금액 : ' + rsp.paid_amount;
			// success.submit();
			// 결제 성공 시 정보를 넘겨줘야한다면 body에 form을 만든 뒤 위의 코드를 사용하는 방법이 있습니다.
			// 자세한 설명은 구글링으로 보시는게 좋습니다.
		} else {
			var msg = '결제에 실패하였습니다.';
			msg += '에러내용 : ' + rsp.error_msg;
		}
		alert(msg);
	});
});
</script>

</body>
</html>