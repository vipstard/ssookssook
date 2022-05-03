package kr.smhrd.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.smhrd.domain.MemberVO;
import kr.smhrd.service.KakaoService;
import kr.smhrd.service.KakaoServiceImple;
import kr.smhrd.service.MemberService;

//카카로 로그인 컨트롤러 

@Controller
public class KakaoController {
	
    @Autowired
    private KakaoService kakaoService;


    @RequestMapping("/KakaoLogin")
    public String home(@RequestParam(value = "code", required = false) String code, HttpSession session) throws Exception{
        System.out.println("#########" + code);
        String access_Token = kakaoService.getAccessToken(code);        
        HashMap<String, Object> userInfo = kakaoService.getUserInfo(access_Token);
      
        System.out.println("###access_Token#### : " + access_Token);
        System.out.println("###userInfo#### : " + userInfo.get("email"));
        System.out.println("###nickname#### : " + userInfo.get("nickname"));
        
        String email =(String)userInfo.get("email");
        String name=(String)userInfo.get("nickname");
        
        MemberVO K_Login = kakaoService.K_Login(email); 
        MemberVO K_Join;
        
        System.out.println("성공 : " + K_Login);
        
        // 카카오 로그인 가능할때
        if(K_Login!=null) { 
        	session.setAttribute("LoginVo", K_Login);
        	
        }else { // 카카오 로그인 불가능 할때
        	K_Join = kakaoService.K_Join(email, name);
        	System.out.println(K_Join);
        	System.out.println("간편가입완료");
        	session.setAttribute("LoginVo", K_Join);
        	
        }
        
        
        return "redirect:/main";
    }
}