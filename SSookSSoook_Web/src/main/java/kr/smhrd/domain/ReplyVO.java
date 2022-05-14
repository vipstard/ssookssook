package kr.smhrd.domain;

import lombok.Data;

@Data
public class ReplyVO {
	private int qna_seq;
	private String reply_content;
	private String reply_date;

}
