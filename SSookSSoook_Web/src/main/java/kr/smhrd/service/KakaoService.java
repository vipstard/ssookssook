package kr.smhrd.service;

import java.util.HashMap;

import kr.smhrd.domain.MemberVO;

public interface KakaoService {
	
	//카카오 로그인
	public MemberVO K_Login(String email);
	
	//액세스 토큰값 받아오기
	public String getAccessToken (String authorize_code);
	
	//유저정보값 받아오기
	public HashMap<String, Object> getUserInfo (String access_Token);
	
	//카카오 로그아웃
	public void kakaoLogout(String access_Token);
	
	//카카오 간편가입
	public MemberVO K_Join(String email, String name);

}
