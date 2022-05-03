package kr.smhrd.controller;

import java.io.IOException;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.scribejava.core.model.OAuth2AccessToken;

import kr.smhrd.domain.MemberVO;
import kr.smhrd.service.KakaoService;
import kr.smhrd.service.NaverLoginBO;
import kr.smhrd.service.NaverService;


@Controller
public class NaverController {
	
	/* NaverLoginBO */
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;

	@Autowired
	private NaverService naverService;
	
	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}
	

	//로그인 첫 화면 요청 메소드
	@RequestMapping(value = "LoginForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Model model, HttpSession session) {
		
		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		
		System.out.println("네이버:" + naverAuthUrl);
		
		//model에 url 실어서 로그인페이지로 보냄. 로그인페이지에서 네이버로그인 버튼 눌렀을때 네이버 띄우기위해
		model.addAttribute("url", naverAuthUrl); 
		return "/TestWeb/LoginForm";
	}

	
	//네이버 로그인 성공시 callback호출 메소드
	@RequestMapping(value = "/callback", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session) throws IOException, ParseException {
		
		System.out.println("callback 실행");
		OAuth2AccessToken oauthToken;
		oauthToken = naverLoginBO.getAccessToken(session, code, state);
		
		//1. 로그인 사용자 정보를 읽어온다.
		apiResult = naverLoginBO.getUserProfile(oauthToken); // String형식의 json데이터
		
		/**
		 * apiResult json 구조 {"resultcode":"00", "message":"success",
		 * "response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"sh@naver.com","name":"\uc2e0\ubc94\ud638"}}
		 **/
		
		//2. String형식인 apiResult를 json형태로 바꿈
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(apiResult);
		JSONObject jsonObj = (JSONObject) obj;
		
		
		//3. 데이터 파싱
		
		//Top레벨 단계 _response 파싱
		JSONObject response_obj = (JSONObject) jsonObj.get("response");
		System.out.println(response_obj);
		
		//response의 nickname, id, email 값 파싱
		String nickname = (String) response_obj.get("nickname");
		String id = (String) response_obj.get("id");
		String email = (String) response_obj.get("email");
		String name = (String) response_obj.get("name");
		
		// 카카오서비스에 있는 로그인사용
		MemberVO N_Login = naverService.N_Login(email);
		MemberVO N_Join;
		
		System.out.println("성공 : " + N_Login);
		
		//네이버 로그인 가능할 때 네이버 이메일 = 사용할 서비스 이메일
		if(N_Login!=null) {
			session.setAttribute("LoginVo", N_Login);
		
		}else {
			
			// 로그인조회시 없을때 간편가입
			N_Join = naverService.N_join(id, email, nickname, name);
			session.setAttribute("LoginVo", N_Join); // 세션 생성
			
			
			//model.addAttribute("result", apiResult);
			
			
		}
		
		return "redirect:/main";
		
	}

	
	
}
