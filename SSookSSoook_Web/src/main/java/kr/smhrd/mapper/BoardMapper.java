package kr.smhrd.mapper;
import java.util.ArrayList;


import org.apache.ibatis.annotations.Delete;

import kr.smhrd.domain.Board;
import kr.smhrd.domain.Criteria;


public interface BoardMapper {
	
	/* QnA 온라인문의 전체 게시물 가지고오기(페이징 적용) */
	public ArrayList<Board> QnaList(Criteria cri);
	
	/* QnA 온라인문의 특정 게시물 번호를 가진 문의 게시물정보 가지고 오기 */
	public Board QnaContent(int idx);

	/* QnA 온라인문의 문의 작성 */
	public void QnaInsert(Board vo);
		
	/* QnA 온라인문의 특정 문의글 삭제 */
	@Delete ("delete from qna_info where qna_seq=#{idx}")
	public void QnaDelete(int idx);
	
	/* QnA 온라인문의 문의글 수정*/
	public void QnaUpdate(Board vo);

	/* QnA 온라인 문의글 조회수 */
	public void QnaContentCount(int idx);
	
	/* 총 게시글 수 */ 
	public int boardTotal(Criteria cri);
	
}
