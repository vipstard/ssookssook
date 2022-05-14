package kr.smhrd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.smhrd.domain.ReplyVO;
import kr.smhrd.service.ReplyService;

@Controller
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	/* 관리자 답변 등록 (문의글번호, 답변내용)*/
	@ResponseBody
	@RequestMapping("Reply_Insert")
	public boolean Reply_Insert(ReplyVO VO) {
		System.out.println("ReplyVO : " + VO);
		return replyService.ReplyInsert(VO);
		
	}
	
	/* 관리자 답변 조회 */
	@RequestMapping("Reply_Select")
	public ReplyVO Reply_Select(ReplyVO VO) {
		System.out.println("ReplyVO : " + VO);
		return replyService.Reply_Select(VO);
		
	}

}
