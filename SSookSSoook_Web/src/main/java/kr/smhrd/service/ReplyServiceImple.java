package kr.smhrd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.smhrd.domain.ReplyVO;
import kr.smhrd.mapper.ReplyMapper;

@Service
public class ReplyServiceImple implements ReplyService{

	@Autowired
	private ReplyMapper replyMapper;
	
	/* 고객센터 게시판 답변달기 
	 qna_idx(고객센터 글번호), reply_content(게시글 내용), reply_date(작성날짜) 			*/ 
	@Override
	public boolean ReplyInsert(ReplyVO Vo) {
		
	return replyMapper.ReplyInsert(Vo);	
	}
	
	
	
	

}
