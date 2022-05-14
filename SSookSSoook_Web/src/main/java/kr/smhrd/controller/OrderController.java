package kr.smhrd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.smhrd.domain.OrderVO;

@Controller
public class OrderController {
	
	@RequestMapping("Order")
	public String Pay(OrderVO orderVO) {
		
		String transPage ="";
		
		
		return "/SsookSsookFront/JSP/payment-cash";
		
	}

}
