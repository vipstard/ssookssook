package kr.smhrd.service;

import kr.smhrd.domain.MemberVO;

public interface NaverService {

	public MemberVO N_join(String id, String email, String name);
	
	public MemberVO N_Login(String email);
}
