package kr.smhrd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.smhrd.domain.MemberVO;
import kr.smhrd.mapper.MemberMapper;

@Service
public class NaverServiceImple implements NaverService {
	
	@Autowired
	MemberMapper mapper;
	
	//네이버 간편회원가입
	@Override
	public MemberVO N_join(String id, String email, String name) {
		
		// 네이버에서 받을 수 있는 정보로만 회원가입 시킴. 나머지는 null값
		mapper.N_Join(id, email, name); 
		
		MemberVO vo = mapper.Social_memberLogin(email);
		return vo;
	}

	//네이버 간편로그인
	@Override
	public MemberVO N_Login(String email) {
		
		MemberVO vo = mapper.Social_memberLogin(email);
		return vo;
	}
	
	

}
