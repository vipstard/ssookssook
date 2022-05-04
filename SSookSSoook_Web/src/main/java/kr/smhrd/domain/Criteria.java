package kr.smhrd.domain;

import lombok.Data;


@Data
public class Criteria {
	
	/* 현재페이지 */
	private int pageNum;
	
	/* 한 페이지 당 보여질 게시물 개수 */
	private int amount;
	
	/* 검색 키워드 */
	private String keyword;
	
	/*스킵 할 게시물 수 ((pageNum-1) * amount)*/
	private int skip;
	
	/* 기본생성자 -> 기본 세팅 : pageNum = 1, amount 10 */
	public Criteria() {
		this(1,10);
		this.skip = 0;
		
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.skip = (pageNum-1)*amount; //페이지당 스킵할 개수 1p 10, 2p 20
	}
	
	public void setPageNum(int pageNum) {
		this.skip = (pageNum-1)*this.amount;
		this.pageNum = pageNum;
	}
	
	public void setAmount(int amount) {
		this.skip = (this.pageNum-1)*amount;
		this.amount = amount;
	}
	

}
