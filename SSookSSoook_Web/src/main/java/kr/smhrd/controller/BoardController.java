package kr.smhrd.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//@Controller : Spring MVC 프로젝트에서 컨트롤러 역할
// 주로 View를 반환하기 위해 사용

@Controller
public class BoardController {
	
	
	//아이디 찾기
	@GetMapping("/EditProfile")
	public String EditProfile() {
		return "EditProfile";
	}
	
	
}
