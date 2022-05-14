package kr.smhrd.domain;

import lombok.Data;

@Data
public class ReplyVO {
	private int qna_idx;
	private String reply_content;
	private String reply_date;

}
