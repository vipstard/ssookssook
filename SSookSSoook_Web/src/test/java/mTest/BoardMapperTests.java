package mTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.smhrd.domain.Board;
import kr.smhrd.domain.Criteria;
import kr.smhrd.domain.MemberVO;
import kr.smhrd.mapper.BoardMapper;
import kr.smhrd.mapper.MemberMapper;
import kr.smhrd.service.BoardService;
import kr.smhrd.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTests {
 
     private static final Logger log = LoggerFactory.getLogger(BoardMapperTests.class);
     
     @Autowired
     private BoardMapper mapper;
     private BoardService service;
     


     /* 게시판 목록(페이징 적용)테스트 */

  @Test
  public void testGetListPaging2() {
      
      Criteria cri = new Criteria();
      
      ArrayList<Board> list = mapper.QnaList(cri);
      
      list.forEach(board -> log.info("" + board));
  }
     
     
 
}
 
	