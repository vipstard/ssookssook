package kr.smhrd.service;

import kr.smhrd.domain.ReplyVO;

public interface ReplyService {
	
	/* 관리자 답변 등록 */
	public boolean ReplyInsert(ReplyVO Vo);
	
	/* 관리자 답변 조회 */
	public ReplyVO Reply_Select(ReplyVO Vo);

	/* 특정게시판 댓글 개수조회 */
	public int ReplyCount(int id);

}
