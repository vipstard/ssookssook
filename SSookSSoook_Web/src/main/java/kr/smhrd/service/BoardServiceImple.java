package kr.smhrd.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.smhrd.domain.Board;
import kr.smhrd.mapper.BoardMapper;

@Service
public class BoardServiceImple implements BoardService{
	
	@Autowired
	private BoardMapper boardMapper;
	
	/* QnA 온라인문의 목록 불러오기 */
	@Override
	public ArrayList<Board> QnaList() {
		
		ArrayList<Board> QnaList = boardMapper.QnaList();
		return QnaList;
	}

	
	/* QnA 온라인문의 상세 페이지 불러오기 */
	@Override
	public Board Qna_Content(int idx) {
		Board Qna_Content = boardMapper.QnaContent(idx);
		return Qna_Content;
	}

	/* QnA 온라인문의 문의 작성 */
	@Override
	public void QnaInsert(Board vo) {
		boardMapper.QnaInsert(vo);
		
	}

	/* QnA 온라인문의 문의글 삭제 */
	@Override
	public void QnaDelete(int idx) {
		boardMapper.QnaDelete(idx);
		
	}

	/* QnA 온라인문의 문의글 수정 */
	@Override
	public void QnaUpdate(Board vo) {
		boardMapper.QnaUpdate(vo);
	}

	/* QnA 문의글 조회수 */
	@Override
	public void QnaContentCount(int idx) {
		boardMapper.QnaContentCount(idx);
		
	}

}
