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


@Controller
public class BoardController {
	
	/* 메인 */
	@GetMapping("main")
	public String boardList() {
		return "/TestWeb/main";
	}
	
	/* 회원가입 폼으로 이동 */
	@GetMapping("JoinForm")
	public String JoinForm() {
		return "/TestWeb/JoinForm";
	}
	
	
	
	/* 회원수정 폼으로 이동 */
	@GetMapping("EditProfile")
	public String EditProfile() {
		return "/TestWeb/EditProfile";
	}
	
	
}
