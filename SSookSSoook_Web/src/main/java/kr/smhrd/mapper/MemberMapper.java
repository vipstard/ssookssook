package kr.smhrd.mapper;


import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.smhrd.domain.Criteria;
import kr.smhrd.domain.MemberVO;

public interface MemberMapper {
	
	//회원 가입
	@Insert("insert into user_info(user_id, user_pw, user_name, user_phone, user_email, "
			+ "user_addr, admin_yn, user_joindate) values(#{id},"
			+ " #{pw}, #{name}, #{phone}, #{email}, #{address}, 'N', now())")
	public void MemberJoin(MemberVO vo);
	

	//로그인
	//@Select("Select * from user_info where user_id=#{user_id} and user_pw=#{user_pw}")
	public MemberVO MemberLogin(MemberVO vo);
	

	//카카오로그인, 네이버로그인, 구글로그인
	
	public MemberVO Social_memberLogin(String email);
	
	//카카오간편회원가입
	@Insert("insert into user_info(user_id, user_name, user_email, admin_yn) values('kakao', #{name}, #{email}, 'N')")
	public void K_Join(@Param("email") String email, @Param("name") String name);
	
	//네이버 간편회원가입
	@Insert("insert into user_info(user_id, user_email, user_name) values( #{id}, #{email}, #{name})")
	public void N_Join(@Param("id") String id, @Param("email") String email,  @Param("name") String name);
	
	
	// 아이디 중복체크
	public int idCheck(String id);
	
	// 이메일 중복체크
	public int emailCheck(String email);
	
	//아이디 찾기
	@Select("select nvl(id, 0) from t_member where name=#{name} and phone=#{phone}")
	public String find_id(@Param("name") String name, @Param("phone") String phone);
	
	//회원정보 수정
	public void MemberUpdate(MemberVO vo);
	
	//회원 리스트(페이징)
	public ArrayList<MemberVO> memberList(Criteria cri);
	
	
	
}
