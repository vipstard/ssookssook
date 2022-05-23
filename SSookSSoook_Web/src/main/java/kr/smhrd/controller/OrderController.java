package kr.smhrd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.smhrd.domain.OrderVO;

@Controller
public class OrderController {
	
	/* 주문 페이지 -> 결제페이지 이동(신용카드, 카카오페이, 무통장) */
	@RequestMapping("Order")
	public String Pay(OrderVO orderVO) {
		
		System.out.println(orderVO);
		
		String transPage =""; // 이동할 페이지
		String PayMethod=orderVO.getPay_method(); //결제수단 정보 얻어오기
		
		/* 카드, 카카오페이 결제 성공시 결제성공페이지로 이동 무통장은 계좌번호있는 페이지로 이동 */
		
			transPage="/SsookSsookFront/JSP/payment-success";
		
			
	
		
		
		
		return transPage;
		
	}

}
