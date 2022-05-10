package kr.smhrd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kr.smhrd.domain.Criteria;
import kr.smhrd.domain.MemberVO;
import kr.smhrd.mapper.MemberMapper;

public interface MemberService{
	
		/* 회원가입 */
		public void Join(MemberVO vo);
		
		/* 회원 주소 테이블 */
		public void JoinAddr(MemberVO vo);
		
		//로그인
		public MemberVO Login(MemberVO vo);
		
		// 아이디 중복체크
		public int idCheck(String id);
			
		// 이메일 중복체크
		public int emailCheck(String email);
		
		// 아이디 찾기
		public String find_id(String name, String phone);
		
		/* 회원 정보 수정 */
		public void memberUpdate(MemberVO vo);
		
		/* 회원 주소 정보 수정 */
		public void addrUpdate(MemberVO vo);
		
		//회원리스트
		public ArrayList<MemberVO> memberList(Criteria cri);
		
		/* 총 회원 수 */
		public int memTotal(Criteria cri);
		
		public MemberVO selectOne(String id);

	

}
