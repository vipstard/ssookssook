package kr.smhrd.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kr.smhrd.domain.MemberVO;
import kr.smhrd.service.MemberService;

@Controller
public class AndroidController {
	
	@Autowired
	private MemberService memberService;
	
	
	// 사람 정보 업데이트
	@ResponseBody
	@RequestMapping(value = "/userInfoUpdate", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json;charset=utf-8")
	public void UserUpdate(String objJson) throws Exception {

		Gson gson = new Gson();
		MemberVO member = gson.fromJson(objJson, MemberVO.class);

		
	}
	
	@ResponseBody
	@RequestMapping("AndServer")
	public MemberVO AndServer(MemberVO vo, @Param("id") String id, @Param("pw") String pw) {
		
		vo.setId(id);
		vo.setPw(pw);
		System.out.println(vo);
		
		return vo;
	}
	
	@ResponseBody
	@RequestMapping("And_Ardu")
	public String AndServer(@Param("sign") int sign) {
		
		System.out.println("들어온 값: " + sign);
		
		return "Input: " + sign;
	}
	
	
		

}
