package kr.smhrd.controller;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kr.smhrd.domain.Criteria;
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
	public ArrayList<MemberVO> AndServer(MemberVO vo, Model model, Criteria cri) {		
		ArrayList<MemberVO> list = memberService.memberList(cri);
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping("And_Ardu")
	public String AndServer() {
		
		
		
		return "1";
	}
	
	
		

}
