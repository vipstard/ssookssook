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
		
		
		
		String transPage ="";
		
		
		return "/SsookSsookFront/JSP/payment-cash";
		
	}

}
