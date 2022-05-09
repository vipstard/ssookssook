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
import org.springframework.web.bind.annotation.RequestParam;

import kr.smhrd.domain.Board;
import kr.smhrd.domain.Criteria;
import kr.smhrd.domain.PageMakerDTO;
import kr.smhrd.service.BoardService;


@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	/* 메인 */
	@GetMapping("main")
	public String boardList() {
		return "/SsookSsookFront/index";
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
	

	/* 고객센터로 이동 */
	@GetMapping("helpDesk")
	public String helpDesk() {
		return "/TestWeb/helpDesk";
	}
	
	/* 문의글쓰기 폼으로 이동 */
	@GetMapping("QnaForm")
	public String QnaForm() {
		return "/TestWeb/QnaForm";
	}
	
	
	
	/* 온라인문의 페이지로 이동 (문의글 목록 출력)*/
	@GetMapping("helpQnA")
	public String helpQnA(Model model, Criteria cri) {
		
		ArrayList<Board> QnaList = boardService.QnaList(cri);
		model.addAttribute("QnaList", QnaList);
		
		int total = boardService.boardTotal(cri);
		
		PageMakerDTO pageMake = new PageMakerDTO(cri, total);
		model.addAttribute("BoardPageMaker", pageMake);
		
		return "/TestWeb/helpQnA";
	}
	
	/* 특정 게시물 번호를 가진 문의 게시물정보 가지고 오기 */
	@GetMapping("QnaContent")
	public String QnaContent(@RequestParam("idx") int idx, Model model) {
		
		/* 서비스의 Qna_Content에 문의글 번호 전달 */
		boardService.QnaContentCount(idx);
		Board Qna_Content = boardService.Qna_Content(idx);
		model.addAttribute("Qna_Content", Qna_Content);
		
		return "/TestWeb/QnaContent";

	}
	
	/* QnA 온라인문의 문의 작성 */
	@PostMapping("QnaInsert")
	public String QnaInsert(Board vo) {
		boardService.QnaInsert(vo);
	
		return "redirect:/helpQnA";

	}
	
	/* QnA 온라인문의 문의글 삭제 */
	@GetMapping("QnaDelete")
	public String QnaDelete(int idx) {
		boardService.QnaDelete(idx);

		return "redirect:/helpQnA";
	}
	
	/* 문의 글 수정 폼으로 이동 */
	@GetMapping("QnaUpdateForm")
	public String QnaUpdateForm(@RequestParam("idx") int idx, Model model) {
		
		Board QnaUpdate = boardService.Qna_Content(idx);
		model.addAttribute("QnaUpdate", QnaUpdate);
		return "/TestWeb/QnaUpdateForm";
	}
	
	/* QnA 온라인문의 문의글 수정 */
	@PostMapping("QnaUpdate")
	public String QnaUpdate(Board vo) {
		boardService.QnaUpdate(vo);
		
		return "redirect:/QnaContent?idx="+vo.getIdx();
	}
	
	
	
}
