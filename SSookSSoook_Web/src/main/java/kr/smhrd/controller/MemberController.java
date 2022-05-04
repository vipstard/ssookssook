package kr.smhrd.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.smhrd.domain.Criteria;
import kr.smhrd.domain.MemberVO;
import kr.smhrd.domain.PageMakerDTO;
import kr.smhrd.service.MemberServiceImple;

@Controller
public class MemberController {
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberServiceImple memberService;
	
	
	
	// 회원가입
	@PostMapping("Join")
	public String Join(MemberVO vo) {
		
		try {
			memberService.Join(vo);
			System.out.println("회원가입 완료");
			System.out.println(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/main";
	}
	
	// 회원 로그인
		@PostMapping("Login_Test")
		public String Login(MemberVO vo, HttpSession session) {
			System.out.println("로그인1 : " + vo);
			MemberVO Login = memberService.Login(vo);
			
			System.out.println("로그인 " + Login);
			
			if(Login!=null) {
				session.setAttribute("LoginVo", Login);
			}
			
			
			return "redirect:/main";
		}
		
		// 회원 로그아웃
		@RequestMapping("LogOut")
		public String LogOut(HttpSession session) {

	      //회원 세션 로그아웃
	      session.invalidate();
	        
			return "redirect:/main";
		}
		
		
		
		/* 회원 정보 수정 */
		@PostMapping("/memberUpdate")
		public String memberUpdate(MemberVO vo) {
			
			System.out.print("회원수정 컨트롤러 ");
			System.out.println(vo);
			
			try {
				memberService.memberUpdate(vo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "redirect:/main";
		}
		
		/*회원 관리*/
		@GetMapping("member_Manage")
		public String member_Manage(Model model, Criteria cri) {

			log.info("member_Manage");

			
			model.addAttribute("Mem_list", memberService.memberList(cri));

			int total = memberService.memTotal(cri);

			PageMakerDTO page = new PageMakerDTO(cri, total);
			System.out.println(page);
			
			model.addAttribute("pageMaker", page);
			
			 return "/TestWeb/member_Manage"; 
			
		}
		
		/*
		 * @RequestMapping("/KakaoLogin") public String home(@RequestParam(value =
		 * "code", required = false) String code) throws Exception{
		 * System.out.println("#########" + code); return "boardList"; }
		 */
	
	//아이디 중복체크
			@PostMapping("idCheck")
			@ResponseBody
			public int idCheck(@RequestParam("id") String id) {
				
				//logger.info("userIdCheck 진입");
				//logger.info("전달받은 id:"+email);
				
				int cnt = memberService.idCheck(id);
				return cnt;
				
			}
			
		//이메일 중복체크
		@PostMapping("emailCheck")
		@ResponseBody
		public int emailCheck(@RequestParam("email") String email) {
			
			//logger.info("userIdCheck 진입");
			//logger.info("전달받은 id:"+email);
			
			int cnt = memberService.emailCheck(email);
			return cnt;
			
		}
	
	
}
