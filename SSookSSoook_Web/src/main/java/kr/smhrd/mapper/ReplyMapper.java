package kr.smhrd.mapper;

import kr.smhrd.domain.ReplyVO;

public interface ReplyMapper {
	
	/* 특정 문의글 관리자 답변 등록 */
	public boolean ReplyInsert(ReplyVO Vo);
	
	/* 특정 문의글 관리자 답변 조회 */
	public ReplyVO ReplySelect(ReplyVO Vo);

}
