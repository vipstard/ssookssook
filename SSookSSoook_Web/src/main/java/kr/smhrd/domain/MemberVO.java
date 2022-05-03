package kr.smhrd.domain;

import lombok.Data;

@Data
public class MemberVO {
	private int rn;
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String email;
	private String addr;
	private String admin_yn;
	private String joindate;
	

}
