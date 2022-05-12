package kr.smhrd.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import kr.smhrd.domain.Criteria;
import kr.smhrd.domain.MemberVO;
import kr.smhrd.service.MemberService;

@Controller
public class AndroidController {
	
	@Autowired
	private MemberService memberService;
	
	boolean check = false;
	String input2="3"; // LED신호
	String input4="0"; // 워터펌프신호
	
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
	
	/* 센서값 받는 곳 */
	@RequestMapping("And_Ardu1")
	public void And_Ardu1(@Param("soilMoisture_Sensor") String soilMoisture_Sensor, @Param("waterLevel_Sensor") String waterLevel_Sensor) {

	String value1 = soilMoisture_Sensor;
	String value2 = waterLevel_Sensor;
	System.out.println("토양: " + value1 + "  수위센서: " + value2);
	
	}
	
	/* Android -> Server -> Arduino제어 신호 받는 곳 */
	@ResponseBody
	@RequestMapping("And_Ardu2")
	public String And_Ardu2(@Param("input1") String input1, @Param("input3") String input3,  Model model) {
	
		
		/* LED 신호 값 */
		if(input1!=null && input1.equals("0")) {
			input2="0";
		}else if(input1!=null && input1.equals("1")) {
			input2="1";
		}
		
		/* 워터펌프 신호값 */
		if(input3!=null && input3.equals("3")) {
			input4="3";
		}else if(input3!=null && input3.equals("4")) {
			input4="4";
			 
		}
		
		System.out.println("input1 2 값 : "  + input1 + " " +input2);
		System.out.println("input3 4 값 : "  + input3 + " " +input4);
		
		
	return input2+input4;
	
	}
	
	
		

}
