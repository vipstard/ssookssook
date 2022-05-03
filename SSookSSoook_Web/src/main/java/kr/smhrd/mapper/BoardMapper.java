package kr.smhrd.mapper;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;

import kr.smhrd.domain.Board;
import kr.smhrd.domain.Criteria;
import kr.smhrd.domain.MemberVO;

public interface BoardMapper {
	
	//전체 게시물 가지고오기
	public ArrayList<Board> boardList();
	
	//게시물 작성
	public void boardInsert(Board vo);
	
	//특정 게시물 번호를 가진 게시물정보 가지고 오기
	public Board boardContent(int idx);
	
	//특정 게시물 번호를 가진 게시물 삭제
	@Delete ("delete from springboard where idx=#{idx}")
	public void boardDelete(int idx);
	
	//특정 게시물 번호를 가진 게시물 수정
	public void boardUpdate(Board vo);

	
	
}
