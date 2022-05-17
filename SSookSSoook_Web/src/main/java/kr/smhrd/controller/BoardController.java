package kr.smhrd.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
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
import kr.smhrd.domain.MemberVO;
import kr.smhrd.domain.PageMakerDTO;
import kr.smhrd.service.BoardService;
import kr.smhrd.service.MemberService;
import kr.smhrd.service.ReplyService;


@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ReplyService replyService;
	
	
	/* 메인 */
	@GetMapping("main")
	public String boardList() {
		return "/SsookSsookFront/JSP/index";
	}
	
	/* 회원가입 폼으로 이동 */
	@GetMapping("JoinForm")
	public String JoinForm() {
		return "/SsookSsookFront/JSP/join";
	}
	
	/* 주문페이지로 이동 */
	@GetMapping("Order")
	public String Order() {
		return "/SsookSsookFront/JSP/Order";
	}
	
	
	
	/* 회원수정 폼으로 이동 */
	@GetMapping("EditProfile")
	public String EditProfile(@Param("id") String id, Model model) {
		System.out.println("ㅇㅇ : " + id);
		MemberVO Edit = memberService.selectOne(id);
		System.out.println("회원수정 : "  + Edit);
		model.addAttribute("LoginVo", Edit);
		
		return "/SsookSsookFront/JSP/EditProfile";
	}
	

	/* 고객센터로 이동 */
	@GetMapping("helpDesk")
	public String helpDesk() {
		return "/TestWeb/helpDesk";
	}
	
	/* 문의글쓰기 폼으로 이동 */
	@GetMapping("QnaForm")
	public String QnaForm(@Param("id")String writer, Model model) {
		
		model.addAttribute("writer", writer);
		return "/SsookSsookFront/JSP/service-write";
	}
	
	/* AS 페이지 이동 */
	@GetMapping("Contact")
	public String Contact() {
		return "/SsookSsookFront/JSP/contact";
	}
	
	/* 회사소개 이동 */
	@GetMapping("About")
	public String About() {
		return "/SsookSsookFront/JSP/about";
	}
	
	/* 구매 - 페이지 */
	@GetMapping("Purchase")
	public String Purchase( ) {

		return "/SsookSsookFront/JSP/purchase";
	}
	
	/* 구매 - 결제페이지 */
	@RequestMapping("PurchasePay")
	public String PurchasePay() {
		return "/SsookSsookFront/JSP/purchase-payment";
	}
	
	
	
	/* 온라인문의 페이지로 이동 (문의글 목록 출력)*/
	@GetMapping("helpQnA")
	public String helpQnA(@Param("id")String id, Model model, Criteria cri) {
		
		ArrayList<Board> QnaList = boardService.QnaList(cri);
		model.addAttribute("QnaList", QnaList);
		
		int total = boardService.boardTotal(cri);
		System.out.println(total);
		
		PageMakerDTO pageMake = new PageMakerDTO(cri, total);
		model.addAttribute("BoardPageMaker", pageMake);
		
		model.addAttribute("id", id);
		
		return "/SsookSsookFront/JSP/service-list";
	}
	
	/* 특정 게시물 번호를 가진 문의 게시물정보 가지고 오기 */
	@GetMapping("QnaContent")
	public String QnaContent(@RequestParam("idx") int idx, Model model) {
		
		/* 서비스의 Qna_Content에 문의글 번호 전달 */
		
		boardService.QnaContentCount(idx);
		
		Board Qna_Content = boardService.Qna_Content(idx);
		model.addAttribute("Qna_Content", Qna_Content);
		
		/* 댓글정보 가져오기 */
		int ReplyCount = replyService.ReplyCount(idx);
		model.addAttribute("ReplyCount", ReplyCount);
		System.out.println(ReplyCount);
		
		return "/SsookSsookFront/JSP/service-view";

	}
	
	/* QnA 온라인문의 문의 작성 */
	@PostMapping("QnaInsert")
	public String QnaInsert(Board vo) {
		System.out.println("관리자댓글 con : " + vo);
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
		return "/SsookSsookFront/JSP/service-writeUp";
	}
	
	/* QnA 온라인문의 문의글 수정 */
	@PostMapping("QnaUpdate")
	public String QnaUpdate(Board vo) {
		boardService.QnaUpdate(vo);
		
		return "redirect:/QnaContent?idx="+vo.getIdx();
	}
	
	@RequestMapping("Sales_Manage")
	public String SalesManage() {
		
		return "/SsookSsookFront/JSP/sales-chart";
	}
	
	
	
	
}
