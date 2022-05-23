package kr.smhrd.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
import kr.smhrd.domain.SensorVO;
import kr.smhrd.service.ArduInService;
import kr.smhrd.service.MemberService;

@Controller
public class AndArduController {
	
	int count = 0;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ArduInService arduinService;
	
	
	String input2="3"; // LED신호
	String input4="0"; // 워터펌프신호
	String value1="0";
	String value2="0";
	boolean check=false;
	
	/*1. 센서 값 수신 후 MariaDB에 넣기*/
	/*2. 안드로이드 - 토양 수위 센서 값 전달*/
	@ResponseBody
	@GetMapping("And_Ardu1")
	public String And_Ardu1(@Param("soilMoisture_Sensor") String soilMoisture_Sensor, @Param("waterLevel_Sensor") String waterLevel_Sensor) {
	
		
		count +=1;
		System.out.println("카운트:" + count);
	if(count%30==0) {	
	
	count=0;
	
	value1 = soilMoisture_Sensor;
	value2 = waterLevel_Sensor;
	
	System.out.println("토양: " + value1 + "  수위센서: " + value2);
	
	arduinService.SensorValueIn(value1, value2);
	
	}
	
	return  "soil : " + value1 + " water : " + value2;
	}
	
	/* Android -> Server -> Arduino제어 신호 받는 곳 */
	@ResponseBody
	@GetMapping("And_Ardu2")
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
		
		System.out.println("input1, input2 값 : "  + input1 + " " +input2);
		System.out.println("input3, input4 값 : "  + input3 + " " +input4);
		
		
		
	return input2+input4;
	
	}
	
	/*1. 센서 값 수신 후 MariaDB에 넣기*/
	/*2. 안드로이드 - 토양 수위 센서 값 전달*/
	@ResponseBody
	@GetMapping("And_Ardu3")
	public JSONObject And_Ardu3(@Param("soilMoisture_Sensor") String soilMoisture_Sensor, @Param("waterLevel_Sensor") String waterLevel_Sensor) {
	
		JSONObject jsonMain = new JSONObject();
		
		JSONArray jArray = new JSONArray();
		
		JSONObject row = new JSONObject();
		
		count +=1;
		System.out.println("카운트 : " + count);
		
		if(count%30==0) {	
		
			count=0;
			
			value1 = soilMoisture_Sensor;
			
			value2 = waterLevel_Sensor;
			
			System.out.print("토양 : " + value1);
			System.out.println("   수위 : " + value2);
			
			
			arduinService.SensorValueIn(value1, value2);
					
		}
		
		row.put("soil", value1);
		row.put("water", value2);
		
		jArray.add(0,row);
		jsonMain.put("data", jArray);
		
		return jsonMain;
	}
	
	
	
	

}
