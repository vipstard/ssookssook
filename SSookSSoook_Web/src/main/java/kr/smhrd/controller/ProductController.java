package kr.smhrd.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.smhrd.domain.MemberVO;
import kr.smhrd.domain.ProductVO;
import kr.smhrd.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/productList")
	public String productList(Model model) {
		
		System.out.println("컨트롤러실행");
		ArrayList<ProductVO> listProduct = productService.productList();
		System.out.println(listProduct);
		model.addAttribute("listProduct", listProduct);
		
		return "/productList";
	}
	

	@RequestMapping("/helpDesk")
	public String helpDesk(Model model) {
		
		
		
		return "/helpDesk";
	}

}
