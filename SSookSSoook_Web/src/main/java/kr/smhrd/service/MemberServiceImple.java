package kr.smhrd.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.smhrd.domain.Criteria;
import kr.smhrd.domain.MemberVO;
import kr.smhrd.mapper.MemberMapper;
import lombok.extern.java.Log;

@Service
public class MemberServiceImple implements MemberService {

	@Autowired
	private MemberMapper mapper;

	/* 회원가입 mapper 접근 */
	@Override
	public void Join(MemberVO vo) {
		mapper.MemberJoin(vo);
	}
	
	/* 회원 주소 mapper 접근 */
	@Override
	public void JoinAddr(MemberVO vo) {
		mapper.MemberJoinAddr(vo);
		
	}

	
	/* 로그인 mapper 접근 */
	@Override
	public MemberVO Login(MemberVO vo) {
		MemberVO VO = mapper.MemberLogin(vo);
		System.out.println("Service2 : " + VO);

		return VO;
	}
	
	/* 회원 로그아웃 */
	@RequestMapping("/LogOut")
	public String LogOut(HttpSession session) {

		//회원 세션 로그아웃
		session.invalidate();
		        
		return "redirect:/main";
	}
			

	// 아이디 중복체크 mapper 접근
	@Override
	public int idCheck(String id) {
		int cnt = mapper.idCheck(id);
		System.out.println("cnt: " + cnt);
		return cnt;
	}

	// 이메일 중복체크 mapper 접근
	@Override
	public int emailCheck(String email) {
		int cnt = mapper.emailCheck(email);
		System.out.println("cnt: " + cnt);
		return cnt;
	}

	// 아이디 찾기
	@Override
	public String find_id(String name, String phone) {

		String result = "";

		try {
			result = mapper.find_id(name, phone);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return result;
	}

	// 회원정보 수정
	@Override
	public void memberUpdate(MemberVO vo) {
		System.out.println("Service : " + vo);
		mapper.MemberUpdate(vo);
	}

	// 회원리스트
	@Override
	public ArrayList<MemberVO> memberList(Criteria cri) {
		ArrayList<MemberVO> list = mapper.memberList(cri);
		System.out.println("Service : " + list);
		return list;
	}

	/* 총 회원 수 */
	@Override
	public int memTotal(Criteria cri) {
		
		return mapper.memTotal(cri);
	}
	
	/* 회원 주소 정보 수정 */
	@Override
	public void addrUpdate(MemberVO vo) {
		System.out.println("서비스 : " + vo );
		mapper.addrUpdate(vo);
		
	}

	/* 특정 회원 정보 검색 */
	@Override
	public MemberVO selectOne(@Param("id") String id) {
		System.out.println("서비스: "  + id);
		MemberVO selectOne = mapper.selectOne(id);
		System.out.println("서비스: "  + selectOne);
		return selectOne;
	}

	/* 회원정보관리 페이지에서 회원 정보 삭제 */
	@Override
	public void memberDelete(String id) {

		mapper.memberDelete(id);
		
	}

	
	
	/*
	 * 회원리스트 (페이징 적용)
	 * 
	 * @Override public List<MemberVO> getMemberListPaging(Criteria cri) {
	 * List<MemberVO> list = mapper.getMemberListPaging(cri); return list; }
	 */
}
