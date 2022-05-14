package kr.smhrd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.smhrd.domain.ReplyVO;
import kr.smhrd.mapper.ReplyMapper;

@Service
public class ReplyServiceImple implements ReplyService{

	@Autowired
	private ReplyMapper replyMapper;
	
	/* 고객센터 관리자 답변 작성 
	 qna_idx(고객센터 글번호), reply_content(게시글 내용), reply_date(작성날짜)
	 Mapper로 전달			*/ 
	@Override
	public boolean ReplyInsert(ReplyVO Vo) {
		
	 return replyMapper.ReplyInsert(Vo);	
	}

	/* 고객센터 관리자 답변 조회 */	
	@Override
	public ReplyVO Reply_Select(ReplyVO Vo) {
		
		return replyMapper.ReplySelect(Vo);
	}
	
	/* 특정 게시물 관리자 답변 여부조회 */
	@Override
	public int ReplyCount(int idx) {
		int count = replyMapper.ReplyCount(idx);
		return count;
	}
	
	
	
	

}
