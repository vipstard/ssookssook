package kr.smhrd.domain;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Board {
	private int idx;		//번호
	private String title;	//제목
	private String content;	//내용
	private String writer;	//작성자
	private String indate;	//작성일 ("2022-03-16")
	private int count;		//조회수

	
	
}
