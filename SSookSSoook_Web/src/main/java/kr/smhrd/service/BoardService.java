package kr.smhrd.service;

import java.util.ArrayList;

import kr.smhrd.domain.Board;
import kr.smhrd.domain.Criteria;

public interface BoardService {
	
	/* QnA 게시판 목록 불러오기 */
	public ArrayList<Board> QnaList(Criteria cri);
	
	/* 특정 게시물 번호를 가진 문의 게시물정보 가지고 오기 */
	public Board Qna_Content(int idx);
	
	/* QnA 문의 작성 */
	public void QnaInsert(Board vo);
	
	/* QnA 문의글 삭제 */
	public void QnaDelete(int idx);
	
	/* QnA 문의글 수정 */
	public void QnaUpdate(Board vo);
	
	/* QnA 문의글 조회수 */
	public void QnaContentCount(int idx);
	
	/* 총 게시글 수 */ 
	public int boardTotal(Criteria cri);

}
